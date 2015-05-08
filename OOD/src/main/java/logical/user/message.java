package logical.user;

import java.util.Date;

/**
 * Created by a on 5/1/15.
 */
public class message {
<<<<<<< HEAD
    private user sender;
    private user receiver;
    private String Content;
    private Date dateOdCreate;


    public user getSender() {
        return sender;
    }

    public void setSender(user sender) {
        sender = sender;
    }

    public user getReceiver() {
        return receiver;
    }

    public void setReceiver(user receiver) {
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


    public message(user sender, user receiver, Date date){
        this.receiver = receiver;
        this.sender = sender;
        dateOdCreate = date;
    }

    public void answermessage(String content){
        Content = content;
    }
=======
    String NameOfSender;
    String NameOfReceiver;
    String Content;
    Date dateOdCreate;

>>>>>>> 8811055fb541bc0d27c5edf7237993e31ef0c1d0
}
