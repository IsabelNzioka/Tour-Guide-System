<%@ page isELIgnored="false" %>

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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
     <jsp:include page="../style/appStyle.jsp" />
     <jsp:include page="../style/adminStyle.jsp" />

</head>
<body>

<div class="Content">
    <div class="ContentLinks">
        <span>Nata Travels</span>

    <jsp:setProperty name="activeMenuBean" property="activeMenu" value='<%= request.getAttribute("activeMenu") %>' />

     
     <%-- <a class="${ (activeMenuBean.getActiveMenu() == 0) ? "active" : "" }" href="./add-tour">Add Tour</a> --%>
    
     <a class="${ (activeMenuBean.getActiveMenu() == 1) ? "active" : "" }" href="./admin-tours">Tours</a>
     <a class="${ (activeMenuBean.getActiveMenu() == 2) ? "active" : "" }" href="./admin-users">Users</a>
     <a class="${ (activeMenuBean.getActiveMenu() == 3) ? "active" : "" }" href="./admin-bookings">Bookings</a>
     <a href="./">Site</a> 
      <a href="./logout">Logout</a>

    </div>
    <div class="ContentLinkContent">

       ${requestScope.statContent}

    <jsp:setProperty name="contentBean" property="content" value='<%= request.getAttribute("content") %>' />
    <jsp:getProperty name="contentBean" property="content" />
    </div>
</div>

<jsp:include page="../style/adminScript.jsp" />
</body>
</html>
