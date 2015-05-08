package data.dao.imp;

import data.dao.UserFuncDao;
import logical.user.message;
import logical.user.user;

import java.util.ArrayList;

/**
 * Created by a on 5/8/15.
 */
public class patientDaoImpl implements UserFuncDao {
    @Override
    public ArrayList<message> readInbox() {
        //liste payamhaye bimar
        return null;
    }

    @Override
    public void SignUp(user user) {
        //save patient to db
    }

    @Override
    public void Login(user user) {

    }

    @Override
    public user getUser(String username) {
        //return patient from db
        return null;
    }

    @Override
    public void retriveData(user user) {
        //find list of messages ..
    }

    @Override
    public ArrayList<user> search() {
        //doctor omoomi motenaseb ba field ha ra miabim
        return null;
    }

    @Override
    public ArrayList<user> showListOfUser() {
        //liste doctorhaye omoomi az db khande va namayesh dade mishavad
        return null;
    }
}
