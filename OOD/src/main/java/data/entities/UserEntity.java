package data.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Mona on 3/14/2015.
 */

@Table(name = "User")
@Entity
public class UserEntity extends MyEntity{
    @Id
    @Type(type = "String")
    @Column(name = "Id")
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


}
