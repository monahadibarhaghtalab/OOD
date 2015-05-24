package logical.user;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by a on 5/1/15.
 */

public class Message {
    public User sender;
    public User receiver;
    public String Content;
    public Date dateOdCreate;

    public String id;

    public Message(User tempUser, Admin admin, Date date) {


    }

    public Message() {
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


//
    public User getSender() {
        return sender;
    }


    public void setSender(User sender) {
        sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }


    public void setReceiver(User receiver) {
        receiver = receiver;
    }

    
    public String getContent() {
        return Content;
    }

    
    public void setContent(String content) {
        Content = content;
    }

    
    public Date getDateOdCreate() {
        return dateOdCreate;
    }

    
    public void setDateOdCreate(Date dateOdCreate) {
        this.dateOdCreate = dateOdCreate;
    }


    public Message(User sender, User receiver, Date date){
        this.receiver = receiver;
        this.sender = sender;
        this.dateOdCreate = date;
//        this.Content = content;
//        this.id = id;
    }

    
    public void answermessage(String content){
        Content = content;
    }
}
