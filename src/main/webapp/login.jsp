<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<script>
	if(window.top!=window){
		window.top.location.href=location.href;		
	}
</script>
<base href="<%=request.getContextPath()%>/">
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<p>
		<strong>${message}</strong>
		<c:remove var="message" scope="session"/>
	</p>
	<form action="login.do" method="post">
		<p>
			<label>账户:<input name="account" value="admin"></label>
		</p>
		<p>
			<label>密码:<input name="password" value="admin"></label>
		</p>
		<p>
			<button type="submit">Login</button>
		</p>
	</form>
	
</body>
</html>