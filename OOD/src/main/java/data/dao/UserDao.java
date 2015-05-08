package data.dao;
import logical.user.doctor.doctor;
import logical.user.user;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public interface UserDao {
    public void SignUp(user user);  //implementation phase1
    public void Login(user user);    //implementation phase1
    public user getUser(String username);
    public void retriveData(user user);

   // public void Logout();
    public ArrayList<user> search();  //implementation phase1
    public ArrayList<user> showListOfUser();   //implementation phase1
}
