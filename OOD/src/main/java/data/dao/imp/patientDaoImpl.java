package data.dao.imp;

import data.dao.UserFuncDao;
import logical.user.Message;
import logical.user.User;

import java.util.ArrayList;

/**
 * Created by a on 5/8/15.
 */
public class patientDaoImpl implements UserFuncDao {
    @Override
    public ArrayList<Message> readInbox() {
        //liste payamhaye bimar
        return null;
    }

    @Override
    public void SignUp(User user) {
        //save patient to db
    }

    @Override
    public void Login(User user) {

    }

    @Override
    public User getUser(String username) {
        //return patient from db
        return null;
    }

    @Override
    public void retriveData(User user) {
        //find list of messages ..
    }

    @Override
    public ArrayList<User> search() {
        //doctor omoomi motenaseb ba field ha ra miabim
        return null;
    }

    @Override
    public ArrayList<User> showListOfUser() {
        //liste doctorhaye omoomi az db khande va namayesh dade mishavad
        return null;
    }
}
