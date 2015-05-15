package data.dao.imp;
import data.context.DatabaseContext;
import data.dao.UserFuncDao;
import data.entities.entityfile.DoctorEntity;
import data.entities.entityfile.MessageEntity;
import data.entities.entityfile.PatientEntity;
import data.entities.entityfile.UserEntity;

import logical.user.Message;
import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by a on 5/1/15.
 */
public class AdminDaoImpl extends  DaoImp implements UserFuncDao{

//    Session session;
//    Transaction tx;
//
//    public AdminDaoImpl(){
//        session = new DatabaseContext().getSession();
//        tx = session.beginTransaction();
//    }

    @Override
    public ArrayList<Message> readInbox() {

//
//        SQLQuery query = session.createSQLQuery( "from MessageEntity where username = :username")
//                .setParameter("username", username).list());
//        List<Object[]> rows = query.list();
//        for(Object[] row : rows){
//            MessageEntity msg = new MessageEntity();
//            msg.setSenderId(UUID.fromString(row[0].toString()));
//            msg.setReceiverId(UUID.fromString(row[1].toString()));
//            msg.content(row[2].toString());
//            System.out.println(msg);
//        }



        return null;
    }

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
        return null;
    }
//
    @Override
    public void retriveData(User User) {
        //nothing
    }

    @Override
    public ArrayList<User> search() {
        //search patient from db and return it
        List<UserEntity> list = session.createSQLQuery("from myMessage where mytype= :mytype").setParameter("mytype", "patient").list();
        ArrayList<User> users = new ArrayList<User>();

        for(int i = 0; i < list.size(); i++){
            users.add(list.get(i).getUser());
        }
        return users;

    }

    @Override
    public ArrayList<User> showListOfUser() {
        //get list of all patients from db and return it

        List<UserEntity> list = session.createSQLQuery("from myUser").list();
        ArrayList<User> users = new ArrayList<User>();

        for(int i = 0; i < list.size(); i++){
            users.add(list.get(i).getUser());
        }
        return users;
    }
}
