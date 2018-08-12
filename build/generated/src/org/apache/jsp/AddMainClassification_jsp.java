package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddMainClassification_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Shared/header.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>AddMainClassification</title>\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\n");
      out.write("    <!-- Brand -->\n");
      out.write("    <a class=\"navbar-brand\" href=\"index.jsp\">Home</a>\n");
      out.write("\n");
      out.write("    <!-- Links -->\n");
      out.write("    <ul class=\"navbar-nav\">\n");
      out.write("    <!-- Dropdown -->\n");
      out.write("    <li class=\"nav-item dropdown\">\n");
      out.write("      <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbardrop\" data-toggle=\"dropdown\">\n");
      out.write("        BOOK\n");
      out.write("      </a>\n");
      out.write("      <div class=\"dropdown-menu\">\n");
      out.write("        <a class=\"dropdown-item\" href=\"AddBook.jsp\">Add Book</a>\n");
      out.write("        <a class=\"dropdown-item\" href=\"#DeleteBook.jsp\">Delete Book</a>\n");
      out.write("        <a class=\"dropdown-item\" href=\"SearchBook.jsp\">Search Book</a>\n");
      out.write("        <a class=\"dropdown-item\" href=\"#EditBook.jsp\">Edit Book</a>\n");
      out.write("      </div>\n");
      out.write("    </li>\n");
      out.write("    <li class=\"nav-item dropdown\">\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"classiDropdown\" data-toggle=\"dropdown\">\n");
      out.write("            Main Classification\n");
      out.write("        </a>\n");
      out.write("        <div class=\"dropdown-menu\">\n");
      out.write("            <a class=\"dropdown-item\" href=\"#SubClassification.jsp\">View All MainClassification</a>\n");
      out.write("            <a class=\"dropdown-item\" href=\"#MainClassification.jsp\">Add MainClassification</a>\n");
      out.write("            <a class=\"dropdown-item\" href=\"#SubClassification.jsp\">Delete MainClassification</a>\n");
      out.write("            <a class=\"dropdown-item\" href=\"#MainClassification.jsp\">Edit MainClassification</a>\n");
      out.write("            <a class=\"dropdown-item\" href=\"#MainClassification.jsp\">Search MainClassification</a>\n");
      out.write("        </div>  \n");
      out.write("    </li>\n");
      out.write("        <li class=\"nav-item dropdown\">\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"classiDropdown\" data-toggle=\"dropdown\">\n");
      out.write("            Sub Classification\n");
      out.write("        </a>\n");
      out.write("        <div class=\"dropdown-menu\">\n");
      out.write("            <a class=\"dropdown-item\" href=\"#SubClassification.jsp\">View All SubClassification</a>\n");
      out.write("            <a class=\"dropdown-item\" href=\"#MainClassification.jsp\">Add SubClassification</a>\n");
      out.write("            <a class=\"dropdown-item\" href=\"#SubClassification.jsp\">Delete SubClassification</a>\n");
      out.write("            <a class=\"dropdown-item\" href=\"#MainClassification.jsp\">Edit SubClassification</a>\n");
      out.write("            <a class=\"dropdown-item\" href=\"#MainClassification.jsp\">Search SubClassification</a>\n");
      out.write("        </div>  \n");
      out.write("        </li>\n");
      out.write("  </ul>\n");
      out.write("</nav>\n");
      out.write("<br>\n");
      out.write("  \n");
      out.write("\n");
      out.write("        \n");
      out.write("        ");
      java.util.Date date = null;
      synchronized (_jspx_page_context) {
        date = (java.util.Date) _jspx_page_context.getAttribute("date", PageContext.PAGE_SCOPE);
        if (date == null){
          date = new java.util.Date();
          _jspx_page_context.setAttribute("date", date, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("   \n");
      out.write("\n");
      out.write("        <form action=\"MainCLassificationController\" method=\"post\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-2\"></div>\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"BookID\">Classification ID</label>\n");
      out.write("                    <input type=\"text\" name=\"mClassificationID\" id=\"bookId\" placeholder=\"Classification ID should be like MC789\" class=\"form-control\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"Title\">Classification Name</label>\n");
      out.write("                    <input type=\"text\" name=\"mClassificationName\" id=\"title\" placeholder=\"Enter Main Classification name\" class=\"form-control\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-3\"></div>\n");
      out.write("            <div class=\"col-md-5\">\n");
      out.write("                <input type = \"submit\" value = \"ADD\" class=\"text-center btn btn-success\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-4\">\n");
      out.write("            <input type = \"submit\" value = \"CANCEL\" class=\"btn btn-danger\">\n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
