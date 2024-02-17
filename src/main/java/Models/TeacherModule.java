package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherModule {

    public static ResultSet checkTeacher (String username){
        String sql = "SELECT username, password, id,privilage_type FROM teachers WHERE username = ?";
        try {
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            ps.setString(1,username);
            return ps.executeQuery();
        } catch (SQLException e) {
            Database.PrintSQLException(e);
            return null;
        }

    }
}
