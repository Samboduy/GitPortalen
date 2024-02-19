package Servlets;

import Models.StudentCourse;
import Models.StudentPackage;
import Models.UsersBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/userpage")
public class UserPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersBean userBean = ((UsersBean) getServletConfig().getServletContext().getAttribute("userBean"));
        StudentPackage.UserPageInformation(userBean, req);
        req.getRequestDispatcher("userpage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
}
