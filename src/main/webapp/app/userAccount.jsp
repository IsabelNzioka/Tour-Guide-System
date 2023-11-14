<%@ page import="com.systechafrica.app.model.entity.UserRole" %>
<jsp:useBean id="contentBean" class="com.systechafrica.app.useBean.ContentBean" scope="request" />
<jsp:useBean id="activeMenuBean" class="com.systechafrica.app.useBean.ActiveMenuBean" scope="request" />
<jsp:useBean id="user" class="com.systechafrica.app.model.entity.User" scope="session" />


<!DOCTYPE html>
<html>
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/1211563ad5.js" crossorigin="anonymous"></script>

    <%@  include file="../style/appStyle.jsp" %>
    <%@  include file="../style/adminStyle.jsp" %>
</head>
<body>

<div class="Content">
    <div class="ContentLinks">
        <span>Nata Travels</span>

        <h3 class="WelcomeUser">Hi, <%= user.getUsername() %></h3>
        <jsp:setProperty name="activeMenuBean" property="activeMenu" value='<%= request.getAttribute("activeMenu") %>' />

        <% if (user.getRole() == UserRole.ADMIN ) { %>
            <a class="<%= (activeMenuBean.getActiveMenu() == 0) ? "active" : "" %>" href="./my-bookings">Bookings</a>
            <a href="./admin">Admin</a>
            <a href="./">Site</a>
            <a href="./logout">Logout</a>
        <% } else { %>
            <a class="<%= (activeMenuBean.getActiveMenu() == 0) ? "active" : "" %>" href="./my-bookings">Bookings</a>
            <a class="<%= (activeMenuBean.getActiveMenu() == 1) ? "active" : "" %>" href="./my-favourites">Favourites</a>
            <a class="<%= (activeMenuBean.getActiveMenu() == 2) ? "active" : "" %>" href="./help">Help</a>
            <a href="./">Site</a>
            <a href="./logout">Logout</a>
        <% } %>

        
    </div>
    <div class="ContentLinkContent">
        <jsp:setProperty name="contentBean" property="content" value='<%= request.getAttribute("content") %>' />
        <%= contentBean.getContent() %> 
    </div>
</div>

</body>
</html>
