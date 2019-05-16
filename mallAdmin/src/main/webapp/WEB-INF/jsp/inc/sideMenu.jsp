<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<br>
<a class="btn btn-primary" href="/product/productList">전체목록</a>
<br>
<br>
<ol>
<c:forEach var="category" items="${category}">
	<li><a class="btn btn-primary" href="/product/productList?categoryNo=${category.categoryNo}">${category.categoryName}</a></li>
</c:forEach>
</ol>