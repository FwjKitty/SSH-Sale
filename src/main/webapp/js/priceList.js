function changePanel(){
	$("#priceListPanel").text("");
	var panel = "<form id='saveForm' method='post'>" +
			"<table class='table table-striped table-bordered table-hover well' style='text-align:center;'>" +
			"<thead style='background-color:#1e90ff;' id='pageHead'></thead>" +
			"<tbody id='pageBody'></tbody>" +
			"</table></form>";
	$("#priceListPanel").append(panel);
}
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
        	$("#priceListPanel").text("");
        	var panel = "<table class='table table-striped table-bordered table-hover well' style='text-align:center;'>" +
    					"<thead style='background-color:#1e90ff;' id='pageHead'></thead>" +
    					"<tbody id='pageBody'></tbody>" +
    					"<tfoot class=''>" +
    					"<tr>" +
    					"<td colspan='5'>" +
    					"<div class='pull-left'>${msg}</div>" +
    					"<div class='pull-right' id='pageFooter'>" +
    					"</div>" +
    					"</td>" +
    					"</tr>" +
    					"</tfoot>";
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
    		_tbody += "</tbody>"
    		_tfooter = "<button onclick='getPriceListPage("+lastpage+")' class='btn btn-default'><<</button>"
				+"<button onclick='getPriceListPage(1)' class='btn btn-default'>first</button>"
				+"<button onclick='getPriceListPage("+finalpage+")' class='btn btn-default'>last</button>"
				+"<button onclick='getPriceListPage("+nextpage+")' class='btn btn-default'>>></button>";
    		$("#priceListPanel").append(panel);
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
	$("#exportPriceList").removeAttr("disabled")
	changePanel();
    $.ajax({
        type: "post",
        url: "priceList_search.action",
        dataType: "json",
        data : {"customersInfo.customerCode":form[0].value,"customersInfo.type":form[1].value,
        		"priceListConfig.hy_item":form[2].value},
        timeout: 5000,
        success: function(priceLists){
    		var _tbody = "";
    		var _thead = "";
    		//遍历json数组
    		$.each(priceLists,function(n, priceList){
        		if(n == 0){
    				_thead+="<tr><th>NO.<input type='hidden' name='displayNames["+0+"]' value='NO.'/></th>";
    				var i = 1;
    				for(var priceRow in priceList){
    					if(priceRow == "price_list_id" || priceRow == "customersInfo.customerId"){
    						continue;
    					}else{
    						_thead+="<th>"+priceList[priceRow]+"<input type='hidden' name='displayNames["+i+"]' value='"+priceList[priceRow]+"'/></th>";
    						i++;
    					}
    	            }
    				_thead+="</tr>";
    			}else{
    				_tbody += "<tr><td style='background-color:#b0c4de;'>"+n+"</td>";
                	for(var price in priceList){
                		if(priceRow == "price_list_id" || priceRow == "customersInfo.customerId"){
    						_tbody+="<input type='hidden' value='"+priceList[priceRow]+"' name='priceLists["+(n-1)+"]."+priceRow+"'/>";
    					}else{
    						_tbody+="<td style='background-color:#f8f8ff;'><input type='text' value='"+priceList[priceRow]+"' name='priceLists["+(n-1)+"]."+priceRow+"' style='width:100%;'/></td>";
    					}
    	            }
                	_tbody+="</tr>";
    			}
    		});
    		$("#saveAndUpdatePriceLists").attr("onclick","updatePriceLists()");
    		$("#pageHead").append(_thead);
    		$("#pageBody").append(_tbody);
        }
    });
}

/**
 * 更新价格表
 */
