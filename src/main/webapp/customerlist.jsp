<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
tr,td{
	border-top-style: none;
	border-bottom-style:none;
	border-left-style:none;
	border-right-style:none;
	}
}
</style>
</head>

<script type="text/javascript">
	var page = 1;
	var mmid = 0;
	function select(){
		document.temp.action = "CustomerListAction.action";  
		document.temp.submit();
	}
	function newcustomer(){
		document.temp.action = "CustomerAddAction.action";  
		document.temp.submit();
	}

	function getCustomer(curPage1) {
		
		
		var urlGet ="<%=request.getContextPath()%>/NormalDiscountAction!showPage.action?curPage=" + curPage1;
		//$("#customer").html("");

		$
				.getJSON(
						urlGet,
						function(data) {
							var row = "<tr><td>操作</td><td>删除</td><td>first_name</td><td>last_name</td><td>email</td><td>customer_id</td><td>address</td><td>last_update</td></tr>";

							$
									.each(
											data,
											function(entryIndex, entry) {//遍历JSON

												row += "<tr><td><button type='button' class='btn btn-default' onclick='mod(this)' id="
														+ entry.normalId
														+ "><a>编辑</a></button><td><a class='btn btn-info'  href='CustomerAction!remove.action?customerId="
														+ entry.normalId
														+ "'>删除</a><td>"
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
														+ "</td></tr>";

											});

							$("#customer").html(row);

						});

	}

		//分页
		function getFirstPage(){
		//makePrePage(10);
		getCustomer(1);
			}
		getFirstPage();
	
	
	function mod(even) {
		alert("kaiidfdf");
		mmid = even.getAttribute("id");
		alert("sdfsdf");
		alert(mmid);
		var heigh = document.body.scrollHeight;
		/* var urlGet = "AddressAction!address.action";
		var val;
		//$("#customer").html("");
		 $.getJSON(urlGet,function(result){
     		 $.each(result, function(i, entity){
     			 val+="<option value='"+entity.addressid+"'>"+entity.address+"</option>";
     			// $("#sl").attr("name",entity.addressid);	
      });
     		 $("#sl").html(val);
    }); */
    
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
	    var url = "http://localhost:8080/Sale/CustomerAction!getCount.action";
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
	    var url = "http://localhost:8080/Sale/CustomerAction!getCount.action";
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
		<div align="center" class="navbar-body">			
				<h3 style="color:#000; ">销售订单管理系统</h3>
		</div>
		<a class="navbar-brand" href="#" style="color: red"><h3
				style="line-height: 0">主页面维护>客户管理>客户查询</h3> </a>
	</div>
	<%-- <div>
		<form class="navbar-form navbar-right" role="search">
			<div class="form-group">
				<a href="loginActiona!out.action" class="btn btn-success"
					role="button" style="margin-right: 20px"><%=session.getAttribute("username")%><br>退出</a>
				
			</div>
		</form>
	</div> --%>
	</nav>

		<div class="container-fluid">
			<div class="row-fluid ">
				<div class="col-md-2 ">
					<!--Sidebar content-->
					<!--竖直导航-->
            <div class="panel-group" id="accordion2">
           		<div class="panel-heading">
                	<strong style="font-size: 30px;">首页</strong>
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
					                        	  	<li><a href="#">经常折扣</a></li>
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
				
		<div class="col-md-10">			
	
				<div class="row">
					<form class="form-horizontal" role="form"  action="" name="temp" method="post">
									<div class="form-group">
							            <label class="col-sm-2 control-label">客户名称</label>
							            <div class="col-sm-2">
							                <input type="text" name="customersInfo.customerName" class="form-control" placeholder="CustomerName" />
							            </div>
							            <label class="col-sm-2 control-label">类型</label>
							            <div class="col-sm-2">
							                <input type="text" name="customersInfo.type" class="form-control" placeholder="Type" />
							            </div>
							             <label class="col-sm-2 control-label">集团公司</label>
							            <div class="col-sm-2">
							                <input type="text" name="customersInfo.groupCompany" class="form-control" placeholder="GroupCompany" />
							            </div>
							           
							        </div>
							    		<div class="form-group">
							            <label class="col-sm-2 control-label">客户简称</label>
							            <div class="col-sm-2">
							                <input type="text" name="customerCode" class="form-control" placeholder="CustomerCode" />
							            </div>
							            <label class="col-sm-2 control-label">状态</label>
							            <div class="col-sm-2">
							                <input type="text" name="customersInfo.status" class="form-control" placeholder="Status" />
							            </div>
							             <label class="col-sm-2 control-label">总公司</label>
							            <div class="col-sm-2">
							                <input type="text" name="customersInfo.corporation" class="form-control" placeholder="Corporation" />
							            </div>
							           
							        </div>

							        <div class="form-group">
							            <div class="col-sm-offset-3 col-sm-3">
							            
							                 <button id="button1" type="submit" class="btn"  onclick="return select()">
							                   	查询
							                </button>
							                
							            </div>
							            <div class="col-sm-offset-3 col-sm-3">
							            	
							                 <button type="submit" id="button2" class="btn" onclick="return newcustomer()">
							                   	新建
							                </button> 
							            </div>
							        </div>
								</form>
					
					<hr style="height:20px;whidth:auto; color:red">
				</div>

				
					<div class="col-md-12" >
						<table class="table table-stripeed table-bordered table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>客户名称</th>
									<th>客户代码</th>
									<th>所属TEAM</th>
									<th>业务经理</th>
									<th>业务助理</th>
									<th>状态</th>
									<th>详细信息</th>
									<th>客户确认</th>
								</tr>	
							</thead>
							<tbody>
								<tr>
									<s:iterator value="#request.customers" id="customer" status="i">
										<th><s:property value="#i.index+1"/></th>
    									<th><s:property value="#customer.customerName"/></th>
    									<th><s:property value="#customer.customerCode"/></th>
    									<th><s:property value="#customer.country"/></th>
    									<th><s:property value="#customer.businessManager"/></th>
    									<th><s:property value="#customer.businessAssistant"/></th>
    									<th><s:property value="#customer.status"/></th>
    									<th><s:a herf="customerDetail.action?customerId=%{customersInfo.customerId}"><button>查看</button></s:a>
    									<s:a herf="updatecustomer.action?customerId=%{customersInfo.customerId}"><button>编辑</button></s:a></th> 
    									<th><s:a herf="confirm.action?customerId=%{customersInfo.customerId}"><button>确认</button></s:a></th> 		
    								</s:iterator>
								</tr>
							</tbody>
						</table>
			</div>
				

				</div>
		</div>
	<!-- </div> -->

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
	
</script>
	
</body>
</html>