/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.40
 * Generated at: 2014-04-26 17:09:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.layout.mobile.page_005fadmin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Info_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/custom-tags.tld", Long.valueOf(1395397053473L));
    _jspx_dependants.put("/WEB-INF/struts-tags.tld", Long.valueOf(1385006053243L));
    _jspx_dependants.put("/WEB-INF/tiles-jsp.tld", Long.valueOf(1385006054786L));
    _jspx_dependants.put("/WEB-INF/c.tld", Long.valueOf(1385006053262L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div style=\"position: relative;width: 100%;overflow: hidden;font-weight: normal; color: #827F8F;\">\r\n");
      out.write("\t");
      if (_jspx_meth_s_005ftext_005f0(_jspx_page_context))
        return;
      out.write(":</b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${companyInfo.address}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"position: relative;width: 100%;overflow: hidden\">\r\n");
      out.write("\t<div class=\"info\">\r\n");
      out.write("\t\t\t<img src=\"/images/vietpage/Phone.png\" style=\"width: 100%;height: 60%\" id=\"phone\"/><br>\r\n");
      out.write("\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${companyInfo.phone}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("<br>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"info\" >\r\n");
      out.write("\t\t<a href=\"#\" id=\"map_image1\">\r\n");
      out.write("\t\t\t<img alt=\"Map of the shop\" src=\"/images/googlemap.jpg\" style=\"width: 100%;height: 60%\">\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t\t");
      if (_jspx_meth_s_005ftext_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"info\" >\r\n");
      out.write("\t\t<a href=\"/items?comid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${companyInfo.id }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" title=\"Menu\" id=\"viewMenu\">\r\n");
      out.write("\t\t\t<img src=\"/images/vietpage/sanpham.png\" class=\"menu_button\" id=\"viewMenu\" style=\"width: 100%;height: 60%\"/>\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t\t<span>San Pham</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"position: relative;width: 100%;overflow: hidden;\">\r\n");
      out.write("\t<div class=\"pageAdminAction\">");
      if (_jspx_meth_s_005ftext_005f2(_jspx_page_context))
        return;
      out.write("</div>\r\n");
      out.write("\t<div class=\"pageAdminAction\" style=\"float: right;\">");
      if (_jspx_meth_s_005ftext_005f3(_jspx_page_context))
        return;
      out.write("</div>\r\n");
      out.write("</div>\r\n");
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

  private boolean _jspx_meth_s_005ftext_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_005ftext_005f0 = (org.apache.struts2.views.jsp.TextTag) _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_005ftext_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005ftext_005f0.setParent(null);
    // /jsp/layout/mobile/page_admin/Info.jsp(8,1) name = name type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005ftext_005f0.setName("vietpage.company.address");
    int _jspx_eval_s_005ftext_005f0 = _jspx_th_s_005ftext_005f0.doStartTag();
    if (_jspx_th_s_005ftext_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005ftext_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_005ftext_005f1 = (org.apache.struts2.views.jsp.TextTag) _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_005ftext_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005ftext_005f1.setParent(null);
    // /jsp/layout/mobile/page_admin/Info.jsp(19,2) name = name type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005ftext_005f1.setName("vietpage.company.location");
    int _jspx_eval_s_005ftext_005f1 = _jspx_th_s_005ftext_005f1.doStartTag();
    if (_jspx_th_s_005ftext_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005ftext_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_005ftext_005f2 = (org.apache.struts2.views.jsp.TextTag) _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_005ftext_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005ftext_005f2.setParent(null);
    // /jsp/layout/mobile/page_admin/Info.jsp(29,30) name = name type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005ftext_005f2.setName("vietpage.pageadmin.additem");
    int _jspx_eval_s_005ftext_005f2 = _jspx_th_s_005ftext_005f2.doStartTag();
    if (_jspx_th_s_005ftext_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f2);
    return false;
  }

  private boolean _jspx_meth_s_005ftext_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_005ftext_005f3 = (org.apache.struts2.views.jsp.TextTag) _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_005ftext_005f3.setPageContext(_jspx_page_context);
    _jspx_th_s_005ftext_005f3.setParent(null);
    // /jsp/layout/mobile/page_admin/Info.jsp(30,52) name = name type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005ftext_005f3.setName("vietpage.pageadmin.addNews");
    int _jspx_eval_s_005ftext_005f3 = _jspx_th_s_005ftext_005f3.doStartTag();
    if (_jspx_th_s_005ftext_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f3);
    return false;
  }
}
