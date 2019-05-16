<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addCategory</title>
<script src="https://code.jquery.com/jquery-3.4.1.js">
</script>
<script>
$(document).ready(function(){
	$('#addbtn').click(function(){
		console.log("addbtn click...");
		$('#addCategoryForm').submit();
	});
});
</script>

</head>
<body>
	<form id="addCategoryForm" action="${pageContext.request.contextPath}/category/addCategory" method="post">
		<div>
			이름 : 
		</div>
		<div>
			<input type="text" name="categoryName">
		</div>
		<div>
			<button id="addbtn" type="button">추가</button>
		</div>
		<input type="hidden" name="categoryNo" value="0">
	</form>
</body>
</html>