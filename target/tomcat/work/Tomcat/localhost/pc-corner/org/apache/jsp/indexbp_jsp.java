/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-01-25 10:58:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;
import java.text.MessageFormat;

public final class indexbp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"content-type\" content=\"text/html; charset=iso-8859-15\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Your PC Corner</title>\r\n");
      out.write("        <style>\r\n");
      out.write("            html, body {\r\n");
      out.write("                padding: 0%;\r\n");
      out.write("                margin: 0%;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            div.row {\r\n");
      out.write("                position: relative;\r\n");
      out.write("                \r\n");
      out.write("                width: 60%;\r\n");
      out.write("                margin-left: 20%;\r\n");
      out.write("                margin-right: 20%;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            div.row div.row {               \r\n");
      out.write("                width: 100%;\r\n");
      out.write("                margin: 0;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .button {\r\n");
      out.write("                background-color: blue;\r\n");
      out.write("                color: white;\r\n");
      out.write("                padding: 1em;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            header {\r\n");
      out.write("                border-bottom: 1px solid black;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .header-row {\r\n");
      out.write("                display: inline-flex;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .menu-line{\r\n");
      out.write("                list-style: none;\r\n");
      out.write("                padding: 0%;\r\n");
      out.write("                margin: 0%;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .menu-line li{\r\n");
      out.write("                display: table-cell;\r\n");
      out.write("                vertical-align: middle;\r\n");
      out.write("                height: 2em;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .header-row .menu-line {\r\n");
      out.write("                position: absolute;\r\n");
      out.write("                right: 0;\r\n");
      out.write("\r\n");
      out.write("                display: table-row;\r\n");
      out.write("                margin-top: 1.4em;\r\n");
      out.write("                margin-bottom: 1.4em;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .header-row .menu-line .button {\r\n");
      out.write("                padding: 1em;\r\n");
      out.write("                text-decoration: none;\r\n");
      out.write("                color: #000;\r\n");
      out.write("\r\n");
      out.write("                background-color: white;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #products-table, #cart-table {\r\n");
      out.write("                width: 100%;\r\n");
      out.write("                border-collapse: collapse;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #products-table thead, #cart-table thead {\r\n");
      out.write("                text-align: center;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #products-table td, #cart-table td {\r\n");
      out.write("                border: 1px solid black;\r\n");
      out.write("                height: 2em;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #products-table td .button {\r\n");
      out.write("                text-align: center;\r\n");
      out.write("                display: block;\r\n");
      out.write("\r\n");
      out.write("                margin-left: auto;\r\n");
      out.write("                margin-right: auto;\r\n");
      out.write("\r\n");
      out.write("                padding: 0.3em;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            #cart-table input {\r\n");
      out.write("                width: 70%;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            .text-center {\r\n");
      out.write("                text-align: center;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("    ");

    String result= (String) request.getAttribute("test");
    out.println(result);
    
      out.write("\r\n");
      out.write("        <header>\r\n");
      out.write("            <div class=\"row header-row\">\r\n");
      out.write("                <h1>PC Corner</h1>\r\n");
      out.write("                <ul class=\"menu-line\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a class=\"button\" href=\"#\">Products</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a class=\"button\" href=\"#\">Cart</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("        <main>\r\n");
      out.write("            <section id=\"products\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <table id=\"products-table\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <td>name</td>\r\n");
      out.write("                            <td>description</td>\r\n");
      out.write("                            <td>weight</td>\r\n");
      out.write("                            <td>price</td>\r\n");
      out.write("                            <td></td>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                            ");

                                HashMap<String, String> product = new HashMap();
                                product.put("name", "Intel Core I5 9420");
                                product.put("description", "Intel`s newest addition to affordable home computing");
                                product.put("weight", "0.100");
                                product.put("price", "20.00");

                                out.println(MessageFormat.format("<tr><td>{0}</td><td>{1}</td><td>{2} Kg</td><td>{3}&euro;</td><td><a class=\"button\" href=\"#\">To cart</a></td></tr>", product.get("name"), product.get("description"), product.get("weight"), product.get("price")));
                            
      out.write("\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Intel Core I5 9420</td>\r\n");
      out.write("                                <td>Intel`s newest addition to affordable home computing</td>\r\n");
      out.write("                                <td>0.100 Kg</td>\r\n");
      out.write("                                <td>20.00&euro;</td>\r\n");
      out.write("                                <td><a class=\"button\" href=\"#\">To cart</a></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Intel Core I5 9420</td>\r\n");
      out.write("                                <td>Intel`s newest addition to affordable home computing</td>\r\n");
      out.write("                                <td>0.100 Kg</td>\r\n");
      out.write("                                <td>20.00&euro;</td>\r\n");
      out.write("                                <td><a class=\"button\" href=\"#\">To cart</a></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Intel Core I5 9420</td>\r\n");
      out.write("                                <td>Intel`s newest addition to affordable home computing</td>\r\n");
      out.write("                                <td>0.100 Kg</td>\r\n");
      out.write("                                <td>20.00&euro;</td>\r\n");
      out.write("                                <td><a class=\"button\" href=\"#\">To cart</a></td>\r\n");
      out.write("                            </tr>\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("            </section>\r\n");
      out.write("            <section id=\"cart\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <table id=\"cart-table\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                            <td>name</td>\r\n");
      out.write("                            <td width=\"10%\">weight</td>\r\n");
      out.write("                            <td width=\"10%\">quantity</td>\r\n");
      out.write("                            <td width=\"10%\">price</td>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody>\r\n");
      out.write("                            <tr>\r\n");
      out.write("                                <td>Intel Core I5 9420</td>\r\n");
      out.write("                                <td>0.100 Kg</td>\r\n");
      out.write("                                <td class=\"text-center\"><input type=\"number\" value=\"1\"></td>\r\n");
      out.write("                                <td>20.00&euro;</td>\r\n");
      out.write("                            </td>\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("            </section>\r\n");
      out.write("        </main>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
