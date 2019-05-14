<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://" +request.getServerName()+":"+request.getServerPort() + path + "/";
%>
<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
            <span class="sr-only">图书管理系统</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <span class="navbar-brand" >图书管理系统</span>
    </div>
    <!--顶部-->
    <div class="header-right">
    	<span>${name }</span>
    	<c:if test="${role == 'admin' }">
    		[ 管理员 ]
    	</c:if>
    	<c:if test="${role == 'student' }">
    		[ 学生 ]
   		</c:if>
        <a href="<%=basePath%>logout2" class="btn btn-danger" title="Logout"> 退出系统</a>
    </div>
</nav>
<!-- 导航 -->
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
        	<li>
                <a href="<%=basePath%>user/userlist"><i class="fa fa-toggle-on"></i>用户管理</a>
            </li>
            <li>
                <a href="<%=basePath%>user/booklist"><i class="fa fa-toggle-on"></i>图书管理</a>
            </li>
            <li>
                <a href="<%=basePath%>order/orderlist"><i class="fa fa-toggle-on"></i>消费流水</a>
            </li>
        </ul>
    </div>
</nav>
