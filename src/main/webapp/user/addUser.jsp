<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加客户</title>
<link href="<%=request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/css/index.css" rel="stylesheet">
<script src="<%=request.getContextPath() %>/js/jquery-2.1.1.min.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
<style type="text/css">
@font-face {
	font-family: 'Glyphicons Halflings';
	src: url('../fonts/glyphicons-halflings-regular.eot');
	src: url('../fonts/glyphicons-halflings-regular.eot?#iefix')
		format('embedded-opentype'),
		url('../fonts/glyphicons-halflings-regular.woff') format('woff'),
		url('../fonts/glyphicons-halflings-regular.ttf') format('truetype'),
		url('../fonts/glyphicons-halflings-regular.svg#glyphicons_halflingsregular')
		format('svg');
}
</style>

<script type="text/javascript">

function check() {
	if ($("#username").val().trim() == "") {
		alert("用户名不能为空");
		$("#username").focus();
		return false;
	} else if ($("#password").val().trim() == "") {
		alert("密码不能为空");
		$("#password").focus();
		return false;
	}else if($("#password").val()!=$("#confirmPassword").val()){
		alert("两次输入密码不同");
		$("#password").focus();
		return false;
	} 
	else {
		return true;
	}
}
	

	function getRole() {
		var urlGet = "UserAction!showRole.action";
		var val;
		$.getJSON(urlGet, function(result) {
			$.each(result, function(i, entity) {
				val += "<option value='"+entity.roleId+"'>" + entity.rolename
						+ "</option>";
			});
			$("#sl").html(val);
		});
	}
	getRole();
</script>

</head>
<body>

	<nav class="navbar navbar-link nav1" style="background-color:#67b168"
		role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#" style="color: red"><h1
				style="line-height: 0">8831许凯迪</h1> </a>
	</div>
	<div>
		<form class="navbar-form navbar-right" role="search">
			<div class="form-group">
				<a href="<%=request.getContextPath()%>/LoginAction!out.action"
					class="btn btn-success" role="button" style="margin-right: 20px"><%=session.getAttribute("username")%><br>退出</a>

			</div>
		</form>
	</div>
	</nav>



	<div class="panel panel-default">
		<div class="container-fluid panel1" style="height: 950px;width:1800px">
			<div class="row-fluid ">
				<div class="col-md-2 "
					style="height: 950px;width:260px">
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
                        <a class="accordion-toggle">首页</a>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse "
                        style="height: auto;">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                     			<li><a href="<%=request.getContextPath()%>/user/userStatic.jsp">用户状态</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" data-toggle="collapse"
                        data-parent="#accordion2" href="#collapseTwo">
                        <a class="accordion-toggle">销售订单管理</a>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse "
                        style="height: auto;">
                 <!--        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#">Java基础</a></li>
                                <li><a href="#">Java面向对象</a></li>
                                <li><a href="#">Java核心API</a></li>
                                <li><a href="#">JavaEE</a></li>
                            </ul>
                        </div> -->
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" data-toggle="collapse"
                        data-parent="#accordion2" href="#collapseThree">
                        <a class="accordion-toggle">用户管理</a>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse "
                        style="height: auto;">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="<%=request.getContextPath()%>/user/showUser.jsp">用户管理</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" data-toggle="collapse"
                        data-parent="#accordion2" href="#collapseFour">
                        <a class="accordion-toggle">主数据维护</a>
                    </div>
                    
                     <div id="collapseFour" class="panel-collapse collapse "
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
                                <li><a href="<%=request.getContextPath() %>/priceList_show.action">价格表管理</a></li>
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
				<div class="col-md-10" style="height: 700px;width:1200px">
					<!--Body content-->
					<div class="panel panel-default">
						<div class="panel-heading" style="font-size: large">
							<strong>创建用户</strong>
						</div>
						<div class="panel-body" style="margin-left: 0px; padding: 0px">
							<div class="panel" style="border-top: solid #67b168">
								<div class="panel-heading">
									<div class="row">
										<div class="col-md-3">
											<h4>基本信息</h4>
										</div>

									</div>
									<div class="panel-body ">

										<form class="form-horizontal well"  id="myForm"
											action="<%=request.getContextPath()%>/UserAction!add.action" method="post" onsubmit="return check()">  
											<fieldset>

												<div class="input-group" style="margin-left: 70px;">
													<label class="input-group-addon" id="basic-addon1">username*</label> <input name="user.username"
													id="username"	style="width: 350px" type="text" class="form-control"
														placeholder="" aria-describedby="basic-addon1">
												</div>
												<div class="input-group"
													style="margin-left: 70px; margin-top: 20px">
													<label class="input-group-addon " id="basic-addon2">password
													*</label> <input name="user.password" style="width: 350px"
													id="password"	type="text" class="form-control" placeholder=""
														aria-describedby="basic-addon1">
												</div>
												<div class="input-group"
													style="margin-left: 70px; margin-top: 20px">
													<label class="input-group-addon" id="basic-addon3"
														style="width: 99px">确认密码*</label> <input
													id="confirmPassword"	style="width: 350px" type="text"
														class="form-control" placeholder=""
														aria-describedby="basic-addon1">
												</div>


												<div class="input-group"
													style="margin-left: 70px; margin-top: 20px">

													<!-- Select Basic -->
													<label class="input-group-addon" id="basic-addon4"
														style="width: 99px">角色名*</label> <select
														name="rolesName" class="input-xlarge" id="sl"
														style="width: 350px; height: 34px">
														<option></option>
													</select>
												</div>
												<div class="btn-group" role="group" aria-label="..."
													style="margin-left: 70px; margin-top: 20px">
													<button type="submit" class="btn btn-success">提交</button>
													<button type="reset" class="btn btn-default">取消</button>
												</div>

											</fieldset>
										</form>
									</div>
								</div>
							</div>
							<div class="panel-footer well" style="height: 120px"></div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>