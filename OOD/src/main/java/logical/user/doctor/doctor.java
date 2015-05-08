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
<<<<<<< HEAD
    String type;
    ArrayList<message> messages;
=======
<<<<<<< HEAD
    String type;
    ArrayList<message> messages;
    //ArrayList<message> consultations;

    public doctor(String username, char[] password, String name, String familyName, int doctorId) {
        super(username, password, name, familyName, doctorId);
        patients = new ArrayList<patient>();
        //this.type = type;
=======
    //ArrayList<message> messages;
>>>>>>> 47c94e9c1d0f41233979693bf53419de80897aa8
    //ArrayList<message> consultations;

    public doctor(String username, char[] password, String name, String familyName, int doctorId) {
        super(username, password, name, familyName, doctorId);
        patients = new ArrayList<patient>();
<<<<<<< HEAD
        //this.type = type;
=======
>>>>>>> 8811055fb541bc0d27c5edf7237993e31ef0c1d0
>>>>>>> 47c94e9c1d0f41233979693bf53419de80897aa8
    }

    public ArrayList<patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<patient> patients) {
        this.patients = patients;
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 47c94e9c1d0f41233979693bf53419de80897aa8
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
<<<<<<< HEAD
=======
=======
>>>>>>> 8811055fb541bc0d27c5edf7237993e31ef0c1d0
>>>>>>> 47c94e9c1d0f41233979693bf53419de80897aa8
}
