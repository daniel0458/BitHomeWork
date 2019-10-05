<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	body{
		text-align: center;
	}
	table {
		margin: auto;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="searchaccount.do" method="post">
	<table>
		<tr>
		<td><a href="index.jsp">홈으로</a></td>
		</tr>
		<tr>
		<td><input type="text" name="name"></td>
		<td><input type="submit" value="조회"></td>
		<td><input type="hidden"></td>
		</tr>
		<tr>
		<td>적금<input type="radio" name="type" value="save">
		대출<input type="radio" name="type" value="loan"></td>
		</tr>
	</table>
	</form>
</body>
</html>