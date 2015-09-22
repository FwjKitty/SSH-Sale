package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class showUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>首页</title>\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/index.css\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery.cookie.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/bootstrap.min.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("@font-face {\r\n");
      out.write("\tfont-family: 'Glyphicons Halflings';\r\n");
      out.write("\tsrc: url('fonts/glyphicons-halflings-regular.eot');\r\n");
      out.write("\tsrc: url('fonts/glyphicons-halflings-regular.eot?#iefix')\r\n");
      out.write("\t\tformat('embedded-opentype'),\r\n");
      out.write("\t\turl('fonts/glyphicons-halflings-regular.woff') format('woff'),\r\n");
      out.write("\t\turl('../fonts/glyphicons-halflings-regular.ttf') format('truetype'),\r\n");
      out.write("\t\turl('../fonts/glyphicons-halflings-regular.svg#glyphicons_halflingsregular')\r\n");
      out.write("\t\tformat('svg');\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar page = 1;\r\n");
      out.write("\tvar mmid = 0;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tfunction getCustomer(curPage1) {\r\n");
      out.write("\t\tvar urlGet = \"UserAction!showPage.action?curPage=\" + curPage1;\r\n");
      out.write("\t\t//$(\"#customer\").html(\"\");\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t$\r\n");
      out.write("\t\t\t\t.getJSON(\r\n");
      out.write("\t\t\t\t\t\turlGet,\r\n");
      out.write("\t\t\t\t\t\tfunction(data) {\r\n");
      out.write("\t\t\t\t\t\t\tvar row = \"<tr><<td>员工号</td><td>用户名称</td><td>角色名称</td><td>操作</td><td>删除</td></tr>\";\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t$\r\n");
      out.write("\t\t\t\t\t\t\t\t\t.each(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdata,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfunction(entryIndex, entry) {//遍历JSON\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\trow += \"<tr><td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ entry.userId\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"</td><td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ entry.username\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"</td><td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ entry.roleName\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"</td><td><button type='button' class='btn btn-success' ><a>编辑</a></button></td><td><button type='button' class='btn btn-default' ><a>删除</a></button></td></tr>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#customer\").html(row);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t\t//分页\r\n");
      out.write("\t\tfunction getFirstPage(){\r\n");
      out.write("\t\tmakePrePage(10);\r\n");
      out.write("\t\tgetCustomer(1);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\tgetFirstPage();\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\tfunction mod(even) {\r\n");
      out.write("\t\talert(\"kaiidfdf\");\r\n");
      out.write("\t\tmmid = even.getAttribute(\"id\");\r\n");
      out.write("\t\talert(\"sdfsdf\");\r\n");
      out.write("\t\talert(mmid);\r\n");
      out.write("\t\tvar heigh = document.body.scrollHeight;\r\n");
      out.write("\t\t/* var urlGet = \"AddressAction!address.action\";\r\n");
      out.write("\t\tvar val;\r\n");
      out.write("\t\t//$(\"#customer\").html(\"\");\r\n");
      out.write("\t\t $.getJSON(urlGet,function(result){\r\n");
      out.write("     \t\t $.each(result, function(i, entity){\r\n");
      out.write("     \t\t\t val+=\"<option value='\"+entity.addressid+\"'>\"+entity.address+\"</option>\";\r\n");
      out.write("     \t\t\t// $(\"#sl\").attr(\"name\",entity.addressid);\t\r\n");
      out.write("      });\r\n");
      out.write("     \t\t $(\"#sl\").html(val);\r\n");
      out.write("    }); */\r\n");
      out.write("    \r\n");
      out.write("    \t//getAddress();\r\n");
      out.write("    \r\n");
      out.write("\t\t//alert(\"sdfsdf\");\r\n");
      out.write("\t\t$(\"#model6\").modal().css({\r\n");
      out.write("\t\t\t\"margin-top\" : function() {\r\n");
      out.write("\t\t\t\treturn (heigh / 5);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#dd\").attr(\"value\", mmid);\r\n");
      out.write("\t\t$(\"#model6\").modal();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t//向前翻页\r\n");
      out.write("\tfunction makePrePage(start){\r\n");
      out.write("\t    var url = \"UserAction!getCount.action?\";\r\n");
      out.write("\t    $.post(url,function(data){\r\n");
      out.write("\t        var count = Math.ceil(data/10);//存储客户总数\r\n");
      out.write("\t        $.cookie(\"count\",data);\r\n");
      out.write("\t        var str1 = null;\r\n");
      out.write("\t        var str2 = null;\r\n");
      out.write("\t        var str3 = null;\r\n");
      out.write("\t        if(start-10 == 0){//生成向前翻页\r\n");
      out.write("\t            str1 = \"<li role='presentation' class='disabled'>\"\r\n");
      out.write("\t                +\"<a href='#' aria-label='Previous'>\"\r\n");
      out.write("\t                +\"<span aria-hidden='true'>&laquo;</span></a></li>\";\r\n");
      out.write("\t        }else{\r\n");
      out.write("\t            str1 = \"<li role='presentation'>\"\r\n");
      out.write("\t                +\"<a href='#' aria-label='Previous' onclick='makePrePage(\"+(start-10)+\")' value=\"+ (start-10) +\">\"\r\n");
      out.write("\t                +\"<span aria-hidden='true'>&laquo;</span></a></li>\";\r\n");
      out.write("\t        }\r\n");
      out.write("\t        //生成向后翻页\r\n");
      out.write("\t        var sum;//记录中间生成的页数\r\n");
      out.write("\t        if(start+1 <= count) {\r\n");
      out.write("\t            str3 = \"<li role='presentation'>\"\r\n");
      out.write("\t                + \"<a href='#' aria-label='Next' onclick='makeNextPage(\"+(start+1)+\")'value=\"+ (start+1) +\">\"\r\n");
      out.write("\t                + \"<span aria-hidden='true'>&raquo;</span></a></li>\";\r\n");
      out.write("\t            sum = start + 1;\r\n");
      out.write("\t        }else{\r\n");
      out.write("\t            str3 = \"<li role='presentation' class='disabled'>\"\r\n");
      out.write("\t                + \"<a href='#' aria-label='Next'>\"\r\n");
      out.write("\t                + \"<span aria-hidden='true'>&raquo;</span></a></li>\";\r\n");
      out.write("\t            sum = count + 1;\r\n");
      out.write("\t        }\r\n");
      out.write("\t        str2 = \"<li role='presentation' class='active'>\"\r\n");
      out.write("\t        \t+ \"<a href='#' role='button' onclick='getCustomer(\"+(start-10+1)+\")'value=\"+ (start-10+1) +\">\"+(start-10+1)\r\n");
      out.write("\t            + \"</a></li>\";\r\n");
      out.write("\t        for(var i = start-10+1+1; i < sum; i++){\r\n");
      out.write("\t            var temp=\"<li role='presentation'>\"\r\n");
      out.write("\t                +\"<a href='#' role='button' onclick='getCustomer(\"+ i +\")'value=\"+ i +\">\"+ i +\"</a></li>\";\r\n");
      out.write("\t            str2 = str2 + temp;\r\n");
      out.write("\t        }\r\n");
      out.write("\t        $(\"#main_page\").html(str1+str2+str3);\r\n");
      out.write("\t        $(\"#main_page a\").click(function(e){\r\n");
      out.write("\t            e.preventDefault();\r\n");
      out.write("\t            $(this).tab(\"show\");\r\n");
      out.write("\t            $.cookie(\"pageNum\",$(this).attr(\"value\"));//记录当前是分页的第几页\r\n");
      out.write("\t            $.cookie(\"pageIdx\",$(this).attr(\"value\"));//记录具体所在页数\r\n");
      out.write("\t            \r\n");
      out.write("\t        });\r\n");
      out.write("\t        getCustomer(start-10+1);\r\n");
      out.write("\t        \r\n");
      out.write("\t    });   \r\n");
      out.write("\t}\r\n");
      out.write("\t//向后翻页\r\n");
      out.write("\tfunction makeNextPage(end){\r\n");
      out.write("\t    var url = \"UserAction!getCount.action?\";\r\n");
      out.write("\t    $.post(url,function(data){\r\n");
      out.write("\t        var count = Math.ceil(data/10);//存储客户总数\r\n");
      out.write("\t        $.cookie(\"count\",data);\r\n");
      out.write("\t        var str1 = null;\r\n");
      out.write("\t        var str2 = null;\r\n");
      out.write("\t        var str3 = null;\r\n");
      out.write("\t        //生成向前翻页\r\n");
      out.write("\t        str1 = \"<li role='presentation'>\"\r\n");
      out.write("\t            +\"<a href='#' aria-label='Previous' onclick='makePrePage(\"+(end-1)+\")'value=\"+ (end-1) +\">\"\r\n");
      out.write("\t            +\"<span aria-hidden='true'>&laquo;</span></a></li>\";\r\n");
      out.write("\t        //生成向后翻页\r\n");
      out.write("\t        var sum;//记录中间生成的页数\r\n");
      out.write("\t        if(end+10 <= count) {\r\n");
      out.write("\t            str3 = \"<li role='presentation'>\"\r\n");
      out.write("\t                + \"<a href='#' aria-label='Next' onclick='makeNextPage(\"+(end+10)+\")'value=\"+ (end+10) +\">\"\r\n");
      out.write("\t                + \"<span aria-hidden='true'>&raquo;</span></a></li>\";\r\n");
      out.write("\t            sum = end + 10;\r\n");
      out.write("\t        }else{\r\n");
      out.write("\t            str3 = \"<li role='presentation' class='disabled'>\"\r\n");
      out.write("\t                + \"<a href='#' aria-label='Next'>\"\r\n");
      out.write("\t                + \"<span aria-hidden='true'>&raquo;</span></a></li>\";\r\n");
      out.write("\t            sum = count +1;\r\n");
      out.write("\t        }\r\n");
      out.write("\t        var str2 = \"<li role='presentation' class='active'>\"\r\n");
      out.write("\t            +\"<a href='#' role='button' onclick='getCustomer(\"+ end +\")'value=\"+ end +\">\"+ end +\"</a></li>\";\r\n");
      out.write("\t        for(var i = end + 1; i < sum; i++){\r\n");
      out.write("\t            var temp=\"<li role='presentation'>\"\r\n");
      out.write("\t                +\"<a href='#' role='button' onclick='getCustomer(\"+ i +\")'value=\"+ i +\">\"+ i +\"</a></li>\";\r\n");
      out.write("\t            str2 = str2 + temp; \r\n");
      out.write("\t        }\r\n");
      out.write("\t        $(\"#main_page\").html(str1+str2+str3);\r\n");
      out.write("\t        $(\"#main_page a\").click(function(e){\r\n");
      out.write("\t            e.preventDefault();\r\n");
      out.write("\t            $(this).tab(\"show\");\r\n");
      out.write("\t            $.cookie(\"pageNum\",$(this).attr(\"value\"));//记录当前是分页的第几页\r\n");
      out.write("\t            $.cookie(\"pageIdx\",$(this).attr(\"value\"));//记录具体所在页数\r\n");
      out.write("\t        });\r\n");
      out.write("\t        getCustomer(end);\r\n");
      out.write("\t    });\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<nav class=\"navbar navbar-link nav1\" style=\"background-color:#67b168\"\r\n");
      out.write("\t\trole=\"navigation\">\r\n");
      out.write("\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t<a class=\"navbar-brand\" href=\"#\" style=\"color: red\"><h1\r\n");
      out.write("\t\t\t\tstyle=\"line-height: 0\">8831许凯迪</h1> </a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<form class=\"navbar-form navbar-right\" role=\"search\">\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<a href=\"LoginAction!out.action\" class=\"btn btn-success\"\r\n");
      out.write("\t\t\t\t\trole=\"button\" style=\"margin-right: 20px\">");
      out.print(session.getAttribute("username"));
      out.write("<br>退出</a>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"panel panel-default\" >\r\n");
      out.write("\t\t<div class=\"container-fluid panel1\" style=\"height: 950px;width:1800px\">\r\n");
      out.write("\t\t\t<div class=\"row-fluid \">\r\n");
      out.write("\t\t\t\t<div class=\"col-md-2 \" style=\"height: 950px;width:260px\">\r\n");
      out.write("\t\t\t\t\t<!--Sidebar content-->\r\n");
      out.write("\t\t<!--竖直导航-->\r\n");
      out.write("\t\t<div style=\"width: 200px;\">\r\n");
      out.write("            <div class=\"panel-group\" id=\"accordion2\">\r\n");
      out.write("            <div class=\"panel-heading\">\r\n");
      out.write("                <strong style=\"font-size: 30px;\">主数据维护</strong>\r\n");
      out.write("            </div>     \r\n");
      out.write("             <div class=\"panel panel-default\">\r\n");
      out.write("                    <div class=\"panel-heading\" data-toggle=\"collapse\"\r\n");
      out.write("                        data-parent=\"#accordion2\" href=\"#collapseOne\">\r\n");
      out.write("                        <a class=\"accordion-toggle\">首页</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"collapseOne\" class=\"panel-collapse collapse \"\r\n");
      out.write("                        style=\"height: auto;\">\r\n");
      out.write("                        <div class=\"panel-body\">\r\n");
      out.write("                            <ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("                     \t\t\t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/user/userStatic.jsp\">用户状态</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"panel panel-default\">\r\n");
      out.write("                    <div class=\"panel-heading\" data-toggle=\"collapse\"\r\n");
      out.write("                        data-parent=\"#accordion2\" href=\"#collapseTwo\">\r\n");
      out.write("                        <a class=\"accordion-toggle\">销售订单管理</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"collapseTwo\" class=\"panel-collapse collapse \"\r\n");
      out.write("                        style=\"height: auto;\">\r\n");
      out.write("                 <!--        <div class=\"panel-body\">\r\n");
      out.write("                            <ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("                                <li><a href=\"#\">Java基础</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Java面向对象</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Java核心API</a></li>\r\n");
      out.write("                                <li><a href=\"#\">JavaEE</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div> -->\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"panel panel-default\">\r\n");
      out.write("                    <div class=\"panel-heading\" data-toggle=\"collapse\"\r\n");
      out.write("                        data-parent=\"#accordion2\" href=\"#collapseThree\">\r\n");
      out.write("                        <a class=\"accordion-toggle\">用户管理</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div id=\"collapseThree\" class=\"panel-collapse collapse \"\r\n");
      out.write("                        style=\"height: auto;\">\r\n");
      out.write("                        <div class=\"panel-body\">\r\n");
      out.write("                            <ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("                                <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/user/showUser.jsp\">用户管理</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"panel panel-default\">\r\n");
      out.write("                    <div class=\"panel-heading\" data-toggle=\"collapse\"\r\n");
      out.write("                        data-parent=\"#accordion2\" href=\"#collapseFour\">\r\n");
      out.write("                        <a class=\"accordion-toggle\">主数据维护</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    \r\n");
      out.write("                     <div id=\"collapseFour\" class=\"panel-collapse collapse \"\r\n");
      out.write("                        style=\"height: auto;\">\r\n");
      out.write("                        <div class=\"panel-body\">\r\n");
      out.write("                            <ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("                                <li class=\"panel-heading\" data-toggle=\"collapse\"\r\n");
      out.write("                    \t\t    data-parent=\"#accordion3\" href=\"#collapseThreeLi\">\r\n");
      out.write("                    \t\t    <a href=\"#\">折扣管理</a></li>\r\n");
      out.write("                             \t\t <div id=\"collapseThreeLi\" class=\"panel-collapse collapse\" style=\"height: auto;\">\r\n");
      out.write("                       \t\t\t\t\t <div class=\"panel-body\">\r\n");
      out.write("                         \t\t\t\t\t   <ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("\t\t\t\t\t                        \t  \t<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/discount/showNormalDiscount.jsp\">经常性折扣</a></li>\r\n");
      out.write("                               \t\t\t\t\t\t <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/discount/showOneDiscount.jsp\">一次性折扣</a></li>\r\n");
      out.write("                               \t\t\t\t\t</ul>\r\n");
      out.write("                               \t\t\t\t</div>\r\n");
      out.write("                               \t\t\t</div>\r\n");
      out.write("                                <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/customer/customerlist.jsp\">客户管理</a></li>\r\n");
      out.write("                                <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/priceList_show.action\">价格表管理</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                     </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                      \r\n");
      out.write("                  <!-- 系统设置 -->\r\n");
      out.write("\t                <div class=\"panel panel-default\">\r\n");
      out.write("\t                    <div class=\"panel-heading\" data-toggle=\"collapse\"\r\n");
      out.write("\t                        data-parent=\"#accordion2\" href=\"#system_configuration\">\r\n");
      out.write("\t                        <a class=\"accordion-toggle\">系统设置</a>\r\n");
      out.write("\t                    </div>\r\n");
      out.write("\t                    <div id=\"system_configuration\" class=\"panel-collapse collapse \"\r\n");
      out.write("\t                        style=\"height: auto;\">\r\n");
      out.write("\t                        <div class=\"panel-body\">\r\n");
      out.write("\t                            <ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("\t                                <li><a href=\"#\">Orderbase配置</a></li>\r\n");
      out.write("\t                                <li><a href=\"#\">客户订单配置</a></li>\r\n");
      out.write("\t                                <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/priceListConfig_show.action\">价格表配置</a></li>\r\n");
      out.write("\t                            </ul>\r\n");
      out.write("\t                        </div>\r\n");
      out.write("\t                    </div>\r\n");
      out.write("\t                </div>\r\n");
      out.write("            \t</div>\r\n");
      out.write("        \t</div>\r\n");
      out.write("        </div>\r\n");
      out.write("\t\t\t\t<div class=\"col-md-10\" style=\"height: 700px;width:1200px\">\r\n");
      out.write("\t\t\t\t\t<!--Body content-->\r\n");
      out.write("\t\t\t\t\t<div class=\"panel panel-default\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"panel-heading\" style=\"font-size: large\">\r\n");
      out.write("\t\t\t\t\t\t\t<strong>用户管理</strong>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"panel-body\" style=\"margin-left: 0px; padding: 0px\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel\" style=\"border-top: solid #67b168\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h4>用户列表</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-9\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-success\" style=\"width: 150px\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tonclick=\"window.location='");
      out.print(request.getContextPath());
      out.write("/user/addUser.jsp'\">新增</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"panel-body form\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<table class=\"table  table-bordered table-striped well\t\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tid=\"customer\" style=\" border: solid #67b168;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"panel-footer\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tstyle=\"text-align: center; height: 50px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"main_page\" style=\"margin-top:-20px\"  >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<nav>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<ul class=\"pagination pagination-sm\" id=\"main_page\"></ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel-footer well\" style=\"height: 120px\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"modal fade myModal2\" id=\"model6\" tabindex=\"-1\"\r\n");
      out.write("\t\trole=\"dialog\" aria-hidden=\"true\">\r\n");
      out.write("\t\t<div class=\"modal-dialog modal-lg\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<Strong>进入编辑</Strong>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<form action=\"CustomerAction!update.action\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"customer.customerId\" id=\"dd\" />\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"row form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-md-2\" style=\"margin-left: 120px\">firstname</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"col-md-4\" type=\"text\" name=\"customer.firstName\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"row form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-md-2\" style=\"margin-left: 120px\">lastname</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"col-md-4\" type=\"text\" name=\"customer.lastName\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"row form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-md-2\" style=\"margin-left: 120px\">email</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"col-md-4\" type=\"text\" name=\"customer.email\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"row form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-md-2\" style=\"margin-left: 120px\">address</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"address_id\" style=\"width: 310px; heigth: 120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"selectpicker\" data-style=\"btn-inverse\" id=\"sl\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"row form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row col-md-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"submit\" class=\"btn btn-success \"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tstyle=\"margin-left: 530px; margin-top: 20px\" value=\"提交\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
