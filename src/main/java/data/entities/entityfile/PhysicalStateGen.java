package data.entities.entityfile;

import logical.user.PhysicalState;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Mona on 6/2/2015.
 */
@MappedSuperclass
public class PhysicalStateGen  {

    public UUID id;



    @Id
    @GenericGenerator(name = "generator", strategy = "uuid2")
    @GeneratedValue(generator = "generator")
    @Type(type = "uuid-binary")
    @Column(name = "id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
