package logical.user.patient;
import data.entities.entityfile.DoctorEntity;
import logical.user.*;
import logical.Profile;
import logical.user.doctor.Doctor;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class Patient extends User {

    public ArrayList<Doctor> doctors;
    public String id;

   // public int NationalId;
    private  ArrayList<Message> messages;
    private Profile myProfile;

//    public Patient(String username, char[] password, String name, String familyName, String id) {
//        super(username, password, name, familyName, id);
//    }

    public Patient(String id, ArrayList<Doctor> doctors) {
        this.id = id;
        this.doctors = doctors;
    }

    public Patient(String id) {

    }
}
