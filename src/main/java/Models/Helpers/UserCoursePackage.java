package Models.Helpers;

import Models.Database;
import Models.StudentsModule;
import Models.UsersBean;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserCoursePackage {

    public static ArrayList<UserCourseConstructor> courses = new ArrayList<>();
    public static void UserPageInformation(UsersBean usersBean, HttpServletRequest req){
        try {
            ResultSet rs = StudentsModule.studentCourseData(usersBean);
            courses.clear();
            while (rs.next()){
                String id = rs.getString("id");
                String courseName= rs.getString("course_name");
                String teacherName = rs.getString("teacher");
                UserCourseConstructor course = new UserCourseConstructor(id,courseName,teacherName);
                courses.add(course);
            }
            req.setAttribute("courses",courses);
        }catch (SQLException e){
            Database.PrintSQLException(e);
        }

    }
}
