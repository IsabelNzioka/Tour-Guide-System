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
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/css/ion.rangeSlider.min.css"/>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/js/ion.rangeSlider.min.js"></script>

    <jsp:include page="../style/appStyle.jsp" />
    <jsp:include page="../style/userDetails.jsp" />

</head>
<body>
    <div class="NavbarContent" id="UserNavbar">
        <span>Nata Travels</span>

        <jsp:setProperty name="navbar" property="activeLink" value='${requestScope.activeMenu}'/>
        <jsp:setProperty name="navbar" property="userRole" value='${sessionScope.userRole}'/>
        <jsp:getProperty name="navbar" property="menu" />

    </div>
    <div class="TourPageMain"></div>
    <div class="TourPage">

     <div class="TourContentLinks">
           <a href="http://localhost:8080/Tours-system/tours?filter=popular">Popular</a>
           <a href="http://localhost:8080/Tours-system/tours?filter=latest">Latest</a>

        <%--    <a href="http://localhost:8080/Tours-system/api/v1/tours/most-popular">Popular</a>
              <a href="http://localhost:8080/Tours-system/api/v1/tours/latest">Latest</a>   --%>

           <div class="priceContainer">
               <label for="priceRange">Price Range:</label>
               <input type="text" id="priceRange" name="priceRange"/>
               <div id="selectedPrices"></div>
           </div>
       </div>
     <div class="ContentTours">
                <jsp:setProperty name="contentBean" property="content" value='<%= request.getAttribute("content") %>' />
                <jsp:getProperty name="contentBean" property="content" />
        </div>
    </div>

    <jsp:include page="../style/userScript.jsp" />
</body>
</html>
