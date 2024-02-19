<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table-cont">
    <table>
        <tr>
            <th>Id</th>
            <th>Courses</th>
            <th>teachers</th>

        </tr>

            <c:forEach items="${courses}" var="course">
                <tr>
                        <td>${course.getId()}</td>
                        <td>${course.getCourseName()}</td>
                        <td>${course.getTeacherName()}</td>
                </tr>
            </c:forEach>

    </table>
</div>
