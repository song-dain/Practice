<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<table align="center" border="1">
		<tr>
			<th>회원 코드</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>성별</th>
			<th>레벨</th>
			<th>등록일</th>
			<th>만료일</th>
			<th>연장여부</th>
		</tr>
		<c:forEach items="${ requestScope.allMember }" var="mem">
			<tr>
				<td>${ mem.code }</td>
				<td>${ mem.id }</td>
				<td>${ mem.pwd }</td>
				<td>${ mem.name }</td>
				<td>${ mem.gender }</td>
				<td>${ mem.level }</td>
				<td>${  mem.registDate }</td>
				<td>${ mem.expiryDate }</td>
				<td>${ mem.extendYn }</td>
			</tr>
		</c:forEach>
	</table>
 

</body>
</html>