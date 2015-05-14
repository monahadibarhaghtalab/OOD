package logical.user;

import java.util.Date;

/**
 * Created by a on 5/1/15.
 */
public class Message {
    private User sender;
    private User receiver;
    private String Content;
    private Date dateOdCreate;


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
        dateOdCreate = date;
    }

    public void answermessage(String content){
        Content = content;
    }
}
