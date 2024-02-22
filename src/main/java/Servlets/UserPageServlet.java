package Servlets;

import Models.Helpers.UserCoursePackage;
import Models.Helpers.UserStudentsPackage;
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
        if (userBean.getUserType().equals("student")){
            String studentId = userBean.getId();
            UserCoursePackage.UserPageInformation(userBean,req,studentId);
        }
        req.getRequestDispatcher("userpage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String showMyCourses = req.getParameter("showcourses");
        String showFellowStudents = req.getParameter("showstudents");
        String showAllStudents = req.getParameter("allstudents");
        String showAllCourses = req.getParameter("allcourses");
        String showStudentCourses = req.getParameter("showStudentCourses");
        String showStudentTeacherCourse = req.getParameter("showStudentTeacherCourse");
        UsersBean userBean = ((UsersBean) getServletConfig().getServletContext().getAttribute("userBean"));
        String studentId;
        if (showMyCourses!=null){
            studentId = userBean.getId();
            studentCourses(userBean,req,studentId);
            req.setAttribute("showMyCoursesBTClick", true);
            req.setAttribute("fellowStudentsBTClick", false);
            req.setAttribute("showAllStudents",false);
            req.getRequestDispatcher("userpage.jsp").forward(req, resp);
        } else if (showFellowStudents!=null){
            UserStudentsPackage.userPageInformation(req,userBean);
            req.setAttribute("fellowStudentsBTClick", true);
            req.setAttribute("showMyCoursesBTClick", false);
            req.setAttribute("showMyCoursesBTClick", false);
        } else if (showAllStudents!=null) {
            UserStudentsPackage.studentPacker(userBean);
            req.setAttribute("showAllStudents",true);
            req.setAttribute("showStudentCourses",false);
            req.setAttribute("showMyCoursesBTClick", false);
            req.setAttribute("showStudentTeacherCourse",false);
        } else if (showAllCourses!=null) {
            UserCoursePackage.allCoursesPacker(userBean);
            req.setAttribute("showAllCourses",true);
            req.setAttribute("showAllStudents",false);
            req.setAttribute("showStudentCourses",false);
            req.setAttribute("showStudentTeacherCourse",false);
        } else if (showStudentCourses!=null) {
            String studentID = req.getParameter("studentIDs");
            UserStudentsPackage.studentCoursesPacker(userBean,studentID);
            req.setAttribute("showStudentCourses",true);
            req.setAttribute("showAllStudents",false);
            req.setAttribute("showMyCoursesBTClick", false);
            req.setAttribute("showStudentTeacherCourse",false);
        }else if (showStudentTeacherCourse!=null){
            String courseId =req.getParameter("courseId");
            UserCoursePackage.teachersStudentsCoursePacker(userBean,courseId);
            req.setAttribute("showStudentTeacherCourse",true);
            req.setAttribute("showStudentCourses",false);
            req.setAttribute("showAllStudents",false);
            req.setAttribute("showMyCoursesBTClick", false);
        }
        req.getRequestDispatcher("userpage.jsp").forward(req, resp);
    }


    public static void studentCourses (UsersBean userBean,HttpServletRequest req, String studentId){
        UserCoursePackage.UserPageInformation(userBean,req,studentId);
    }

}
