package logical.user;

import logical.user.patient.Patient;

import java.util.Date;

/**
 * Created by a on 5/1/15.
 */
public class Message {
    private User sender;
    private User receiver;
    private String title;
    private String Content;
    private Date dateOdCreate;
    private int PatientId;


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


    public Message(User sender, User receiver, Date date, String content, String title, int id){
        this.receiver = receiver;
        this.sender = sender;
        dateOdCreate = date;
        this.Content = content;
        this.title = title;
        PatientId = id;
    }

    public void answermessage(String content){
        Content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPatientId() {
        return PatientId;
    }

    public void setPatientId(int patientId) {
        PatientId = patientId;
    }
}
