<%@ page import="jdk.internal.org.objectweb.asm.tree.IntInsnNode" %>
<%@page language="java" contentType="text/html; charset=utf-8"  %>
<html>
<body>
<h2>distribute shacha!</h2>
<%!
    int count = 1;
    int initCount = 1;
    int destroyCount = 1;
%>

<%!
    public void jspInit(){
        initCount++;
        System.out.println("初始化:"+initCount);
    }

    public void jspDestroy(){
        destroyCount++;
        System.out.println("销毁次数:"+destroyCount);
    }
%>

<%=count++%>
<br>

<%@include file="sub.jsp"%>

<jsp:forward page="sub.jsp"></jsp:forward>

</body>
</html>
