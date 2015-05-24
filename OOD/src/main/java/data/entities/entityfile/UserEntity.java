package data.entities.entityfile;

import logical.user.User;
import logical.user.doctor.Doctor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Table(name = "myuser")
@Entity
@PrimaryKeyJoinColumn(name="id")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class UserEntity  extends UserGen{

    public String myusername;
    public char[] mypassword;
    public String myname;
    public String myfamilyName;
    public String id;

    public String mytype;



    public UserEntity(User obj){
        setId(obj.id);
        setMyusername(obj.getUsername());
        setMypassword(obj.getPassword());
        setMyname(obj.getName());
        setMyfamilyName(obj.getFamilyName());
        messageSend = new HashSet<MessageEntity>();
        messageReceive = new HashSet<MessageEntity>();

    }

    public UserEntity() {
    }


//    public User getUser(){
//        User res = new User(this.myusername, this.mypassword, this.myname, this.myfamilyName, this.id, this.getMytype());
//        return res;
//    }


    @Column(name = "myusername")
    @Basic
    public String getMyusername(){
        return myusername;
    }
    public void setMyusername(String myusername) {
        this.myusername = myusername;
    }


    @Column(name = "mypassword")
    @Basic
    public char[] getMypassword(){
        return mypassword;
    }
    public void setMypassword(char[] mypassword) {
        this.mypassword = mypassword;
    }

    @Column(name = "myname")
    @Basic
    public String getMyname(){
        return myname;
    }
    public void setMyname(String myfamilyName) {
        this.myname = myname;
    }

    @Column(name = "myfamilyname")
    @Basic
    public String getMyfamilyName(){
        return myfamilyName;
    }
    public void setMyfamilyName(String myfamilyName) {
        this.myfamilyName = myfamilyName;
    }

    @Column(name = "mytype")
    @Basic
    public String getMytype() {
        return mytype;
    }

    public void setMytype(String mytype) {
        this.mytype = mytype;
    }


    private Set<MessageEntity> messageSend;
    @OneToMany(mappedBy = "sender")
    public Set<MessageEntity> getMessageSend() {
        return messageSend;
    }

    public void setMessageSend(Set<MessageEntity> message) {
        this.messageSend = message;
    }

    public void addMessageSend(MessageEntity newmessage) {
        messageSend.add(newmessage);
    }

    private  Set<MessageEntity> messageReceive;
    @OneToMany(mappedBy = "receiver")
    public Set<MessageEntity> getMessageRec() {
        return messageReceive;
    }

    public void setMessageRec(Set<MessageEntity> message) {
        this.messageReceive = message;
    }

    public void addMessageRec(MessageEntity newmessage) {
        messageReceive.add(newmessage);
    }


}
