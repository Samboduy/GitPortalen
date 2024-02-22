package Models.Helpers;

public class TeacherStudentsConstructor {
    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getYHP() {
        return YHP;
    }

    public String getDescription() {
        return description;
    }

    private String courseId;
    private String courseName;
    private String teacherName;
    private String teacherId;
    private String studentId;
    private String studentName;
    private String YHP;
    private String description;
    TeacherStudentsConstructor(String courseId, String courseName, String studentId, String studentName, String teacherId, String teacherName){
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.studentName = studentName;
    }

    TeacherStudentsConstructor(String courseId, String courseName, String teacherName,String YHP,String description){
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.YHP = YHP;
        this.description = description;
    }
}
