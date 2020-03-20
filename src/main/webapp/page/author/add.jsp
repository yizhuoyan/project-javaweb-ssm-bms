<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getContextPath()%>/">
<meta charset="UTF-8">
<title>新增作者</title>
</head>
<body>
	<p>
		<strong>${message}</strong>
	</p>
 	<form action="author/add.do" method="post">
 		<p>
 			<label>*姓名:<input name="name" value="${param.name}"></label>
 		</p>
 		<p>
 			<label>年龄:<input name="age" type="number" value="${param.age}"></label>
 		</p>
 		<p>
 			<label>出生日期:<input name="birthDay" type="date" value="${param.birthDay}"></label>
 		</p>
 		<p>
 			<label>死亡日期:<input name="deadDay" type="date" value="${param.deadDay}"></label>
 		</p>
 		<p>
 			<label>简介:</label>
 			<textarea name="intro">${param.intro}</textarea>
 		</p>
 		
 		<p>
 			<button type="submit">确定</button>
 			<button type="reset">重置</button>
 			<a href="author/qry.do">返回</a>
 		</p>
 	
 	</form>

</body>
</html>