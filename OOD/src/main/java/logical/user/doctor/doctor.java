package logical.user.doctor;
import logical.user.*;
import logical.user.patient.Patient;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class Doctor extends User {
    private ArrayList<Patient> patients;
    private String type;
    ArrayList<Message> messages;
    public Patient currentPatient;
    //ArrayList<message> consultations;


    public Doctor(String username, char[] password, String name, String familyName, String doctorId,String type) {


        super(username, password, name, familyName, doctorId);
        patients = new ArrayList<Patient>();
        this.type = type;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

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
