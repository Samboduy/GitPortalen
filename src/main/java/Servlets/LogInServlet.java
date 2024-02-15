package Servlets;

import Models.Database;
import Models.UsersBean;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.RescaleOp;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "login",urlPatterns = "/login")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //saves what table to use in sql question
        String table = req.getParameter("stud_teach");
        System.out.println(table);
        //Querie for information on student/teacher
        String sql = "SELECT id,email,password FROM " + table + " WHERE email = ?";
        //saving what user wrote into the form
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            //Searching for the user with the right email
            PreparedStatement ps = Database.connect().prepareStatement(sql);
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            rs.next();
            //checking if email and password is correct, need to redirect in future to another site
            //If email and password is correct then userbean gets Users id and the state is confirmed
            if (rs.getString("email").equals(email)
                    && rs.getString("password").equals(password)){
                UsersBean usersBean = new UsersBean();
                usersBean.setId(rs.getString("id"));
                usersBean.setConfirmed(true);
                req.getSession().setAttribute("user",usersBean);
            }else{
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            Database.PrintSQLException(e);
        }

    }
}
