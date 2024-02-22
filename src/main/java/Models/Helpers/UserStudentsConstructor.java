package Models.Helpers;

public class UserStudentsConstructor {
    public String getCourseName() {
        return courseName;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }
    private String courseName;
    private String studentFirstName;
    private String studentLastName;
    private String studentId;
    private String email;
    private String phone;
    private String username;

    UserStudentsConstructor(String courseName, String studentName, String studentId){
        this.courseName = courseName;
        this.studentFirstName = studentName;
        this.studentId = studentId;
    }
    UserStudentsConstructor( String studentName,String studentLastName, String studentId,String email,String phone,String username){
        this.studentFirstName = studentName;
        this.studentLastName = studentLastName;
        this.studentId = studentId;
        this.email = email;
        this.phone = phone;
        this.username = username;
    }
}
