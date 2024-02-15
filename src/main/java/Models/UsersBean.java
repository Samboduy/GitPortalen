package Models;

import java.io.Serializable;
import java.sql.ResultSet;

public class UsersBean implements Serializable {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



   private String id;

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    private boolean confirmed;
    public UsersBean(){
    }
}
