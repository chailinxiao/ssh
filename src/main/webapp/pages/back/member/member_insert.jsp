<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gsy
  Date: 2018/2/6
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path +"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
        <div id="page-inner">
            <div class="col-md-12">
                <div class="col-md-6 col-md-offset-4">
                    <h1 class="h1">增加用户操作</h1>
                </div>
                <div class="col-md-12">
                    <hr>
                </div>
            </div>
            	<%--编写增加数据表单 --%>
	         <form action="<%=basePath%>user/create" method="post" class="form-horizontal" id="insertForm">
	         	<div class="form-group">
	         		<label for="phone" class="col-md-3 col-md-offset-4 control-label" style="color: red">${msg }</label>
	         		<input type="hidden" name="id" id="id" class="form-control" value="${user.id }">
	         	</div>
	         	<!--联系电话-->
	              <div class="form-group">
	                  <label for="phone" class="col-md-3 control-label">联系电话</label>
	                  <div class="col-md-6">
	                      <input type="text" name="mobile" id="phone" class="form-control" value="${user.mobile }">
	                  </div>
	              </div>
	              <%--性别--%>
	             <div class="form-group" style="display: ${user.id > 0 ? 'none' : 'block'}">
	                 <label for="password" class="col-md-3 control-label">初始密码</label>
	                 <div class="col-md-6">
	                      <input type="password" name="password" id="password" class="form-control input-sm">
	                  </div>
	              </div>
	             <%--性别--%>
	             <div class="form-group">
	                 <label for="name" class="col-md-3 control-label">姓名</label>
	                 <div class="col-md-6">
	                      <input type="text" name="username" id="name" class="form-control input-sm" value="${user.username }">
	                  </div>
	              </div>
	              <%--年龄--%>
	              <div class="form-group">
	                  <label for="age" class="col-md-3 control-label">年龄</label>
	                  <div class="col-md-6">
	                      <input type="text" name="age" id="age" class="form-control input-sm" value="${user.age }">
	                  </div>
	              </div>
	              <%--年龄--%>
	              <div class="form-group">
	                  <label for="role" class="col-md-3 control-label">身份</label>
	                  <div class="col-md-6">
	                       <select class="form-control" id="role" name="role" value="${user.role }">
						      <option value="student" ${user.role=='student'? 'selected':'' }>学生</option>
						      <option value="admin"  ${user.role=='admin'? 'selected':'' }>管理员</option>
						    </select>
	                  </div>
	              </div>
	              
	              <div class="form-group">
                        <div class="col-md-5 col-md-offset-3">
                            <button type="submit" class="btn btn-success c">提交</button>
                            <button type="reset" class="btn btn-success">重置</button>
                        </div>
                    </div>
               </form>
               
        </div>
    </div>
</div>


<jsp:include page="/pages/back/footer.jsp"></jsp:include>
<script src="assets/js/jquery-1.10.2.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script src="assets/js/jquery.metisMenu.js"></script>
<script src="assets/js/custom.js"></script>
<script type="text/javascript" src="validate/js/jquery-1.11.3.min.js" ></script>
<script type="text/javascript" src="validate/js/additional-methods.min.js" ></script>
<script type="text/javascript" src="validate/js/jquery.metadata.js" ></script>
<script type="text/javascript" src="validate/js/jquery.validate.min.js" ></script>
<script type="text/javascript" src="validate/js/Message_zh_CN.js"></script>
<script type="text/javascript" src="validate/member_insert.js"></script>
</body>
</html>
