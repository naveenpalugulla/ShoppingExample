<%@ page import="java.util.*" %>
<%@page contentType="text/html" language="java" %>

<%@page errorPage="e.html" %>
<%@include file="Welcome.html" %>

<!DOCTYPE html >
<html>
<head>

<title>Insert title here</title>
</head>
<body>
WELCOME
<br>
<%
out.println(10/1);
out.println(x);
out.println("<br>");
Date d=new Date();
out.println(d);
out.println("<br>");
int a=10,b=40;
out.println(add(a,b));

%>
<br>
<%=add(30,30) %>
<br>
<%=add(30,30,30) %>
<br>
<%=a %>
<br>
<%=b %>
<br>
<%=d %>
<br>
<%=a+b %>


<% int hour=d.getHours();

if(hour<12)
{
	out.println("Good Morning");
}
else 
	if(hour<14)
	{
		out.println("Good Afternoon");
	}
	else
	{
		out.println("Good Evening");
	}
%>

</body>
</html>
<%!
int x;

int add(int a,int b)
{
	return a+b;
}

%>
<%!

int add(int a,int b,int c)
{
	return a+b+c;
}

%>