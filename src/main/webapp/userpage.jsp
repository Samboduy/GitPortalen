
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="Fragments/header.jsp" %>
<body>
<div class="container">
    <c:if test="${applicationScope.userBean.privilegeType == ('user')}">
        <%@ include file="Fragments/nav.jsp" %>
    </c:if>

    <c:if test="${applicationScope.userBean.privilegeType == 'admin'}">
        <%@ include file="Fragments/adminNav.jsp" %>
    </c:if>
    <div class="text">
        <h1>Your Courses</h1>
    </div>
    <%@ include file="Fragments/courseTable.jsp" %>
        <div class="form-cont">
            <form action="${pageContext.request.contextPath}/userpage" method="POST">
               <%--@declare id="selectcourse"--%><label for="selectCourse">Select Course Id:</label><br>
                <select name="courseId" id="courseId"><br>
                    <c:forEach items="${courses}" var="course">
                    <option value="${course.getId()}" >${course.getId()}</option>
                    </c:forEach>
                </select><br>
                <input type="submit" name="showstudents" value="show students">
            </form>
        </div>
</div>

</body>
</html>
