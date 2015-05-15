package data.entities.entityfile;

import logical.user.Message;

import java.util.UUID;

/**
 * Created by Mona on 5/8/2015.
 */
public class MessageEntity {
    private long id;
    private Message message;

    public MessageEntity(Message message) {

    }

    public void setid(long id) {
        this.id = id;
    }

    public Message getMessage() {
        return message;
    }
//
//    public void setsenderId(UUID senderId) {
//        this.senderId = senderId;
//    }
}
