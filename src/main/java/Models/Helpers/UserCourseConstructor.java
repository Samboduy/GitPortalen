package Models.Helpers;

public class UserCourseConstructor {
    public String getId() {
        return id;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getYHP() {
        return YHP;
    }
    public String getDescription() {
        return description;
    }

    private String id;
    private String courseName;
    private String YHP;
    private String description;



    UserCourseConstructor(String id, String courseName,String YHP,String description){
        this.id = id;
        this.courseName = courseName;
        this.YHP = YHP;
        this.description = description;
    }
    UserCourseConstructor(String courseName, String YHP, String description){

        this.courseName = courseName;
        this.YHP = YHP;
        this.description = description;
    }
}
