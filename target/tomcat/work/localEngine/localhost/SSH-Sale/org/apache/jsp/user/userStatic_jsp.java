package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class userStatic_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>用户状态</title>\r\n");
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
      out.write("\r\n");
      out.write("\tfunction getCustomer() {\r\n");
      out.write("\t\tvar urlGet = \"UserAction!ShowOne.action\";\r\n");
      out.write("\t\t$\r\n");
      out.write("\t\t\t\t.getJSON(\r\n");
      out.write("\t\t\t\t\t\turlGet,\r\n");
      out.write("\t\t\t\t\t\tfunction(data,entity) {\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#userid\").text(data.userId); \r\n");
      out.write("\t\t\t\t\t\t\t$(\"#username\").text(data.username);\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#roleName\").text(data.roleName);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t\tgetCustomer();\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
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
      out.write("\t\t\t\t\t\t\t<strong>当前用户</strong>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"panel-body\" style=\"margin-left: 0px; padding: 0px\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"panel\" style=\"border-top: solid #67b168\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"panel-heading\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h4>用户信息</h4>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"panel-body \">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<form class=\"form-horizontal well\"  id=\"myForm\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\taction=\"");
      out.print(request.getContextPath());
      out.write("/UserAction!add.action\" method=\"post\" onsubmit=\"return check()\">  \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<fieldset>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-group\" style=\"margin-left: 220px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"input-group-addon\" id=\"basic-addon1\">员工号</label> <label \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"userid\"\tstyle=\"width: 350px\"  class=\"form-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t ></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-group\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"margin-left: 220px; margin-top: 20px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"input-group-addon \" id=\"basic-addon2\">用户名\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label> <label  style=\"width: 350px\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"username\"\t class=\"form-control\" ></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-group\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"margin-left: 220px; margin-top: 20px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"input-group-addon \" id=\"basic-addon2\">角色名\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label> <label  style=\"width: 350px\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"roleName\"\t class=\"form-control\" ></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"LoginAction!out.action\" class=\"btn btn-success\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\trole=\"button\" style=\"margin-left: 220px;width:100px; margin-top: 20px\">退出</a>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</form>\r\n");
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
