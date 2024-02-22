package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoursesModule {
    public static ResultSet coursesId(){
        String sql = "SELECT id\n" +
                "FROM courses\n" +
                "Order BY id";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            return  ps.executeQuery();
        }catch (SQLException ex){
            Database.PrintSQLException(ex);
            return null;
        }
    }
    public static ResultSet findTeachersStudentsCourse(String courseId){
        String sql = "SELECT c.id as courseId,c.course_name,s.id as studentId,s.fname as studentName,t.id as teacherId,t.fname as teacherName\n" +
                "FROM students s  \n" +
                "LEFT JOIN student_courses sc \n" +
                "ON s.id = sc.student_id\n" +
                "LEFT JOIN courses c \n" +
                "ON c.id = sc.course_id \n" +
                "LEFT JOIN teacher_courses tc \n" +
                "ON c.id = tc.course_id\n" +
                "LEFT JOIN teachers t \n" +
                "ON t.id = tc.teacher_id \n" +
                "WHERE c.id = ? \n" +
                "GROUP by s.id";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            ps.setString(1,courseId);
            return  ps.executeQuery();
        }catch (SQLException ex){
            Database.PrintSQLException(ex);
            return null;
        }
    }
    public static ResultSet courses(){
        String sql = "SELECT id,course_name,YHP,description FROM courses;";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            return  ps.executeQuery();
        }catch (SQLException ex){
            Database.PrintSQLException(ex);

    public static ResultSet allCourses() {
        String sql = "SELECT id ,course_name, YHP, description FROM courses";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException e) {
            Database.PrintSQLException(e);
            return null;
        }
    }
}
