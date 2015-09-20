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
	<title>价格表管理</title>
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/css/index.css" rel="stylesheet">
	<script src="<%=request.getContextPath() %>/js/jquery-2.1.1.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/jquery.cookie.js"></script>
	<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/priceList.js"></script>
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
	getPriceListPage(1);
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
				<span>面包屑</span>
				<hr style="margin-top:3px;">
			</div>
			<div class="col-md-2">
				<!--Sidebar content-->
				<!--竖直导航-->
		        <div class="panel-group" id="accordion2">
		            <!-- 销售订单管理 -->
		            <div class="panel panel-default">
	                   <div class="panel-heading" data-toggle="collapse"
	                        data-parent="#accordion2" href="#sale_order">
	                        <a class="accordion-toggle">销售订单管理</a>
	                    </div>
	                    <div id="sale_order" class="panel-collapse collapse "
	                        style="height: auto;">
	                        <div class="panel-body">
	                            <ul class="nav nav-pills nav-stacked">
	                                <li><a href="#">1</a></li>
	                                <li><a href="#">2</a></li>
	                                <li><a href="#">3</a></li>
	                                <li><a href="#">4</a></li>
	                            </ul>
	                        </div>
	                    </div>
	                </div>
	                <!-- 发货单管理 -->
	                <div class="panel panel-default">
	                    <div class="panel-heading" data-toggle="collapse"
	                        data-parent="#accordion2" href="#dispatch_order">
	                        <a class="accordion-toggle">发货单管理</a>
	                    </div>
	                    <div id="dispatch_order" class="panel-collapse collapse "
	                        style="height: auto;">
	                        <div class="panel-body">
	                            <ul class="nav nav-pills nav-stacked">
	                                <li><a href="#">1</a></li>
	                                <li><a href="#">2</a></li>
	                                <li><a href="#">3</a></li>
	                            </ul>
	                        </div>
	                    </div>
	                </div>
	                <!-- 主数据维护 -->
	                <div class="panel panel-default">
	                    <div class="panel-heading" data-toggle="collapse"
	                        data-parent="#accordion2" href="#main_data">
	                        <a class="accordion-toggle">主数据维护</a>
	                    </div>
	                     <div id="main_data" class="panel-collapse collapse "
	                        style="height: auto;">
	                        <div class="panel-body">
	                            <ul class="nav nav-pills nav-stacked">
	                                <li class="panel-heading" data-toggle="collapse"
	                    		    data-parent="#accordion3" href="#collapseThreeLi">
	                    		    <a href="#">折扣管理</a></li>
	                             		 <div id="collapseThreeLi" class="panel-collapse collapse" style="height: auto;">
	                       					 <div class="panel-body">
	                         					   <ul class="nav nav-pills nav-stacked">
						                        	  	<li><a href="#">经常性折扣</a></li>
	                               						 <li><a href="#">一次性折扣</a></li>
	                               					</ul>
	                               				</div>
	                               			</div>
	                                <li><a href="javascript:void(0)" onclick="getPriceListPage(1)">价格表管理</a></li>
	                                <li><a href="#">客户管理</a></li>
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
			<div class="col-md-10">
				<!--Body content-->
				<div class="panel panel-default">
					<div class="panel-heading" style="font-size: large">
						<strong>价格表管理</strong>
					</div>
					<div class="panel-body" style="margin-left: 0px; padding: 0px">
						<div class="panel">
							<div class="panel-heading">
								<div class="col-sm-10">
								<form class="form-horizontal" role="form" name="form" id="searchForm" method="post">
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
							            <label class="col-sm-3 control-label">工厂型号</label>
							            <div class="col-sm-3">
							                <input type="text" name="priceList.hyItem" class="form-control" placeholder="HYItem" />
							            </div>
							        </div>
							        <div class="form-group">
							            <div class="col-sm-offset-3 col-sm-4">
							                <button type="button" class="btn" onclick="searchPriceList()">
							                   	查询/编辑
							                </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							                <button type="button" class="btn" onclick="showSelectCustomerCode()">
							                  	 新增
							                </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							                <button type="submit" class="btn">
							                  	 保存
							                </button>
							            </div>
							            <div class="col-sm-offset-1 col-sm-3">
							                <button type="submit" class="btn">
							                   	导出Excel
							                </button>
							                <button type="submit" class="btn" onclick="showImportPriceList()">
							                   	导入Excel
							                </button>
							            </div>
							        </div>
								</form>
								</div>
							</div>
							<div class="col-sm-12"><hr style="border:3px solid #780000;"></div>
							<div class="panel-body">
								<div class='form-group'>
						            <label class='col-sm-3 control-label'>导入文件</label>
						            <div class='col-sm-3'>
						                <input type='file' name='priceListFile' class='form-control'/>
						            </div>
						        </div>
						        <div class='form-group'>
							    	<div class='col-sm-2'>
							        	<button type='button' class='btn' onclick='searchPriceList()'>
							            	选择
							            </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							            <button type='button' class='btn' onclick='showSelectCustomerCode()'>
											导入
							            </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							            <button type='button' class='btn'>
							             	确认
							            </button>
							        </div>
							    </div>
						        <div class='col-sm-12'><hr style='border:3px solid #780000;'></div>
						        <table class='table table-striped table-bordered table-hover well' style='text-align:center;'>
									<thead style='background-color:#1e90ff;' id='pageHead'>
									</thead>
									<tbody id='pageBody'>
									</tbody>
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
						<div class="panel-footer well" style="height: 120px"></div>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- modal for save -->
	<div class="modal fade" id="selectCustomerCodeModal" tabindex="-1" role="dialog" aria-labelledby="selectCustomerCodeLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                	<button class="close" data-dismiss="modal" aria-label="Close">
	                    <span aria-hidden="true">&times;</span>
	                </button>
	                <h3 class="modal-title" id="selectCustomerCodeLabel">选择客户</h3>
	            </div>
                <div class="modal-body">
	                <div class="form-group">
	                    <select class="form-control" id="selectCustomerCode">
	                    	
	                    </select>
	                </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" onclick="showPriceListHeader()">下一步</button>
                    <button class="btn btn-danger" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>