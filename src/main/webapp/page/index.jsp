<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<style>
	html,body{
		margin: 0;
		height: 100%;
		font-size: 14px;
	}
	menu,ul,li,form,h1{
		margin: 0;
		padding: 0;
	}
	body>header{
		line-height: 100px;
		background: background;
		color: white;
	}
	body>section{
		position: absolute;
		top:100px;
		bottom: 80px;
		width: 100%;
	}
	menu{
		position:absolute;
		top:0;
		width: 200px;
		height: 100%;
		background: #99ff99;
		border-right: 1px solid black;
		box-sizing: border-box;
		text-align: center;
	}
	ul.menu{
		
	}
	ul.menu>li{
		border-bottom: 1px solid #999;
		
	}
	.menu a{
		display: inline-block;
		width: 100%;
		padding: 10px 0;
		text-decoration: none;
	}
	.menu a:HOVER{
		background: #999;
	}
	main{
		display: block;
		height: 100%;
		margin-left: 200px;
	}
	main>iframe{
		width: 100%;
		height:100%;
		border: none; 
	}
	body>footer{
		position: absolute;
		bottom: 0px;
		width: 100%;
		line-height: 80px;
		text-align: center;
		background: black;
		color: white;
	}
	body>header>h1{
		float: left;
	}
	.welcome{
		display: inline;
	}
</style>
</head>
<body>
	<header>
		<h1>图书管理系统</h1>
		<p class="welcome">
			欢迎您，${sessionScope.currentUser.name}
			<span>
			<a href="page/center/modify-password.jsp">修改密码</a>
			<a href="">退出登录</a>
			</span>
		</p>
	</header>
	<section>
		<menu>
			<ul class="menu">
				<li><a href="author/qry.do" target="mainFrame">作者管理</a></li>
			</ul>
		</menu>
		<main>
			<iframe name="mainFrame"></iframe>
		</main>
	</section>
	<footer>
		xxx图书管理系统 版权所有
	</footer>
</body>
</html>