package Models;

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


    private String id;
    private String privilegeType;
    private String userType;
    boolean confirmed = false;
    public UsersBean(){
    }
}
