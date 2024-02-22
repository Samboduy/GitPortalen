<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-cont">
    <table>
        <tr>
            <th>Student Id</th>
            <th>Students</th>
            <th>Course</th>
        </tr>
        <c:forEach items="${applicationScope.userBean.studentCourses}" var="student">
            <tr>
                <td>${student.getStudentId()}</td>
                <td>${student.getStudentName()}</td>
                <td>${student.getCourseName()}</td>
            </tr>
        </c:forEach>
    </table>
</div>
