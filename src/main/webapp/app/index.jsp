<%-- This is INDEX PAGE --%>
<%@ page import="com.systechafrica.utils.Calculator" %>
<%!
       String appHeader  = "<h2>Tour Booking and Management System</h2>" ;

       int addSum(int v1, int v2) {
        return v1 + v2;
    }

    int justAnotherNo = new Calculator().addNumbers(300, 4000);
       
       
       
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nata Tours</title>
</head>
<body>
    <span><a href="home.jsp">Home JSP</a></span>

    <%= appHeader %>
    <h1><%=   application.getAttribute("homeAttribute") %></h1>
    <%

    int hundred = 100;
    int oneTousand = 1000;

    int sum = addSum(hundred, oneTousand); 
    out.println("The sum is : " + sum);
    %>

    <%= addSum(200, 4000) %>
    <%= justAnotherNo %>

    
</body>
</html>