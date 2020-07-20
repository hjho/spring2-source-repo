<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="fileAdd" enctype="multipart/form-data">
	<input type="hidden" name="cud" value="file"/>
	<input type="file" label="첨부파일" name="bs_file"/>
	<input type="submit" value="전송"/>
</form>
</body>
</html>