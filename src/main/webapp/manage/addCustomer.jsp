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
	function getAddress() {
		var urlGet = "AddressAction!showAddress.action";
		var val;
		$.getJSON(urlGet, function(result) {
			$.each(result, function(i, entity) {
				val += "<option value='"+entity.addressid+"'>" + entity.address
						+ "</option>";
			});
			$("#sl").html(val);
		});
	}
	getAddress();
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
		<div class="container-fluid panel1" style="height: 600px">
			<div class="row-fluid ">
				<div class="col-md-2 "
					style="height: 580px; width: 260px; margin-left: -30px">
					<!--Sidebar content-->
					<!--竖直导航-->
					<ul class="nav nav-pills nav-stacked nav-l">
						<li class="active "><a href="#" onclick="getCustomer(1)"><span
								class=" glyphicon glyphicon-stop "></span> Donbord<span
								class="glyphicon glyphicon-chevron-right"
								style="margin-left: 105px"></span> </a></li>
						<li><a href="index.jsp"><span
								class=" glyphicon glyphicon-stop "></span> 应用设置<span
								class="glyphicon glyphicon-chevron-right"
								style="margin-left: 105px"></span> </a></li>
						<li><a href="index.jsp"><span
								class=" glyphicon glyphicon-stop "></span> 管理设置<span
								class="glyphicon glyphicon-chevron-right"
								style="margin-left: 105px"></span> </a></li>
						<li><a href="index.jsp"><span
								class=" glyphicon glyphicon-stop "></span> 数据配置<span
								class="glyphicon glyphicon-chevron-right"
								style="margin-left: 105px"></span> </a></li>

						<li><a href="index.jsp"><span
								class=" glyphicon glyphicon-stop "></span> 数据管理<span
								class="glyphicon glyphicon-chevron-right"
								style="margin-left: 105px"></span> </a></li>
						<li><a href="index.jsp"><span
								class=" glyphicon glyphicon-stop "></span> 订单管理<span
								class="glyphicon glyphicon-chevron-right"
								style="margin-left: 105px"></span> </a></li>
						<li><a href="index.jsp"><span
								class=" glyphicon glyphicon-stop "></span> 发货单管理<span
								class="glyphicon glyphicon-chevron-right"
								style="margin-left: 90px"></span> </a></li>
					</ul>
				</div>
				<div class="col-md-10" style="height: 500px">
					<!--Body content-->
					<div class="panel panel-default">
						<div class="panel-heading" style="font-size: large">
							<strong>创建Customer</strong>
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

										<form class="form-horizontal well"
											action="<%=request.getContextPath()%>/CustomerAction!add.action" method="get">  
											<fieldset>

												<div class="input-group" style="margin-left: 70px;">
													<label class="input-group-addon" id="basic-addon1">First
														Name*</label> <input name="customer.firstName"
														style="width: 350px" type="text" class="form-control"
														placeholder="" aria-describedby="basic-addon1">
												</div>
												<div class="input-group"
													style="margin-left: 70px; margin-top: 20px">
													<label class="input-group-addon " id="basic-addon2">Last
														Name*</label> <input name="customer.lastName" style="width: 350px"
														type="text" class="form-control" placeholder=""
														aria-describedby="basic-addon1">
												</div>
												<div class="input-group"
													style="margin-left: 70px; margin-top: 20px">
													<label class="input-group-addon" id="basic-addon3"
														style="width: 99px">Email</label> <input
														name="customer.email" style="width: 350px" type="text"
														class="form-control" placeholder=""
														aria-describedby="basic-addon1">
												</div>


												<div class="input-group"
													style="margin-left: 70px; margin-top: 20px">

													<!-- Select Basic -->
													<label class="input-group-addon" id="basic-addon4"
														style="width: 99px">Address*</label> <select
														name="addressid" class="input-xlarge" id="sl"
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