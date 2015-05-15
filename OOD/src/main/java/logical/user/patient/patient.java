package logical.user.patient;
import logical.Profile;
import logical.user.Message;
import logical.user.User;


import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class Patient extends User {
    private Profile myProfile;
    private String NameOfDoctor;
   // private int NationalId;
    private ArrayList<Message> messages;
    public Patient(String username, String password, String name, String familyName, String id) {
        super(username, password, name, familyName, id);
    }
}
