package data.dao;
import logical.user.User;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public interface UserDao {
    public void SignUp(User user);  //implementation phase1
    public void Login(User user);    //implementation phase1
    public User getUser(String username);
    public void retriveData(User user);

   // public void Logout();
    public ArrayList<User> search();  //implementation phase1
    public ArrayList<User> showListOfUser();   //implementation phase1
}
