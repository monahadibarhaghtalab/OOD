package logical.user.patient;
import data.entities.entityfile.DoctorEntity;
import data.entities.entityfile.UserEntity;
import logical.user.*;
import logical.Profile;
import logical.user.doctor.Doctor;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class Patient extends User  {



    private Profile myProfile;

    private String NameOfDoctor;
    // private int NationalId;

    public ArrayList<Doctor> doctors;

    public ArrayList<String> disease;
    public String id;

    private ArrayList<Message> messages;

    public Patient(String username, char[] password, String name, String familyName, String id) {


        super(username, password, name, familyName, id, "patient");


    }

    public Patient(UserEntity usr) {


        super(usr.getMyusername(), usr.getMypassword(), usr.getMyname(), usr.getMyfamilyName(), usr.getId(), "patient");


    }


    public Patient(User usr) {


        super(usr.getUsername(), usr.getPassword(), usr.getName(), usr.getFamilyName(), usr.getId(), "patient");


    }
    public Patient() {
    }

//    public Patient(String id, ArrayList<Doctor> doctors) {
//        this.id = id;
//        this.doctors = doctors;
//    }
//
//    public Patient(String id) {
//
//    }
//
//    public Patient() {
//    }
//


    public Profile getProfile() {
        return myProfile;
    }

    public void setProfile(Profile myProfile) {
        this.myProfile = myProfile;


    }



    public ArrayList<String> getDisease() {
        return disease;
    }

    public void setDisease(ArrayList<String> disease) {
        this.disease = disease;
    }


    public ArrayList<String> history;
    public void addHistory(String hist) {
        history.add(hist);

    }

    public ArrayList<String> getHistory() {
        return history;
    }
    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }

//    public ArrayList<Doctor> getDoctors() {
//        return doctors;
//    }
//
//    public void setDoctors(ArrayList<Doctor> doctors) {
//        this.doctors = doctors;
//    }

}
