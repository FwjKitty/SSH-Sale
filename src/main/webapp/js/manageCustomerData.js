$(document).ready(function(){
    makePrePage(10);
    getCusData(1);
});

function getFirstPage(){
	makePrePage(10);
    getCusData(1);
}

//获得客户信息
function getCusData(index){
    var text = $("#downBoard").html();
    var page = index.toString();
    $("#downBoard").html('<p>' + new Date() + " : 加载数据中，请稍后...</p>" + text);
    var url = "http://localhost:8080/StrutsExam8837/CusData.action";
    $.post(url,{page:page},function(data){
    	var obj = JSON.parse(data);
    	var temp = null;
    	var sum;
    	var count = parseInt($.cookie("count"));
    	if(index != Math.ceil(count/12))sum = 12;
    	else {sum = count-(page-1)*12;}
    	for(var i = 0;i < sum; i++){
    		var whatever = obj.customers[i].firstName+","+obj.customers[i].lastName+","
    					+obj.customers[i].address+","+obj.customers[i].email+","+obj.customers[i].customerId;
    		var str="<tr>"
                +"<td><a href='#' data-toggle='modal' data-target='#updtCusModal'"
                +"data-whatever='" + whatever + "'>"
                +"编辑 </a>|<a href='#' onclick='deleteCus("+ obj.customers[i].customerId +")'> 删除</a></td>"
                +"<td>" + obj.customers[i].firstName + "</td>"
                +"<td>" + obj.customers[i].lastName + "</td>"
                +"<td>" + obj.customers[i].address + "</td>"
                +"<td>" + obj.customers[i].email + "</td>"
                +"<td>" + obj.customers[i].customerId + "</td>"
                +"<td>" + obj.customers[i].lastUpdate + "</td>"
                +"</tr>";
            temp = temp + str;
    	}
    	$("#tbody_cusData").html(temp);
    }).error(function(){
        $("#downBoard").text("通讯有问题，请稍后重试。");
    });
}
//向前翻页
function makePrePage(start){
    var url = "http://localhost:8080/StrutsExam8837/CusCount.action";
    $.post(url,function(data){
    	var obj = JSON.parse(data);
        var count = Math.ceil(parseInt(obj.count)/12);//存储客户总数
        $.cookie("count",obj.count);
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
        	+ "<a href='#' role='button' onclick='getCusData("+(start-10+1)+")'value="+ (start-10+1) +">"+(start-10+1)
            + "</a></li>";
        for(var i = start-10+1+1; i < sum; i++){
            var temp="<li role='presentation'>"
                +"<a href='#' role='button' onclick='getCusData("+ i +")'value="+ i +">"+ i +"</a></li>";
            str2 = str2 + temp;
        }
        $("#main_page").html(str1+str2+str3);
        $("#main_page a").click(function(e){
            e.preventDefault();
            $(this).tab("show");
            $.cookie("pageNum",$(this).attr("value"));//记录当前是分页的第几页
            $.cookie("pageIdx",$(this).attr("value"));//记录具体所在页数
            
        });
        getCusData(start-10+1);
    });   
}
//向后翻页
function makeNextPage(end){
    var url = "http://localhost:8080/StrutsExam8837/CusCount.action";
    $.post(url,function(data){
        var obj = JSON.parse(data);
        var count = Math.ceil(parseInt(obj.count)/12);//存储客户总数
        $.cookie("count",obj.count);
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
            sum = count + 1;
        }
        var str2 = "<li role='presentation' class='active'>"
            +"<a href='#' role='button' onclick='getCusData("+ end +")'value="+ end +">"+ end +"</a></li>";
        for(var i = end + 1; i < sum; i++){
            var temp="<li role='presentation'>"
                +"<a href='#' role='button' onclick='getCusData("+ i +")'value="+ i +">"+ i +"</a></li>";
            str2 = str2 + temp;
        }
        $("#main_page").html(str1+str2+str3);
        $("#main_page a").click(function(e){
            e.preventDefault();
            $(this).tab("show");
            $.cookie("pageNum",$(this).attr("value"));//记录当前是分页的第几页
            $.cookie("pageIdx",$(this).attr("value"));//记录具体所在页数
        });
        getCusData(end);
    });
}
//删除客户信息
function deleteCus(id){
    if(confirm("真的要删除此客户的信息吗？")){
        var text = $("#downBoard").html();
        var pageNum = $.cookie("pageNum");
        var pageIdx = $.cookie("pageIdx");
//        alert(pageIdx);
        $("#downBoard").html(text + '<p>' + new Date() + " : 删除数据中，请稍后...</p>");
        var url = "http://localhost:8080/StrutsExam8837/DeleteCus.action?id="+id;
        $.post(url,function(){
            alert("删除成功！");
            makePrePage(10);
            getCusData(1);
        });
    }
}