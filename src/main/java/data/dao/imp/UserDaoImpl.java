package data.dao.imp;

import data.dao.UserDao;
import data.entities.entityfile.PatientEntity;
import data.entities.entityfile.UserEntity;
import logical.user.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 5/8/15.
 */
public class UserDaoImpl extends DaoImp implements UserDao {
//    Session  session;
//    SQLQuery query;

//    UserDaoImpl(){
//        Transaction tx = session.beginTransaction();
//
//    }

    @Override
    public void SignUp(User user) {
        //save user in db


    }

    @Override
    public void Login(User user) {

    }

//    @Override
//    public void Login(User user) {
//
//    }

    @Override
    public User getUser(String username) {
        //find user from db and return it as user object
        init();
        List<UserEntity> user = session.createQuery("from UserEntity where myusername = :username")
                .setParameter("username", username).list();


        return new User(user.get(0));
    }




    @Override
    public ArrayList<User> search() {
        return null;
    }

//    @Override
//    public ArrayList<User> showListOfUser() {
//        return null;
//    }


}
