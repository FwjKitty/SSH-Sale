<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>登录</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
</head>
<script language="javascript">
function check() {
	if (form.customer_name.value == "") {
		alert("用户名不能为空");
		form.first_name.focus();
		return false;
	} else if (form.last_name.value == "") {
		alert("密码不能为空");
		form.last_name.focus();
		return false;
	} else {
		return true;
	}
}
</script>
<body background="img/bg_login.jpg">
  	<div class="container-fluid">
  	<div class="row">
  		<div class="col-sm-4">
  			<div class="col-sm-10">
  				<h3></h3>
  			</div>
  		</div>
  		<div class="col-sm-4" style="background-color:#fff;margin-top:200px;">
  			${msg}
  			<form class="form-horizontal" role="form" name="form" action="<%=request.getContextPath() %>/LoginAction.action" onsubmit="return check()" method="post">
  				<br/>
		        <strong>订单销售管理系统</strong>
		        <hr/>
		        <div class="form-group">
		            <label class="col-sm-3 control-label">用户名</label>
		            <div class="col-sm-8">
		                <input type="text" name="username" class="form-control" placeholder="UserName" />
		            </div>
		        </div>
		        <div class="form-group">
		            <label class="col-sm-3 control-label">密码</label>
		            <div class="col-sm-8">
		                <input type="password" name="password" class="form-control" placeholder="password" />
		            </div>
		        </div>
		        <div class="form-group">
		            <div class="col-sm-offset-3 col-sm-8">
		                <button type="submit" class="btn btn-success">
		                   	登录
		                </button>
		            </div>
		        </div>
		    </form>
  		</div>
  	</div>
	</div>
  </body>
</html>