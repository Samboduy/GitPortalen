package Models.Helpers;

import Models.CoursesModule;
import Models.Database;
import Models.StudentsModule;
import Models.UsersBean;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserCoursePackage {

    public static ArrayList<UserCourseConstructor> courses = new ArrayList<>();
    public static ArrayList<TeacherStudentsConstructor> teacherStudents = new ArrayList<>();
    public static ArrayList<String> coursesID = new ArrayList<>();
    public static ArrayList<String> studentsID = new ArrayList<>();
    public static void UserPageInformation(UsersBean usersBean, HttpServletRequest req,String studentId){
        try {
            ResultSet rs = StudentsModule.studentCourseData(studentId);
            teacherStudents.clear();
            while (rs.next()){
                String id = rs.getString("id");
                String courseName= rs.getString("course_name");
                String teacherName = rs.getString("teacher");
                String YHP = rs.getString("YHP");
                String description = rs.getString("description");
                TeacherStudentsConstructor teacherCourse = new TeacherStudentsConstructor(id,courseName,teacherName,YHP,description);
                teacherStudents.add(teacherCourse);
            }
            usersBean.setTeachersStudentsCourses(teacherStudents);
            req.setAttribute("courses",courses);
        }catch (SQLException e){
            Database.PrintSQLException(e);
        }
    }

    public static void allCoursesPacker(UsersBean usersBean){
        try {
            ResultSet rs = CoursesModule.courses();
            courses.clear();
            while (rs.next()){
                String id = rs.getString("id");
                String courseName= rs.getString("course_name");
                String YHP = rs.getString("YHP");
                String description = rs.getString("description");
                UserCourseConstructor course = new UserCourseConstructor(id,courseName,YHP,description);
                courses.add(course);
            }
            usersBean.setAllCourses(courses);
        }catch (SQLException e){
            Database.PrintSQLException(e);
        }
    }

    public static void teachersStudentsCoursePacker(UsersBean usersBean,String courseId){
        try {
            ResultSet rs = CoursesModule.findTeachersStudentsCourse(courseId);
            teacherStudents.clear();
            while (rs.next()){
                String coursesId= rs.getString("courseId");
                String courseName= rs.getString("course_name");
                String studentId = rs.getString("studentId");
                String studentFName = rs.getString("studentName");
                String teacherId = rs.getString("teacherId");
                String teacherFName = rs.getString("teacherName");
                TeacherStudentsConstructor teachersStudentsCourse = new TeacherStudentsConstructor(coursesId,courseName,studentId,studentFName,teacherId,teacherFName);
                teacherStudents.add(teachersStudentsCourse);
            }
            usersBean.setTeachersStudentsCourses(teacherStudents);
        }catch (SQLException e){
            Database.PrintSQLException(e);
        }
    }
}
