package data.entities.entityfile;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Mona on 3/14/2015.
 */

@Table(name = "mona")
@Entity
public class UserEntity extends MyEntity {

    private UUID guid;
    @Id
    @GenericGenerator(name = "generator", strategy = "uuid2", parameters = {})
    @GeneratedValue(generator = "generator")
    @Type(type = "uuid-binary")
    @Column(name = "UUID" )
    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }


//    @Id
//   // @Type(type = "String")
//    @Column(name = "Id")
//    public String getId() {
//        return id;
//    }
//    public void setId(String id) {
//        this.id = id;
//    }


}