function updatePriceLists(){
	$("#saveForm").ajaxSubmit({
		url : 'priceList_update.action',
        type : "post",
        datatype : "text",
        success:function(msg) {
        	alert(msg);
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
	$("#exportPriceList").removeAttr("disabled")
	changePanel();
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
    		$("#saveAndUpdatePriceLists").attr("onclick","savePriceLists()");
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
        datatype : "json",
        success:function(data) {
        	data = JSON.parse(data);
        	alert(data["msg"]);
        }
	});
}

/**
 * 显示导入界面
 */
function showImportPriceList(){
	$("#priceListPanel").text("");
	var form = document.getElementById("searchForm");
	$("#priceListPanel").text("");
	panel="<form id='uploadPriceListFileForm' method='post' enctype='multipart/form-data'><div class='form-group'>" +
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
	"<button type='button' class='btn' onclick='saveImportPriceLists()'>" +
	"确认" +
	"</button>&nbsp;&nbsp;&nbsp;<span id='importMsg' style='color:#228b22;font-weight:bold;font-style:italic;'></span>&nbsp;&nbsp;&nbsp;" +
	"</div>" +
	"</div></form>" +
	"<div class='col-sm-12'><hr style='border:3px solid #780000;'></div>" +
	"<div class='col-sm-12'>" +
	"<h5>导入明细</h5><br><p id='priceListsMsg' style='color:red;font-weight:bold;font-style:italic;'></p>" +
	"</div>" +
	"<form id='saveForm' method='post'>" +
	"<table class='table' style='text-align:center;'>" +
	"<thead style='background-color:#fffacd;' id='pageHead'></thead>" +
	"<tbody id='pageBody'></tbody>" +
	"</table></form>";
	$("#priceListPanel").append(panel);
	$.ajax({
        type: "post",
        url: "priceList_importPriceListShow.action",
        dataType: "json",
        data : {"customersInfo.customerCode":form[0].value,"customersInfo.type":form[1].value},
        timeout: 5000,
        success: function(priceListHeader){
    		//遍历json对象
        	var i = 0;
    		for(var priceListCol in priceListHeader){
    			if(priceListCol == "customersInfo.customerId"){
    				_thead = "<tr><th>No.<input type='hidden' id='importCustomerId' value='"+priceListHeader[priceListCol]+"'/></th>";
    				continue;
    			}
    			_thead += "<th>"+priceListHeader[priceListCol]+"<input type='hidden' id='priceListCol"+i+"' value='"+priceListCol+"'/></th>";
				i++;
    		}
        	_thead+="<th>导入状态</th><th>备注</th></tr>";
        	$("#exportPriceList").attr("disabled","true");
        	$("#pageHead").append(_thead);
    		$("#selectCustomerCodeModal").modal('hide');
        }
    });
}

/**
 * 显示导入的列表
 * @returns {Boolean}
 */
function uploadPriceListFile(){
	$("#pageBody").text("");
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
    		var _tbody = "";
    		//遍历json数组
    		$.each(JSON.parse(priceLists),function(n, priceList){
				_tbody += "<tr><td style='border:0 solid red;'>"+(n+1)+"<input type='text' name='priceLists["+n+"].customersInfo.customerId' value='"+$("#importCustomerId").val()+"'/></td>";
				var i = 0;
				for(var columnName in priceList){
					_tbody+="<td style='border:0 solid red;'>"+priceList[columnName]+"<input type='text' name='priceLists["+n+"]."+$("#priceListCol"+i).val()+"' value='"+priceList[columnName]+"'/></td>";
					i++;
				}
            	_tbody+="</tr>";
    		});
    		$("#pageBody").append(_tbody);
         	$('#uploadMsg').html('已完成！');
        }/*,
        resetForm:true*/
	});
}

/**
 * 保存导入列表
 */
function saveImportPriceLists(){
	$("#saveForm").ajaxSubmit({
		url : 'priceList_save.action',
        type : "post",
        datatype : "json",
        error:function(data,status){
        	alert(JSON.parse(data));
        	alert("error");
        },
        success:function(result) {
        	data = JSON.parse(result);
        	if(data["msg"] == "保存成功！"){
        		$("#priceListsMsg").text("导入"+data["number"]+"条记录，成功"+data["number"]+"条，错误"+0+"条");
        		$('#importMsg').html('已完成！');
        	}else{
        		$("#priceListsMsg").text("导入"+data["number"]+"条记录，成功"+0+"条，错误"+data["number"]+"条");
        	}
        }
	});
}