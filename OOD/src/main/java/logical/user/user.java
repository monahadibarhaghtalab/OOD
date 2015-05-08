package logical.user;

/**
 * Created by a on 5/1/15.
 */
public class user {
    private String username;
    private char[] password;
    private String name;
<<<<<<< HEAD
    private String familyName;

   // private String type;
    private int id;
=======
    private String type;
    //private int id;
>>>>>>> 8811055fb541bc0d27c5edf7237993e31ef0c1d0

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

    public user(String username, char[] password, String name, String familyName, int id){
        this.username = username;
        this.password = password;
        this.name = name;
        this.familyName = familyName;
        this.id = id;
      //  this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
=======

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public user(String username, char[] password, String name){
        this.username = username;
        this.password = password;
        this.name = name;
      //  this.type = type;
>>>>>>> 8811055fb541bc0d27c5edf7237993e31ef0c1d0
    }
}
