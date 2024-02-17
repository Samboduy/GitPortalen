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
}