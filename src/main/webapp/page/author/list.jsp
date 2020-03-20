<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getContextPath()%>/">
<meta charset="UTF-8">
<title>查询</title>
<link rel="stylesheet" href="css/common.css">
<style>
table.data{
	border:1px solid black;
	border-collapse: collapse;
	width: 100%;
	text-align: center;
}
table.data td,table.data th{
	border:1px solid black;
}

table.data>tbody>tr:NTH-CHILD(odd) {
	background: #f3f3f3;	
}
.pagination{
	text-align: center;
	padding: 10px;
}
body>header>menu{
	padding: 5px;
}
.qryForm{
	padding: 1em;
	text-align: center;
}
</style>
</head>
<body>
	<c:set var="result" value="${requestScope.result}"></c:set>
	<header>
		<ol class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li>作者管理</li>
		</ol>
		<menu>
			<a href="author/add.do">新增</a>
			<a href="javascript:doDelete()">删除</a>
		</menu>
		
		<form id="qryform" action="author/qry.do" class="qryForm">
			<input name="key" value="${param.key}"><button>Go!</button>
			<input type="hidden" name="pageNo" value="1">
		</form>
	</header>
	
	<section>
        <form id="delform" action="/author/del.do" method="post" enctype="application/x-www-form-urlencoded">
		<table class="data">
			<thead>
				<tr>
					<th width="50px"><input id="toggleSelected" type="checkbox" title="全选/全不选">序号</th>
					<th width="100px">操作</th>
					<th>名字</th>
					<th>年龄</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${result.found}" var="hasResult">
					<c:forEach var="a" items="${result.rows}" varStatus="vs">
						<tr>
						<td>${vs.count}<input name="id" value="${a.id}" type="checkbox"></td>
						<td>
							<a href="author/check.do?id=${a.id}.do">查看/修改</a>
						</td>
						<td>${a.name}</td>
						<td>${a.age}</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${!hasResult}">
					<tr>
						<td>
							<img alt="not found" src="img/404.jpg">
						</td>
					</tr>	
				</c:if>
			</tbody>
		</table>
        </form>
		<c:if test="${hasResult}">
		<section class="pagination">
			<span>
				共${result.totalRows}条记录
				每页${result.pageSize}条
				共${result.totalPages}页
			</span>
			<span>
				<c:if var="firstPage" test="${result.pageNo==1}">
					<a>首页</a>
					<a>上一页</a>
				</c:if>
				<c:if test="${!firstPage}">
					<a href="javascript:goPage(1)">首页</a>
					<a href="javascript:goPage(${result.pageNo-1})">上一页</a>
				</c:if>
				
				<c:if var="lastPage" test="${result.pageNo==result.totalPages}">
					<a>下一页</a>
					<a>末页</a>
				</c:if>
				<c:if test="${!lastPage}">
					<a href="javascript:goPage(${result.pageNo+1})">下一页</a>
					<a href="javascript:goPage(${result.totalPages})">末页</a>
				</c:if>
			</span>
		</section>
		</c:if>
	</section>

	<script src="js/jquery-3.2.1.js"></script>
	<script>
		/**
		*页面跳转处理
		*@param no {number} 页面
		**/
		var goPage=function(no){
			var form=document.querySelector("#qryform");
			form.pageNo.value=String(no);
			form.submit();
		}
        /**
         * 全选/全不选
         */
        $("#toggleSelected").click(function () {
            var toggle=this;
            $("input[name=id]").each(function () {
                this.checked=toggle.checked;
            });
        });

        var doDelete=function () {
            //判断是否有选中记录
            var noselected=$("input[name=id]").filter(":checked").length===0;
            if(noselected){
                alert("请选择相关记录");
                return;
            }
            //确认?
            if(!window.confirm("确认删除?")){
                return;
            }

            $("#delform").submit();
        }
        //ajax方式删除
        var doDelete=function () {
            //1判断是否有选中记录
            var checkboxArray=document.getElementsByName("id");
            var selectedRows=[];
            for(var i=checkboxArray.length;i-->0;){
                if(checkboxArray[i].checked){
                    selectedRows.push(checkboxArray[i].value);
                }
            }
            if(selectedRows.length===0){
                alert("请选择相关记录");
                return;
            }
            //确认?
            if(!window.confirm("确认删除?")){
                return;
            }
            //发出ajax request
            var url="author/del.do";
            var data={"id":selectedRows};
            //["1111","22223"] ===>id=1111&id=22223
            var param="";
            for(var i=selectedRows.length;i-->0;){
                param+="id=";
                param+=selectedRows[i];
                param+="&";
            }
            data=param.substring(0,param.length-1);

            $.post(url,data,function(resp){
                    if(resp.code==="ok"){
                        alert(resp.message);
                        //重新查询一次
                        $("#qryform").submit();

                    }else{
                        alert(resp.message);
                    }
            },"json");


        }
	</script>
</body>
</html>