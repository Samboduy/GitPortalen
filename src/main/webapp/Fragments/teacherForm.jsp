<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="form-cont">
    <form action="${pageContext.request.contextPath}/userpage" method="POST">
        <%--@declare id="selectstudent"--%><%--@declare id="selectcourse"--%>
            <input type="submit" name="allstudents" value="Show All Students">
            <input type="submit" name="allcourses" value="Show All Courses"><br>
            <label for="selectStudent">Select student Id:</label><br>
            <select name="studentIDs" id="studentIDs"><br>
                <c:forEach items="${applicationScope.userBean.allStudents}" var="studentId">
                    <option value="${studentId.getStudentId()}" >${studentId.getStudentId()}</option>
                </c:forEach>
            </select><br>
            <input type="submit" name="showStudentCourses" value="Show All Courses For a Student"><br>
            <label for="selectCourse">Select course Id:</label><br>
            <select name="courseId" id="courseId"><br>
                <c:forEach items="${applicationScope.userBean.allCourses}" var="courseId">
                    <option value="${courseId.getId()}" >${courseId.getId()}</option>
                </c:forEach>
            </select><br>
            <input type="submit" name="showStudentTeacherCourse" value="Show All Students and Teachers for a Course"><br>
    </form>
</div>
