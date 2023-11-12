
<%-- <%@ page import="com.systechafrica.app.view.navbar.Navbar" %> --%>
<%-- <%@ page import="com.systechafrica.app.model.entity.User" %> --%>
<%@ page import="com.systechafrica.app.view.css.AppCss" %>

<jsp:useBean id="navbar" class="com.systechafrica.app.view.navbar.Navbar" scope="request" />
<jsp:useBean id="user" class="com.systechafrica.app.model.entity.User" scope="session" />
<jsp:useBean id="contentBean" class="com.systechafrica.app.useBean.ContentBean" scope="request" />

<jsp:useBean id="activeMenuBean" class="com.systechafrica.app.useBean.ActiveMenuBean" scope="request" />



<!DOCTYPE html>
<html>
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/1211563ad5.js" crossorigin="anonymous"></script>

    <%@  include file="./style/appStyle.jsp" %>

</head>
<body>
    <div class="NavbarContent">
        <span>Nata Travels</span>

        <jsp:setProperty name="activeMenuBean" property="activeMenu" value='<%= request.getAttribute("activeMenu") %>' />
        <%= navbar.menu(activeMenuBean.getActiveMenu(),  user )%> 
      
    </div>
    <div class="Content">

    <jsp:setProperty name="contentBean" property="content" value='<%= request.getAttribute("content") %>' />
       <%= contentBean.getContent() %>     
    </div>
</body>
</html>