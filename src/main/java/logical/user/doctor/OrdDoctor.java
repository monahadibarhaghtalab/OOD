package logical.user.doctor;

import data.entities.entityfile.UserEntity;

/**
 * Created by a on 5/8/15.
 */

public class OrdDoctor extends Doctor {

    public OrdDoctor(String username, char[] password, String name, String familyName, String doctorId) {


        super(username, password, name, familyName, doctorId, "General");


    }

    public OrdDoctor(UserEntity user) {


        super(user, "General");


    }

    public OrdDoctor(Doctor doctor) {
        super(doctor.getUsername(), doctor.getPassword(), doctor.getName(), doctor.getFamilyName(), doctor.getId(),"General");

    }
}
