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
	<table>
		<tr>
			<th>회원 코드</th>
			<th>회원 이름</th>
		</tr>
		<c:forEach items="${ requestScope.allMember }" var="mem">
			<tr>
				<td>${ mem.code }</td>
				<td>${ mem.name }</td>
		</c:forEach>
	</table>
 

</body>
</html>