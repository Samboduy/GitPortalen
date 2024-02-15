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
        <div class="nav-cont">
            <nav>
                <a href="http://localhost:23310/login">Login</a>
            </nav>
        </div>
        <div class="text">
            <h1>Login</h1>
        </div>

        <div class="form-cont">
            <form action="/login" method="POST">
                <input type="radio" id="Student" name="stud_teach" value="Student">
                <label for="student">Student</label><br>
                <input type="radio" id="teacher" name="stud_teach" value="Teacher">
                <label for="teacher">teacher</label><br>
                <label for="email">Email:</label><br>
                <input type="text" id="email" name="email" required><br>
                <label for="password">Password:</label><br>
                <input type="text" id="password" name="password" required><br>
                <input type="submit" value="Add">
            </form>
        </div>
    </div>
</body>
</html>