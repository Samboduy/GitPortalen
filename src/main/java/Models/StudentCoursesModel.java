package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCoursesModel {

    public static ResultSet studentCourses(String studentId){
        String sql = "SELECT s.id, s.fname,IFNULL(GROUP_CONCAT(c.course_name SEPARATOR ', '), '') as courses FROM student_courses sc\n" +
                "    LEFT JOIN students s ON s.id = sc.student_id\n" +
                "    LEFT JOIN courses c ON c.id = sc.course_id WHERE s.id = ?";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            ps.setString(1,studentId);
            return ps.executeQuery();
        }catch (SQLException e){
            Database.PrintSQLException(e);
            return null;
        }
    }
}
