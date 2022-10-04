<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Processing</title>
</head>
<body>
    <%
        request.setCharacterEncoding("UTF-8");
        Enumeration en=request.getParameterNames();
        
        Enumeration em=request.getParameterNames();
        while(em.hasMoreElements())
        {
            String name=(String)em.nextElement();
            String pValue=request.getParameter(name);
            out.println(name+" : "+pValue + "<br>");
        }
        
    %>
</body>
</html>
