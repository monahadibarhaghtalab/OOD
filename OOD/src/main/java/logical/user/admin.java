package logical.user;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class Admin extends User {
    private ArrayList<Message> messages;
    public Admin(String username, String password, String name, String familyName, String id) {
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
