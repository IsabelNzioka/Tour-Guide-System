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
    <div class="formContainerLogin">

    <h1>${requestScope.activeMenu}</h1>
    <h1>'${requestScope.activeMenu}'</h1>
    <h2> h1${requestScope.activeMenu} </h2>



        <form action="./account-login" method="post">
            <div class="container">
                <label for="username"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required>
                <label for="password"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" required>
                <button type="submit" class="ButtonSubmit">Login</button>
            </div>
            <div class="container">
                <span class="psw">Have you forgotten your <a href="#">password?</a></span>
                <p>Don't have an Account yet ?</p>
                <a href="./account-register">Create account</a>
            </div>
        </form>
    </div>
</body>
</html>
