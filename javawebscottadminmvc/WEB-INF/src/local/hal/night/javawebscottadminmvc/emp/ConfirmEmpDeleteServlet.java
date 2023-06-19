package local.hal.night.javawebscottadminmvc.emp;

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
import local.hal.night.javawebscottadminmvc.dao.EmpDAO;
import local.hal.night.javawebscottadminmvc.entity.Emp;

@WebServlet(name = "ConfirmEmpDeleteServlet", urlPatterns = { "/emp/confirmDelete" })
public class ConfirmEmpDeleteServlet extends ParentServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspPath = "/emp/confirmEmpDelete.jsp";

		request.setCharacterEncoding("UTF-8");
		String deleteEmpEmpno = request.getParameter("deleteEmpEmpno");

		Connection con = null;
		try {
			int deleteEmpEmpnoInt = Integer.parseInt(deleteEmpEmpno);

			con = getConnection();
			EmpDAO empDAO = new EmpDAO(con);

			Emp emp = empDAO.findByPK(deleteEmpEmpnoInt);
			if (emp != null) {
				request.setAttribute("emp", emp);
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
