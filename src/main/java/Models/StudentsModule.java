package Models;

import Models.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentsModule {
    public static ResultSet checkStudent (String username){
        String sql = "SELECT username,password,id FROM students WHERE username = ?";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            Database.PrintSQLException(e);
            return null;
        }

    }
    public static ResultSet studentCourseData(UsersBean usersBean){
        String sql = "SELECT s.fname, c.id,c.course_name, IFNULL(GROUP_CONCAT(t.fname SEPARATOR ', '), '') as teacher \n" +
                "FROM students s  \n" +
                "LEFT JOIN student_courses sc \n" +
                "ON s.id = sc.student_id\n" +
                "LEFT JOIN courses c \n" +
                "ON c.id = sc.course_id \n" +
                "LEFT JOIN teacher_courses tc \n" +
                "ON c.id = tc.course_id\n" +
                "LEFT JOIN teachers t \n" +
                "ON t.id = tc.teacher_id \n" +
                "WHERE s.id = ?  \n" +
                "GROUP by c.id;";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            ps.setString(1,usersBean.getId());
            return ps.executeQuery();
        }catch (SQLException e){
            Database.PrintSQLException(e);
            return null;
        }
    }

}