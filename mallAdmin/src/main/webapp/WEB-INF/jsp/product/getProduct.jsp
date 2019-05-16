<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getProduct</title>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){
	$('#addbtn').click(function(){
		console.log("addbtn click...");
		$('#addProductStockForm').submit();
	});
});
</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-2 bg-light text-dark" >
			<jsp:include page="/WEB-INF/jsp/inc/sideMenu.jsp"></jsp:include>
		</div>
		<div class="col-sm-10" >
			<div>
				<a class="btn btn-primary" href="${pageContext.request.contextPath}/product/productList?currentPage=${currentPage}&categoryNo=${categoryNo}&searchWord=${searchWord}">글목록</a>
				<table class="table table-striped">
			        <thead>
			            <tr>
			                <th>productCommonName</th>
			                <th>productCommonPrice</th>
			                <th>productCommonDate</th>
			            </tr>
			        </thead>
			        <tbody>
		                <tr>
		                    <td>${productCommon.productCommonName}</td>
		                    <td>${productCommon.productCommonPrice}</td>
		                    <td>${productCommon.productCommonDate}</td>
		                </tr>
			        </tbody>
			    </table>
			</div>
			<a class="btn btn-primary" href="${pageContext.request.contextPath}/product/addProduct?productCommonNo=${productCommon.productCommonNo}">상품추가</a>
			<div>
				<table class="table table-striped">
			        <thead>
			            <tr>
			            	<th>productColor</th>
			                <th>productSize</th>
			                <th>productStock</th>
			                <th>재고량 수정하기</th>
			                <th>수정하기</th>
			           </tr>
			        </thead>
			        <tbody>
				        <c:if test='${product != "null" }'>			        
				            <c:forEach var="p" items="${product}">
				                <tr>
				                    <td>${p.productColor}</td>
				                    <td>${p.productSize}</td>
				                    <td>${p.productStock}</td>
				                    <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/product/modifyProductStock?productNo=${p.productNo}">재고량 수정</a></td>
				                    <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/product/updateProduct?productNo=${p.productNo}">수정</a></td>
				                </tr>
				            </c:forEach>
				        </c:if>
			        </tbody>
			    </table>
			</div>
		</div>
	</div>
</body>
</html>