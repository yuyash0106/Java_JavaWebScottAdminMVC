<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="local.hal.night.javawebscottadminmvc.entity.*"%>
<%
	Map<Integer, Emp> resultList = (Map<Integer, Emp>) request.getAttribute("resultList");
	Map<Integer, Dept> resultListD = (Map<Integer, Dept>) request.getAttribute("resultListD");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">

<title>従業員情報リスト|JavaWebScottAdmin Lesson</title>
<link rel="stylesheet" href="/javawebscottadminmvc/css/main.css"
	type="text/css">
</head>
<body>
	<h1>従業員リスト</h1>
	<nav>
		<ul>
			<li><a href="/javawebscottadminmvc/">TOP</a></li>
			<li>従業員リスト</li>
		</ul>
	</nav>
	<section>
		<p>
			新規登録は<a href="/javawebscottadminmvc/emp/goEmpAdd">こちら</a>から
		</p>
	</section>
	<section>
		<table>
			<thead>
				<tr>
					<th>従業員番号</th>
					<th>従業員名</th>
					<th>役職</th>
					<th>上司</th>
					<th>雇用日</th>
					<th>給与</th>
					<th>歩合</th>
					<th>所属部門</th>
					<th colspan="2">操作</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (resultList.isEmpty()) {
				%>
				<tr>
					<td colspan="5">該当従業員は存在しません。</td>
				</tr>
				<%
					} else {
						for (Map.Entry<Integer, Emp> entry : resultList.entrySet()) {
							Integer empno = entry.getKey();
							Integer empNo;
							Integer deptno;
							Emp emp = entry.getValue();

							resultList.get(empno).getMgr();
				%>
				<tr>
					<td><%=empno%></td>
					<td><%=emp.getEname()%></td>
					<td><%=emp.getJob()%></td>

					<%
						if (emp.getMgr() == 0) {
					%>
					<td><%=emp.getMgr()%>: 上司なし</td>
					<%
						} else if (resultList.containsKey(emp.getMgr())) {
									empNo = emp.getMgr();
									String mgrName = resultList.get(empNo).getEname();
					%>
					<td><%=emp.getMgr()%>: <%=mgrName%></td>
					<%
						}
					%>


					<td><%=emp.getHiredate()%></td>
					<td><%=emp.getSal()%></td>
					<td><%=emp.getComm()%></td>

					<%
						if (resultListD.containsKey(emp.getDeptno())) {
									deptno = emp.getDeptno();
									String dName = resultListD.get(deptno).getDname();
					%>
					<td><%=emp.getDeptno()%>:<%=dName%></td>
					<%
						}
					%>

					<td>
						<form action="/javawebscottadminmvc/emp/prepareEdit" method="post">
							<input type="hidden" id="editEmpEmpno" name="editEmpEmpno"
								value="<%=empno%>">
							<button type="submit">編集</button>
						</form>
					</td>
					<td>
						<form action="/javawebscottadminmvc/emp/confirmDelete"
							method="post">
							<input type="hidden" id="deleteEmpEmpno" name="deleteEmpEmpno"
								value="<%=empno%>">
							<button type="submit">削除</button>
						</form>
					</td>
				</tr>
				<%
					}
					}
				%>
			</tbody>
		</table>
	</section>
</body>
</html>