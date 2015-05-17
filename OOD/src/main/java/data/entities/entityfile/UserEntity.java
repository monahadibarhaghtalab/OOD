package data.entities.entityfile;

import logical.user.User;
import logical.user.doctor.Doctor;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by Mona on 3/14/2015.
 */

@Table(name = "myuser")
@Entity
public class UserEntity  {

    public String myusername;
    public char[] mypassword;
    public String myname;
    public String myfamilyName;
    public String id;

    public String mytype;

    public UserEntity(User obj) {
        setId(obj.id);
        setMyusername(obj.getUsername());
        setMypassword(obj.getPassword());
        setMyname(obj.getName());
        setMyfamilyName(obj.getFamilyName());
        message = new ArrayList<MessageEntity>();

    }

    public UserEntity() {
    }

    @Id
    @Column(name = "user_id" )
    public String getId() {
        return id;
    }


    public void setId(String id) {
        //  System.out.println(id +"IIIIIIIIIIIID");
        this.id = id;
    }
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

    @OneToMany(mappedBy = "user")
    private ArrayList<MessageEntity> message;

    public ArrayList<MessageEntity> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<MessageEntity> message) {
        this.message = message;
    }

    public void addMessage(MessageEntity newmessage) {
        message.add(newmessage);
    }

    public User getUser(){
        User res = new User(this.myusername, this.mypassword, this.myname, this.myfamilyName, this.id);
        return res;
    }
}
