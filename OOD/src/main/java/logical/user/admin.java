package logical.user;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class Admin extends User {
    public ArrayList<Message> messages;
    public Admin(String username, char[] password, String name, String familyName, String id, String type) {

        super(username, password, name, familyName, id, type);
        messages = new ArrayList<Message>();
    }

    
    public ArrayList<Message> getMessages() {
        return messages;
    }

    
    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
