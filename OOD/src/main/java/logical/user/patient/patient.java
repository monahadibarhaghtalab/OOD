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

    public Patient(String username, char[] password, String name, String familyName, String id) {


        super(username, password, name, familyName, id);
    }

    public Profile getProfile() {
        return myProfile;
    }

    public void setProfile(Profile myProfile) {
        this.myProfile = myProfile;
    }
}
