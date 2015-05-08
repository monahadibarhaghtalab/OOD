package logical.user.doctor;
import logical.*;
import logical.user.*;
import logical.user.patient.patient;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class doctor extends user{
    private ArrayList<patient> patients;
    String type;
    ArrayList<message> messages;
    //ArrayList<message> consultations;

    public doctor(String username, char[] password, String name, String familyName, int doctorId) {
        super(username, password, name, familyName, doctorId);
        patients = new ArrayList<patient>();
        //this.type = type;
    }

    public ArrayList<patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<patient> patients) {
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
