package logical.user;

import data.entities.entityfile.MessageEntity;
import logical.user.patient.Patient;

import java.util.Date;

/**
 * Created by a on 5/1/15.
 */
public class Message {
    public User sender;
    public User receiver;
    public String title;
    public String Content;
    public Date dateOdCreate;
    public String PatientId;


    public int type;// o if is request 1 if is consult

    public Message() {
    }


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


    public Message(User sender, User receiver, Date date, String content, String title, String id, int type){
        this.receiver = receiver;
        this.sender = sender;
        dateOdCreate = date;
        this.Content = content;
        this.title = title;
        PatientId = id;
        this.type = type;
    }

    public Message(MessageEntity msg){
        this.receiver = new User(msg.getReceiver());
        this.sender = new User(msg.getSender());
        dateOdCreate = msg.getDateOdCreate();
        this.Content = msg.getContent();
        this.title = msg.getTitle();
        this.PatientId = msg.getPatientId();
    }
//
//    public Message() {
//    }

    public void answermessage(String content){
        Content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPatientId() {
        return PatientId;
    }

    public void setPatientId(String patientId) {
        PatientId = patientId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
