/**
 * 分页显示全部
 * @param pageNow
 */
function getPriceListConfigPage(pageNow) {
	$("#msg").text("");
    $.ajax({
        type: "post",
        url: "priceListConfig_getPageResult.action",
        dataType: "json",
        data : {"pageNow":pageNow},
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
            		_tbody +="<td style='background-color:#fffff0;'><input type='checkbox' value='是' name='activity'/></td></tr>";
            	}
    		});
    		_tfooter = "<button onclick='getPriceListConfigPage("+lastpage+")' class='btn btn-default'><<</button>"
				+"<button onclick='getPriceListConfigPage(1)' class='btn btn-default'>first</button>"
				+"<button onclick='getPriceListConfigPage("+finalpage+")' class='btn btn-default'>last</button>"
				+"<button onclick='getPriceListConfigPage("+nextpage+")' class='btn btn-default'>>></button>";
    		$("#pageBody").append(_tbody);
    		$("#pageFooter").append(_tfooter);
        }
    });
}

/**
 * 分页查询
 * @param pageNow
 */
function searchPriceListConfig(pageNow) {
	$("#msg").text("");
	var form = document.getElementById("searchForm");
    $.ajax({
        type: "post",
        url: "priceListConfig_search.action",
        dataType: "json",
        data : {"customersInfo.customerCode":form[0].value,"customersInfo.customerType":form[1].value,
        		"customersInfo.customerName":form[2].value,"priceListConfig.activity":form[3].value,
        		"priceListConfig.excelCol":form[4].value,"priceListConfig.displayName":form[5].value,
        		"pageNow":pageNow},
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

/**
 * 新增配置时选择客户简称
 */
function showSelectCustomerCode(){
	$.ajax({
        type: "post",
        url: "priceListConfig_showSelectCustomerCode.action",
        dataType: "json",
        data : "{}",
        timeout: 5000,
        success: function(customersInfos){
        	var _options = "";
    		//遍历json数组
        	$.each(customersInfos,function(n, customersInfo){
            	_options += "<option value='"+customersInfo.customerId+"'>"+customersInfo.customerCode+"</option>";
    		});
    		$("#saveCustomerCode").append(_options);
    		$("#savePriceListConfig").modal('show');
        }
    });
}
/**
 * 新增配置时，选择客户后显示编辑列表
 */
function showPriceListColumn(){
	$("#pageBody").text("");
	$("#pageBody").append("<input type='hidden' name='customersInfo.customerId' value='$('#saveCustomerCode').val()'/>");
	$.ajax({
        type: "post",
        url: "priceListConfig_showPriceListColumn.action",
        dataType: "json",
        data : "{}",
        timeout: 5000,
        success: function(priceListColumns){
    		var _tbody = "";
    		var _tfooter = "";
    		//遍历json对象
    		var i=0;
    		for(var priceListColumn in priceListColumns){
    			i++;
    			_tbody +="<tr><td style='background-color:#b0c4de;'>"+i+"</td>"
    				+"<td style='background-color:#f8f8ff;'>"+priceListColumn+"</td>"
    				+"<td><input type='text' name='priceListConfig.displayName' style='width:100%;'/></td>"
    				+"<td><input type='text' name='priceListConfig.excelCol' style='width:100%;'/></td>";
    			if(priceListColumn == "hy_item" || priceListColumn == "effective_date_from" || priceListColumn == "effective_date_to"){
            		_tbody +="<td style='background-color:#fffff0;'><input type='checkbox' value='是' name='activity' checked/></td></tr>";
            	}else{
            		_tbody +="<td style='background-color:#fffff0;'><input type='checkbox' value='否' name='activity'/></td></tr>";
            	}
    		}
    		$("#pageBody").append(_tbody);
    		$("#savePriceListConfig").modal('hide');
        }
    });
}

/**
 * 保存配置
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