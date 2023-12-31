/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.26
 * Generated at: 2021-03-05 11:29:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.emp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import local.hal.night.javawebscottadminmvc.entity.*;

public final class empEdit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("local.hal.night.javawebscottadminmvc.entity");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("java.text.ParseException");
    _jspx_imports_classes.add("java.sql.Date");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPではGET、POST、またはHEADのみが許可されます。 JasperはOPTIONSも許可しています。");
        return;
      }
    }

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
      out.write("\r\n");

	Emp emp = (Emp) request.getAttribute("emp");

	List<String> validationMsgs = (List<String>) request.getAttribute("validationMsgs");
	Map<Integer, Emp> resultList = (Map<Integer, Emp>) request.getAttribute("resultList");
	Map<Integer, Emp> resultListMgr = (Map<Integer, Emp>) request.getAttribute("resultListMgr");
	Map<Integer, Dept> resultListDept = (Map<Integer, Dept>) request.getAttribute("resultListDept");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ja\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>従業員情報編集｜JavaWebScottAdmin Practice</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/javawebscottadminmvc/css/main.css\"\r\n");
      out.write("\ttype=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1>従業員情報編集</h1>\r\n");
      out.write("\t<nav>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li><a href=\"/javawebscottadminmvc/\">TOP</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/javawebscottadminmvc/emp/showList\">従業員リスト</a></li>\r\n");
      out.write("\t\t\t<li>従業員情報編集</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</nav>\r\n");
      out.write("\r\n");
      out.write("\t");

		if (validationMsgs != null) {
	
      out.write("\r\n");
      out.write("\t<section id=\"errorMsg\">\r\n");
      out.write("\t\t<p>以下のメッセージをご確認ください。</p>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t");

				for (String msg : validationMsgs) {
			
      out.write("\r\n");
      out.write("\t\t\t<li>");
      out.print(msg);
      out.write("</li>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t");

		}
	
      out.write("\r\n");
      out.write("\t<section>\r\n");
      out.write("\t\t<p>情報を入力し、更新ボタンをクリックしてください。</p>\r\n");
      out.write("\t\t<form action=\"/javawebscottadminmvc/emp/edit\" method=\"post\">\r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>従業員番号&nbsp;<span class=\"required\">必須</span></th>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(emp.getEmpno());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>従業員名&nbsp;<span class=\"required\">必須</span></th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" id=\"editEmpEname\" name=\"editEmpEname\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.print(emp.getEname());
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>役職&nbsp;<span class=\"required\">必須</span></th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" id=\"editEmpJob\" name=\"editEmpJob\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.print(emp.getJob());
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>上司番号&nbsp;<span class=\"required\">必須</span></th>\r\n");
      out.write("\t\t\t\t\t\t<td><select name=\"editEmpMgr\" id=\"editEmpMgr\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");

								Integer empno;
									for (Map.Entry<Integer, Emp> entry : resultList.entrySet()) {

										empno = entry.getKey();
										Emp emp1 =  entry.getValue();

										if(emp.getMgr() == 0){
										}else{
										empno = emp.getMgr();
										}


										if (resultList.get(empno).getEmpno() == emp1.getEmpno()) {

											
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(emp.getMgr());
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tselected>");
      out.print(resultList.get(empno).getEmpno());
      out.write(":\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
      out.print(resultList.get(empno).getEname());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");


										}else{
											 empno = entry.getKey();
											
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(resultList.get(empno).getEmpno());
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t>");
      out.print(resultList.get(empno).getEmpno());
      out.write(":\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
      out.print(resultList.get(empno).getEname());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");

										}

									}

								if (emp.getMgr() == 0) {
									empno = emp.getEmpno();
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"0\" selected>0:上司なし</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								} else {
									empno = emp.getMgr();
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"0\">0:上司なし</option>\r\n");
      out.write("\t\t\t\t\t\t\t");

								}


								
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>雇用日&nbsp;<span class=\"required\">必須</span></th>\r\n");
      out.write("\t\t\t\t\t\t<td><select name=\"editEmpHiredateYear\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"editEmpHiredateYear\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									String str = new SimpleDateFormat("yyyy-MM-dd").format(emp.getHiredate());
									String y = str.substring(0, 4);
									int yI = Integer.parseInt(y);
									for (int i = 1980; i <= 2021; i++) {
										if (yI == i) {
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(i);
      out.write("\" selected>");
      out.print(i);
      out.write("年\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									} else {
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("年\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									}
									}
								
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select> <select name=\"editEmpHiredateMonth\" id=\"editEmpHiredateMonth\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									String m = str.substring(5, 7);
									int monthI = Integer.parseInt(m);
									for (int i = 1; i <= 12; i++) {
										if (monthI == i) {
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(i);
      out.write("\" selected>");
      out.print(i);
      out.write("月\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									} else {
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("月\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									}
									}
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select> <select name=\"editEmpHiredateDay\" id=\"editEmpHiredateDay\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									String d = str.substring(8, 10);
									int dayI = Integer.parseInt(d);
									for (int i = 1; i <= 31; i++) {
										if (dayI == i) {
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(i);
      out.write("\" selected>");
      out.print(i);
      out.write("日\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									} else {
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("日\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									}
									}
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>給与&nbsp;<span class=\"required\">必須</span></th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"number\" id=\"editEmpSal\" name=\"editEmpSal\"\r\n");
      out.write("\t\t\t\t\t\t\tstep=\"0.01\" value=\"");
      out.print(emp.getSal());
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>歩合&nbsp;<span class=\"required\">必須</span></th>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" id=\"editEmpComm\" name=\"editEmpComm\"\r\n");
      out.write("\t\t\t\t\t\t\tstep=\"0.01\" value=\"");
      out.print(emp.getComm());
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th>部門番号&nbsp;<span class=\"required\">必須</span></th>\r\n");
      out.write("\t\t\t\t\t\t<td><select name=\"editEmpDeptno\" id=\"editEmpDeptno\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									for (Map.Entry<Integer, Dept> entry : resultListDept.entrySet()) {
										Integer deptno = entry.getKey();

										Dept dept = entry.getValue();

										resultListDept.get(deptno).getDeptno();
										if (resultListDept.get(deptno).getDeptno() == emp.getDeptno()) {
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(resultListDept.get(deptno).getDeptno());
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tselected>");
      out.print(resultListDept.get(deptno).getDeptno());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(resultListDept.get(deptno).getDname());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									} else {
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(resultListDept.get(deptno).getDeptno());
      out.write('"');
      out.write('>');
      out.print(resultListDept.get(deptno).getDeptno());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(resultListDept.get(deptno).getDname());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

									}
									}
								
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\" class=\"submit\">\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"submit\">更新</button>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</section>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
