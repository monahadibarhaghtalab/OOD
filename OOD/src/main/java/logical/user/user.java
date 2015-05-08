package logical.user;

/**
 * Created by a on 5/1/15.
 */
public class user {
    private String username;
    private char[] password;
    private String name;
    private String type;
    //private int id;

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
    }
}
