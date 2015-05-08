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
    //ArrayList<message> messages;
    //ArrayList<message> consultations;

    public doctor(String username, char[] password, String name) {
        super(username, password, name);
        patients = new ArrayList<patient>();
    }

    public ArrayList<patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<patient> patients) {
        this.patients = patients;
    }
}
