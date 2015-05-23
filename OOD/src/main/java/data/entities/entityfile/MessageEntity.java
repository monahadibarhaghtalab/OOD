package data.entities.entityfile;

import logical.user.Message;
import logical.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Mona on 5/8/2015.
 */
@Table(name = "mymessage")
@Entity
@AttributeOverride(name = "id", column = @Column(name = "message_id"))
public class MessageEntity extends Message{
    private String id;
    public String content;
    public Date dateOdCreate;

    public MessageEntity(Message mymessage) {
//        super(mymessage.sender, mymessage.receiver, mymessage.dateOdCreate, mymessage.Content, mymessage.id);
        super(mymessage.sender, mymessage.receiver, mymessage.dateOdCreate);
//        setId(mymessage.id);
//        setMyContent(mymessage.getContent());
//        setReceiver(new UserEntity(mymessage.getReceiver()));
//        setSender(new UserEntity(mymessage.getSender()));
    }

//    public MessageEntity(User sender, User receiver, Date date) {
//        super(sender, receiver, date);
//    }

//    @Id
//    @Column(name = "message_id" )
//    public String getId() {
//        return id;
//    }
//
//
//    public void setId(String id) {
//        //  System.out.println(id +"IIIIIIIIIIIID");
//        this.id = id;
//    }


//    @Column(name = "mycontent")
//    @Basic
//    public String getMyContent(){
//        return content;
//    }
//    public void setMyContent(String content) {
//        this.content = content;
//    }

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



    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private UserEntity sender;

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

    public UserEntity getSender() {
        return sender;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity receiver;

    public void setReceiver(UserEntity receiver) {
        this.receiver = receiver;
    }

    public UserEntity getReceiver() {
        return sender;
    }

    public Message getMessage() {

        Message m = new Message(sender.getUser(), receiver.getUser(), getDateOdCreate());
        return m;
    }
}
