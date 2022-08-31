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
 	
 	<a href="${ pageContext.servletContext.contextPath}/member/list"><h4 align="center">전체 회원 조회</h4></h4></a>
 	<hr>
 	<h3>회원 등록</h3>
 	<form action="${ pageContext.servletContext.contextPath}/member/join" method="post">
 		<label>이름 : </label>
 		<input type="text" name="name"><br>
 		<label>아이디 : </label>
 		<input type="text" name="id"><br>
 		<label>비밀번호 : </label>
 		<input type="password" name="pwd"><br>
		<label>성별 : </label>
		<input type="radio" name="gender" id="male" value="남">
		<label for="male">남자</label>
		<input type="radio" name="gender" id="female" value="여">
		<label for="female">여자</label><br>
		<label>수영 등급 : </label> 
		<select name="memberLevel">
			<option value="입문">입문</option>
			<option value="초급">초급</option>
			<option value="중급">중급</option>
			<option value="고급">고급</option>
		</select><br>
		등록일(시작일) : <input type="date" name="registDate"><br>
		만료일(종료일) : <input type="date" name="expiryDate"><br><br>
		<button type="submit">회원 가입</button>
 	</form>
 	<br>
 	<hr>
 	<h4>회원 검색</h4>
 	<form action="${ pageContext.servletContext.contextPath}/member/search" >
 		<label>이름 </label>
 		<input type="text" name="name">
 		<button type="submit">검색</button>
 	</form>
 	<br>
 	<hr>
 	<h4>회원권 연장</h4>
 	<form action="${ pageContext.servletContext.contextPath}/member/extend" method="post">
 		<label>이름 </label>
 		<input type="text" name="name">
 		<input type="date" name="expiryDate">
 		<button type="submit">연장</button>
 	</form>
 	<br>
 	<hr>
 	<h4>회원 정보 삭제</h4>
 	<form action="${ pageContext.servletContext.contextPath}/member/delete" method="post">
 		<label>이름 </label>
 		<input type="text" name="name">
 		<button type="submit">정보 삭제</button>
 	</form>
 	<br>
 	<hr>
</body>
</html>