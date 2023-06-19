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

@WebServlet(name = "EmpDeleteServlet", urlPatterns = { "/emp/delete" })
public class EmpDeleteServlet extends ParentServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirectPath = "/javawebscottadminmvc/emp/showList";
		boolean isRedirect = false;

		request.setCharacterEncoding("UTF-8");
		String deleteEmpEmpno = request.getParameter("deleteEmpEmpno");
		int deleteEmpEmpnoInt = Integer.parseInt(deleteEmpEmpno);

		Connection con = null;

		try {
			con = getConnection();
			EmpDAO empDAO = new EmpDAO(con);

			int result = empDAO.delete(deleteEmpEmpnoInt);
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
			RequestDispatcher rd = request.getRequestDispatcher(ERROR_JSP);
			rd.forward(request, response);
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}

}
