package logical.user;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class Admin extends User {
    private ArrayList<Message> messages;
<<<<<<< HEAD
    public Admin(String username, char[] password, String name, String familyName, String id) {
=======
    public Admin(String username, char[] password, String name, String familyName, int id) {
>>>>>>> 22ea7e51ffe473627c228a1dceacf0ad145985f4
        super(username, password, name, familyName, id);
        messages = new ArrayList<Message>();
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
