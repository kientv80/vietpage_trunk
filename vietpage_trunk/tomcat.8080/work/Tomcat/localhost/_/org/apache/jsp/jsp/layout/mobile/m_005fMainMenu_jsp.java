/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.40
 * Generated at: 2014-02-16 12:51:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.layout.mobile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class m_005fMainMenu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/custom-tags.tld", Long.valueOf(1389336987213L));
    _jspx_dependants.put("/WEB-INF/struts-tags.tld", Long.valueOf(1385006053243L));
    _jspx_dependants.put("/WEB-INF/tiles-jsp.tld", Long.valueOf(1385006054786L));
    _jspx_dependants.put("/WEB-INF/c.tld", Long.valueOf(1385006053262L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvar_005fvalue;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fui_005fitem_0026_005fwidth_005fshowView_005fshowShortDesc_005fitem_005fheight_005fedit_005fcallBackMethod_005fbtnPrefix_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fui_005fPopupWindow_0026_005fzIndex_005fwidth_005fshowPanelButtonId_005fshowOkButton_005fpanelTitle_005fpanelId_005fokButtonCallBack_005fisVisible_005fisRender_005fisModal_005fisCentered_005fdragAble_005fcontainerId_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvar_005fvalue = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fui_005fitem_0026_005fwidth_005fshowView_005fshowShortDesc_005fitem_005fheight_005fedit_005fcallBackMethod_005fbtnPrefix_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fui_005fPopupWindow_0026_005fzIndex_005fwidth_005fshowPanelButtonId_005fshowOkButton_005fpanelTitle_005fpanelId_005fokButtonCallBack_005fisVisible_005fisRender_005fisModal_005fisCentered_005fdragAble_005fcontainerId_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvar_005fvalue.release();
    _005fjspx_005ftagPool_005fui_005fitem_0026_005fwidth_005fshowView_005fshowShortDesc_005fitem_005fheight_005fedit_005fcallBackMethod_005fbtnPrefix_005fnobody.release();
    _005fjspx_005ftagPool_005fui_005fPopupWindow_0026_005fzIndex_005fwidth_005fshowPanelButtonId_005fshowOkButton_005fpanelTitle_005fpanelId_005fokButtonCallBack_005fisVisible_005fisRender_005fisModal_005fisCentered_005fdragAble_005fcontainerId_005fnobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Menu item -->\r\n");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /jsp/layout/mobile/m_MainMenu.jsp(9,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mainMenus.items != null && mainMenus.items.size() > 0}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t<table class=\"table\">\r\n");
        out.write("\t\t\t<tr >\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_s_005fiterator_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t</tr>\r\n");
        out.write("\t\t</table>\r\n");
        out.write("\t");
        if (_jspx_meth_ui_005fPopupWindow_005f0(_jspx_th_c_005fif_005f0, _jspx_page_context))
          return true;
        out.write('\r');
        out.write('\n');
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fiterator_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:iterator
    org.apache.struts2.views.jsp.IteratorTag _jspx_th_s_005fiterator_005f0 = (org.apache.struts2.views.jsp.IteratorTag) _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvar_005fvalue.get(org.apache.struts2.views.jsp.IteratorTag.class);
    _jspx_th_s_005fiterator_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fiterator_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /jsp/layout/mobile/m_MainMenu.jsp(12,4) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setValue("mainMenus.items");
    // /jsp/layout/mobile/m_MainMenu.jsp(12,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setVar("m_item");
    int _jspx_eval_s_005fiterator_005f0 = _jspx_th_s_005fiterator_005f0.doStartTag();
    if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fiterator_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fiterator_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t<td style=\"width: 300px;\">\r\n");
        out.write("\t\t\t\t\t\t\t");
        if (_jspx_meth_ui_005fitem_005f0(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\t</td>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_s_005fiterator_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fiterator_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvar_005fvalue.reuse(_jspx_th_s_005fiterator_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvar_005fvalue.reuse(_jspx_th_s_005fiterator_005f0);
    return false;
  }

  private boolean _jspx_meth_ui_005fitem_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  ui:item
    com.vnsoft.server.tags.ItemTag _jspx_th_ui_005fitem_005f0 = (com.vnsoft.server.tags.ItemTag) _005fjspx_005ftagPool_005fui_005fitem_0026_005fwidth_005fshowView_005fshowShortDesc_005fitem_005fheight_005fedit_005fcallBackMethod_005fbtnPrefix_005fnobody.get(com.vnsoft.server.tags.ItemTag.class);
    _jspx_th_ui_005fitem_005f0.setPageContext(_jspx_page_context);
    _jspx_th_ui_005fitem_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /jsp/layout/mobile/m_MainMenu.jsp(14,7) name = width type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fitem_005f0.setWidth("540");
    // /jsp/layout/mobile/m_MainMenu.jsp(14,7) name = height type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fitem_005f0.setHeight("300");
    // /jsp/layout/mobile/m_MainMenu.jsp(14,7) name = item type = com.vnsoft.server.model.Item reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fitem_005f0.setItem((com.vnsoft.server.model.Item) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${m_item}", com.vnsoft.server.model.Item.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /jsp/layout/mobile/m_MainMenu.jsp(14,7) name = edit type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fitem_005f0.setEdit(false);
    // /jsp/layout/mobile/m_MainMenu.jsp(14,7) name = callBackMethod type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fitem_005f0.setCallBackMethod("viewItem");
    // /jsp/layout/mobile/m_MainMenu.jsp(14,7) name = btnPrefix type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fitem_005f0.setBtnPrefix("btn");
    // /jsp/layout/mobile/m_MainMenu.jsp(14,7) name = showView type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fitem_005f0.setShowView(true);
    // /jsp/layout/mobile/m_MainMenu.jsp(14,7) name = showShortDesc type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fitem_005f0.setShowShortDesc(false);
    int _jspx_eval_ui_005fitem_005f0 = _jspx_th_ui_005fitem_005f0.doStartTag();
    if (_jspx_th_ui_005fitem_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fui_005fitem_0026_005fwidth_005fshowView_005fshowShortDesc_005fitem_005fheight_005fedit_005fcallBackMethod_005fbtnPrefix_005fnobody.reuse(_jspx_th_ui_005fitem_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fui_005fitem_0026_005fwidth_005fshowView_005fshowShortDesc_005fitem_005fheight_005fedit_005fcallBackMethod_005fbtnPrefix_005fnobody.reuse(_jspx_th_ui_005fitem_005f0);
    return false;
  }

  private boolean _jspx_meth_ui_005fPopupWindow_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fif_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  ui:PopupWindow
    com.vnsoft.server.tags.yui.PopupWindowTag _jspx_th_ui_005fPopupWindow_005f0 = (com.vnsoft.server.tags.yui.PopupWindowTag) _005fjspx_005ftagPool_005fui_005fPopupWindow_0026_005fzIndex_005fwidth_005fshowPanelButtonId_005fshowOkButton_005fpanelTitle_005fpanelId_005fokButtonCallBack_005fisVisible_005fisRender_005fisModal_005fisCentered_005fdragAble_005fcontainerId_005fnobody.get(com.vnsoft.server.tags.yui.PopupWindowTag.class);
    _jspx_th_ui_005fPopupWindow_005f0.setPageContext(_jspx_page_context);
    _jspx_th_ui_005fPopupWindow_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fif_005f0);
    // /jsp/layout/mobile/m_MainMenu.jsp(20,1) name = panelId type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fPopupWindow_005f0.setPanelId("mainmenuPanID");
    // /jsp/layout/mobile/m_MainMenu.jsp(20,1) name = width type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fPopupWindow_005f0.setWidth(1000);
    // /jsp/layout/mobile/m_MainMenu.jsp(20,1) name = isCentered type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fPopupWindow_005f0.setIsCentered("false");
    // /jsp/layout/mobile/m_MainMenu.jsp(20,1) name = showPanelButtonId type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fPopupWindow_005f0.setShowPanelButtonId((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${btn}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /jsp/layout/mobile/m_MainMenu.jsp(20,1) name = isVisible type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fPopupWindow_005f0.setIsVisible("false");
    // /jsp/layout/mobile/m_MainMenu.jsp(20,1) name = containerId type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fPopupWindow_005f0.setContainerId("vewItem");
    // /jsp/layout/mobile/m_MainMenu.jsp(20,1) name = panelTitle type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fPopupWindow_005f0.setPanelTitle((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${companyInfo.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    // /jsp/layout/mobile/m_MainMenu.jsp(20,1) name = isRender type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fPopupWindow_005f0.setIsRender("true");
    // /jsp/layout/mobile/m_MainMenu.jsp(20,1) name = zIndex type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fPopupWindow_005f0.setzIndex(5);
    // /jsp/layout/mobile/m_MainMenu.jsp(20,1) name = isModal type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fPopupWindow_005f0.setIsModal("true");
    // /jsp/layout/mobile/m_MainMenu.jsp(20,1) name = dragAble type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fPopupWindow_005f0.setDragAble(true);
    // /jsp/layout/mobile/m_MainMenu.jsp(20,1) name = showOkButton type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fPopupWindow_005f0.setShowOkButton(true);
    // /jsp/layout/mobile/m_MainMenu.jsp(20,1) name = okButtonCallBack type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_ui_005fPopupWindow_005f0.setOkButtonCallBack("assessItem1");
    int _jspx_eval_ui_005fPopupWindow_005f0 = _jspx_th_ui_005fPopupWindow_005f0.doStartTag();
    if (_jspx_th_ui_005fPopupWindow_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fui_005fPopupWindow_0026_005fzIndex_005fwidth_005fshowPanelButtonId_005fshowOkButton_005fpanelTitle_005fpanelId_005fokButtonCallBack_005fisVisible_005fisRender_005fisModal_005fisCentered_005fdragAble_005fcontainerId_005fnobody.reuse(_jspx_th_ui_005fPopupWindow_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fui_005fPopupWindow_0026_005fzIndex_005fwidth_005fshowPanelButtonId_005fshowOkButton_005fpanelTitle_005fpanelId_005fokButtonCallBack_005fisVisible_005fisRender_005fisModal_005fisCentered_005fdragAble_005fcontainerId_005fnobody.reuse(_jspx_th_ui_005fPopupWindow_005f0);
    return false;
  }
}
