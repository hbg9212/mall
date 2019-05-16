<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
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
		$('#addProductForm').submit();
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
			<form id="addProductForm" action="${pageContext.request.contextPath}/product/addProduct" method="post">
				<input type="hidden" name="productCommonNo" value="${productCommonNo}">
				<div>
					상품 색상  :
				</div>
				<div>
					<input class="form-control" type="text" name="productColor">
				</div>
				<div>
					상품 사이즈  :
				</div>
				<div>
					<input class="form-control" type="text" name="productSize">
				</div>
				<div>
					상품 제고량  :
				</div>
				<div>
					<input class="form-control" type="text" name="productStock">
				</div>
				<div>
					<button class="btn btn-primary" id="addbtn" type="button">추가</button>
				</div>
				<input type="hidden" name="productNo" value="0">
			</form>
		</div>
	</div>
</body>
</html>