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
 * JavaWebScottAdminMVC Sample Src16
 *
 * 部門情報削除確認画面。
 * @author yuyas
 *
 */
@WebServlet(name = "ConfirmDeptDeleteServlet", urlPatterns = { "/dept/confirmDelete" })
public class ConfirmDeptDeleteServlet extends ParentServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspPath = "/dept/confirmDeptDelete.jsp";

		request.setCharacterEncoding("UTF-8");
		String deleteDeptDeptno = request.getParameter("deleteDeptDeptno");

		Connection con = null;

		try {
			int deleteDeptDeptnoInt = Integer.parseInt(deleteDeptDeptno);

			con = getConnection();
			DeptDAO deptDAO = new DeptDAO(con);

			Dept dept = deptDAO.findByPK(deleteDeptDeptnoInt);
			if (dept != null) {
				request.setAttribute("dept", dept);
			} else {
				jspPath = ERROR_JSP;
				request.setAttribute("errorMsg", "もう一度はじめからやり直してください。");
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

		RequestDispatcher rd = request.getRequestDispatcher(jspPath);
		rd.forward(request, response);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}
}
