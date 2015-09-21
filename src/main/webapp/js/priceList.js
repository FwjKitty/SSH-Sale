/**
 * 分页显示全部
 * @param pageNow
 */
function getPriceListPage(pageNow) {
	$("#msg").text("");
    $.ajax({
        type: "post",
        url: "priceList_getPageResult.action",
        dataType: "json",
        data : {"pageNow":pageNow},
        timeout: 5000,
        success: function(priceList){
        	var nextpage ;
            var lastpage ;
            var finalpage="${fn:substringBefore((count-count%10)/10+1, '.')}";
            if(pageNow==1){
            	lastpage=1;
            }else lastpage=pageNow-1;
            if(finalpage==pageNow){
            	nextpage=pageNow;
            }else nextpage=pageNow+1;
        	$("#pageBody").text("");
        	$("#pageFooter").text("");
    		var _tbody = "";
    		var _tfooter = "";
    		//遍历json数组
    		$.each(priceList,function(n, priceCol){
    			var i = 0;
    			if(pageNow > 1){
    				i = (n+1)*(pageNow-1)*10+1;
    			}else{
    				i = n+1;
    			}
            	_tbody +="<tr><td style='background-color:#b0c4de;'>"+i+"</td>"
            		+"<td style='background-color:#f8f8ff;'>"+priceCol.hy_item+"</td>"
            		+"<td><input type='text' name='priceCol.effectiveDateFrom' value='"+priceCol.effective_date_from+"'  style='width:100%;'/></td>"
            		+"<td><input type='text' name='priceCol.effectiveDateTo' value='"+priceCol.effective_date_to+"' style='width:100%;'/></td></tr>";
    		});
    		_tfooter = "<button onclick='getPriceListPage("+lastpage+")' class='btn btn-default'><<</button>"
				+"<button onclick='getPriceListPage(1)' class='btn btn-default'>first</button>"
				+"<button onclick='getPriceListPage("+finalpage+")' class='btn btn-default'>last</button>"
				+"<button onclick='getPriceListPage("+nextpage+")' class='btn btn-default'>>></button>";
    		$("#pageBody").append(_tbody);
    		$("#pageFooter").append(_tfooter);
        }
    });
}

/**
 * 分页查询
 * @param pageNow
 */
function searchPriceList() {
	$("#msg").text("");
	var form = document.getElementById("searchForm");
    $.ajax({
        type: "post",
        url: "priceList_search.action",
        dataType: "json",
        data : {"customersInfo.customerCode":form[0].value,"customersInfo.type":form[1].value,
        		"priceListConfig.hy_item":form[2].value},
        timeout: 5000,
        success: function(priceLists){
        	$("#pageHead").text("");
        	$("#pageBody").text("");
        	$("#pageFooter").text("");
    		var _tbody = "";
    		var _thead = "";
    		//遍历json数组
    		$.each(priceLists,function(n, priceList){
        		if(n == 0){
    				_thead+="<tr><th>序号</th>";
    				for(var price in priceList){
    					if(price == "price_list_id" || price == "customersInfo.customerId"){
    						continue;
    					}else{
    						_thead+="<th>"+priceList[price]+"</th>";
    					}
    	            }
    				_thead+="</tr>";
    			}else{
    				_tbody += "<tr><td style='background-color:#b0c4de;'>"+n+"</td>";
                	for(var price in priceList){
                		if(price == "price_list_id" || price == "customersInfo.customerId"){
    						_tbody+="<input type='hidden' value='"+priceList[price]+"' name='priceLists["+(n-1)+"]."+price+"'/>";
    					}else{
    						_tbody+="<td style='background-color:#f8f8ff;'><input type='text' value='"+priceList[price]+"' name='priceLists["+(n-1)+"]."+price+"' style='width:100%;'/></td>";
    					}
    	            }
                	_tbody+="</tr>";
    			}
    		});
    		$("#pageHead").append(_thead);
    		$("#pageBody").append(_tbody);
        }
    });
}

/**
 * 新增价格表时，选择客户简称
 */
function showSelectCustomerCode(){
	$.ajax({
        type: "post",
        url: "priceList_getCustomerCode.action",
        dataType: "json",
        data : "{}",
        timeout: 5000,
        error: function(){
        	alert("error");
        },
        success: function(customersInfos){
        	var _options = "";
    		//遍历json数组
        	$.each(customersInfos,function(n, customersInfo){
            	_options += "<option value='"+customersInfo.customerId+"'>"+customersInfo.customerCode+"</option>";
    		});
    		$("#selectCustomerCode").append(_options);
    		$("#selectCustomerCodeModal").modal('show');
        }
    });
}

/**
 * 新增价格表时选择客户简称后，显示启用的列
 */
