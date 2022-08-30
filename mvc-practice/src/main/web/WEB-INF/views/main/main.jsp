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
 	
 	<h4>전체 회원 조회</h4>
 	<form action="${ pageContext.servletContext.contextPath}/member/list">
 		<button type="submit">전체 회원 조회</button>
 	</form>
 	
 	<h4><a action="/member/list">전체 회원 조회</a></h4>
 	
 	<h4>회원 검색</h4>
 	<form action="${ pageContext.servletContext.contextPath}/member/search" >
 		<label>이름 </label>
 		<input type="text" name="name">
 		<button type="submit">검색</button>
 	</form>
 	
 	<h4>회원권 연장</h4>
 	<form action="${ pageContext.servletContext.contextPath}/member/extend" method="post">
 		<label>이름 </label>
 		<input type="text" name="name">
 		<input type="date" name="expiryDate">
 		<button type="submit">연장</button>
 	</form>
 	
 	<h4>회원 정보 삭제</h4>
 	<form action="${ pageContext.servletContext.contextPath}/member/delete" method="post">
 		<label>이름 </label>
 		<input type="text" name="name">
 		<button type="submit">정보 삭제</button>
 	</form>
</body>
</html>