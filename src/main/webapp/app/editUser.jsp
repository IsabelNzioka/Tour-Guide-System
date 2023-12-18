<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.systechafrica.app.model.entity.UserRole" %>


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
    <c:set var="user" value="${  sessionScope.user}" />
    <div class="formContainerLogin">

        <form action="./admin-update-user" method="post">
            <div class="container">
              <%--  <input type="hidden" name="id" value="${user.username}"> --%>
                <label for="username"><b>Username</b></label>
                <input type="text" placeholder="Edit Username" name="username" value="${user.username}" required>

                <label for="email"><b>Email</b></label>
                <input type="text" placeholder="Edit Email" name="email" value="${user.email}" required>

                <label for="role"><b>User Role</b></label>
                   <select name="role" required>
                      <c:forEach var="role" items="${UserRole.values()}">
                          <option value="${role}" ${role == user.role ? 'selected' : ''}>${role}</option>
                      </c:forEach>
                    </select>

                <button type="submit" class="ButtonSubmit">Update</button>
            </div>
        </form>
    </div>
</body>
</html>
