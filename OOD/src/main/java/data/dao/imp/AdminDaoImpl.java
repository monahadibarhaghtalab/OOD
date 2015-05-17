package data.dao.imp;
import data.dao.UserFuncDao;
import data.entities.entityfile.DoctorEntity;
import data.entities.entityfile.MessageEntity;
import data.entities.entityfile.PatientEntity;
import data.entities.entityfile.UserEntity;

import logical.user.Message;
import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 5/1/15.
 */
public class AdminDaoImpl extends  DaoImp implements UserFuncDao{



    @Override
    public void SignUp(User user) {
        //save admin to db
        if(user instanceof Doctor){
            DoctorEntity doctor = new DoctorEntity((Doctor) user);
            session.save(doctor);
        }
        else if(user instanceof Patient){
            PatientEntity patient = new PatientEntity((Patient) user);
            session.save(patient);
        }
    //    else if(User instace of drugstore ) for drug store


    }

    @Override
    public void Login(User User) {



    }



    @Override
    public User getUser(String Username) {
        //return admin from db
        List<UserEntity> list = session.createSQLQuery("from myuser where mytype= :mytype").setParameter("mytype", "admin").list();

        return list.get(0).getUser();
    }
//
    @Override
    public void retriveData(User User) {
        //nothing
    }

    @Override
    public ArrayList<User> search() {
        //search patient from db and return it
        List<UserEntity> list = session.createSQLQuery("from myuser where mytype= :mytype").setParameter("mytype", "patient").list();
        ArrayList<User> users = new ArrayList<User>();

        for(int i = 0; i < list.size(); i++){
            users.add(list.get(i).getUser());
        }
        return users;

    }

    @Override
    public ArrayList<User> showListOfUser() {
        //get list of all patients from db and return it

        List<UserEntity> list = session.createSQLQuery("from myuser").list();
        ArrayList<User> users = new ArrayList<User>();

        for(int i = 0; i < list.size(); i++){
            users.add(list.get(i).getUser());
        }
        return users;
    }

    @Override
    public ArrayList<Message> readInbox(User user) {
        List<MessageEntity> list = session.createSQLQuery("from mymessage where reciver= :reciver").setParameter("reciver", user.getId()).list();
        ArrayList<Message> messages = new ArrayList<Message>();

        for(int i = 0; i < list.size(); i++){
            messages.add(list.get(i).getMessage());
        }
        return messages;
    }
}
