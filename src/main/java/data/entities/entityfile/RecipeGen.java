package data.entities.entityfile;

import logical.Recipe;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Mona on 6/3/2015.
 */
@MappedSuperclass
public class RecipeGen{

    public UUID id;


    public RecipeGen() {
    }

    @Id
    @GenericGenerator(name = "generator", strategy = "uuid2")
    @GeneratedValue(generator = "generator")
    @Type(type = "uuid-binary")
    @Column(name = "id")
    public UUID  getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
