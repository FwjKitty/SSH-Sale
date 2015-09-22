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
 * 查询
 */
function searchPriceListConfig() {
	$("#pageBody").text("");
	$("#msg").text("");
	var form = document.getElementById("searchForm");
    $.ajax({
        type: "post",
        url: "priceListConfig_search.action",
        dataType: "json",
        data : {"customersInfo.customerCode":form[0].value,"customersInfo.type":form[1].value,
        		"customersInfo.customerName":form[2].value,"priceListConfig.activity":form[3].value,
        		"priceListConfig.excelCol":form[4].value,"priceListConfig.displayName":form[5].value},
        timeout: 5000,
        success: function(priceListConfigs){
    		var _tbody = "";
    		//遍历json数组
    		$.each(priceListConfigs,function(n, priceListConfig){
            	_tbody +="<tr><td style='background-color:#b0c4de;'>"+(n+1)+"<input type='hidden' name='priceListConfigs["+n+"].customersInfo.customerId' value='"+priceListConfig.customerId+"'/><input type='hidden' name='priceListConfigs["+n+"].priceListConfigId' value='"+priceListConfig.priceListConfigId+"'/></td>"
            		+"<td style='background-color:#f8f8ff;'>"+priceListConfig.priceListCol+"<input type='hidden' name='priceListConfigs["+n+"].priceListCol' value='"+priceListConfig.priceListCol+"'/></td>"
            		+"<td><input type='text' name='priceListConfigs["+n+"].displayName' value='"+priceListConfig.displayName+"'  style='width:100%;'/></td>"
            		+"<td><input type='text' name='priceListConfigs["+n+"].excelCol' value='"+priceListConfig.excelCol+"' style='width:100%;'/></td>";
            	if(priceListConfig.activity == "是"){
            		_tbody +="<td style='background-color:#fffff0;'><input type='checkbox' value='是' name='priceListConfigs["+n+"].activity' checked/></td></tr>";
            	}else{
            		_tbody +="<td style='background-color:#fffff0;'><input type='checkbox' value='否' name='priceListConfigs["+n+"].activity'/></td></tr>";
            	}
    		});
    		$("#saveAndUpdate").attr("name","search");
    		$("#pageBody").append(_tbody);
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
	$.ajax({
        type: "post",
        url: "priceListConfig_showPriceListColumn.action",
        dataType: "json",
        data : "{}",
        timeout: 5000,
        success: function(priceListColumns){
    		var _tbody = "";
    		//遍历json对象
    		var i=0;
    		for(var priceListColumn in priceListColumns){
    			i++;
    			_tbody +="<tr><td style='background-color:#b0c4de;'>"+i+"<input type='hidden' name='priceListConfigs["+(i-1)+"].customersInfo.customerId' value='"+$('#saveCustomerCode').val()+"'/></td>"
    				+"<td style='background-color:#f8f8ff;'>"+priceListColumn+"<input type='hidden' name='priceListConfigs["+(i-1)+"].priceListCol' value='"+priceListColumn+"'/></td>"
    				+"<td><input type='text' name='priceListConfigs["+(i-1)+"].displayName' style='width:100%;'/></td>"
    				+"<td><input type='text' name='priceListConfigs["+(i-1)+"].excelCol' style='width:100%;'/></td>";
    			if(priceListColumn == "hy_item" || priceListColumn == "effective_date_from" || priceListColumn == "effective_date_to"){
            		_tbody +="<td style='background-color:#fffff0;'><input type='checkbox' value='是' name='priceListConfigs["+(i-1)+"].activity' checked/></td></tr>";
            	}else{
            		_tbody +="<td style='background-color:#fffff0;'><input type='checkbox' value='否' name='priceListConfigs["+(i-1)+"].activity'/></td></tr>";
            	}
    		}
    		$("#saveAndUpdate").attr("name","add");
    		$("#pageBody").append(_tbody);
    		$("#savePriceListConfig").modal('hide');
        }
    });
}

/**
 * 保存配置
 */
function savePriceListConfig() {
	var url = "priceListConfig_update.action";
	if($("#saveAndUpdate").attr("name") == "search"){
		url = "priceListConfig_update.action";
	}else if($("#saveAndUpdate").attr("name") == "add"){
		url = "priceListConfig_save.action";
	}
	$("#saveForm").ajaxSubmit({
		url : url,
        type : "post",
        datatype : "text",
        success:function(msg) {
        	alert(msg);
        }
	});
}