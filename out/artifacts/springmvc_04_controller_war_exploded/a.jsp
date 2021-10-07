<%--
  Created by IntelliJ IDEA.
  User: duanyihan
  Date: 10/5/21
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--这里如果不加pagecontext 会访问localhost下的add2/1/3-->
<form action=${pageContext.request.contextPath}/add2/1/3 method="post">
    <input type="submit">
</form>

</body>
</html>
