<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>categoryList</title>
</head>
<body>
	<ol>
	<c:forEach var="category" items="${category}">
		<li><a class="btn btn-primary" href="">${category.categoryName}</a></li>
	</c:forEach>
	</ol>
</body>
</html>