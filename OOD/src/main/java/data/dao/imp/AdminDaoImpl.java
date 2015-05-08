<<<<<<< HEAD
package data.dao.imp;
import data.dao.AdminDao;
import data.dao.UserFuncDao;
import logical.user.admin;
import logical.user.message;
import logical.user.user;

import java.util.ArrayList;
=======
package data.dao;
>>>>>>> 8811055fb541bc0d27c5edf7237993e31ef0c1d0

/**
 * Created by a on 5/1/15.
 */
<<<<<<< HEAD
public class AdminDaoImpl implements UserFuncDao{

    @Override
    public ArrayList<message> readInbox() {
        return null;
    }

    @Override
    public void SignUp(user user) {
        //save admin to db
    }

    @Override
    public void Login(user user) {

    }

    @Override
    public user getUser(String username) {
        //return admin from db
        return null;
    }

    @Override
    public void retriveData(user user) {
        //nothing
    }

    @Override
    public ArrayList<user> search() {
        //search patient from db and return it
        return null;
    }

    @Override
    public ArrayList<user> showListOfUser() {
        //get list of all patients from db and return it
        return null;
    }
=======
public class AdminDaoImpl implements AdminDao {
>>>>>>> 8811055fb541bc0d27c5edf7237993e31ef0c1d0
}
