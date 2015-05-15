package logical.user;

/**
 * Created by a on 5/1/15.
 */
public class User {
    public String username;
    public char[] password;
    public String name;
    public String familyName;

   // private String type;
    public int id;

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

//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

    public User(String username, char[] password, String name, String familyName, int id){
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
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
