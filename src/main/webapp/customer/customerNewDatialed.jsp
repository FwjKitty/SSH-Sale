<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建客户</title>
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
	/* 
	function a(){
		var d=document.all.form2.abc;
		alert(d);
		var v=d.options[d.selectedIndex].value;
		alert(v);  
		} */
	
	
	function NewCustomersInfo(){
			/* alert("用户名不能为空"); */
			var Cn=document.getElementById("text1").value;
			var ty=document.getElementById("text2").value;
			var Cc=document.getElementById("text4").value;
			
			var mu=document.getElementById("address7").value;
			var mai=document.getElementById("address8").value;
			var status=document.getElementById("address9").value;
			
			
			var jiajia=document.getElementById("payment2").value;
			
			var jie=document.getElementById("payment3").value;
			var yiban=document.getElementById("payment4").value;
			var fukuai=document.getElementById("payment5").value;
			
			
			var suoshu=document.getElementById("o1").value;
			var jingli=document.getElementById("o2").value;
			var zuli=document.getElementById("o3").value;
			
			
			if(Cn==null||Cn== ''){
				alert("用户名不能为空");
				return false;
			}else if(ty==null||ty==''){
				alert("type不能为空");
				return false;
			}else
			if(Cc==null||Cc==''){
				alert("客户简称不能为空");
				return false;
			}else
			 if(status==null||status==''){
				alert("状态不能为空");
				return false;
			}else  
				
			/* if(city==null||city==''){
				alert("城市不能为空");
				return false;
			}else */
			if(mu==null||mu==''){
				alert("目的港不能为空");
				return false;
			}else
			if(mai==null||Cc==''){
				alert("唛头不能为空");
				return false;
			}else
			if(jiajia==null){
				alert("通用加价条款不能为空");
				return false;
			}else
			if(jie==null){
				alert("结算货币不能为空");
				return false;
			}else
			if(yiban==null){
				alert("一般折扣不能为空");
				return false;
			}else
			if(fukuai==null){
				alert("付款方式不能为空");
				return false;
			}else
			if(suoshu==null||suoshu==''){
				alert("所属ATEM不能为空");
				return false;
			}else
			if(jingli==null||jingli==''){
				alert("业务经理不能为空");
				return false;
			}else
			if(zuli==null||zuli==''){
				alert("业务经理不能为空");
				return false;
			}else {
			
	alert("带*号为必填项,是否确认保存？");
		var d=document.all.form1.abc;
		var v=d.options[d.selectedIndex].value;
		
		document.temp.action ="<%=request.getContextPath()%>/CustomerAddAction?country="+v;
		document.temp.submit();
	
		document.form1.submit();
		alert("aaa");
		document.form1.submit();		
		document.form4.submit();
		document.form5.submit();
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
				style="line-height: 0">主页面维护>客户管理>新建客户</h3> </a>
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
				
		<div class="col-md-10">			
	
				<div class="row">
					<form  id="form1"  name="temp" class="form-horizontal" role="form"  action=""  method="post"> 
									<div class="form-group">
							            <label class="col-sm-2 control-label">* 客户名称</label>
							            <div class="col-sm-2">
							                <input  id="text1" type="text" name="customerName" class="form-control" placeholder="CustomerName" />
							            </div>
							            <label class="col-sm-2 control-label">* 类型</label>
							            <div class="col-sm-2">
							                <input  id="text2" type="text" name="type" class="form-control" placeholder="Type" />
							            </div>
							             <label  id="test3" class="col-sm-2 control-label">集团公司</label>
							            <div class="col-sm-2">
							                <input id="text3" type="text" name="groupCompany" class="form-control" placeholder="GroupCompany" />
							            </div>
							           
							        </div>
							    		<div class="form-group">
							            <label class="col-sm-2 control-label">* 客户简称</label>
							            <div class="col-sm-2">
							                <input id="text4" type="text" name="customerCode" class="form-control" placeholder="CustomerCode" />
							            </div>
							            <label class="col-sm-2 control-label">* 状态</label>
							            <div class="col-sm-2">
							            		<p>
  													<small>请在地址有效框中填写状态</small>
												</p>
							                <input id="text5" disabled type="text"  name="status" class="form-control" placeholder="Status" />
							            </div>
							             <label class="col-sm-2 control-label">总公司</label>
							            <div class="col-sm-2">
							                <input id="text6" type="text" name="corporation" class="form-control" placeholder="Corporation" />
							            </div>
							           
							        </div>

							        <div class="form-group">
							            <div class="col-sm-offset-2 col-sm-2">
							            
							                 <button id="button1" type="button"  class="btn btn-info" >
							                   
							                   	<a href="<%=request.getContextPath()%>/customer/customerlist.jsp">查询</a>
							                </button>
							                
							            </div>
							            <div class="col-sm-offset-2 col-sm-2">
							            	
							                 <button type="submit" id="button2" class="btn btn-info">
							                	 <a href="<%=request.getContextPath()%>/customer/customerNewDatialed.jsp">新建</a>
							                </button> 
							            </div>
							           <div class="col-sm-offset-2 col-sm-2">            	
							                 <button type="submit" id="button3" class="btn btn-info" onclick="return NewCustomersInfo()">
							                  		 保存
							                </button> 
							            </div>
							        </div>
								<!-- </form> -->
					
					<hr style="color：red;">
				<!-- </div> -->

				<h4>地址信息</h4>
					<!-- <div class="col-md-12" >

						
						<form action="" name="form2" id="form2" class="form-horizontal" role="form"   method="post"> -->
						
						
								<div class="form-group">
							            <label class="col-sm-2 control-label">地址1</label>
							            <div class="col-sm-5">
							            	
							                <input  id="address1" type="text" name="addressLine1" class="form-control"  />
							            </div>
							    </div>
							    <div class="form-group">
							            <label class="col-sm-2 control-label">地址2</label>
							            <div class="col-sm-5">
							                <input  id="address2" type="text" name="addressLine2" class="form-control"  />
							            </div>
							    </div>
							       <div class="form-group">
							            <label class="col-sm-2 control-label"> 城市</label>
							            <div class="col-sm-3">
							                <input  id="address3" type="text" name="city" class="form-control" placeholder="Los Angeles" />
							            </div>
							    </div>
							    <div class="form-group">
							            <label class="col-sm-2 control-label">州/省</label>
							            <div class="col-sm-3">
							                <input  id="address4" type="text" name="state" class="form-control" placeholder="California" />
							            </div>
							    </div>
							   <div class="form-group">
							            <label class="col-sm-2 control-label">* 国家</label>
							            <div class="col-sm-3"  >
							            						            
							                <select class="form-control" name="abc" onchange="a()">
											
							                	<option value="USA">USA</option>
  												<option value="AL Albania">AL Albania</option>
												<option value="EG Egypt">EG Egypt</option>
												<option value="IE Ireland">IE Ireland</option>
												<option value="BR Brazil">BR Brazil</option>
												<option value="CN China">CN China</option>
												<option value="MO Macao">MO Macao</option>
												<option value="TW Taiwan">TW Taiwan</option>
												<option value="HK Hong Kong">HK Hong Kong</option>
												<option value="UK England">UK England</option>
												<option value="CL Chile">CL Chile</option>
												<option value="IN India">IN India</option>
												<option value="IT Italy">IT Italy</option>
												<option value="IL Israel">IL Israel</option>
												<option value="IR Iran">IR Iran</option>
												<option value="IQ Iraq">IQ Iraq</option>
												<option value="YE Yemen">YE Yemen</option>
												<option value="JM Jamaica">JM Jamaica</option>
												<option value="SY Syria">SY Syria</option>
												<option value="HU Hungary">HU Hungary</option>
												<option value="NZ New Zealand">NZ New Zealand</option>
												<option value="SG Singapore">SG Singapore</option>
												
											</select>
											
							            </div>
							    </div>
							      <div class="form-group">
							            <label class="col-sm-2 control-label" >邮编</label>
							            <div class="col-sm-2">
							                <input  id="address6" type="text" name="postcode" class="form-control" placeholder="20930" />
							            </div>
							    </div>
							      <div class="form-group">
							            <label class="col-sm-2 control-label">* 目的港</label>
							            <div class="col-sm-2">
							                <input  id="address7" type="text" name="portOfDestination" class="form-control" placeholder="Los Angeles" />
							            </div>
							    </div>
							      <div class="form-group">
							            <label class="col-sm-2 control-label">* 唛头</label>
							            <div class="col-sm-4">
							                <input  id="address8" type="text" name="shippingMark" class="form-control" placeholder="ABC,SHIPPING MARK,FORD AUTO" />
							            </div>
							    </div>
							      <div class="form-group">
							            <label class="col-sm-2 control-label">* 有效</label>
							            <div class="col-sm-2">
							                <input  id="address9" type="text" name="status" class="form-control" placeholder="待确认" />
							            </div>
							    </div>
							      <div class="form-group">
							            <label class="col-sm-2 control-label">失效日期</label>
							            <div class="col-sm-2">
							                <input  id="address10" type="text" name="inactiveDate" class="form-control" placeholder="yyyy-mm-dd" />
							            </div>
							    </div>
							    <div class="form-group">
							            <div class="col-sm-offset-10 col-sm-2">
							                 <button id="addressbutton" type="button"  class="btn btn-info"  onclick="return NewCustomersInfo()">
							                   	保存
							                </button>
							     		</div>              
							 	</div>
							 	
								
						<!-- </form> -->
						
						<hr>
						<h4>付款信息</h4>
						<!-- <form action="" id="form3" class="form-horizontal" role="form"   method="post"> -->
								<div class="form-group">
							            <label class="col-sm-2 control-label"> 所属发票组</label>
							            <div class="col-sm-3">
							                <input  id="payment1" type="text" name="invoiceGroup" class="form-control" placeholder="xxxxx"/>
							            </div>
							              <label class="col-sm-2 control-label">* 通用加价条款</label>
							            <div class="col-sm-3">
							                <input  id="payment2" type="text" name="markupName" class="form-control" placeholder="低于50片加价5%"/>
							            </div>
							    </div>
							    <div class="form-group">
							            <label class="col-sm-2 control-label">* 结算货币</label>
							            <div class="col-sm-3">
							                <input id="payment3" type="text" name="currency" class="form-control" placeholder="USD"/>
							            </div>
							              <label class="col-sm-2 control-label">* 一般折扣</label>
							            <div class="col-sm-3">
							                <input  id="payment4" type="text" name="discountName" class="form-control" placeholder="3%折扣"/>
							            </div>
							    </div>
							   <div class="form-group">
							            <label class="col-sm-2 control-label">* 付款方式</label>
							            <div class="col-sm-4">
							                <input id="payment5"  type="text" name="paymentTerm" class="form-control" placeholder="60天后付款"/>
							    		</div>
							  </div>
							   <div class="form-group">
							            <label class="col-sm-2 control-label" > 价格条款1</label>
							            <div class="col-sm-4">
							               <textarea id="payment6" class="form-control" rows="4" name="priceTerm1" placeholder="输入文本"></textarea>
							    		</div>
							  </div>
							    <div class="form-group">
							            <label class="col-sm-2 control-label"> 价格条款2</label>
							            <div class="col-sm-4">
							               <textarea id="payment7" class="form-control" rows="4" placeholder="输入文本" name="priceTerm2"></textarea>
							    		</div>
							  </div>
							    <div class="form-group">
							         <label class="col-sm-2 control-label"> 价格条款3</label>
							        <div class="col-sm-4">
							               <textarea id="payment8" class="form-control" rows="4" placeholder="输入文本" name="priceTerm3"></textarea>
							    	</div>
							  </div>
							  <div class="form-group">
							            <div class="col-sm-offset-10 col-sm-2">
							                 <button id="paymentbutton" type="button"  onclick="return " class="btn btn-info" onclick="return NewCustomersInfo()">
							                   	保存
							                </button>
							     		</div>              
							 	</div>
							 
						<!-- </form> -->
						<hr>
						<h4>组织信息</h4>
						<!-- <form action="" id="form4" class="form-horizontal" role="form"   method="post"> -->
								<div class="form-group">
							            <label class="col-sm-2 control-label">* 所属ATEM</label>
							            <div class="col-sm-2">
							                <input id="o1"  type="text" name="marketArea" class="form-control" placeholder="05-美国"/>
							            </div>
							    </div>
							    <div class="form-group">
							            <label class="col-sm-2 control-label">* 业务经理</label>
							            <div class="col-sm-2">
							                <input id="o2"   type="text" name="businessManager" class="form-control" placeholder="张三"/>
							            </div>
							    </div>
							      <div class="form-group">
							            <label class="col-sm-2 control-label">* 业务助理</label>
							            <div class="col-sm-2">
							                <input  id="o3"  type="text" name="businessAssistant" class="form-control" placeholder="李四"/>
							            </div>
							    </div>
							     <div class="form-group">
							            <div class="col-sm-offset-10 col-sm-2">
							                 <button id="oranizationbutton" type="button"  onclick="return NewCustomersInfo()" class="btn btn-info">
							                   	保存
							                </button>
							     		</div>              
							 	</div>
					<!-- 	</form> -->
						<hr>
						<h4>联系人信息</h4>
						<!-- <form action="" id="form5" class="form-horizontal" role="form"   method="post"> -->
								<div class="form-group">
							            <label class="col-sm-2 control-label">发件人邮箱</label>
							            <div class="col-sm-3">
							                <input  id="mail1" type="text" name="mailFrom" class="form-control" placeholder="Micheal@winhere.com.cn"/>
							            </div>
							    </div>
							    <div class="form-group">
							            <label class="col-sm-2 control-label">Pre Po收件人</label>
							            <div class="col-sm-3">
							                <input  id="mail2" type="text" name="prePoMailTo" class="form-control" placeholder="Micheal@winhere.com.cn"/>
							            </div>
							    </div>
							    <div class="form-group">
							            <label class="col-sm-2 control-label">Po 收件人</label>
							            <div class="col-sm-3">
							                <input id="mail3"  type="text" name="poMailTo" class="form-control" placeholder="Micheal@winhere.com.cn;Mike@winhere.com.cn;"/>
							            </div>
							    </div>
							    <div class="form-group">
							            <label class="col-sm-2 control-label">OC/PI收件人</label>
							            <div class="col-sm-3">
							                <input  id="mail4" type="text" name="ocpiMailTo" class="form-control" placeholder="Micheal@winhere.com.cn"/>
							            </div>
							    </div>
							    <div class="form-group">
							            <label class="col-sm-2 control-label">INV/Packing list 收件人</label>
							            <div class="col-sm-3">
							                <input id="mail5"  type="text" name="invPklistMailto" class="form-control" placeholder="Micheal@winhere.com.cn"/>
							            </div>
							    </div>
							     <div class="form-group">
							            <div class="col-sm-offset-10 col-sm-2">
							                 <button id="oranizationbutton" type="contactorbutton"  onclick="return NewCustomersInfo()" class="btn btn-info">
							                   	保存
							                </button>
							     		</div>              
							 	</div>
						</form>
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