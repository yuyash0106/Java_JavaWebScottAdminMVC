<%--
JavaWebScottAdmin Practice Src10

従業員情報編集画面。

ファイル名=empEdit.jsp
ディレクトリ=/javawebscottadmin/emp
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.text.ParseException"%>
<%@ page import="local.hal.night.javawebscottadminmvc.entity.*"%>
<%
	Emp emp = (Emp) request.getAttribute("emp");

	List<String> validationMsgs = (List<String>) request.getAttribute("validationMsgs");
	Map<Integer, Emp> resultList = (Map<Integer, Emp>) request.getAttribute("resultList");
	Map<Integer, Emp> resultListMgr = (Map<Integer, Emp>) request.getAttribute("resultListMgr");
	Map<Integer, Dept> resultListDept = (Map<Integer, Dept>) request.getAttribute("resultListDept");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>従業員情報編集｜JavaWebScottAdmin Practice</title>
<link rel="stylesheet" href="/javawebscottadminmvc/css/main.css"
	type="text/css">
</head>
<body>
	<h1>従業員情報編集</h1>
	<nav>
		<ul>
			<li><a href="/javawebscottadminmvc/">TOP</a></li>
			<li><a href="/javawebscottadminmvc/emp/showList">従業員リスト</a></li>
			<li>従業員情報編集</li>
		</ul>
	</nav>

	<%
		if (validationMsgs != null) {
	%>
	<section id="errorMsg">
		<p>以下のメッセージをご確認ください。</p>
		<ul>
			<%
				for (String msg : validationMsgs) {
			%>
			<li><%=msg%></li>
			<%
				}
			%>
		</ul>
	</section>
	<%
		}
	%>
	<section>
		<p>情報を入力し、更新ボタンをクリックしてください。</p>
		<form action="/javawebscottadminmvc/emp/edit" method="post">
			<table>
				<tbody>
					<tr>
						<th>
					<tr>
						<th>従業員番号&nbsp;<span class="required">必須</span></th>
						<td><%=emp.getEmpno()%></td>
					</tr>
					<tr>
						<th>従業員名&nbsp;<span class="required">必須</span></th>
						<td><input type="text" id="editEmpEname" name="editEmpEname"
							value="<%=emp.getEname()%>"></td>
					</tr>
					<tr>
						<th>役職&nbsp;<span class="required">必須</span></th>
						<td><input type="text" id="editEmpJob" name="editEmpJob"
							value="<%=emp.getJob()%>"></td>
					</tr>
					<tr>
						<th>上司番号&nbsp;<span class="required">必須</span></th>
						<td><select name="editEmpMgr" id="editEmpMgr">
								<%
								Integer empno;
									for (Map.Entry<Integer, Emp> entry : resultList.entrySet()) {

										empno = entry.getKey();
										Emp emp1 =  entry.getValue();

										if(emp.getMgr() == 0){
										}else{
										empno = emp.getMgr();
										}


										if (resultList.get(empno).getEmpno() == emp1.getEmpno()) {

											%>
											<option value="<%=emp.getMgr()%>"
												selected><%=resultList.get(empno).getEmpno()%>:
												<%=resultList.get(empno).getEname()%>
											</option>
											<%

										}else{
											 empno = entry.getKey();
											%>
											<option value="<%=resultList.get(empno).getEmpno()%>"
												><%=resultList.get(empno).getEmpno()%>:
												<%=resultList.get(empno).getEname()%>
											</option>
											<%
										}

									}

								if (emp.getMgr() == 0) {
									empno = emp.getEmpno();
							%>
							<option value="0" selected>0:上司なし</option>
							<%
								} else {
									empno = emp.getMgr();
							%>
							<option value="0">0:上司なし</option>
							<%
								}


								%>



						</select></td>
					</tr>
					<tr>
						<th>雇用日&nbsp;<span class="required">必須</span></th>
						<td><select name="editEmpHiredateYear"
							id="editEmpHiredateYear">
								<%
									String str = new SimpleDateFormat("yyyy-MM-dd").format(emp.getHiredate());
									String y = str.substring(0, 4);
									int yI = Integer.parseInt(y);
									for (int i = 1980; i <= 2021; i++) {
										if (yI == i) {
								%>
								<option value="<%=i%>" selected><%=i%>年
								</option>
								<%
									} else {
								%>
								<option value="<%=i%>"><%=i%>年
								</option>
								<%
									}
									}
								%>

						</select> <select name="editEmpHiredateMonth" id="editEmpHiredateMonth">
								<%
									String m = str.substring(5, 7);
									int monthI = Integer.parseInt(m);
									for (int i = 1; i <= 12; i++) {
										if (monthI == i) {
								%>
								<option value="<%=i%>" selected><%=i%>月
								</option>
								<%
									} else {
								%>
								<option value="<%=i%>"><%=i%>月
								</option>
								<%
									}
									}
								%>
						</select> <select name="editEmpHiredateDay" id="editEmpHiredateDay">
								<%
									String d = str.substring(8, 10);
									int dayI = Integer.parseInt(d);
									for (int i = 1; i <= 31; i++) {
										if (dayI == i) {
								%>
								<option value="<%=i%>" selected><%=i%>日
								</option>
								<%
									} else {
								%>
								<option value="<%=i%>"><%=i%>日
								</option>
								<%
									}
									}
								%>
						</select></td>
					</tr>
					<tr>
						<th>給与&nbsp;<span class="required">必須</span></th>
						<td><input type="number" id="editEmpSal" name="editEmpSal"
							step="0.01" value="<%=emp.getSal()%>"></td>
					</tr>
					<tr>
						<th>歩合&nbsp;<span class="required">必須</span></th>
						<td><input type="text" id="editEmpComm" name="editEmpComm"
							step="0.01" value="<%=emp.getComm()%>"></td>
					</tr>
					<tr>
						<th>部門番号&nbsp;<span class="required">必須</span></th>
						<td><select name="editEmpDeptno" id="editEmpDeptno">
								<%
									for (Map.Entry<Integer, Dept> entry : resultListDept.entrySet()) {
										Integer deptno = entry.getKey();

										Dept dept = entry.getValue();

										resultListDept.get(deptno).getDeptno();
										if (resultListDept.get(deptno).getDeptno() == emp.getDeptno()) {
								%>
								<option value="<%=resultListDept.get(deptno).getDeptno()%>"
									selected><%=resultListDept.get(deptno).getDeptno()%>
									<%=resultListDept.get(deptno).getDname()%>
								</option>
								<%
									} else {
								%>
								<option value="<%=resultListDept.get(deptno).getDeptno()%>"><%=resultListDept.get(deptno).getDeptno()%>
									<%=resultListDept.get(deptno).getDname()%>
								</option>
								<%
									}
									}
								%>

						</select></td>
					</tr>
					<tr>
						<td colspan="2" class="submit">
							<button type="submit">更新</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</section>
</body>
</html>