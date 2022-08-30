<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		(function()){
			const successCode = '${ requestScope.successCode }';
		}
		
		let successMessage = '';
		let movePath = '';
		
		switch(successCode){
		case 'updateExpiry' :
			successMessage = '회원권이 연장되었습니다.';
			movePath = '${ pageContext.servletContext.contextPath }/member/list';
			break;
		case 'deleteMember' :
			successMessage = '정보 삭제 완료되었습니다.';
			movePath = '${ pageContext.servletContext.contextPath }/member/list';
		}
		
		alert(successMessage);
		location.href = movePath;
	</script>
	
	회원권이 연장되었습니다.

</body>
</html>