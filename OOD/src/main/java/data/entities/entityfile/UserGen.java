package data.entities.entityfile;

import logical.user.User;

import javax.persistence.*;

/**
 * Created by Mona on 5/24/2015.
 */

@MappedSuperclass
@Inheritance(strategy= InheritanceType.JOINED)
public class UserGen extends User {
    @Id
    @Column(name = "id" )
    public String getId() {
        return id;
    }
    public void setId(String id) {
        //  System.out.println(id +"IIIIIIIIIIIID");
        this.id = id;
    }

}
