<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	p {
		text-align: center;
		
	}
	table{
		margin: auto;
	}
</style>
<script type="text/javascript">
$(function() {
	$("#save-btn").click(function() {
		$("form").show();
		$("#type").attr("value", "save");
		$("#save").show();
		$("#loan").hide();
	});
	$("#loan-btn").click(function() {
		$("form").show();
		$("#type").attr("value", "loan");
		$("#loan").show();
		$("#save").hide();
	});
});

</script>
</head>
<body>
	<p>
	<button id="save-btn" class="button">
	적금 
	</button>
	<button id="loan-btn" class="button">
	대출
	</button>
	<a href="index.jsp">홈으로</a>
	</p>
	<form action="account.do" method="post" hidden="hidden">
		<table>
		<tr>
		<td><label for="name">이름</label></td><td><input type="text" name="name"></td>
		</tr>
		<tr>
		<td><label for="term">기간</label></td><td><input type="number" name="term">개월</td>
		</tr>
		<tr id="save" hidden="hidden">
		<td>
		<label for="save-money">월입금액</label></td><td><input type="number" name="save-money">원</td>
		</tr>
		<tr id="loan" hidden="hidden">
		<td><label for="loan-money">대출금액</label></td><td><input type="number" name="loan-money">원</td>
		</tr>
		<tr>
		<td>
		<input type="hidden" id="type" name="type">
		</td>
		<td>
		<input type="submit">
		<input type="reset">
		</td>
		</table>
	</form>
</body>
</html>