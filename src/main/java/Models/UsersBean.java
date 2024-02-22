package Models;

import Models.Helpers.TeacherStudentsConstructor;
import Models.Helpers.UserCourseConstructor;
import Models.Helpers.UserStudentsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

public class UsersBean implements Serializable {
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPrivilegeType() {
        return privilegeType;
    }
    public void setPrivilegeType(String privilegeType) {
        this.privilegeType = privilegeType;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public boolean isConfirmed() {
        return confirmed;
    }
    public boolean getConfirmed() {
        return confirmed;
    }
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
    public ArrayList<UserCourseConstructor> getAllCourses() {
        return allCourses;
    }
    public void setAllCourses(ArrayList<UserCourseConstructor> allCourses) {
        this.allCourses = allCourses;
    }
    public ArrayList<UserStudentsConstructor> getAllStudents() {
        return allStudents;
    }
    public ArrayList<UserStudentsConstructor> getStudentCourses() {
        return studentCourses;
    }
    public void setStudentCourses(ArrayList<UserStudentsConstructor> studentCourses) {
        this.studentCourses = studentCourses;
    }
    public ArrayList<UserCourseConstructor> getUserCourses() {
        return userCourses;
    }
    public void setUserCourses(ArrayList<UserCourseConstructor> userCourses) {
        this.userCourses = userCourses;
    }
    public void setAllStudents(ArrayList<UserStudentsConstructor> allStudents) {
        this.allStudents = allStudents;
    }
    public void setTeachersStudentsCourses(ArrayList<TeacherStudentsConstructor> teachersStudentsCourses) {
        this.teachersStudentsCourses = teachersStudentsCourses;
    }
    public ArrayList<TeacherStudentsConstructor> getTeachersStudentsCourses() {
        return teachersStudentsCourses;
    }
    private ArrayList<UserCourseConstructor> userCourses;
    private ArrayList<TeacherStudentsConstructor> teachersStudentsCourses;
    private ArrayList<UserStudentsConstructor> studentCourses;
    private ArrayList<UserCourseConstructor> allCourses;
    private ArrayList<UserStudentsConstructor> allStudents;
    private String id;
    private String privilegeType;
    private String userType;
    boolean confirmed = false;
    public UsersBean(){
    }
}
