<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="com.hand.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/css/index.css" rel="stylesheet">
<script src="<%=request.getContextPath() %>/js/jquery-2.1.1.min.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.cookie.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
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
</head>
<script type="text/javascript">
	var page = 1;
	var mmid = 0;

	//查询显示
	function showQuery(){
		var name=$("#name").val();
		var type=$("#sl").val();
		var urlGet ="<%=request.getContextPath()%>/NormalDiscountAction!query.action?name="+name+"&type="+type;
		//$("#customer").html("");

		$
				.getJSON(
						urlGet,
						function(data) {
							var row = "<tr><td>序号</td><td>折扣名称</td><td>折扣类型</td><td>折扣基准</td><td>折扣数量（片）</td><td>折扣率</td><td>有效</td><td>操作</td></tr>";

							$
									.each(
											data,
											function(entryIndex, entry) {//遍历JSON

												row += "<tr><td>"
														+entry.id
														+"</td><td>"
														+ entry.discountName
														+ "</td><td>"
														+ entry.type
														+ "</td><td>"
														+ entry.discountBase
														+ "</td><td>"
														+ entry.baseQty
														+ "</td><td>"
														+ entry.discountRate
														+ "</td><td>"
														+ entry.activity
														+ "</td><td><a type='button' class='btn btn-success' id="
														+ entry.normalId
														+ " href='<%=request.getContextPath()%>/discount/addNormalDiscount.jsp?id="+entry.normalId+"&discountName="
														+entry.discountName+"&discountBase="
														+entry.discountBase+"&type="
														+entry.type+"&baseQty="
														+entry.baseQty+"&discountRate="
														+entry.discountRate+"&activity="
														+entry.activity+"'>编辑</td></tr>";

											});

							$("#customer").html(row);

						});
		
	}
	
	
	
	function getCustomer(curPage1) {
		
		
		var urlGet ="<%=request.getContextPath()%>/NormalDiscountAction!showPage.action?curPage=" + curPage1;
		//$("#customer").html("");

		$
				.getJSON(
						urlGet,
						function(data) {
							var row = "<tr><td>序号</td><td>折扣名称</td><td>折扣类型</td><td>折扣基准</td><td>折扣数量（片）</td><td>折扣率</td><td>有效</td><td>操作</td></tr>";

							$
									.each(
											data,
											function(entryIndex, entry) {//遍历JSON

												row += "<tr><td>"
														+entry.id
														+"</td><td>"
														+ entry.discountName
														+ "</td><td>"
														+ entry.type
														+ "</td><td>"
														+ entry.discountBase
														+ "</td><td>"
														+ entry.baseQty
														+ "</td><td>"
														+ entry.discountRate
														+ "</td><td>"
														+ entry.activity
														+ "</td><td><a type='button' class='btn btn-success' id="
														+ entry.normalId
														+ " href='<%=request.getContextPath()%>/discount/editNormalDiscount.jsp?id="+entry.normalId+"&discountName="
														+entry.discountName.replace('%','%25')+"&discountBase="
														+entry.discountBase+"&type="
														+entry.type+"&baseQty="
														+entry.baseQty+"&discountRate=" 
														+entry.discountRate+"&activity="
														+entry.activity+"'>编辑</td></tr>";

											});

							$("#customer").html(row);

						});

	}
	

		//分页
		function getFirstPage(){
		makePrePage(10);
		getCustomer(1);
			}
		getFirstPage();
	
	
	function mod(even) {
		mmid = even.getAttribute("id");
		alert(mmid);
		var heigh = document.body.scrollHeight;
	
    	getAddress();
    
		//alert("sdfsdf");
		$("#model6").modal().css({
			"margin-top" : function() {
				return (heigh / 5);
			}
		});
		
		$("#dd").attr("value", mmid);
		$("#model6").modal();
	}
	
	
	//向前翻页
	function makePrePage(start){
	    var url = "<%=request.getContextPath()%>/NormalDiscountAction!getCount.action";
	    $.post(url,function(data){
	        var count = Math.ceil(data/10);//存储客户总数
	        $.cookie("count",data);
	        var str1 = null;
	        var str2 = null;
	        var str3 = null;
	        if(start-10 == 0){//生成向前翻页
	            str1 = "<li role='presentation' class='disabled'>"
	                +"<a href='#' aria-label='Previous'>"
	                +"<span aria-hidden='true'>&laquo;</span></a></li>";
	        }else{
	            str1 = "<li role='presentation'>"
	                +"<a href='#' aria-label='Previous' onclick='makePrePage("+(start-10)+")' value="+ (start-10) +">"
	                +"<span aria-hidden='true'>&laquo;</span></a></li>";
	        }
	        //生成向后翻页
	        var sum;//记录中间生成的页数
	        if(start+1 <= count) {
	            str3 = "<li role='presentation'>"
	                + "<a href='#' aria-label='Next' onclick='makeNextPage("+(start+1)+")'value="+ (start+1) +">"
	                + "<span aria-hidden='true'>&raquo;</span></a></li>";
	            sum = start + 1;
	        }else{
	            str3 = "<li role='presentation' class='disabled'>"
	                + "<a href='#' aria-label='Next'>"
	                + "<span aria-hidden='true'>&raquo;</span></a></li>";
	            sum = count + 1;
	        }
	        str2 = "<li role='presentation' class='active'>"
	        	+ "<a href='#' role='button' onclick='getCustomer("+(start-10+1)+")'value="+ (start-10+1) +">"+(start-10+1)
	            + "</a></li>";
	        for(var i = start-10+1+1; i < sum; i++){
	            var temp="<li role='presentation'>"
	                +"<a href='#' role='button' onclick='getCustomer("+ i +")'value="+ i +">"+ i +"</a></li>";
	            str2 = str2 + temp;
	        }
	        $("#main_page").html(str1+str2+str3);
	        $("#main_page a").click(function(e){
	            e.preventDefault();
	            $(this).tab("show");
	            $.cookie("pageNum",$(this).attr("value"));//记录当前是分页的第几页
	            $.cookie("pageIdx",$(this).attr("value"));//记录具体所在页数
	            
	        });
	        getCustomer(start-10+1);
	        
	    });   
	}
	//向后翻页
	function makeNextPage(end){
	    var url = "<%=request.getContextPath()%>/NormalDiscountAction!getCount.action";
	    $.post(url,function(data){
	        var count = Math.ceil(data/10);//存储客户总数
	        $.cookie("count",data);
	        var str1 = null;
	        var str2 = null;
	        var str3 = null;
	        //生成向前翻页
	        str1 = "<li role='presentation'>"
	            +"<a href='#' aria-label='Previous' onclick='makePrePage("+(end-1)+")'value="+ (end-1) +">"
	            +"<span aria-hidden='true'>&laquo;</span></a></li>";
	        //生成向后翻页
	        var sum;//记录中间生成的页数
	        if(end+10 <= count) {
	            str3 = "<li role='presentation'>"
	                + "<a href='#' aria-label='Next' onclick='makeNextPage("+(end+10)+")'value="+ (end+10) +">"
	                + "<span aria-hidden='true'>&raquo;</span></a></li>";
	            sum = end + 10;
	        }else{
	            str3 = "<li role='presentation' class='disabled'>"
	                + "<a href='#' aria-label='Next'>"
	                + "<span aria-hidden='true'>&raquo;</span></a></li>";
	            sum = count +1;
	        }
	        var str2 = "<li role='presentation' class='active'>"
	            +"<a href='#' role='button' onclick='getCustomer("+ end +")'value="+ end +">"+ end +"</a></li>";
	        for(var i = end + 1; i < sum; i++){
	            var temp="<li role='presentation'>"
	                +"<a href='#' role='button' onclick='getCustomer("+ i +")'value="+ i +">"+ i +"</a></li>";
	            str2 = str2 + temp; 
	        }
	        $("#main_page").html(str1+str2+str3);
	        $("#main_page a").click(function(e){
	            e.preventDefault();
	            $(this).tab("show");
	            $.cookie("pageNum",$(this).attr("value"));//记录当前是分页的第几页
	            $.cookie("pageIdx",$(this).attr("value"));//记录具体所在页数
	        });
	        getCustomer(end);
	    });
	}	
	
