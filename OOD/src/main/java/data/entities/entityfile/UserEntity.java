package data.entities.entityfile;

import logical.user.User;

/**
 * Created by Mona on 3/14/2015.
 */


public class UserEntity extends MyEntity {


    private String username;
    private char[] password;
    private String name;
    private String familyName;
    private String id;

    public User getUser(){
        User res = new User(this.username, this.password, this.name, this.familyName, this.id);
        return res;
    }
}
