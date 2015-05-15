package data.dao.imp;

import antlr.debug.MessageAdapter;
import data.dao.UserFuncDao;
import data.entities.entityfile.MessageEntity;
import data.entities.entityfile.UserEntity;
import logical.user.Message;
import logical.user.User;
import logical.user.doctor.Doctor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 5/8/15.
 */
public class PatientDaoImpl extends DaoImp implements UserFuncDao{
    @Override
    public ArrayList<Message> readInbox() {
        //liste payamhaye bimar
        List<MessageEntity> list = session.createSQLQuery("from myMessage").list();
        ArrayList<Message> messageList = new ArrayList<Message>();

        for(int i = 0; i < list.size(); i++){
            messageList.add(list.get(i).getMessage());
        }
        return messageList;
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
        //liste doctorhaye omoomi az db khande va namayesh dade mishavad
        List<UserEntity> list = session.createQuery("from myuser where mytype = :mytype")
                .setParameter("mytype", "General").list();
        ArrayList<User> doctorList = new ArrayList<User>();

        for(int i = 0; i < list.size(); i++){
            doctorList.add(list.get(i).getUser());
        }
        return doctorList;

        return null;
    }

    @Override
    public ArrayList<User> showListOfUser() {
        //liste doctorhaye omoomi az db khande va namayesh dade mishavad
        List<UserEntity> list = session.createQuery("from myuser where mytype = :mytype")
                .setParameter("mytype", "General").list();
        ArrayList<User> doctorList = new ArrayList<User>();

        for(int i = 0; i < list.size(); i++){
            doctorList.add(list.get(i).getUser());
        }
        return doctorList;

    }
}
