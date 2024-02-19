package Models;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class StudentCourse {
    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    private String id;
    private String courseName;
    private String teacherName;
    StudentCourse(String id,String courseName,String teacherName){
        this.id = id;
        this.courseName = courseName;
        this.teacherName = teacherName;
    }
}
