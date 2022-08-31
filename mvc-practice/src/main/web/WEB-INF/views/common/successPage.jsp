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
	<script>
		(function(){
			
			const succCode = '${ requestScope.succCode }';
			
			let successMessage = '';
			let movePath = '';
			
			switch(succCode) {
			case 'updateExpiry' : 
				successMessage = '회원권이 연장되었습니다!'
				movePath = '${ pageContext.servletContext.contextPath }/member/search?name=${name}';
				break;
			case 'joinMembership' : 
				successMessage = '회원이 등록되었습니다!'
				movePath = '${ pageContext.servletContext.contextPath }/member/search?name=${name}';
				break;
			case 'deleteMember' : 
				successMessage = '회원 정보가 삭제되었습니다.'
				movePath = '${ pageContext.servletContext.contextPath }/member/list';
				break;
			
			}
			
			alert(successMessage);
			location.href = movePath;
			
		})();
	</script>

</body>
</html>