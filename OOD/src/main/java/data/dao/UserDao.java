package data.dao;
<<<<<<< HEAD
import logical.user.doctor.doctor;
import logical.user.user;
=======
import user.*;
>>>>>>> 8811055fb541bc0d27c5edf7237993e31ef0c1d0

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public interface UserDao {
<<<<<<< HEAD
    public void SignUp(user user);  //implementation phase1
    public void Login(user user);    //implementation phase1
    public user getUser(String username);
    public void retriveData(user user);

   // public void Logout();
    public ArrayList<user> search();  //implementation phase1
=======
    public void SignUp();  //implementation phase1
    public void Login();
    public void Logout();
    public user search();  //implementation phase1
>>>>>>> 8811055fb541bc0d27c5edf7237993e31ef0c1d0
    public ArrayList<user> showListOfUser();   //implementation phase1
}
