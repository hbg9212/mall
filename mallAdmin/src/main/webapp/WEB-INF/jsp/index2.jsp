<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h1>관리자 메인 페이지</h1>
	<div class="row">
		<div class="col-sm-2 bg-light text-dark" >
			<c:if test="${adminId != null}">
				<div>${adminLevel} ${adminName}님 안녕하세요</div>
			</c:if>
			<c:if test="${adminId == null}">
				<a class="btn btn-primary" href="/admin/login">로그인</a>
			</c:if>
			<c:if test="${adminId != null}">
				<a class="btn btn-primary" href="/category/addCategory">카테고리 추가</a><br><br>
				<a class="btn btn-primary" href="/category/categoryLsit">카테고리 리스트</a><br><br>
				<a class="btn btn-primary" href="/admin/logout">로그아웃</a><br>
			</c:if>
		</div>
		<div class="col-sm-10" >
			
		</div>
	</div>
</body>
</html>