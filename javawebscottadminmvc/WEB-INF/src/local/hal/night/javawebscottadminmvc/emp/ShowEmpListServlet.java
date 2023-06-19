package local.hal.night.javawebscottadminmvc.emp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.hal.night.javawebscottadminmvc.ParentServlet;
import local.hal.night.javawebscottadminmvc.dao.DeptDAO;
import local.hal.night.javawebscottadminmvc.dao.EmpDAO;
import local.hal.night.javawebscottadminmvc.entity.Dept;
import local.hal.night.javawebscottadminmvc.entity.Emp;

@WebServlet(name = "ShowEmpListServlet", urlPatterns = { "/emp/showList" })
public class ShowEmpListServlet extends ParentServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String jspPath = "/emp/empList.jsp";
		Connection con = null;

		try {
			con = getConnection();
			EmpDAO empDAO = new EmpDAO(con);
			DeptDAO deptDAO = new DeptDAO(con);

			Map<Integer, Emp> resultList = empDAO.findAll();
			Map<Integer,Dept> resultListD = deptDAO.findAll();

			request.setAttribute("resultList", resultList);
			request.setAttribute("resultListD", resultListD);
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

		try {
			con = getConnection();
			EmpDAO empDAO = new EmpDAO(con);

			Map<Integer, Dept> resultListEmp = empDAO.findDept();

			request.setAttribute("resultListEmp", resultListEmp);
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
