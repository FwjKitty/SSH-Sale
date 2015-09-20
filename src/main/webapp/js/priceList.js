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
            		+"<td style='background-color:#f8f8ff;'>"+priceCol.hyItem+"</td>"
            		+"<td><input type='text' name='priceCol.effectiveDateFrom' value='"+priceCol.effectiveDateFrom+"'  style='width:100%;'/></td>"
            		+"<td><input type='text' name='priceCol.effectiveDateTo' value='"+priceCol.effectiveDateTo+"' style='width:100%;'/></td></tr>";
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
        data : {"customersInfo.customerCode":form[0].value,"customersInfo.customerType":form[1].value,
        		"priceListConfig.hyItem":form[2].value},
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
    					if(price == "price_list_id"){
    						continue;
    					}else{
    						_thead+="<th>"+priceList[price]+"</th>";
    					}
    	            }
    				_thead+="</tr>";
    			}else{
    				_tbody += "<tr><td style='background-color:#b0c4de;'>"+n+"</td>";
                	for(var price in priceList){
                		if(price == "price_list_id"){
    						_tbody+="<input type='hidden' value='"+priceList[price]+"' name='priceList."+price+"'/>";
    					}else{
    						_tbody+="<td style='background-color:#f8f8ff;'><input type='text' value='"+priceList[price]+"' name='priceList."+price+"' style='width:100%;'/></td>";
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
	$("#pageBody").text("");
	$("#pageBody").text("");
	$("#pageFooter").text("");
	$.ajax({
        type: "post",
        url: "priceList_getPriceListHeader.action",
        dataType: "json",
        data : {"customersInfo.customerId":$("#selectCustomerCode").val()},
        timeout: 5000,
        success: function(priceListHeader){
        	var _thead = "";
    		var _tbody = "";
    		var _tfooter = "";
    		//遍历json对象
    		_thead += "<tr>";
    		_tbody += "<tr>";
    		for(var priceListCol in priceListHeader){
				_thead += "<th>"+priceListHeader[priceListCol]+"</th>";
				_tbody += "<td><input type='text' name='priceList."+priceListCol+"' value='' style='width:100%;'/></td>"
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
function savePriceListConfig() {
	$("#msg").text("");
	var form = document.getElementById("searchForm");
    $.ajax({
        type: "post",
        url: "priceListConfig_save.action",
        dataType: "json",
        data : {"customersInfo.customerCode":form[0].value,"customersInfo.customerType":form[1].value,
        		"customersInfo.customerName":form[2].value,"priceListConfig.activity":form[3].value,
        		"priceListConfig.excelCol":form[4].value,"priceListConfig.displayName":form[5].value},
        timeout: 5000,
        success: function(priceListConfigs){
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
    		$.each(priceListConfigs,function(n, priceListConfig){
    			var i = 0;
    			if(pageNow > 1){
    				i = (n+1)*(pageNow-1)*10+1;
    			}else{
    				i = n+1;
    			}
            	_tbody +="<tr><td style='background-color:#b0c4de;'>"+i+"</td>"
            		+"<td style='background-color:#f8f8ff;'>"+priceListConfig.priceListCol+"</td>"
            		+"<td><input type='text' name='priceListConfig.displayName' value='"+priceListConfig.displayName+"'  style='width:100%;'/></td>"
            		+"<td><input type='text' name='priceListConfig.excelCol' value='"+priceListConfig.excelCol+"' style='width:100%;'/></td>";
            	if(priceListConfig.activity == "是"){
            		_tbody +="<td style='background-color:#fffff0;'><input type='checkbox' value='是' name='activity' checked/></td></tr>";
            	}else{
            		_tbody +="<td style='background-color:#fffff0;'><input type='checkbox' value='否' name='activity'/></td></tr>";
            	}
    		});
    		_tfooter = "<button onclick='searchPriceListConfig("+lastpage+")' class='btn btn-default'><<</button>"
				+"<button onclick='searchPriceListConfig(1)' class='btn btn-default'>first</button>"
				+"<button onclick='searchPriceListConfig("+finalpage+")' class='btn btn-default'>last</button>"
				+"<button onclick='searchPriceListConfig("+nextpage+")' class='btn btn-default'>>></button>";
    		$("#pageBody").append(_tbody);
    		$("#pageFooter").append(_tfooter);
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
        	_panel="<form action='priceList_importPriceList.action' id='uploadPriceListFileForm' method='post' enctype='multipart/form-data'><div class='form-group'>" +
        		"<label class='col-sm-1 control-label'>导入文件</label>" +
        		"<div class='col-sm-3'>" +
        		"<input type='file' id='priceListFile' name='priceListFile' class='form-control'/>" +
        		"</div>" +
        		"</div>" +
        		"<div class='form-group'>" +
        		"<div class='col-sm-1'>" +
        		"<button type='button' class='btn' onclick='searchPriceList()'>" +
        		"选择" +
        		"</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
        		"<button type='submit' class='btn'>" +
        		"导入" +
        		"</button>&nbsp;&nbsp;<span id='uploadMsg'></span>&nbsp;&nbsp;&nbsp;" +
        		"<button type='button' class='btn'>" +
        		"确认" +
        		"</button>" +
        		"</div>" +
        		"</div></form>" +
        		"<div class='col-sm-12'><hr style='border:3px solid #780000;'></div>" +
        		"<div class='col-sm-12'>" +
        		"导入明细<br>" +
        		"</div>" +
        		"<table class='table table-striped table-bordered table-hover well' style='text-align:center;'>" +
        		"<thead style='background-color:#fffacd;'>";
        	_thead = "<tr>";
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
/*onclick='uploadPriceListFile()'*/
$("#uploadPriceListFileForm").ajaxSubmit({
	url : 'priceList_importPriceList.action',
    type : "post",
    data : {"priceListFile":$("#priceListFile").val()},
    datatype : "json",
    beforeSubmit:function(){
        var fileName = $("#priceListFile").val();
        alert($.trim(fileName));
        if($.trim(fileName) == ""){
        	alert("您未选择文件！");
        }
        fileName = fileName.substring(fileName.lastIndexOf(".")+1)  
        if(fileName != "xls" && fileName != "xlsx"){  
            alert("Formart Error! \rPlease select file by .xls or .xlsx!");  
            return false;  
        }
        $('#uploadMsg').html('File Upload ... ...');
    },  
    success:function(data,status) {
     	$('#uploadMsg').html('已完成！');
        $('#pageBody').fadeIn("fast",function(){  
            console.log(data);
        });
    },
    resetForm:true
});
function uploadPriceListFile(){
	alert("import");
	$.ajaxForm({
		url : 'priceList_importPriceList.action',
        type : "post",
        data : {"priceListFile":$("#priceListFile").val()},
        datatype : "json",
        beforeSubmit:function(){
            var fileName = $("#priceListFile").val();
            alert($.trim(fileName));
            if($.trim(fileName) == ""){
            	alert("您未选择文件！");
            }
            fileName = fileName.substring(fileName.lastIndexOf(".")+1)  
            if(fileName != "xls" && fileName != "xlsx"){  
                alert("Formart Error! \rPlease select file by .xls or .xlsx!");  
                return false;  
            }
            $('#uploadMsg').html('File Upload ... ...');
        },  
        success:function(data,status) {
         	$('#uploadMsg').html('已完成！');
            $('#pageBody').fadeIn("fast",function(){  
                console.log(data);
            });
        },
        resetForm:true
	});
}