<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="form-cont">
    <form action="/login" method="POST">
        <%--@declare id="teachstud"--%><label for="teachStud">Teacher or Student:</label><br>
        <select name="teach_stud" id="teach_stud"><br>
            <option value="Teacher">teacher</option>
            <option value="Student">student</option>
        </select><br>
        <label for="username">Username:</label><br>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Password:</label><br>
        <input type="text" id="password" name="password" required><br>
        <input type="submit" value="login">
    </form>
</div>