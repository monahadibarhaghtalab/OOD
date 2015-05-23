package logical.user.doctor;
import logical.user.*;
import logical.user.patient.Patient;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class Doctor extends User{
    public ArrayList<Patient> patients;
    public String typeDoctor;
    public ArrayList<Message> messages;
    //ArrayList<message> consultations;

    public Doctor(String username, char[] password, String name, String familyName, String id,  String typeDoctor) {

        super(username, password, name, familyName, id, "doctor");
        patients = new ArrayList<Patient>();
        //this.type = type;
    }

    public Doctor() {
    }

//    public ArrayList<Patient> getPatients() {
//        return patients;
//    }

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
