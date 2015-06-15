package logical.user.doctor;
import data.entities.entityfile.UserEntity;
import logical.user.*;
import logical.user.patient.Patient;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class Doctor extends User{
    private ArrayList<Patient> patients;
    public String type;
    ArrayList<Message> messages;
    public Patient currentPatient;
    //ArrayList<message> consultations;

    public Doctor(String username, char[] password, String name, String familyName, String doctorId,String type) {


        super(username, password, name, familyName, doctorId, type);
        patients = new ArrayList<Patient>();
        this.type = type;
    }

    public Doctor(UserEntity usr, String type){

        super(usr.getMyusername(), usr.getMypassword(), usr.getMyname(), usr.getMyfamilyName(), usr.getId(), type);
//        patients = new ArrayList<Patient>();
        this.type = type;
    }

    public Doctor(User usr, String type) {


        super(usr.getUsername(), usr.getPassword(), usr.getName(), usr.getFamilyName(), usr.getId(), "patient");
        this.type = type;

    }

    public Doctor() {
    }


//    public ArrayList<Patient> getPatients() {
//        return patients;
//    }
//
//    public void setPatients(ArrayList<Patient> patients) {
//        this.patients = patients;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
//
//    public patient searchPatients(patient p){
//        for (int i = 0; i < patients.size(); i++){
//            if(patients.get(i).getId() == p.getId())
//                return patients.get(i);
//        }
//        return null;
//    }
//
//    public ArrayList<message> getInbox(){
//        return messages;
//    }
}
