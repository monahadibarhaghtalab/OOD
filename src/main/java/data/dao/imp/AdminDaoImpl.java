package data.dao.imp;
import data.context.DatabaseContext;
import data.dao.AdminDao;
import data.dao.UserFuncDao;
import data.entities.entityfile.DoctorEntity;
import data.entities.entityfile.MessageEntity;
import data.entities.entityfile.PatientEntity;
import data.entities.entityfile.UserEntity;


import logical.user.Admin;
import logical.user.Message;
import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 5/1/15.
 */
public class AdminDaoImpl extends  DaoImp implements UserFuncDao, AdminDao {



    @Override
    public void SignUp(User user) {
        //save admin to db
        init();
        UserEntity userEn = new UserEntity(user);
        session.save(userEn);
        tx.commit();
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
        init();
        List<UserEntity> list = session.createQuery("from UserEntity where mytype= :mytype").setParameter("mytype", "admin").list();
        System.out.println("in getUser! " + list.get(0));
        UserEntity temp = list.get(0);
       User user=new User(temp.getMyusername(), temp.getMypassword(), temp.getMyname(), temp.getMyfamilyName(), temp.getId(), temp.getMytype());
        return user;
    }
//


    @Override
    public ArrayList<User> search() {


        return null;
    }

//    @Override
//    public ArrayList<User> showListOfUser(User user) {
//        //get list of all patients from db and return it
//
//        List<UserEntity> list = session.createQuery("from UserEntity").list();
////        ArrayList<User> users = new ArrayList<User>();
////
////        for(int i = 0; i < list.size(); i++){
////            users.add(list.get(i).getUser());
////        }
//        return new ArrayList<User>(list);
//    }

    @Override
    public ArrayList<Message> readInbox(User user) {
//        List<MessageEntity> list = session.createQuery("from MessageEntity where receiver= :receiver").setParameter("receiver", user.getId()).list();
//
//
//        ArrayList<Message> messages = new ArrayList<Message>();
//
//        for(int i = 0; i < list.size(); i++){
//            MessageEntity temp = list.get(i);
//            messages.add(new Message(, temp.getReceiver(), temp.getDateOdCreate(), temp.getContent()));
//        }
//        return new ArrayList<Message>(list);
        return null;
    }

    @Override
    public ArrayList<Message> getMessages(User user) {
        init();
        List<MessageEntity> list = session.createQuery("from MessageEntity where reciver_id= :receiver and mytype = :type").setParameter("receiver", new UserEntity(user)).setParameter("type", 0).list();
    System.out.println(" in dao size list : "+ list.size());
       ArrayList<Message> messages= new ArrayList<Message>();
        for(int i = 0; i < list.size(); i++){
            messages.add(new Message(list.get(i)));
        }
        return messages;
    }

    @Override
    public ArrayList<Message> readInbox() {
        return null;
    }

    @Override
    public Patient searchPatient(String PatientID) {
        init();
        List<UserEntity> list = session.createQuery("from UserEntity where mytype= :mytype and user_id = :myid ").setParameter("mytype", "patient").setParameter("myid", PatientID).list();
//        ArrayList<User> users = new ArrayList<User>();
//mypatient
//        for(int i = 0; i < list.size(); i++){
//            users.add(list.get(i).getUser());
//        }
        return new Patient(list.get(0));
    }


    public  ArrayList<Patient> showListOfAllPatients() {

        Session session;
        Transaction tx;

            session = new DatabaseContext().getSession();
            tx = session.beginTransaction();

        //search patient from db and return it
        List<UserEntity> list = session.createQuery("from UserEntity where mytype= :mytype").setParameter("mytype", "patient").list();
        ArrayList<Patient> users = new ArrayList<Patient>();

        for(int i = 0; i < list.size(); i++){
            users.add(new Patient(list.get(i)));
        }
        return users;
    }

    @Override
    public void addAdmin(User user) {
        init();

        UserEntity useren = new UserEntity(user);
        session.save(useren);

        tx.commit();

    }


    @Override
    public void deleteMsgUserSend(User user) {

        Session session;
        Transaction tx;

        session = new DatabaseContext().getSession();
        tx = session.beginTransaction();

        Query query = session.createQuery("delete MessageEntity where sender_id= :sender and mytype = :type");
        query.setParameter("sender", user.getId()).setParameter("type", 0);
        int result = query.executeUpdate();

        tx.commit();
    }
}
