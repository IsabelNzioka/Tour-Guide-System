<%@ page isELIgnored="false" %>

<jsp:useBean id="navbar" class="com.systechafrica.app.view.navbar.Navbar" scope="request" />


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/1211563ad5.js" crossorigin="anonymous"></script>

    <jsp:include page="../style/appStyle.jsp" />
    <jsp:include page="../style/registerLoginStyle.jsp" />
    

</head>
<body>
    <div class="NavbarContent">
        <span>Nata Travels</span>

        <jsp:setProperty name="navbar" property="activeLink" value='${requestScope.activeMenu}'/>
        <jsp:setProperty name="navbar" property="userRole" value='${sessionScope.userRole}'/>
        <jsp:getProperty name="navbar" property="menu" />

    </div>
    <div class="formContainerRegister">
        <form action="./account-register" method="post">
            <div class="container">
                <label for="username"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required>
                <label for="password"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" required>
                <label for="confirmPassword"><b>Confirm Password</b></label>
                <input type="password" placeholder="Confirm Password" name="confirmPassword" required>
                 <label for="phonenumber"><b>Phone Number</b></label>
                 <input type="number" placeholder="Enter Phone Number" name="phonenumber" required>
                <label for="email"><b>Email</b></label>
                <input type="email" placeholder="Enter Email" name="email" required>
                <button type="submit" class="ButtonSubmit">Register</button>
            </div>
            <div class="container">
                <span class="psw">Forgot <a href="#">password?</a></span>
                <p>Already have an account?</p>
                <a href="./account-login">Log in</a>
            </div>
        </form>
    </div>
</body>
</html>
