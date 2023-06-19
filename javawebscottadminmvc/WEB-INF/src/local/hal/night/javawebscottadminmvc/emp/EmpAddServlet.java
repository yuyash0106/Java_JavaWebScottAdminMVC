package local.hal.night.javawebscottadminmvc.emp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
import local.hal.night.javawebscottadminmvc.dao.EmpDAO;
import local.hal.night.javawebscottadminmvc.entity.Emp;

@WebServlet(name = "EmpAddServlet", urlPatterns = { "/emp/add" })
public class EmpAddServlet extends ParentServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspPath = "/emp/empAdd.jsp";
		String redirectPath = "/javawebscottadminmvc/emp/showList";
		boolean isRedirect = false;

		request.setCharacterEncoding("UTF-8");
		String addEmpEmpno = request.getParameter("addEmpEmpno");
		String addEmpEname = request.getParameter("addEmpEname");
		String addEmpJob = request.getParameter("addEmpJob");
		String addEmpMgr = request.getParameter("addEmpMgr");
		String addEmpHiredateYear = request.getParameter("addEmpHiredateYear");
		String addEmpHiredateMonth = request.getParameter("addEmpHiredateMonth");
		String addEmpHiredateDay = request.getParameter("addEmpHiredateDay");
		String addEmpSal = request.getParameter("addEmpSal");
		String addEmpComm = request.getParameter("addEmpComm");
		String addEmpDeptno = request.getParameter("addEmpDeptno");

		addEmpEmpno = addEmpEmpno.trim();
		addEmpEname = addEmpEname.trim();
		addEmpJob = addEmpJob.trim();
		addEmpSal = addEmpSal.trim();
		addEmpComm = addEmpComm.trim();
		addEmpHiredateYear = addEmpHiredateYear.trim();
		addEmpHiredateMonth = addEmpHiredateMonth.trim();
		addEmpHiredateDay = addEmpHiredateDay.trim();

		List<String> validationMsgs = new ArrayList<String>();
		Connection con = null;

		try {
			con = getConnection();
			EmpDAO empDAO = new EmpDAO(con);

			int addEmpEmpnoInt = Integer.parseInt(addEmpEmpno);
			int addEmpMgrInt = Integer.parseInt(addEmpMgr);
			double addEmpSalDouble = Double.parseDouble(addEmpSal);
			double addEmpCommDouble = Double.parseDouble(addEmpComm);
			int addEmpDeptnoInt = Integer.parseInt(addEmpDeptno);

			String addEmpHiredate = addEmpHiredateYear + "-" + addEmpHiredateMonth + "-" + addEmpHiredateDay;


			 Date sqlDate= Date.valueOf(addEmpHiredate);

			Emp emp = empDAO.findByPK(addEmpEmpnoInt);

			if (emp != null) {
				validationMsgs.add("その従業員番号はすでに使われています。別のものを指定してください。");
			}
			if (validationMsgs.isEmpty()) {
				emp = new Emp();
				emp.setEmpno(addEmpEmpnoInt);
				emp.setEname(addEmpEname);
				emp.setJob(addEmpJob);
				emp.setMgr(addEmpMgrInt);
				emp.setHiredate(sqlDate);
				emp.setSal(addEmpSalDouble);
				emp.setComm(addEmpCommDouble);
				emp.setDeptno(addEmpDeptnoInt);

				int result = empDAO.insert(emp);
				if (result < 1) {
					jspPath = ERROR_JSP;
					request.setAttribute("errorMsg", "情報登録に失敗しました。もう一度はじめからやり直してください。");
				} else {
					isRedirect = true;
				}
			} else {
				request.setAttribute("validationMsgs", validationMsgs);
				request.setAttribute("addEmpEmpno", addEmpEmpno);
				request.setAttribute("addEmpEname", addEmpEname);
				request.setAttribute("addEmpJob", addEmpJob);
				request.setAttribute("addEmpMgr", addEmpMgr);
				request.setAttribute("addEmpHiredateYear", addEmpHiredateYear);
				request.setAttribute("addEmpHiredateMonth", addEmpHiredateMonth);
				request.setAttribute("addEmpHiredateDay", addEmpHiredateDay);
				request.setAttribute("addEmpSal", addEmpSal);
				request.setAttribute("addEmpComm", addEmpComm);
				request.setAttribute("addEmpDeptno", addEmpDeptno);
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
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
	doPost(request,response);
}
}
