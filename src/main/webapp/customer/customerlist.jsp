<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page isELIgnored="false" %>
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
/*  	function select(){
		document.temp.action = "CustomerListAction.action";  
		document.temp.submit();
	} */
/* 	function newcustomer(){
		document.temp.action = "CustomerAddAction";  
		document.temp.submit();
	}  */
	if("${mag}"!=null&&"${mag}"!=''){
		alert("${mag}");
	}
	if("${msg}"!=null&&"${msg}"!=''){
		alert("${msg}");
	}
	if("${jue}"!=null&&"${jue}"!=''){
		alert("${jue}");
	}
	

	function getCustomer(curPage1) {
		
	var	customerName=document.getElementById("text1").value;
	var	type=document.getElementById("text2").value;
	var	groupCompany=document.getElementById("text3").value;
	var	customerCode=document.getElementById("text4").value;
	var	status=document.getElementById("text5").value;
	var	corporation=document.getElementById("text6").value;	
	if((customerName==null||customerName=='')&&(type==null||type=='')&&(groupCompany==null||groupCompany=='')&&(customerCode==null||customerCode=='')&&(status==null||status=='')&&(corporation==null||corporation==''))
	{
		alert("请在表中填入需要查询的关键信息");
		return false;
	}else{
		var urlGet ="<%=request.getContextPath()%>/CustomerListAction?customerName="+customerName+"&type="+type+"&groupCompany="+groupCompany
				+"&customerCode="+customerCode+"&status="+status+"&corporation="+corporation;
		//$("#customer").html("");
		$.getJSON(urlGet,function(data) {
				var row = "<tr><td>序号</td><td>客户名称</td><td>客户代码</td><td>所属TEAM</td><td>业务经理</td><td>业务助理</td><td>状态</td><td>详细信息</td><td>客户确认</td></tr>";
				if(data == ""){
					alert("该用户不存在！");
				}
				$.each(data,function(i, entry) {//遍历JSON
					
						row += "<tr><td>"
								+i
								+"</td><td>"
								+ entry.CN
								+"</td><td>"
								+ entry.CD
								+ "</td><td>"
								+ entry.Coun
								+ "</td><td>"
								+ entry.BM
								+ "</td><td>"
								+ entry.BA
								+ "</td><td>"
								+ entry.Sta
								+ "</td><td><a href='<%=request.getContextPath()%>/CustomerDetailed.action?customerId=" +entry.id+ "'><button>查看</button></a>"
								+"<a href='<%=request.getContextPath()%>/CustomerUpdateDetailed.action?customerId="+entry.id+"'><button>编辑</button></a>"
								+"</td><td><a href='<%=request.getContextPath()%>/ConfirmAction.action?customerId="+entry.id+"'><button>确认</button>"
								+"</td></tr>"
					});
				$("#table1").html(row);
			
			});
	}
	}

		//分页
		function getFirstPage(){
		//makePrePage(10);
		getCustomer(1);
			}
	
	
	
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
				style="line-height: 0">主页面维护>客户管理>客户查询</h3></a>
	</div>
	<div>
		<form class="navbar-form navbar-right" role="search">
			<div class="form-group">
				<a href="LoginAction!out.action" class="btn btn-success"
					role="button" style="margin-right: 20px"><%=session.getAttribute("username")%><br>退出</a>
				
			</div>
		</form>
	</div>
	</nav>

		<div class="container-fluid">
			<div class="row-fluid ">
								<div class="col-md-2 ">
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
                        <a class="accordion-toggle">用户管理</a>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse "
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
        </div>
				
		<div class="col-md-10">			
	
				<div class="row">
					<form  id="form1"  name="temp" class="form-horizontal" role="form"  action=""  method="post">
									<div class="form-group">
							            <label class="col-sm-2 control-label">客户名称</label>
							            <div class="col-sm-2">
							                <input  id="text1" type="text" name="customerName" class="form-control" placeholder="CustomerName" />
							            </div>
							            <label class="col-sm-2 control-label">类型</label>
							            <div class="col-sm-2">
							                <input  id="text2" type="text" name="type" class="form-control" placeholder="Type" />
							            </div>
							             <label  id="test3" class="col-sm-2 control-label">集团公司</label>
							            <div class="col-sm-2">
							                <input id="text3" type="text" name="groupCompany" class="form-control" placeholder="GroupCompany" />
							            </div>
							           
							        </div>
							    		<div class="form-group">
							            <label class="col-sm-2 control-label">客户简称</label>
							            <div class="col-sm-2">
							                <input id="text4" type="text" name="customerCode" class="form-control" placeholder="CustomerCode" />
							            </div>
							            <label class="col-sm-2 control-label">状态</label>
							            <div class="col-sm-2">
							                <input id="text5" type="text" name="status" class="form-control" placeholder="Status" />
							            </div>
							             <label class="col-sm-2 control-label">总公司</label>
							            <div class="col-sm-2">
							                <input id="text6" type="text" name="corporation" class="form-control" placeholder="Corporation" />
							            </div>
							           
							        </div>

							        <div class="form-group">
							            <div class="col-sm-offset-3 col-sm-3">
							            
							                 <button id="button1" type="button"  class="btn"  onclick="return getCustomer(1)">
							                   	查询
							                </button>
							                
							            </div>
							            <div class="col-sm-offset-3 col-sm-3">
							            	
							                 <button type="submit" id="button2" class="btn" >
							                 <a href="<%=request.getContextPath()%>/customer/customerNewDatialed.jsp">新建</a>
							                   	
							                </button> 
							            </div>
							        </div>
								</form>
					
					<hr style="height:20px;whidth:auto; color:red">
				</div>

				
					<div class="col-md-12" >
						
						<table class="table table-stripeed table-bordered table-hover" id="table1">
							
							
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