package local.hal.night.javawebscottadminmvc.dept;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.hal.night.javawebscottadminmvc.ParentServlet;
import local.hal.night.javawebscottadminmvc.dao.DeptDAO;
import local.hal.night.javawebscottadminmvc.entity.Dept;

/**
 * JavaWebScottAdminMVC Sample Src12
 *
 * 部門情報登録。
 * @author yuyas
 *
 */
@WebServlet(name = "DeptAddServlet", urlPatterns = { "/dept/add" })
public class DeptAddServlet extends ParentServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspPath = "/dept/deptAdd.jsp";
		String redirectPath = "/javawebscottadminmvc/dept/showList";
		boolean isRedirect = false;

		request.setCharacterEncoding("UTF-8");
		String addDeptDeptno = request.getParameter("addDeptDeptno");
		String addDeptDname = request.getParameter("addDeptDname");
		String addDeptLoc = request.getParameter("addDeptLoc");

		addDeptDeptno = addDeptDeptno.trim();
		addDeptDname = addDeptDname.trim();
		addDeptLoc = addDeptLoc.trim();

		List<String> validationMsgs = new ArrayList<String>();
		Connection con = null;

		try {
			con = getConnection();
			DeptDAO deptDAO = new DeptDAO(con);

			int addDeptDeptnoInt = Integer.parseInt(addDeptDeptno);
			Dept dept = deptDAO.findByPK(addDeptDeptnoInt);

			if (dept != null) {
				validationMsgs.add("その部門番号はすでに使われています。別のものを指定してください。");
			}
			if (validationMsgs.isEmpty()) {
				dept = new Dept();
				dept.setDeptno(addDeptDeptnoInt);
				dept.setDname(addDeptDname);
				dept.setLoc(addDeptLoc);

				int result = deptDAO.insert(dept);
				if (result < 1) {
					jspPath = ERROR_JSP;
					request.setAttribute("errorMsg", "情報登録に失敗しました。もう一度はじめからやり直してください。");
				} else {
					isRedirect = true;
				}
			} else {
				request.setAttribute("validationMsgs", validationMsgs);
				request.setAttribute("addDeptDeptno", addDeptDeptno);
				request.setAttribute("addDeptDname", addDeptDname);
				request.setAttribute("addDeptLoc", addDeptLoc);
			}
		} catch (NamingException ex) {
			jspPath = ERROR_JSP;
			ex.printStackTrace();
			request.setAttribute("errorMsg", "もう一度はじめから操作をお願いします。");
		} catch (SQLException ex) {
			jspPath = ERROR_JSP;
			ex.printStackTrace();
			request.setAttribute("errorMsg", "もう一度はじめから操作をお願いします。");
		} catch (Exception ex) {
			jspPath = ERROR_JSP;
			ex.printStackTrace();
			request.setAttribute("errorMsg", "もう一度はじめから操作をお願いします。");
		} finally {
			close(con);
		}
		if (isRedirect) {
			response.sendRedirect(redirectPath);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(jspPath);
			rd.forward(request, response);
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}

}
