package data.entities.entityfile;

import logical.user.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Mona on 3/14/2015.
 */


public class UserEntity extends MyEntity {


    private String username;
    private String password;
    private String name;
    private String familyName;
    private String id;

    public User getUser(){
        User res = new User(this.username, this.password, this.name, this.familyName, this.id);
        return res;
    }
}
