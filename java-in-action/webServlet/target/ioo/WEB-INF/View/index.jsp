<%--
  Created by IntelliJ IDEA.
  User: zuston
  Date: 16/11/12
  Time: 下午1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>zuston</title>
</head>
<body>
<h1><%=request.getAttribute("name")%></h1>
<h1><%=request.getAttribute("pwd")%></h1>
<h1>${pwd}</h1>
<h2><%=application.getAttribute("age")%></h2>
<h3><%=session.getAttribute("school")%></h3>
</body>
</html>