function showPriceListHeader(){
	$("#pageHead").text("");
	$("#pageBody").text("");
	$.ajax({
        type: "post",
        url: "priceList_getPriceListHeader.action",
        dataType: "json",
        data : {"customersInfo.customerId":$("#selectCustomerCode").val()},
        timeout: 5000,
        success: function(priceListHeader){
        	var _thead = "";
    		var _tbody = "";
    		//遍历json对象
    		_thead += "<tr>";
    		_tbody += "<tr><input type='hidden' name='priceLists[0].customersInfo.customerId' value='"+$("#selectCustomerCode").val()+"'/>";
    		for(var priceListCol in priceListHeader){
				_thead += "<th>"+priceListHeader[priceListCol]+"</th>";
				_tbody += "<td><input type='text' name='priceLists[0]."+priceListCol+"' value='' style='width:100%;'/></td>"
    		}
    		_thead += "</tr>";
    		_tbody += "</tr>";
    		$("#pageHead").append(_thead);
    		$("#pageBody").append(_tbody);
    		$("#selectCustomerCodeModal").modal('hide');
        }
    });
}

/**
 * 保存价格表
 */
function savePriceLists(){
	$("#saveForm").ajaxSubmit({
		url : 'priceList_save.action',
        type : "post",
//	        data : {"priceListFile":$("#priceListFile").val()},
        datatype : "text",
        success:function(msg) {
        	alert(msg);
        }
	});
}

function showImportPriceList(){
	$("#priceListPanel").text("");
	var form = document.getElementById("searchForm");
	$.ajax({
        type: "post",
        url: "priceList_importPriceListShow.action",
        dataType: "json",
        data : {"customersInfo.customerCode":form[0].value,"customersInfo.customerType":form[1].value},
        timeout: 5000,
        success: function(priceListHeader){
        	_panel="<form id='uploadPriceListFileForm' method='post' enctype='multipart/form-data'><div class='form-group'>" +
        		"<label class='col-sm-1 control-label'>导入文件</label>" +
        		"<div class='col-sm-3'>" +
        		"<input type='file' id='priceListFile' name='priceListFile' class='form-control'/>" +
        		"</div>" +
        		"</div>" +
        		"<div class='form-group'>" +
        		"<div class='col-sm-3'>" +
        		"<button type='button' class='btn' onclick='searchPriceList()'>" +
        		"选择" +
        		"</button><br><br>" +
        		"<button type='button' class='btn' onclick='uploadPriceListFile()'>" +
        		"导入" +
        		"</button>&nbsp;&nbsp;&nbsp;<span id='uploadMsg' style='color:#228b22;font-weight:bold;font-style:italic;'></span>&nbsp;&nbsp;&nbsp;<br><br>" +
        		"<button type='button' class='btn'>" +
        		"确认" +
        		"</button>" +
        		"</div>" +
        		"</div></form>" +
        		"<div class='col-sm-12'><hr style='border:3px solid #780000;'></div>" +
        		"<div class='col-sm-12'>" +
        		"导入明细<br>" +
        		"</div>" +
        		"<table class='table' style='text-align:center;'>" +
        		"<thead style='background-color:#fffacd;' id='pageHead'>";
        	_thead = "<tr><th>No.</th>";
    		//遍历json对象
    		for(var priceListCol in priceListHeader){
				_thead += "<th>"+priceListHeader[priceListCol]+"</th>";
			}
        	_panel+=_thead+"<th>导入状态</th><th>备注</th></tr>" +
        		"</thead>" +
        		"<tbody id='pageBody'>" +
        		"</tbody>" +
        		"</table>";
        	$("#exportPriceList").attr("disabled","false");
    		$("#priceListPanel").append(_panel);
    		$("#selectCustomerCodeModal").modal('hide');
        }
    });
}

function uploadPriceListFile(){
	//判断上传控件中是否选择了图片  
    var fileName = $("#priceListFile").val();  
    if ($.trim(fileName) == "") {  
        alert("请选择需要导入的文件！");  
        return false;  
    }
    fileName = fileName.substring(fileName.lastIndexOf(".")+1)  
    if(fileName != "xls" && fileName != "xlsx"){  
        alert("格式错误! \r请选择类型为.xls或者.xlsx的文件!");  
        return false;  
    }
    $('#uploadMsg').html('文件上传中...');
	$("#uploadPriceListFileForm").ajaxSubmit({
		url : 'priceList_importPriceList.action',
        type : "post",
//        data : {"priceListFile":$("#priceListFile").val()},
        datatype : "json",
        success:function(priceLists) {
        	$("#pageBody").text("");
    		var _tbody = "";
    		//遍历json数组
    		$.each(JSON.parse(priceLists),function(n, priceList){
				_tbody += "<tr><td style='border:0 solid red;'>"+(n+1)+"</td>";
            	for(var columnName in priceList){
					_tbody+="<td style='border:0 solid red;'>"+priceList[columnName]+"</td>";
	            }
            	_tbody+="</tr>";
    		});
    		$("#pageBody").append(_tbody);
         	$('#uploadMsg').html('已完成！');
        }/*,
        resetForm:true*/
	});
}