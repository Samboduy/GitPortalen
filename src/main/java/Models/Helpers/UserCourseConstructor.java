package Models.Helpers;

public class UserCourseConstructor {
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
    UserCourseConstructor(String id, String courseName, String teacherName){
        this.id = id;
        this.courseName = courseName;
        this.teacherName = teacherName;
    }
}
