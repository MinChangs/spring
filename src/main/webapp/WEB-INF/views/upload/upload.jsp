<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	upload.jsp
<form action="${cp}/file/upload" enctype="multipart/form-data" method="post">
	<input type="file" name="img"/>
	<input type="submit" name="전송"/>
</form>
</body>
</html>