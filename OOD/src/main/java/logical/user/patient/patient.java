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
<<<<<<< HEAD
   // private int NationalId;
    private ArrayList<message> messages;
    public patient(String username, char[] password, String name,String familyName, int id) {
        super(username, password, name, familyName, id);
=======
    private int NationalId;
    private ArrayList<message> messages;
    public patient(String username, char[] password, String name) {
        super(username, password, name);
>>>>>>> 8811055fb541bc0d27c5edf7237993e31ef0c1d0
    }
}
