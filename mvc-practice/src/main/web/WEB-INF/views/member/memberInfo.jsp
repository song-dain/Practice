<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<th>이름</th>
			<th>성별</th>
			<th>레벨</th>
			<th>등록일</th>
			<th>만료일</th>
			<th>연장여부</th>
		</tr>
		<tr>
			<td>${ searchMember.code }</td>
			<td>${ searchMember.id }</td>
			<td>${ searchMember.name }</td>
			<td>${ searchMember.gender }</td>
			<td>${ searchMember.level }</td>
			<td>${ searchMember.registDate }</td>
			<td>${ searchMember.expiryDate }</td>
			<td>${ searchMember.extendYn }</td>
		</tr>
	</table>
</body>
</html>