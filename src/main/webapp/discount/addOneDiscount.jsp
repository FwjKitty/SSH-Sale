<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加折扣</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/index.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/js/jquery-2.1.1.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
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
	$(function(){
		//名称
		$(".tdchange0").dblclick(function(){
			$(this).text("");
			var  input = "<input type='text'/>";			
			$(this).append(input);
			$("input").focus();
			$("input").blur(function(){
				if($(this).val()==""){
					$(this).remove();
				}else{
					$(this).closest("td").text($(this).val());
					$(".a0").attr("value",$(this).val());
				}
			})
		
		})
		//客户代码
	/* 	$(".tdchange1").dblclick(function(){
			
			$(this).text("");
			var  input = "<input type='text'/>";			
			$(this).append(input);
			
			$("input").focus();
			 $("input").blur(function(){
				if($(this).val()==""){
					$(this).remove();
				}else{
					$(this).closest("td").text($(this).val());
					$(".a1").attr("value",$(this).val());
				}
				
			})  
			
		
		})*/
		//折扣金额
		$(".tdchange2").dblclick(function(){
			$(this).text("");
			var  input = "<input type='text'/>";			
			$(this).append(input);
			$("input").focus();
			$("input").blur(function(){
				if($(this).val()==""){
					$(this).remove();
				}else{
					$(this).closest("td").text($(this).val());
					$(".a2").attr("value",$(this).val());
					$(".tdchange4").text($(this).val());
					$(".a4").attr("value",$(this).val());
				}
			})
		
		})
		
		//折扣余额
		$(".tdchange4").dblclick(function(){
			$(this).text("");
			var  input = "<input type='text'/>";			
			$(this).append(input);
			$("input").focus();
			$("input").blur(function(){
				if($(this).val()==""){
					$(this).remove();
				}else{
					
					$(this).closest("td").text($(this).val());
					$(".a4").attr("value",$(this).val());
				}
			})
		
		})
		
		//有效
		$(".tdchange5").dblclick(function(){
			$(this).text("");
			var  input = "<input type='text'/>";			
			$(this).append(input);
			$("input").focus();
			$("input").blur(function(){
				if($(this).val()==""){
					$(this).remove();
					
				}else{
					$(this).closest("td").text($(this).val());
						$(".a5").attr("value",$(this).val());
					
				}
			})
		
		})
	
		
		
	})
	

	
	//
	//验证
	function v(){
		if($(".tdchange0").text()==""){
			alert("折扣名称不能为空");
			return false;
		}
		else if($(".tdchange2").text()==""){
			alert("折扣金额不能为空");
			return false;
		}
			return true;
		
	}
	
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
		<div class="container-fluid panel1" style="height: 600px;width:1800px">
			<div class="row-fluid ">
				<div class="col-md-2 "
					style="height: 580px; width: 260px">
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
				<div class="col-md-10" style="height: 500px;width:1200px">
					<!--Body content-->
					<div class="panel panel-default">
						<div class="panel-heading" style="font-size: large">
							<strong>折扣管理</strong>
						</div>
						<div class="panel-body" style="margin-left: 0px; padding: 0px">
							<div class="panel" style="border-top: solid #67b168">
								<div class="panel-heading">
									<div class="row">
										<div class="col-md-3">
											<h4>新增/编辑折扣</h4>
										</div>

									</div>
									<div class="panel-body ">

										<form class="form-horizontal well"
											action="<%=request.getContextPath()%>/SpecialDiscountAction!add.action"
											method="post" onsubmit="return v()">
											<fieldset>
											
											
											
											<input
													class="a2" type="hidden" name="specialDiscount.amount"
													value="" /> 
												 <input class="a3" type="hidden"
													name="specialDiscount.appliedAmount" value="0" />
												
												<input class="a0" type="hidden"
													name="specialDiscount.discountName" value="" />  <input
													class="a4" type="hidden" name="specialDiscount.balance"
													value="" />
													<input
													class="a5" type="hidden" name="specialDiscount.activity"
													value="是" />
												<table class="table  table-bordered table-striped well	"
													id="customer" style="border: solid #67b168;">
													<tr>
														<td>折扣名称</td>
														<td>客户代码</td>
														<td>折扣金额</td>
														<td>已用金额</td>
														<td>折扣余额</td>
														<td>有效</td>

													</tr>
													<tr>

														<td class="tdchange0"></td>
														<td class="tdchange1">
														<select class="input-xlarge " id="sl"
															name="specialDiscount.customerCode">
																
															</select>		
														</td>
														<td class="tdchange2"></td>
														<td class="tdchange3">0</td>
														<td class="tdchange4"></td>
														<td class="tdchange5">是</td>
													</tr>

												</table>
												<div>
													<button type="submit" class="btn btn-success"
														style="margin-left: 900px; width: 160px">保存</button>
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
<script>
function getCus() {
	var urlGet = "ShowCustomerCodeAction!showCustomers.action";
	var val;
	$.getJSON(urlGet, function(result) {
		$.each(result, function(i, entity) {
			val += "<option value='"+entity.customerCode+"'>" + entity.customerCode
					+ "</option>";
		});
		$("#sl").html(val);
		
	});
}
getCus();
</script>
</body>
</html>