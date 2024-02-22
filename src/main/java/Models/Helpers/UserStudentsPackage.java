package Models.Helpers;

import Models.Database;
import Models.StudentCoursesModel;
import Models.StudentsModule;
import Models.UsersBean;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserStudentsPackage {
  private static  ArrayList<UserStudentsConstructor> students = new ArrayList<>();
    public static void userPageInformation(HttpServletRequest req,UsersBean userbean){
        String courseId = req.getParameter("courseId");
        System.out.println(courseId);
       ResultSet rs =  StudentsModule.fellowStudentsData(courseId);
       students.clear();
       try{
           while (rs.next()){
               String courseName = rs.getString("course_name");
               String studentName = rs.getString("fname");
               String studentId = rs.getString("id");
               UserStudentsConstructor student = new UserStudentsConstructor(courseName,studentName,studentId);
               students.add(student);
           }
           userbean.setStudentCourses(students);
       }catch (SQLException ex){
           Database.PrintSQLException(ex);
       }
    }
    public static void studentPacker(UsersBean userbean){
        ResultSet rs = StudentsModule.students();
        students.clear();
        try {
            while (rs.next()){
                String studentFName = rs.getString("fname");
                String studentLName = rs.getString("lname");
                String studentID = rs.getString("id");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String userpage = rs.getString("username");
                UserStudentsConstructor student = new UserStudentsConstructor(studentFName,studentLName,studentID,email,phone,userpage);
                students.add(student);
            }
            userbean.setAllStudents(students);
        }catch (SQLException e){
            Database.PrintSQLException(e);
        }
    }

    public static void studentCoursesPacker(UsersBean userbean,String studentId){
        ResultSet rs = StudentCoursesModel.studentCourses(studentId);
        students.clear();
        try {
            while (rs.next()){
                String studentFName = rs.getString("fname");
                String studentID = rs.getString("id");
                String courseNames = rs.getString("courses");
                UserStudentsConstructor student = new UserStudentsConstructor(courseNames,studentFName,studentID);
                students.add(student);
            }
            userbean.setStudentCourses(students);
        }catch (SQLException e){
            Database.PrintSQLException(e);
        }
    }
}
