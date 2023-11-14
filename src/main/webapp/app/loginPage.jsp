<jsp:useBean id="navbar" class="com.systechafrica.app.view.navbar.Navbar" scope="request" />
<jsp:useBean id="user" class="com.systechafrica.app.model.entity.User" scope="session" />
<jsp:useBean id="activeMenuBean" class="com.systechafrica.app.useBean.ActiveMenuBean" scope="request" />

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


    <%@  include file="../style/appStyle.jsp" %>
    <%@  include file="../style/registerLoginStyle.jsp" %>

</head>
<body>
    <div class="NavbarContent">
        <span>Nata Travels</span>

        <jsp:setProperty name="activeMenuBean" property="activeMenu" value='<%= request.getAttribute("activeMenu") %>' />
        <%= navbar.menu(activeMenuBean.getActiveMenu(),  user )%> 

    </div>
    <div class="formContainerLogin">
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
