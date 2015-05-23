package logical.user.patient;
import data.entities.entityfile.DoctorEntity;
import logical.user.*;
import logical.Profile;
import logical.user.doctor.Doctor;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class Patient extends User  {


    public ArrayList<Doctor> doctors;

    public ArrayList<String> disease;
    public String id;

   // public int NationalId;
    private  ArrayList<Message> messages;
    private Profile myProfile;

    public Patient(String username, char[] password, String name, String familyName, String id) {
        super(username, password, name, familyName, id, "patient");
//        setDoctors(doctors);
//        setDisease(disease);
    }

    public Patient(String id, ArrayList<Doctor> doctors) {
        this.id = id;
        this.doctors = doctors;
    }

    public Patient(String id) {

    }

    public Patient() {
    }


    public ArrayList<String> getDisease() {
        return disease;
    }

    public void setDisease(ArrayList<String> disease) {
        this.disease = disease;
    }


//    public ArrayList<Doctor> getDoctors() {
//        return doctors;
//    }
//
//    public void setDoctors(ArrayList<Doctor> doctors) {
//        this.doctors = doctors;
//    }

}
