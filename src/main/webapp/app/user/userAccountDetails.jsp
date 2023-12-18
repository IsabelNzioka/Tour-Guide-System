<%@ page isELIgnored="false" %>
<%@ page import="com.systechafrica.app.model.entity.UserRole" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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



     <jsp:include page="../../style/appStyle.jsp" />
     <jsp:include page="../../style/adminStyle.jsp" />
     <jsp:include page="../../style/userDetails.jsp" />

</head>
<body>

<div class="Content">
    <div class="ContentLinks">
        <span>Nata Travels</span>

        <h3 class="WelcomeUser">Hi, ${sessionScope.userName}</h3>
            <jsp:setProperty name="activeMenuBean" property="activeMenu" value='<%= request.getAttribute("activeMenu") %>' />

                <c:choose>
                <c:when test="${  sessionScope.userRole eq UserRole.ADMIN }">
                    <a class="${  (activeMenuBean.getActiveMenu() == 0) ? "active" : "" }" href="./my-bookings">Bookings</a>
                    <a href="./admin">Admin</a>
                    <a href="./">Site</a>
                    <a href="./logout">Logout</a>
                </c:when>
                <c:otherwise>
                    <a class="${  (activeMenuBean.getActiveMenu() == 0) ? "active" : "" }" href="./my-bookings">Bookings</a>
                    <a class="${  (activeMenuBean.getActiveMenu() == 1) ? "active" : "" }" href="./my-favourites">Favourites</a>
                    <a class="${  (activeMenuBean.getActiveMenu() == 2) ? "active" : "" }" href="./help">Help</a>
                    <a href="./">Site</a>
                    <a href="./logout">Logout</a>
                </c:otherwise>
                </c:choose>

    </div>
    <div class="ContentLinkContent">
    <c:set var="user" value="${  sessionScope.user}" />

    <div class="UserCardDetails">
          <div class="personalDetails">
              <h1>Personal Details </h1>
               <p>${user.username}</p>
               <p>${user.phonenumber}</p>
               <p>${user.email}</p>

               <h2></h2>
          </div>
          <div class="personalDetails">
                     <h1>Edit Details</h1>
                     <form action="./user-account" method="post">

                       <label for="username"><b>Username</b></label>
                       <input type="text" placeholder="Edit Username" name="username" value="${user.username}" required>

                       <label for="phonenumber"><b>Phone Number</b></label>
                       <input type="number" placeholder="Enter Phone Number" name="phonenumber" value="${user.phonenumber}" required>

                       <label for="email"><b>Email</b></label>
                       <input type="text" placeholder="Edit Email" name="email" value="${user.email}" required>
                       <button type="submit" class="ButtonSubmit">Update</button>

                     </form>


                    </div>
    </div>
            <jsp:setProperty name="contentBean" property="content" value='<%= request.getAttribute("content") %>' />
            <jsp:getProperty name="contentBean" property="content" />
     </div>

</div>

</body>
</html>
