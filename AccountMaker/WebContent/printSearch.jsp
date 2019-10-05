<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="type" value="${type}"></c:set>
	<c:forEach var="data" items="${list}">
	 		계좌번호: <span>${data.accNum}</span>
			이름: <span>${data.name}</span>
			기간: <span>${data.term}개월</span>
			이자율: <span>${data.INTEREST}%</span>
			이자액: <span>${data.interestAmount}</span>
			<c:choose>
				<c:when test="${type eq 'save'}">
					월입금액: <span>${data.saveAvg}</span>
					총남입금액: <span>${data.saveAmount}</span>
					만기시 환금액: <span>${data.saveReturn }원</span>
				</c:when>
				<c:when test="${type eq 'loan'}">
					대출금액: <span>${data.loanAvg}</span>
					월상환액: <span>${data.loanAmount}</span>
				</c:when>
			</c:choose>
			<br>
			<hr>			
	</c:forEach>
	<a href="index.jsp">홈으로</a>
	<a href="searchAccount.jsp">조회로</a>
	<a href="makeAccount.jsp">계좌생성</a>
</body>
</html>