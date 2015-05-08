package logical.user;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class admin extends user {
    private ArrayList<message> messages;
<<<<<<< HEAD
    public admin(String username, char[] password, String name, String familyName, int id) {
        super(username, password, name, familyName, id);
=======
<<<<<<< HEAD
    public admin(String username, char[] password, String name, String familyName, int id) {
        super(username, password, name, familyName, id);
=======
    public admin(String username, char[] password, String name) {
        super(username, password, name);
>>>>>>> 8811055fb541bc0d27c5edf7237993e31ef0c1d0
>>>>>>> 47c94e9c1d0f41233979693bf53419de80897aa8
        messages = new ArrayList<message>();
    }

    public ArrayList<message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<message> messages) {
        this.messages = messages;
    }
}
