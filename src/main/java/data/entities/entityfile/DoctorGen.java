package data.entities.entityfile;

import logical.user.doctor.Doctor;

import javax.persistence.*;

/**
 * Created by Mona on 5/24/2015.
 */

@MappedSuperclass
public class DoctorGen {

    public String id;
    public DoctorGen(String id) {
       this.id = id;
    }

    public DoctorGen() {
    }

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
