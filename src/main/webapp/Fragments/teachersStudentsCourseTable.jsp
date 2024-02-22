<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-cont">
    <table>
        <tr>
            <th>Course Id</th>
            <th>Course</th>
            <th>Student Id</th>
            <th>Student</th>
            <th>Teacher Id</th>
            <th>Teacher</th>
        </tr>
        <c:forEach items="${applicationScope.userBean.teachersStudentsCourses}" var="course">
            <tr>
                <td>${course.getCourseId()}</td>
                <td>${course.getCourseName()}</td>
                <td>${course.getStudentId()}</td>
                <td>${course.getStudentName()}</td>
                <td>${course.getTeacherId()}</td>
                <td>${course.getTeacherName()}</td>
            </tr>
        </c:forEach>
    </table>
</div>
