package logical.user.patient;
import logical.user.*;
import logical.Profile;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class Patient extends User {
    private Profile myProfile;
    private String NameOfDoctor;
   // private int NationalId;
    private ArrayList<Message> messages;
    public Patient(String username, char[] password, String name, String familyName, int id) {
        super(username, password, name, familyName, id);
    }
}
