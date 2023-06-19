package local.hal.night.javawebscottadminmvc.emp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

@WebServlet(name = "EmpEditServlet", urlPatterns = { "/emp/edit" })
public class EmpEditServlet extends ParentServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspPath = "ERROR_JSP";
		String redirectPath = "/javawebscottadminmvc/emp/showList";
		boolean isRedirect = false;

		request.setCharacterEncoding("UTF-8");
		String editEmpEmpno = request.getParameter("editEmpEmpno");
		String editEmpEname = request.getParameter("editEmpEname");
		String editEmpJob = request.getParameter("editEmpJob");
		String editEmpMgr = request.getParameter("editEmpMgr");
		String editEmpHiredateYear = request.getParameter("editEmpHiredateYear");
		String editEmpHiredateMonth = request.getParameter("editEmpHiredateMonth");
		String editEmpHiredateDay = request.getParameter("editEmpHiredateDay");
		String editEmpSal = request.getParameter("editEmpSal");
		String editEmpComm = request.getParameter("editEmpComm");
		String editEmpDeptno = request.getParameter("editEmpDeptno");

		editEmpEmpno = editEmpEmpno.trim();
		editEmpEname = editEmpEname.trim();
		editEmpJob = editEmpJob.trim();
		editEmpSal = editEmpSal.trim();
		editEmpComm = editEmpComm.trim();
		editEmpHiredateYear = editEmpHiredateYear.trim();
		editEmpHiredateMonth = editEmpHiredateMonth.trim();
		editEmpHiredateDay = editEmpHiredateDay.trim();

		Emp emp = new Emp();
		int editEmpEmpnoInt = Integer.parseInt(editEmpEmpno);
		int editEmpMgrInt = Integer.parseInt(editEmpMgr);
		double editEmpSalDouble = Double.parseDouble(editEmpSal);
		double editEmpCommDouble = Double.parseDouble(editEmpComm);
		int editEmpDeptnoInt = Integer.parseInt(editEmpDeptno);

		String editEmpHiredate = editEmpHiredateYear + "-" + editEmpHiredateMonth + "-" + editEmpHiredateDay;

		 Date sqlDate= Date.valueOf(editEmpHiredate);
		emp.setEmpno(editEmpEmpnoInt);
		emp.setEname(editEmpEname);
		emp.setJob(editEmpJob);
		emp.setMgr(editEmpMgrInt);
		emp.setSal(editEmpSalDouble);
		emp.setComm(editEmpCommDouble);
		emp.setHiredate(sqlDate);
		emp.setDeptno(editEmpDeptnoInt);

		Connection con = null;

		try {
			con = getConnection();
			EmpDAO empDAO = new EmpDAO(con);
			int result = empDAO.update(emp);
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
