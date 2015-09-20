<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<title>价格表配置管理</title>
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/css/index.css" rel="stylesheet">
	<script src="<%=request.getContextPath() %>/js/jquery-2.1.1.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.cookie.js"></script>
	<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/priceListConfig.js"></script>
<style type="text/css">
@font-face {
	font-family: 'Glyphicons Halflings';
	src: url('fonts/glyphicons-halflings-regular.eot');
	src: url('fonts/glyphicons-halflings-regular.eot?#iefix')
		format('embedded-opentype'),
		url('fonts/glyphicons-halflings-regular.woff') format('woff'),
		url('../fonts/glyphicons-halflings-regular.ttf') format('truetype'),
		url('../fonts/glyphicons-halflings-regular.svg#glyphicons_halflingsregular')
		format('svg');
}
</style>
<script type="text/javascript">
	getPriceListConfigPage(1);
</script>
</head>
<body>

	<nav class="navbar navbar-link nav1" style="background-color:#67b168"
		role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#" style="color: red">
			<h1style="line-height: 0">销售订单管理系统</h1>
		</a>
	</div>
	<div>
		<form class="navbar-form navbar-right" role="search">
			<div class="form-group">
				<a href="loginActiona!out.action" class="btn btn-success"
					role="button" style="margin-right: 20px">
					<%=session.getAttribute("customer_name")%><br>退出
				</a>
				
			</div>
		</form>
	</div>
	</nav>
	
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-sm-12" style="margin:10px 0;">
				<span>价格管理</span>
				<hr style="margin-top:3px;">
			</div>
			<div class="col-md-2">
				<!--Sidebar content-->
				<!--竖直导航-->
					<div style="width: 200px;">
            <div class="panel-group" id="accordion2">
            <div class="panel-heading">
                <strong style="font-size: 30px;">主数据维护</strong>
            </div>
                <div class="panel panel-default">
                    <div class="panel-heading" data-toggle="collapse"
                        data-parent="#accordion2" href="#collapseOne">
                        <a class="accordion-toggle">销售订单管理</a>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse "
                        style="height: auto;">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#">Java基础</a></li>
                                <li><a href="#">Java面向对象</a></li>
                                <li><a href="#">Java核心API</a></li>
                                <li><a href="#">JavaEE</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" data-toggle="collapse"
                        data-parent="#accordion2" href="#collapseTwo">
                        <a class="accordion-toggle">发货单管理</a>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse "
                        style="height: auto;">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#">SQL基础</a></li>
                                <li><a href="#">Oracle</a></li>
                                <li><a href="#">MySQL</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" data-toggle="collapse"
                        data-parent="#accordion2" href="#collapseThree">
                        <a class="accordion-toggle">主数据维护</a>
                    </div>
                    
                     <div id="collapseThree" class="panel-collapse collapse "
                        style="height: auto;">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <li class="panel-heading" data-toggle="collapse"
                    		    data-parent="#accordion3" href="#collapseThreeLi">
                    		    <a href="#">折扣管理</a></li>
                             		 <div id="collapseThreeLi" class="panel-collapse collapse" style="height: auto;">
                       					 <div class="panel-body">
                         					   <ul class="nav nav-pills nav-stacked">
					                        	  	<li><a href="<%=request.getContextPath()%>/discount/showNormalDiscount.jsp">经常性折扣</a></li>
                               						 <li><a href="<%=request.getContextPath()%>/discount/showOneDiscount.jsp">一次性折扣</a></li>
                               					</ul>
                               				</div>
                               			</div>
                                <li><a href="<%=request.getContextPath()%>/customer/customerlist.jsp">客户管理</a></li>
                                <li><a href="javascript:void(0)" onclick="getPriceListPage(1)">价格表管理</a></li>
                            </ul>
                        </div>
                     </div>
                  </div>
                      
                  <!-- 系统设置 -->
	                <div class="panel panel-default">
	                    <div class="panel-heading" data-toggle="collapse"
	                        data-parent="#accordion2" href="#system_configuration">
	                        <a class="accordion-toggle">系统设置</a>
	                    </div>
	                    <div id="system_configuration" class="panel-collapse collapse "
	                        style="height: auto;">
	            	            <div class="panel-body">
	                            <ul class="nav nav-pills nav-stacked">
	                                <li><a href="#">Orderbase配置</a></li>
	                                <li><a href="#">客户订单配置</a></li>
	                                <li><a href="<%=request.getContextPath() %>/priceListConfig_show.action">价格表配置</a></li>
	                            </ul>
	                        </div>
	                    </div>
	                </div>  
                 
                
            </div>
        </div>
				</div>
			<div class="col-md-10">
				<!--Body content-->
				<div class="panel panel-default">
					<%-- <div class="panel-heading" style="font-size:large">
						<strong>价格表配置管理</strong>
					</div> --%>
					<div class="panel-body" style="margin-left: 0px; padding: 0px">
						<div class="panel">
							<div class="panel-heading">
								<div class="col-sm-10"><%-- action="<%=request.getContextPath() %>/priceListConfig_save.action" --%>
								<form class="form-horizontal" role="form" id="searchForm" method="post">
									<div class="form-group">
							            <label class="col-sm-3 control-label">客户简称</label>
							            <div class="col-sm-3">
							                <input type="text" name="customersInfo.customerCode" class="form-control" placeholder="CustomerCode" />
							            </div>
							            <label class="col-sm-3 control-label">类型</label>
							            <div class="col-sm-3">
							                <input type="text" name="customersInfo.type" class="form-control" placeholder="Type" />
							            </div>
							        </div>
							        <div class="form-group">
							            <label class="col-sm-3 control-label">客户名称</label>
							            <div class="col-sm-3">
							                <input type="text" name="customersInfo.customerName" class="form-control" placeholder="CustomerName" />
							            </div>
							            <label class="col-sm-3 control-label">启用状态</label>
							            <div class="col-sm-3">
							                <select name="priceListConfig.activity" class="form-control">
							                	<option value="全部" selected>全部</option>
							                	<option value="是">是</option>
							                	<option value="否">否</option>
							                </select>
							            </div>
							        </div>
							        <div class="form-group">
							            <label class="col-sm-3 control-label">序号</label>
							            <div class="col-sm-3">
							                <input type="text" name="priceListConfig.excelCol" class="form-control" placeholder="ExcelCol" />
							            </div>
							            <label class="col-sm-3 control-label">字段名称</label>
							            <div class="col-sm-3">
							                <input type="text" name="priceListConfig.displayName" class="form-control" placeholder="ColumnName" />
							            </div>
							        </div>
							        <div class="form-group">
							            <div class="col-sm-offset-4 col-sm-3">
							                <button class="btn" onclick="searchPriceListConfig(1)">
							                   	查询/修改
							                </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							                <button type="submit" class="btn">
							                   	保存
							                </button>
							            </div>
							            <div class="col-sm-offset-3 col-sm-2">
							                <button class="btn" type="button" onclick="showSelectCustomerCode()">
							                   	新增配置
							                </button>
							            </div>
							        </div>
								</form>
								</div>
							</div>
							<div class="col-sm-12"><hr style="border:3px solid #780000;"></div>
							<div class="panel-body form">
								<table class="table table-bordered well" style="text-align:center;cellspacing:0;cellpadding:0;">
									<thead style="background-color:#1e90ff">
										<tr>
											<th>序号</th>
											<th>PL列名</th>
											<th>显示名称</th>
											<th>Excel列</th>
											<th>启用</th>
										</tr>
									</thead>
									<tbody id="pageBody">
									<%-- <s:iterator value="#request.priceListConfigs" id="priceListConfig" status="i">
										<tr>
											<!-- 
											<td><a href="<%=request.getContextPath() %>/PriceListConfig_edit.action?priceListConfig.priceListConfigId=${priceListConfig.priceListConfigId}">编辑</a> | <a href="<%=request.getContextPath() %>/PriceListConfig_del.action?priceListConfig.priceListConfigId=${priceListConfig.priceListConfigId}">删除</a></td>
											 -->
											<td><s:property value="#i.index"/></td>
											<td><s:property value="#priceListConfig.priceListConfigId"/></td>
											<td><s:property value="#priceListConfig.displayName"/></td>
											<td><s:property value="#priceListConfig.excelCol"/></td>
											<td><s:property value="#priceListConfig.activity"/></td>
										</tr>
									</s:iterator> --%>
									</tbody>
									<tfoot class="">
										<tr>
											<td colspan="5">
											<div class="pull-left">${msg}</div>
											<div class="pull-right" id="pageFooter">
											<%-- <s:if test="pageNow+1-1==1">
												<button onclick="getPage(1)" class="btn btn-default"><<</button>
											</s:if>
											<s:else>
												<button onclick="getPage(${pageNow-1})" class="btn btn-default"><<</button>
											</s:else>
												<button onclick="getPage(1,)" class="btn btn-default">first</button>
												<button onclick="getPage(${fn:substringBefore((count-count%10)/10+1, '.')})" class="btn btn-default">last</button>
												<button onclick="getPage(${pageNow+1})" class="btn btn-default">>></button>
											 --%></div>
											</td>
										</tr>
									</tfoot>
								</table>
							</div>
							<div class="panel-footer" style="text-align: center; height: 50px">
								
								<div class="main_page" style="margin-top:-20px"  >
									<nav>
									<ul class="pagination pagination-sm" id="main_page">
										
									</ul>
									</nav>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- modal for save -->
	<div class="modal fade" id="savePriceListConfig" tabindex="-1" role="dialog" aria-labelledby="savePriceListConfigLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                	<button class="close" data-dismiss="modal" aria-label="Close">
	                    <span aria-hidden="true">&times;</span>
	                </button>
	                <h3 class="modal-title" id="savePriceListConfigLabel">选择客户</h3>
	            </div>
                <div class="modal-body">
	                <div class="form-group">
	                    <select class="form-control" id="saveCustomerCode" name="customersInfo.customerCode">
	                    	
	                    </select>
	                </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" onclick="showPriceListColumn()">下一步</button>
                    <button class="btn btn-danger" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>