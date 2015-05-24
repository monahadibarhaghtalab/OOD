package data.entities.entityfile;

import logical.user.Message;

import javax.persistence.*;

/**
 * Created by Mona on 5/24/2015.
 */
@MappedSuperclass
@Inheritance(strategy= InheritanceType.JOINED)
public class MessageGen extends Message {

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
