/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-08-26 09:33:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.front;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class question_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
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
      out.write("<!DOCTYPE html \">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Java算法练习系统</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("css/bootstrap.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("css/front/question.css\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tString.prototype.trim2 = function() {\r\n");
      out.write("\t\treturn this.replace(/(^\\s*)|(\\s*$)/g, \"\");\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction F(objid) {\r\n");
      out.write("\t\treturn document.getElementById(objid).value;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction G(objid) {\r\n");
      out.write("\t\treturn document.getElementById(objid);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t//返回一步\r\n");
      out.write("\tfunction backOne(){\r\n");
      out.write("\t\twindow.history.back(-1);\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onLoad=\"keyUp();\">\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t<div class=\"cont\">\r\n");
      out.write("\t\t<a onclick=\"backOne();\"><span class=\"glyphicon glyphicon-hand-left back\"></span></a>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"title\">\r\n");
      out.write("\t\t\t<h3>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h3>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<span>时间限制：1.0 s</span><span>内存限制：256 M</span>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"quest\">\r\n");
      out.write("\t\t\t<pre>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</pre>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"answer\">\r\n");
      out.write("\t\t\t<h3>你的答案</h3><h4></h4>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<span>温馨提示：</span>编译语言为<em>Java</em>；公共类类名为<em>Main</em>；不能导入package！\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<span>你的代码：</span>\r\n");
      out.write("\t\t\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${rootPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("front/toSubmit?qtId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${question.typeId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"\r\n");
      out.write("\t\t\t\tmethod=\"post\">\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"position: relative\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"60%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"ol\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<textarea  cols=\"2\" rows=\"10\" id=\"li\" disabled=\"disabled\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div> <textarea name=\"answer\"  cols=\"100\" rows=\"20\" wrap=\"off\" id=\"c2\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tonblur=\"check('2')\" onKeyUp=\"keyUp()\" onFocus=\"clearValue('2')\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tonscroll=\"G('li').scrollTop=this.scrollTop;\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\toncontextmenu=\"return false\" class=\"grey\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t<div class=\"but\">\r\n");
      out.write("\t\t\t\t\t<input  class=\"btn btn-success\"  type=\"submit\" value=\"提交答案\">\r\n");
      out.write("\t\t\t\t</div>\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fimport_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar msgA = [ \"msg1\", \"msg2\", \"msg3\", \"msg4\" ];\r\n");
      out.write("\tvar c = [ \"c1\", \"c2\", \"c3\", \"c4\" ];\r\n");
      out.write("\tvar slen = [ 50, 20000, 20000, 60 ];//允许最大字数 \r\n");
      out.write("\tvar num = \"\";//http://www.phpernote.com/javascript-function/752.html \r\n");
      out.write("\tvar isfirst = [ 0, 0, 0, 0, 0, 0 ];\r\n");
      out.write("\tfunction isEmpty(strVal) {\r\n");
      out.write("\t\tif (strVal == \"\")\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction isBlank(testVal) {\r\n");
      out.write("\t\tvar regVal = /^\\s*$/;\r\n");
      out.write("\t\treturn (regVal.test(testVal))\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction chLen(strVal) {\r\n");
      out.write("\t\tstrValstrVal = strVal.trim2();\r\n");
      out.write("\t\tvar cArr = strVal.match(/[^\\x00-\\xff]/ig);\r\n");
      out.write("\t\treturn strVal.length + (cArr == null ? 0 : cArr.length);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction check(i) {\r\n");
      out.write("\t\tvar iValue = F(\"c\" + i);\r\n");
      out.write("\t\tvar iObj = G(\"msg\" + i);\r\n");
      out.write("\t\tvar n = (chLen(iValue) > slen[i - 1]);\r\n");
      out.write("\t\tif ((isBlank(iValue) == true) || (isEmpty(iValue) == true) || n == true) {\r\n");
      out.write("\t\t\tiObj.style.display = \"block\";\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tiObj.style.display = \"none\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkAll() {\r\n");
      out.write("\t\tfor (var i = 0; i < msgA.length; i++) {\r\n");
      out.write("\t\t\tcheck(i + 1);\r\n");
      out.write("\t\t\tif (G(msgA[i]).style.display == \"none\") {\r\n");
      out.write("\t\t\t\tcontinue;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\talert(\"填写错误,请查看提示信息！\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tG(\"form1\").submit();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction clearValue(i) {\r\n");
      out.write("\t\tG(c[i - 1]).style.color = \"#000\";\r\n");
      out.write("\t\tkeyUp();\r\n");
      out.write("\t\tif (isfirst[i] == 0) {\r\n");
      out.write("\t\t\tG(c[i - 1]).value = \"\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tisfirst[i] = 1;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction keyUp() {\r\n");
      out.write("\t\tvar obj = G(\"c2\");\r\n");
      out.write("\t\tvar str = obj.value;\r\n");
      out.write("\t\tstrstr = str.replace(/\\r/gi, \"\");\r\n");
      out.write("\t\tstrstr = str.split(\"\\n\");\r\n");
      out.write("\t\tn = str.length;\r\n");
      out.write("\t\tline(n);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction line(n) {\r\n");
      out.write("\t\tvar lineobj = G(\"li\");\r\n");
      out.write("\t\tfor (var i = 1; i <= n; i++) {\r\n");
      out.write("\t\t\tif (document.all) {\r\n");
      out.write("\t\t\t\tnum += i + \"\\r\\n\";\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\tnum += i + \"\\n\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tlineobj.value = num;\r\n");
      out.write("\t\tnum = \"\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction autoScroll() {\r\n");
      out.write("\t\tvar nV = 0;\r\n");
      out.write("\t\tif (!document.all) {\r\n");
      out.write("\t\t\tnV = G(\"c2\").scrollTop;\r\n");
      out.write("\t\t\tG(\"li\").scrollTop = nV;\r\n");
      out.write("\t\t\tsetTimeout(\"autoScroll()\", 20);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tif (!document.all) {\r\n");
      out.write("\t\twindow.addEventListener(\"load\", autoScroll, false);\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
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

  private boolean _jspx_meth_c_005fimport_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_005fimport_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fimport_005f0.setParent(null);
    // /WEB-INF/jsp/front/question.jsp(31,1) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fimport_005f0.setUrl("head.jsp");
    int[] _jspx_push_body_count_c_005fimport_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fimport_005f0 = _jspx_th_c_005fimport_005f0.doStartTag();
      if (_jspx_th_c_005fimport_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fimport_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fimport_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fimport_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fimport_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f1 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_005fimport_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fimport_005f1.setParent(null);
    // /WEB-INF/jsp/front/question.jsp(77,1) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fimport_005f1.setUrl("footer.jsp");
    int[] _jspx_push_body_count_c_005fimport_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fimport_005f1 = _jspx_th_c_005fimport_005f1.doStartTag();
      if (_jspx_th_c_005fimport_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fimport_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fimport_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fimport_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f1);
    }
    return false;
  }
}