package logical.user;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by a on 5/1/15.
 */
@MappedSuperclass
public class User  {
    public String myusername;
    public char[] mypassword;
    public String myname;
    public String myfamilyName;



    public String mytype;

   // private String type;
    public String id;

    public User() {
    }

    
    public String getUsername() {
        return myusername;
    }

    
    public void setUername(String myusername) {
        this.myusername = myusername;
    }

    
    public char[] getPassword() {
        return mypassword;
    }

    
    public void setPassword(char[] mypassword) {
        this.mypassword = mypassword;
    }

    
    public String getName() {
        return myname;
    }

    
    public void setName(String name) {
        this.myname = name;
    }

    
    public String getMytype() {
        return mytype;
    }

    
    public void setMytype(String mytype) {
        this.mytype = mytype;
    }

//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

    public User(String username, char[] password, String name, String familyName, String id, String type){
        this.myusername = username;
        this.mypassword = password;
        this.myname = name;
        this.myfamilyName = familyName;
        this.id = id;
        this.mytype = type;
      //  this.type = type;
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

    
    public String getFamilyName() {
        return myfamilyName;
    }

    
    public void setFamilyName(String familyName) {
        this.myfamilyName = familyName;
    }
}
