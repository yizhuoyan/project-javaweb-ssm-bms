<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<%
String ctx=request.getContextPath();
pageContext.setAttribute("ctx", ctx);
%>
<base href="${ctx}/">
<meta charset="UTF-8">
<title>提示</title>
<meta http-equiv="refresh" content="3;url=${ctx}/${requestScope.url}">

</head>
<body>
	<p>
	${requestScope.message}
	</p>
	<p>
		3s后自动跳转，如果没有跳转，请点击<a href="${ctx}/${requestScope.url}">立即跳转</a>
	</p>
	
</body>
</html>