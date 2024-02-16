package Models;

import java.io.Serializable;
import java.sql.ResultSet;

public class UsersBean implements Serializable {

    private boolean admin;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    private USER_TYPE type;
    public enum USER_TYPE{
        student,
        teacher
    }
    private PRIVILAGE_TYPE privType = PRIVILAGE_TYPE.user;
    private enum PRIVILAGE_TYPE{
        user,
        admin,
        superAdmin
    }
    boolean confirmed = false;
    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public USER_TYPE getType() {
        return type;
    }

    public void setType(USER_TYPE type) {
        this.type = type;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public UsersBean(){
    }
}
