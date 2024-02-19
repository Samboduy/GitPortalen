package Models;

import Models.Database;

import java.sql.*;

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
    public static String insertStudent(String fname, String lname, String town, String email, int phone, String username, String password) {
        System.out.println(fname + lname);
        String insertSuccessfull;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:13306/gritacademyportal", "root", "");

            String query = "Insert INTO students (fname, lname, town, email, phone, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setString(1, fname);
                pstmt.setString(2, lname);
                pstmt.setString(3, town);
                pstmt.setString(4, email);
                pstmt.setInt(5, phone);
                pstmt.setString(6, username);
                pstmt.setString(7, password);

                insertSuccessfull = "Insert successful";

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Insert successful");
                } else {
                    System.out.println("Insert failed");
                }
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            throw new RuntimeException("Error inserting student: " + e.getMessage(), e);

        }
        return insertSuccessfull;
    }
}