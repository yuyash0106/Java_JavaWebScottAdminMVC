package local.hal.night.javawebscottadminmvc.dept;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
 * JavaWebScottAdminMVC Sample Src15
 *
 * 部門情報更新。
 * @author yuyas
 *
 */
@WebServlet(name = "DeptEditServlet", urlPatterns = { "/dept/edit" })
public class DeptEditServlet extends ParentServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspPath = "ERROR_JSP";
		String redirectPath = "/javawebscottadminmvc/dept/showList";
		boolean isRedirect = false;

		request.setCharacterEncoding("UTF-8");
		String editDeptDeptno = request.getParameter("editDeptDeptno");
		String editDeptDname = request.getParameter("editDeptDname");
		String editDeptLoc = request.getParameter("editDeptLoc");

		editDeptDname = editDeptDname.trim();
		editDeptLoc = editDeptLoc.trim();

		Dept dept = new Dept();
		int editDeptDeptnoInt = Integer.parseInt(editDeptDeptno);
		dept.setDeptno(editDeptDeptnoInt);
		dept.setDname(editDeptDname);
		dept.setLoc(editDeptLoc);

		Connection con = null;
		try {
			con = getConnection();
			DeptDAO deptDAO = new DeptDAO(con);
			int result = deptDAO.update(dept);
			if (result < 1) {
				request.setAttribute("errorMsg", "情報更新に失敗しました。もう一度はじめからやり直してください。");
			} else {
				isRedirect = true;
			}
		} catch (NamingException ex) {
			ex.printStackTrace();
			request.setAttribute("errorMsg", "もう一度はじめから操作をお願いします。");
		} catch (SQLException ex) {
			ex.printStackTrace();
			request.setAttribute("errorMsg", "もう一度はじめから操作をお願いします。");
		} catch (Exception ex) {
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
