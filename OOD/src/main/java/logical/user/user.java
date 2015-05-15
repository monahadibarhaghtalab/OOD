package logical.user;

/**
 * Created by a on 5/1/15.
 */
public class User {
    private String myusername;
    private char[] mypassword;
    private String name;
    private String familyName;

   // private String type;
    private String id;

    public String getMyusername() {
        return myusername;
    }

    public void setMyusername(String myusername) {
        this.myusername = myusername;
    }

    public char[] getMypassword() {
        return mypassword;
    }

    public void setMypassword(char[] mypassword) {
        this.mypassword = mypassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

    public User(String username, char[] password, String name, String familyName, String id){
        this.myusername = username;
        this.mypassword = password;
        this.name = name;
        this.familyName = familyName;
        this.id = id;
      //  this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
