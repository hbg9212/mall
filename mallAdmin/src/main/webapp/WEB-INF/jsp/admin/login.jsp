<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>관리자 로그인 </h1>
	<div class="row">
		<div class="col-sm-2 bg-light text-dark" >
			<jsp:include page="/WEB-INF/jsp/inc/sideMenu.jsp"></jsp:include>
		</div>
		<div class="col-sm-10" >
			<form method="post" action="${pageContext.request.contextPath}/admin/login">
				관리자ID : 
				<input class="form-control" type="text" name="memberId">
				관리자PW : 
				<input class="form-control" type="password" name="memberPw">
				<br>
				<input class="btn btn-primary" type="submit" value="로그인">
			</form>
		</div>
	</div>
</body>
</html>