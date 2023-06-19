<%--
javaWebScottAdmin Practice Src 07

従業員情報追加画面。

ファイル名=empAdd.jsp
ディレクトリ=/javawebscottadmin/emp/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="local.hal.night.javawebscottadminmvc.entity.*"%>
<%
	String addEmpEmpno = (String) request.getAttribute("addEmpEmpno");
	String addEmpEname = (String) request.getAttribute("addEmpEname");
	String addEmpJob = (String) request.getAttribute("addEmpJob");
	String addEmpMgr = (String) request.getAttribute("addEmpMgr");
	String addEmpHiredateYear = (String) request.getAttribute("addEmpHiredateYear");
	String addEmpHiredateMonth = (String) request.getAttribute("addEmpHiredateMonth");
	String addEmpHiredateDay = (String) request.getAttribute("addEmpHiredateDay");
	String addEmpSal = (String) request.getAttribute("addEmpSal");
	String addEmpComm = (String) request.getAttribute("addEmpComm");
	String addEmpDeptno = (String) request.getAttribute("addEmpDeptno");

	Map<Integer, Emp> resultList = (Map<Integer, Emp>) request.getAttribute("resultList");
	Map<Integer, Emp> resultListMgr = (Map<Integer, Emp>) request.getAttribute("resultListMgr");
	Map<Integer, Dept> resultListDept = (Map<Integer, Dept>) request.getAttribute("resultListDept");

	if (addEmpEmpno == null) {
		addEmpEmpno = "";
	}
	if (addEmpEname == null) {
		addEmpEname = "";
	}
	if (addEmpJob == null) {
		addEmpJob = "";
	}
	if (addEmpMgr == null) {
		addEmpMgr = "";
	}
	if (addEmpHiredateYear == null) {
		addEmpHiredateYear = "";
	}
	if (addEmpHiredateMonth == null) {
		addEmpHiredateMonth = "";
	}
	if (addEmpHiredateDay == null) {
		addEmpHiredateDay = "";
	}
	if (addEmpSal == null) {
		addEmpSal = "";
	}
	if (addEmpComm == null) {
		addEmpComm = "";
	}
	if (addEmpDeptno == null) {
		addEmpDeptno = "";
	}

	List<String> validationMsgs = (List<String>) request.getAttribute("validationMsgs");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>従業員情報追加｜JavaWebScottAdminMVC Practice</title>
<link rel="stylesheet" href="/javawebscottadminmvc/css/main.css"
	type="text/css">
</head>
<body>
	<h1>従業員情報追加</h1>
	<nav>
		<ul>
			<li><a href="/javawebscottadminmvc/">TOP</a></li>
			<li><a href="/javawebscottadminmvc/emp/showList">従業員リスト</a></li>
			<li>従業員情報追加</li>
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
		<p>情報を入力し、登録ボタンをクリックしてください。</p>
		<form action="/javawebscottadminmvc/emp/add" method="post">
			<table>
				<tr>
					<th>従業員番号&nbsp;<span class="required">必須</span></th>
						<td><input type="number" required="required" id="addEmpEmpno"
							name="addEmpEmpno" min="1000" max="9999" value="<%=addEmpEmpno%>"
							required></td>
				</tr>

				<tr>
					<th>従業員名&nbsp;<span class="required">必須</span></th>
					<td><input type="text" required="required" id="addEmpEname"
						name="addEmpEname" value="<%=addEmpEname%>" required></td>

				</tr>
				<tr>
					<th>役職&nbsp;<span class="required">必須</span></th>
					<td><input type="text" required="required" id="addEmpJob"
						name="addEmpJob" value="<%=addEmpJob%>" required></td>
				</tr>
				<tr>
					<th>上司番号&nbsp;<span class="required">必須</span></th>
					<td><select required name="addEmpMgr" id="addEmpMgr"
						required="required">
							<option value="" selected>--</option>
							<%
								for (Map.Entry<Integer, Emp> entry : resultList.entrySet()) {
									Integer empno = entry.getKey();

									Emp emp = entry.getValue();

									if (resultList.get(empno).getMgr() != null) {
							%>
							<option value="<%=resultList.get(empno).getEmpno()%>"><%=resultList.get(empno).getEmpno()%>:
								<%=resultList.get(empno).getEname()%>
							</option>
							<%
								}
								}

							%>
							<option value="0">0:上司なし</option>
							<%

							%>
					</select></td>
				</tr>
				<tr>
					<th>雇用日&nbsp;<span class="required">必須</span></th>
					<td><select required name="addEmpHiredateYear"
						id="addEmpHiredateYear" required="required">
							<option value="" selected>--</option>
							<%
								for (int i = 1980; i < 2022; i++) {
							%>
							<option value="<%=i%>"><%=i%>年
							</option>
							<%
								}
							%>
					</select> <select required name="addEmpHiredateMonth"
						id="addEmpHiredateMonth" required="required">
							<option value="" selected>--</option>
							<%
								for (int i = 1; i < 13; i++) {
							%>
							<option value="<%=i%>"><%=i%>月
							</option>
							<%
								}
							%>
					</select> <select required name="addEmpHiredateDay" id="addEmpHiredateDay"
						required="required">
							<option value="" selected>--</option>
							<%
								for (int i = 1; i < 32; i++) {
							%>
							<option value="<%=i%>"><%=i%>日
							</option>
							<%
								}
							%>
					</select></td>



				</tr>
				<tr>
					<th>給与&nbsp;<span class="required">必須</span></th>
					<td><input type="number" required="required" id="addEmpSal"
						name="addEmpSal" step="0.01" value="<%=addEmpSal%>" required></td>
				</tr>
				<tr>
					<th>歩合&nbsp;<span class="required">必須</span></th>
					<td><input type="number" required="required" id="addEmpComm"
						name="addEmpComm" step="0.01" value="<%=addEmpComm%>" required></td>
				</tr>
				<tr>
					<th>部門番号&nbsp;<span class="required">必須</span></th>
					<td><select required name="addEmpDeptno" id="addEmpDeptno"
						required="required">
							<option value="" selected>--</option>
							<%
								for (Map.Entry<Integer, Dept> entry : resultListDept.entrySet()) {
									Integer deptno = entry.getKey();

									Dept dept = entry.getValue();

									resultListDept.get(deptno).getDeptno();
									if (resultListDept.get(deptno).getDeptno() != null) {
							%>
							<option value="<%=resultListDept.get(deptno).getDeptno()%>"><%=resultListDept.get(deptno).getDeptno()%>:
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
						<button type="submit">登録</button>
					</td>
				</tr>

			</table>
		</form>
	</section>
</body>
</html>