</script>




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
				<a href="loginActiona!out.action" class="btn btn-success"
					role="button" style="margin-right: 20px"><%=session.getAttribute("username")%><br>退出</a>
				
			</div>
		</form>
	</div>
	</nav>

	<div class="panel panel-default" >
		<div class="container-fluid panel1" style="height: 950px;width:1800px">
			<div class="row-fluid ">
				<div class="col-md-2 " style="height: 950px;width:260px">
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
                        <a class="accordion-toggle">Java</a>
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
                        <a class="accordion-toggle">数据库</a>
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
					                        	  	<li><a href="#">经常性折扣</a></li>
                               						 <li><a href="#">一次性折扣</a></li>
                               					</ul>
                               				</div>
                               			</div>
                                <li><a href="#">客户管理</a></li>
                                <li><a href="#">价格表管理</a></li>
                            </ul>
                        </div>
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
							<strong>折扣管理</strong>
						</div>
						<div class="panel-body ">
								<form action="<%=request.getContextPath()%>/NormalDiscountAction!query.action" method="post">
                                    <div class=" form-inline" >
                                        <fieldset>
                                            <div class="input-group" style="margin-left: 70px">
                                                <label class="input-group-addon" id="basic-addon3"  style="width: 99px">折扣名称</label>
                                                <input  style="width: 350px" type="text" id="name" class="form-control" placeholder="" aria-describedby="basic-addon1">
                                            </div>

                                            <div class="input-group" style="margin-left: 70px">
                                                <!-- Select Basic -->
                                                <label class="input-group-addon" id="basic-addon4" style="width: 99px"  >类型</label>

                                                    <select class="input-xlarge" id="sl" style="width: 350px;height: 34px" id="select1">
                                                        <option selected="selected">全部类型</option>
                                                        <option>一般折扣</option>
                                                        <option >通用加价</option>
                                                    </select>
                                            </div>
                                            <div class="btn-group " role="group" aria-label="..." style="margin-left: 600px;margin-top: 60px">
                                                <button type="button" class="btn btn-success " role="button" style="width: 150px" onclick="javascript:window.location.href='<%=request.getContextPath()%>/discount/addNormalDiscount.jsp?id=&discountName=&discountBase=金额&type=一般折扣&baseQty=&discountRate=&activity=是'">新增</button>
                                                <button type="button" class="btn btn-default  "  style="width: 150px;margin-left: 20px" onclick="showQuery();">查询</button>
                                            </div>

                                        </fieldset>
                                    </div>
                                   </form> 
                                </div>
						
						
						
						<div class="panel-body" style="margin-left: 0px; padding: 0px">
							<div class="panel" style="border-top: solid #67b168">
								<div class="panel-heading">
									<div class="row">
										<div class="col-md-3">
											<h4>经常性折扣</h4>
										</div>
										<div class="col-md-9">
											<%-- <button type="button" class="btn btn-success"
												onclick="window.location='<%=request.getContextPath()%>/manage/addCustomer.jsp'">新建</button> --%>
										</div>
									</div>
									<div class="panel-body form">

										<table class="table  table-bordered table-striped well	"
											id="customer" style=" border: solid #67b168;">
										</table>
										<div class="panel-footer"
											style="text-align: center; height: 50px">
											
											<div class="main_page" style="margin-top:-20px"  >
												<nav>
												<ul class="pagination pagination-sm" id="main_page"></ul>
												</nav>
											</div>
									
										</div>
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

	<div class="modal fade myModal2" id="model6" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<Strong>进入编辑</Strong>
				</div>
				<div class="modal-body">
					<form action="CustomerAction!update.action">
						<div class="form-group">
							<input type="hidden" name="customer.customerId" id="dd" />
							<div class="row form-group">
								<div class="row">
									<div class="col-md-2" style="margin-left: 120px">firstname</div>
									<input class="col-md-4" type="text" name="customer.firstName">
								</div>
							</div>
							<div class="row form-group">
								<div class="row">
									<div class="col-md-2" style="margin-left: 120px">lastname</div>
									<input class="col-md-4" type="text" name="customer.lastName">
								</div>
							</div>

							<div class="row form-group">
								<div class="row">
									<div class="col-md-2" style="margin-left: 120px">email</div>
									<input class="col-md-4" type="text" name="customer.email">
								</div>
							</div>

							<div class="row form-group">
								<div class="row">
									<div class="col-md-2" style="margin-left: 120px">address</div>

									<select name="address_id" style="width: 310px; heigth: 120"
										class="selectpicker" data-style="btn-inverse" id="sl">
									</select>
								</div>

								<div class="row form-group">
									<div class="row col-md-2">
										<input type="submit" class="btn btn-success "
											style="margin-left: 530px; margin-top: 20px" value="提交">
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
	
</body>
</html>