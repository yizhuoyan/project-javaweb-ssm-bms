<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getContextPath()%>/">
<meta charset="UTF-8">
<title>修改密码</title>
</head>
<body>
	<p>
		<strong>${message}</strong>
	</p>
	<form action="modifyPassword.do" method="post">
		<p>
			<label>*旧密码:<input name="oldPassword"></label>
		</p>
		<p>
			<label>*新密码:<input name="newPassword"></label>
		</p>
		<p>
			<label>*新密码确认:<input name="newPasswordConfirm"></label>
		</p>
		<p>
			<button type="submit">确定</button>
			<a href="index.do">返回</a>
		</p>
	</form>
</body>
</html>