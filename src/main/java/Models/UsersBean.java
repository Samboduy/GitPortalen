package Models;

import java.io.Serializable;

public class UsersBean implements Serializable {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    private USER_TYPE UserType;
    public enum USER_TYPE{
        student,
        teacher
    }

    public PRIVILAGE_TYPE getPrivType() {
        return privType;
    }

    public void setPrivType(PRIVILAGE_TYPE privType) {
        this.privType = privType;
    }

    private PRIVILAGE_TYPE privType = PRIVILAGE_TYPE.user;
    public enum PRIVILAGE_TYPE{
        user,
        admin,
        superAdmin
    }
    boolean confirmed = false;
    public boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public USER_TYPE getUserType() {
        return UserType;
    }

    public void setUserType(USER_TYPE userType) {
        this.UserType = userType;
    }
    public UsersBean(){
    }
}
