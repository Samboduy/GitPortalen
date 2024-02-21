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
}
