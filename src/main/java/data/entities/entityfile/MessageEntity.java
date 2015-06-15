package data.entities.entityfile;

import logical.user.Message;
import logical.user.User;


import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Mona on 5/8/2015.
 */
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "mymessage")
@Entity
@AttributeOverride(name = "id", column = @Column(name = "message_id"))
public class MessageEntity extends MessageGen{
    private UserEntity receiver;
    private UserEntity sender;
    private String content;
    private Date dateOdCreate;
    private String title;
    private String senderId;
    private String receiverId;

    private String patientId;

    private int type;


    public MessageEntity() {
    }


//    public Message getMessage() {
//
//        Message m = new Message(sender.getUser(), receiver.getUser(), getDateOdCreate());
//        return m;
//    }




    public MessageEntity( UserEntity sender, UserEntity receiver, Message mymessage) {
//        super(mymessage.getSender(), mymessage.getReceiver(), mymessage.getDateOdCreate(), mymessage.getContent(), mymessage.getTitle(), mymessage.getPatientId());
//        super(id);
        setContent(mymessage.getContent());
        setDateOdCreate(mymessage.getDateOdCreate());
        setTitle(mymessage.getTitle());
        setType(mymessage.getType());
        System.out.println(mymessage.getPatientId() + " messaaaaaaaaaaaaaaaaaaaaage pateintId!");
        setPatientId(mymessage.getPatientId());

        setReceiver(receiver);
        setReceiverId(receiver.getId());
        System.out.println(" in message Entity: sender id" + mymessage.getSender().getId() + " in message Entity: rec id "+ mymessage.getSender().getFamilyName());
//        UserEntity temp = new UserEntity(mymessage.getSender());
//        temp.setId(mymessage.getSender().getId());
        setSender(sender);
        setSenderId(sender.getId());
    }





    @Column(name = "sender_id", nullable = false)
    @Basic
    public String getSenderId(){
        return senderId;
    }
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false, insertable = false, updatable = false)
    public UserEntity getSender() {
        return sender;
    }
    public void setSender(UserEntity sender) {
        this.sender = sender;
    }


    @Column(name = "reciver_id", nullable = false)
    @Basic
    public String getReceiverId(){
        return receiverId;
    }
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }



    @ManyToOne
    @JoinColumn(name = "reciver_id", nullable = false, insertable = false, updatable = false)
    public UserEntity getReceiver() {
        return receiver;
    }
    public void setReceiver(UserEntity receiver) {
        this.receiver = receiver;
    }


    @Column(name = "mytitle")
    @Basic
    public String getTitle(){
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    @Column(name = "mydate")
    @Basic

    public Date getDateOdCreate() {
        return dateOdCreate;
    }

    public void setDateOdCreate(Date dateOdCreate) {
        this.dateOdCreate = dateOdCreate;
    }


    @Column(name = "mycontent")
    @Basic
    public String getContent(){
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }


    @Column(name = "mytype")
    @Basic
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    @Column(name = "patientid")
    @Basic
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
