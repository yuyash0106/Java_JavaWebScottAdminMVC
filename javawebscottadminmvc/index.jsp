<%--
JavaWebScottAdminMVC Lesson Src03

TOP画面。

ファイル名=index.jsp
ディレクトリ=/javawebscottadminmvc/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>TOP|JavaWebScottAdmin Lesson</title>
</head>
<body>
	<h1>TOP</h1>
	<nav>
		<ul>
			<li><a href="/javawebscottadminmvc/dept/showList">部門リスト</a></li>
			<li><a href="/javawebscottadminmvc/emp/showList">従業員リスト</a></li>
		</ul>
	</nav>
</body>
</html>