package logical.user;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class admin extends user {
    private ArrayList<message> messages;
    public admin(String username, char[] password, String name, String familyName, int id) {
        super(username, password, name, familyName, id);
        messages = new ArrayList<message>();
    }

    public ArrayList<message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<message> messages) {
        this.messages = messages;
    }
}
