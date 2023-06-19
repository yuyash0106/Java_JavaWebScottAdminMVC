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

@WebServlet(name = "PrepareEmpEditServlet", urlPatterns = { "/emp/prepareEdit" })
public class PrepareEmpEditServlet extends ParentServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspPath = "/emp/empEdit.jsp";

		request.setCharacterEncoding("UTF-8");
		String editEmpEmpno = request.getParameter("editEmpEmpno");

		Connection con = null;

		try {
			int editEmpEmpnoInt = Integer.parseInt(editEmpEmpno);

			con = getConnection();
			EmpDAO empDAO = new EmpDAO(con);
			DeptDAO deptDAO = new DeptDAO(con);

			Emp emp = empDAO.findByPK(editEmpEmpnoInt);

			Map<Integer, Emp> resultList = empDAO.findAll();
			Map<Integer,Dept> resultListDept = deptDAO.findAll();
			Map<Integer,Emp> resultListMgr = empDAO.findMgr();

			if (emp != null) {
		        request.setAttribute("emp", emp);
		        request.setAttribute("resultListMgr", resultListMgr);
		        request.setAttribute("resultList", resultList);
		        request.setAttribute("resultListDept", resultListDept);


			} else {
				jspPath = ERROR_JSP;
				request.setAttribute("errorMsg", "更新対象従業員情報の取得に失敗しました。もう一度はじめからやり直してください。");
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
