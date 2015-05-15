package logical.user.doctor;
import logical.user.*;
import logical.user.patient.Patient;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class Doctor extends User {
    private ArrayList<Patient> patients;
    public String type;
    ArrayList<Message> messages;
    //ArrayList<message> consultations;

<<<<<<< HEAD
    public Doctor(String username, char[] password, String name, String familyName, String doctorId) {
=======
    public Doctor(String username, char[] password, String name, String familyName, int doctorId) {
>>>>>>> 22ea7e51ffe473627c228a1dceacf0ad145985f4
        super(username, password, name, familyName, doctorId);
        patients = new ArrayList<Patient>();
        //this.type = type;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
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
