package data.dao;
import user.*;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public interface UserDao {
    public void SignUp();  //implementation phase1
    public void Login();
    public void Logout();
    public user search();  //implementation phase1
    public ArrayList<user> showListOfUser();   //implementation phase1
}
