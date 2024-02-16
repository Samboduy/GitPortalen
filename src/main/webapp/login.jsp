<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/CSS/style.css">
</head>
<body>
    <div class="container">
        <c:if test="${applicationScope.userBean.privType == 'user'}">
        <%@ include file="Fragments/nav.jsp" %>
        </c:if>
        <c:if test="${applicationScope.userBean.privType == 'admin'}">
                <%@ include file="Fragments/nav.jsp" %>
                </c:if>
        <div class="text">
            <h1>Login</h1>
        </div>

        <div class="form-cont">
            <form action="/login" method="POST">
                <label for="teacher">Choose teacher or student:</label><br>
                  <select name="teach_stud" id="teach_stud"><br>
                    <option value="Teacher">teacher</option>
                    <option value="Student">student</option>
                   </select><br>
                <label for="username">Username:</label><br>
                <input type="text" id="username" name="username" required><br>
                <label for="password">Password:</label><br>
                <input type="text" id="password" name="password" required><br>
                <input type="submit" value="Add">
            </form>
        </div>
    </div>
</body>
</html>