package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<title>登录</title>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\">\r\n");
      out.write("    <meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/bootstrap.min.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("function check() {\r\n");
      out.write("\tif (form.customer_name.value == \"\") {\r\n");
      out.write("\t\talert(\"用户名不能为空\");\r\n");
      out.write("\t\tform.first_name.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t} else if (form.last_name.value == \"\") {\r\n");
      out.write("\t\talert(\"密码不能为空\");\r\n");
      out.write("\t\tform.last_name.focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<body background=\"img/bg_login.jpg\">\r\n");
      out.write("  \t<div class=\"container-fluid\">\r\n");
      out.write("  \t<div class=\"row\">\r\n");
      out.write("  \t\t<div class=\"col-sm-4\">\r\n");
      out.write("  \t\t\t<div class=\"col-sm-10\">\r\n");
      out.write("  \t\t\t\t<h3></h3>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t\t<div class=\"col-sm-4\" style=\"background-color:#fff;margin-top:200px;\">\r\n");
      out.write("  \t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("  \t\t\t<form class=\"form-horizontal\" role=\"form\" name=\"form\" action=\"");
      out.print(request.getContextPath() );
      out.write("/LoginAction.action\" onsubmit=\"return check()\" method=\"post\">\r\n");
      out.write("  \t\t\t\t<br/>\r\n");
      out.write("\t\t        <strong>订单销售管理系统</strong>\r\n");
      out.write("\t\t        <hr/>\r\n");
      out.write("\t\t        <div class=\"form-group\">\r\n");
      out.write("\t\t            <label class=\"col-sm-3 control-label\">用户名</label>\r\n");
      out.write("\t\t            <div class=\"col-sm-8\">\r\n");
      out.write("\t\t                <input type=\"text\" name=\"username\" class=\"form-control\" placeholder=\"UserName\" />\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t\t        <div class=\"form-group\">\r\n");
      out.write("\t\t            <label class=\"col-sm-3 control-label\">密码</label>\r\n");
      out.write("\t\t            <div class=\"col-sm-8\">\r\n");
      out.write("\t\t                <input type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"password\" />\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t\t        <div class=\"form-group\">\r\n");
      out.write("\t\t            <div class=\"col-sm-offset-3 col-sm-8\">\r\n");
      out.write("\t\t                <button type=\"submit\" class=\"btn btn-success\">\r\n");
      out.write("\t\t                   \t登录\r\n");
      out.write("\t\t                </button>\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t\t    </form>\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("  </body>\r\n");
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
