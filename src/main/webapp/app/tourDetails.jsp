<%@ page isELIgnored="false" %>

<jsp:useBean id="navbar" class="com.systechafrica.app.view.navbar.Navbar" scope="request" />
<jsp:useBean id="contentBean" class="com.systechafrica.app.useBean.ContentBean" scope="request" />




<!DOCTYPE html>
<html>
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/1211563ad5.js" crossorigin="anonymous"></script>

    <jsp:include page="../style/appStyle.jsp" />

</head>
<body>
    <div class="NavbarContent">
        <span>Nata Travels</span>

        <jsp:setProperty name="navbar" property="activeLink" value='${requestScope.activeMenu}'/>
        <jsp:setProperty name="navbar" property="userRole" value='${sessionScope.userRole}'/>
        <jsp:getProperty name="navbar" property="menu" />

    </div>
    <div class="Content">


    <jsp:setProperty name="contentBean" property="content" value='<%= request.getAttribute("content") %>' />
    <jsp:getProperty name="contentBean" property="content" />
    </div>

      <h1>${requestScope.tourDetails.getPrice() }, ${requestScope.tourDetails.getId()}</h1>
       <button class='BookNow' onclick='viewMore("${requestScope.tourDetails.getId()}", "tour-booking")'>
           View More
       </button>



    <jsp:include page="../style/userScript.jsp" />
</body>
</html>