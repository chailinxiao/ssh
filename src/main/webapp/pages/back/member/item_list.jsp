<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <base href="<%=basePath%>">
    <title>YF图书管理系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/basic.css" rel="stylesheet" />
    <link href="assets/css/custom.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<div id="wrapper">
    <jsp:include page="/pages/back/header.jsp"></jsp:include>
    <!-- 此处编写内容  -->
    <div id="page-wrapper">
    	<div>
    		<a href="<%=basePath%>user/add">用户录入</a>
    	</div>
        <div id="page-inner">
            <c:if test="${allItems != null}">
                <table class="table">
                    <tr>
                        <th>姓名</th>
                        <th>年龄</th>
                        <th>身份</th>
                        <c:if test="${role == 'admin' }">
                        	 <th>操作</th>
                        </c:if>
                       
                    </tr>
                    <c:forEach items="${allItems}" var="item">
                        <tr>
                            <td>${item.username}</td>
                            <td>${item.age}</td>
                            <td>
                            	<c:if test="${item.role == 'admin' }">
                            		管理员
                            	</c:if>
                            	<c:if test="${item.role == 'student' }">
                            		学生
                            	</c:if>
                            </td>
                            <c:if test="${role == 'admin' }">
                            <td>
                            	
                            	<a href="<%=basePath%>user/add?uid=${item.id}"><button type="button" class="btn btn-warning">编辑</button></a>
                            	<a href="<%=basePath%>user/del?uid=${item.id}"><button type="button" class="btn btn-danger">删除</button></a>
                            </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
</div>

<jsp:include page="/pages/back/footer.jsp"></jsp:include>
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/jquery.metisMenu.js"></script>
<script src="assets/js/custom.js"></script>

<script type="text/javascript" src="validate/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="validate/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="validate/js/jquery.metadata.js"></script>
<script type="text/javascript" src="validate/js/additional-methods.min.js"></script>
<script type="text/javascript" src="validate/js/Message_zh_CN.js"></script>
<script type="text/javascript" src="validate/member_insert.js"></script>
</body>
</html>
