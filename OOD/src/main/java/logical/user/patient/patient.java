package logical.user.patient;
import logical.user.*;
import logical.profile;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class patient extends user {
    private profile myProfile;
    private String NameOfDoctor;
    private int NationalId;
    private ArrayList<message> messages;
    public patient(String username, char[] password, String name) {
        super(username, password, name);
    }
}
