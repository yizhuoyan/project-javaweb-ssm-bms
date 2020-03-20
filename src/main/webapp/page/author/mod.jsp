<%@page pageEncoding="utf-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getContextPath()%>/">
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<title>查看/修改作者</title>
</head>
<body>
	<header>
		<ol class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li><a href="author/qry.do">作者管理</a></li>
			<li>查看/修改作者</li>
		</ol>
	</header>
	<p>
		<strong>${message}</strong>
	</p>
 	<form action="author/mod.do" method="post">
 		<input type="hidden"  name="id" value="${empty m.id?param.id:m.id}">
 		<p>
 			<label>*姓名:<input name="name" value="${empty m.name?param.name:m.name}"></label>
 		</p>
 		<p>
 			<label>年龄:<input name="age" type="number" value="${empty m.age?param.age:m.age}"></label>
 		</p>
 		<p>
 			
 			<fmt:formatDate var="birthDay" value="${empty m.birthDay?param.bithDay:m.birthDay}" pattern="yyyy-MM-dd"/>
 			
 			<label>出生日期:<input name="birthDay" type="date" value="${birthDay}"></label>
 		</p>
 		<p>
 			<fmt:formatDate var="deadDay" value="${empty m.deadDay?param.deadDay:m.deadDay}" pattern="yyyy-MM-dd"/>
 			<label>死亡日期:<input name="deadDay" type="date" value="${deadDay}"></label>
 		</p>
 		<p>
 			<label>简介:</label>
 			<textarea name="intro">${empty m.intro?param.intro:m.intro}</textarea>
 		</p>
 		
 		<p>
 			<button type="submit">确定</button>
 			<button type="reset">重置</button>
 			<a href="author/qry.do">返回</a>
 		</p>
 	
 	</form>

</body>
</html>