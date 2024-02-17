package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static Connection con;
    public static Connection connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //PORT and DbName should be changed

            con = DriverManager.getConnection("jdbc:mysql://localhost:13306/gritacademyportal","user","");
            return con;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    public static Connection connectInsert(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //PORT and DbName should be changed

            con = DriverManager.getConnection("jdbc:mysql://localhost:13306/gritacademy","userRead","");
            return con;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static int insertStudent(String sql){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //PORT and DbName should be changed
            con = DriverManager.getConnection("jdbc:mysql://localhost:13306/gritacademy","user","");
            Statement stmt = con.createStatement();
            return stmt.executeUpdate(sql);
        }catch (SQLException ex){
            PrintSQLException(ex);
            return -1;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeCon(){
        try{
            con.close();
        }catch (SQLException exception){
            PrintSQLException(exception);
        }

    }

    public static void PrintSQLException(SQLException sqle) {
        PrintSQLException(sqle, false);
    }
    public static void PrintSQLException(SQLException sqle, Boolean printStackTrace) {
        while(sqle != null) {
            System.out.println("\n---SQLException Caught---\n");
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("ErrorCode: " + sqle.getErrorCode());
            System.out.println("Message: " + sqle.getMessage());
            if(printStackTrace) sqle.printStackTrace();
            sqle = sqle.getNextException();
        }
    }
}
