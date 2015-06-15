package data.entities.entityfile;

import logical.user.User;

import javax.persistence.*;

/**
 * Created by Mona on 5/24/2015.
 */

@MappedSuperclass
public class UserGen {


    public String id;

    public UserGen(String id){this.id = id;
    }

    public UserGen() {
    }


    @Id
    @Column(name = "id" )
    public String getId() {
        return id;
    }
    public void setId(String id) {
         System.out.println(id +"IIIIIIIIIIIID");
        this.id = id;
    }

}
