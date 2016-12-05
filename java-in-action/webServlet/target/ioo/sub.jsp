<%--
  Created by IntelliJ IDEA.
  User: zuston
  Date: 16-11-10
  Time: 下午1:54
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=utf-8"  import="java.util.*,java.io.*,java.net.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--el表达式--%>
<%@ page isELIgnored ="false" %>
<p>
    <%=(new Date().toLocaleString())%>

</p>
<br>
<%=config.getServletName()%>
<br>
<%=request.getRequestURL()%>
<br>

<%
    Cookie[] cookieArr = request.getCookies();
    for(Cookie cook:cookieArr){
        if(cook.getName().equals("name")){
            cook.setMaxAge(0);
            response.addCookie(cook);
        }
        out.println("参数:"+URLDecoder.decode(cook.getName()));
        out.println("值:"+URLDecoder.decode(cook.getValue()));
    }
    Cookie cookie = new Cookie("name","zjf");
    cookie.setMaxAge(60*60*24);
    response.addCookie(cookie);



%>


<%
    if(session.isNew()){
        int visitCount = 1;
        out.println("新访问用户,次数为:"+visitCount);
        session.setAttribute("count",visitCount);
    }else{
        int visitCount = Integer.parseInt(String.valueOf(session.getAttribute("count")));
        out.println("老用户,次数为:"+visitCount++);
        session.setAttribute("count",visitCount);
    }
%>

<br>

<%
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    out.print(sdf.format(date));
%>

<br>

<jsp:text>
    Box Perimeter is: ${2*23 + 2*12}
</jsp:text>


