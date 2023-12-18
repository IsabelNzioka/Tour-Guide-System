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
    <jsp:include page="../style/userDetails.jsp" />

</head>
<body>
    <div  class="NavbarContent">
        <span>Nata Travels</span>

        <jsp:setProperty name="navbar" property="activeLink" value='${requestScope.activeMenu}'/>
        <jsp:setProperty name="navbar" property="userRole" value='${sessionScope.userRole}'/>
        <jsp:getProperty name="navbar" property="menu" />

    </div>

    <div class="TourDetailsImage">
           <div class="ImageOne"> One</div>
           <div class="ImageTwo">Two </div>
           <div class="ImageThree">Three </div>
    </div>

    <%-- <div class="Content">
    <jsp:setProperty name="contentBean" property="content" value='<%= request.getAttribute("content") %>' />
    <jsp:getProperty name="contentBean" property="content" />
    </div>  --%>

    <div class="TourPrevDetails">
        <div class="Top">
             <h1> ${requestScope.tourDetails.getName()}</h1>
             <h1>$ ${requestScope.tourDetails.getPrice() }</h1>
        </div>
         <div class="Bottom">
           <div> <h1>9 / 10</h1> <p> 33 reviews </p> </div>
           <p>free cancellations</p>
         </div>
    </div>

    <div class="TourMore">
     <div class="TourMoreDetails">
            <h1>Overview</h1>
            <p>Walk down the world-famous Wall Street and take in some major landmarks along the way such as the New York Stock Exchange and The Federal Reserve on this self-guided GPS audio tour. You'll get a concise but comprehensive history lesson that discusses the Dutch immigrants who settled the area, the takeover that claimed the land for England, and the eventual British surrender to a new, United States of America. For more recent history, you'll visit the Charging Bull statue and Zuccotti Park, where the Occupy Wall Street movement took place </p>
            <p>
            The sights you’ll see and experience along the way include modern art, historical monuments, and the unmistakable vibe of New York City. So slide your phone in your pocket and take the tour at your leisure. The tour is ready whenever you are and the audio plays automatically at exactly the right time and place using your smartphone's GPS and the VoiceMap mobile app, which also works offline.
            </p>
        </div>

<jsp:setProperty name="contentBean" property="content" value='<%= request.getAttribute("content") %>' />

<%--
      <div class="BookNowDetails">
            <h1>$ ${requestScope.tourDetails.getPrice() }</h1>
            <p>Price details</p>
             <jsp:setProperty name="contentBean" property="content" value='<%= request.getAttribute("content") %>' />
             <jsp:getProperty name="contentBean" property="content" />

      </div>

      --%>

    <%

        String content = (String) request.getAttribute("content");
    %>
<div class="BookNowDetails">

    <form action="./tour-booking" method="post">
          <p>Total Price: <span id="totalPrice">$${requestScope.tourDetails.getPrice()}</span></p>
           <label for="numberOfPeople">Number of People:</label>
           <input type="number" name="noOfPeople" id="numberOfPeople" oninput="calculateTotalPrice()">
           <button type="submit">Book Now</button>
    </form>

</div>
    </div>







<script>
    function calculateTotalPrice() {
        var price = ${requestScope.tourDetails.getPrice()};
        var numberOfPeople = Number(document.getElementById("numberOfPeople").value);
        var totalPrice = price * numberOfPeople;

        document.getElementById("totalPrice").textContent = totalPrice.toFixed(2);
    }
</script>
    <jsp:include page="../style/userScript.jsp" />
</body>
</html>
