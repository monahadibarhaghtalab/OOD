package data.dao.imp;


import data.context.DatabaseContext;
import data.dao.PatientDao;
import data.dao.UserFuncDao;
import data.entities.entityfile.*;
import logical.Activity;
import logical.Disease;
import logical.Recipe;
import logical.user.Message;
import logical.user.PhysicalState;
import logical.user.User;
import logical.user.doctor.Doctor;

import logical.user.doctor.ExpertDoctor;
import logical.user.doctor.OrdDoctor;

import logical.user.patient.Patient;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by a on 5/8/15.
 */

public class PatientDaoImpl extends DaoImp implements UserFuncDao, PatientDao {



    @Override
    public void SignUp(User user) {
        //save patient to db
        init();
        PatientEntity patient = new PatientEntity(new Patient(user));
        session.save(patient);
        System.out.println("in sign up!!!! &&&&&&& patient!!! *****");
        tx.commit();

        deleteMsgUserSend(user);


    }



    @Override
    public void Login(User user) {

    }

    @Override
    public User getUser(String username) {
        //return patient from db
        init();
        List<UserEntity> list = session.createQuery("from UserEntity where myusername= :myusername").setParameter("myusername", username).list();

        return new Patient(list.get(0));


    }


    @Override
    public ArrayList<User> search() {
        //doctor omoomi motenaseb ba field ha ra miabim
        //liste doctorhaye omoomi az db khande va namayesh dade mishavad
//        List<UserEntity> list = session.createQuery("from UserEntity where mytype = :mytype")
//                .setParameter("mytype", "General").list();

        return null;

    }

//    @Override
//    public ArrayList<User> showListOfUser() {
//        //liste doctorhaye omoomi az db khande va namayesh dade mishavad
//        List<UserEntity> list = session.createQuery("from UserEntity where mytype = :mytype")
//                .setParameter("mytype", "General").list();
////        ArrayList<User> doctorList = new ArrayList<User>();
////
////        for(int i = 0; i < list.size(); i++){
////            doctorList.add(list.get(i).getUser());
////        }
//        return new ArrayList<User>(list);
//
//
//    }




    @Override
    public ArrayList<Doctor> getAllDoctors(Patient p) {
        init();
        List<PatientEntity> list = session.createQuery("from PatientEntity where patient_id = :id")
                .setParameter("id", p.getId()).list();
        List<DoctorEntity> doctors = list.get(0).getDoctors();
        ArrayList<Doctor> dr = new ArrayList<Doctor>();
        for(int i = 0; i < doctors.size(); i++){
            List<UserEntity> user = session.createQuery("from UserEntity where user_id= :myid").setParameter("myid", doctors.get(i).getId()).list();
            dr.add(new Doctor(user.get(0), doctors.get(i).getTypeDoctor()));
        }
        return  dr;
    }

    @Override
    public OrdDoctor getOrdDoc(Patient p)
    {
        init();
        List<PatientEntity> list = session.createQuery("from PatientEntity  where patient_id = :id")
                .setParameter("id", p.getId()).list();

        List<DoctorEntity> doctors = list.get(0).getDoctors();

        for(int i = 0; i <doctors.size(); i++){
            if(doctors.get(i).getTypeDoctor().equals("General")){
                DoctorEntity dr = doctors.get(i);
                List<UserEntity> user = session.createQuery("from UserEntity where user_id= :myid").setParameter("myid", dr.getId()).list();
                return new OrdDoctor(user.get(0));
            }
        }
        return null;
    }

//    @Override
//    public void addHistory(Patient p, Disease d) {
//
//    }

    @Override
    public void addPhysicalState(Patient p, PhysicalState ps) {
        init();
        System.out.println("in physical state@@@@@@");
        PhysicalStateEntity phy = new PhysicalStateEntity(ps);
        session.save(phy);
        tx.commit();
//        List<PatientEntity> patient = session.createQuery("from PatientEntity where patient_id = :myid")
//                .setParameter("myid", myPatientProfile.getId()).list();
//        patient.get(0). addAct(act);

    }

    @Override
    public ArrayList<Message> getMessages(User user) {
        init();
        List<MessageEntity> list =session.createQuery("from MessageEntity where reciver_id= :receiver ").setParameter("receiver", new UserEntity(user)).list();
        ArrayList<Message> messages = new ArrayList<Message>();

        for(int i = 0; i < list.size(); i++){
            messages.add(new Message(list.get(i)));
        }
        return messages;
    }

    public  ArrayList<OrdDoctor> getListOfAllOrdDoctor() {

        Session session;
        Transaction tx;

        session = new DatabaseContext().getSession();
        tx = session.beginTransaction();

        List<DoctorEntity> list = session.createQuery("from DoctorEntity where typeDoctor = :mytype")
                .setParameter("mytype", "General").list();

        ArrayList<OrdDoctor> ordDr = new ArrayList<OrdDoctor>();
        for(int i = 0; i < list.size(); i++){
            List<UserEntity> user = session.createQuery("from UserEntity where user_id= :myid").setParameter("myid", list.get(i).getId()).list();
            ordDr.add(new OrdDoctor(user.get(0)));
        }

        return ordDr;
    }

    public  ArrayList<OrdDoctor> getListOfOrdDoctor(String text, String text1) {

        Session session;
        Transaction tx;

        session = new DatabaseContext().getSession();
        tx = session.beginTransaction();

        List<DoctorEntity> list = session.createQuery("from DoctorEntity where typeDoctor = :mytype")
                .setParameter("mytype", "General").list();

        ArrayList<OrdDoctor> ordDr = new ArrayList<OrdDoctor>();
        for(int i = 0; i < list.size(); i++){
            List<UserEntity> user = session.createQuery("from UserEntity where user_id= :myid").setParameter("myid", list.get(i).getId()).list();
            if(user.get(0).getMyname().equals(text) &&  user.get(0).getMyfamilyName().equals(text1)){
                ordDr.add(new OrdDoctor(user.get(0)));
            }

        }

        return ordDr;
    }


    public  ArrayList<ExpertDoctor> getListOfProDoctor(String text, String text1) {

        Session session;
        Transaction tx;

        session = new DatabaseContext().getSession();
        tx = session.beginTransaction();

        List<DoctorEntity> list = session.createQuery("from DoctorEntity where typeDoctor = :mytype")
                .setParameter("mytype", "Spec").list();

        ArrayList<ExpertDoctor> ordDr = new ArrayList<ExpertDoctor>();
        for(int i = 0; i < list.size(); i++){
            List<UserEntity> user = session.createQuery("from UserEntity where user_id= :myid").setParameter("myid", list.get(i).getId()).list();
            if(user.get(0).getMyname().equals(text) &&  user.get(0).getMyfamilyName().equals(text1)){
                ordDr.add(new ExpertDoctor(user.get(0)));
            }

        }

        return ordDr;
    }

    @Override
    public ArrayList<Message> readInbox(User user) {
        //liste payamhaye bimar
        List<MessageEntity> list = session.createQuery("from MessageEntity").list();
//        ArrayList<Message> messageList = new ArrayList<Message>();
//
//        for(int i = 0; i < list.size(); i++){
//            messageList.add(list.get(i).getMessage());
//        }
        return null;

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
        System.out.println("after delete patient");
    }

    public void addRecipe(Patient PatientEntity, Recipe r) {
        RecipeEntity rc = new RecipeEntity(r);
        init();
        session.save(rc);
        tx.commit();
//        List<PatientEntity> patient = session.createQuery("from PatientEntity where patient_id = :myid")
//                .setParameter("myid", PatientEntity.getId()).list();
//        patient.get(0). addRcp(rc);


    }

    @Override
    public ArrayList<Disease> getHistory(Date firstDate, Date secondDate, Patient p) {

        init();
        List<PatientEntity> patient = session.createQuery("from PatientEntity where patient_id = :myid")
                .setParameter("myid", p.getId()).list();

        List<DiseaseEntity> phs = session.createQuery("from DiseaseEntity where patient_id = :myid and mydate <= :secDate and mydate >= :frDate")
                .setParameter("myid", patient.get(0).getId()).setParameter("secDate", secondDate).setParameter("frDate", firstDate).list();

        ArrayList<Disease> dis = new ArrayList<Disease>();
        for(int i = 0; i < phs.size(); i++){
            dis.add(new Disease(phs.get(i)));
        }
        return dis;
    }

    @Override
    public ArrayList<Activity> getActivity(Date firstDate, Date secondDate, Patient myPatientProfile)
    {
        init();
        List<PatientEntity> patient = session.createQuery("from PatientEntity where patient_id = :myid")
                .setParameter("myid", myPatientProfile.getId()).list();

        List<ActivityEntity> phs = session.createQuery("from ActivityEntity where patient_id = :myid and mydate <= :secDate and mydate >= :frDate")
                .setParameter("myid", patient.get(0).getId()).setParameter("secDate", secondDate).setParameter("frDate", firstDate).list();

        ArrayList<Activity> act = new ArrayList<Activity>();
        for(int i = 0; i < phs.size(); i++){
            act.add(new Activity(phs.get(i)));
        }
        return act;
    }

    @Override
    public void addActivity(Patient myPatientProfile, Activity activity) {
        init();
        ActivityEntity act = new ActivityEntity(activity);
        session.save(act);
        tx.commit();
//        List<PatientEntity> patient = session.createQuery("from PatientEntity where patient_id = :myid")
//                .setParameter("myid", myPatientProfile.getId()).list();
//        patient.get(0). addAct(act);

    }

    @Override
    public ArrayList<PhysicalState> getPhysicalState(Date firstDate, Date secondDate, Patient myPatient) {
        init();
        List<PatientEntity> patient = session.createQuery("from PatientEntity where patient_id = :myid")
                .setParameter("myid", myPatient.getId()).list();

        List<PhysicalStateEntity> phs = session.createQuery("from PhysicalStateEntity where patient_id = :myid and mydate <= :secDate and mydate >= :frDate")
                .setParameter("myid", patient.get(0).getId()).setParameter("secDate", secondDate).setParameter("frDate", firstDate).list();

        ArrayList<PhysicalState> act = new ArrayList<PhysicalState>();
        for(int i = 0; i < phs.size(); i++){
            act.add(new PhysicalState(phs.get(i)));
        }
        return act;
    }

    @Override
    public Patient getPatientByID(String Id) {
        init();
        List<UserEntity> patient = session.createQuery("from UserEntity where user_id = :myid")
                .setParameter("myid",Id).list();
        return new Patient(patient.get(0));
    }

    public void addHistory(Patient p, Disease disease) {
//        List<PatientEntity> patient = session.createQuery("from PatientEntity where patient_id = :myid")
//                .setParameter("myid", p.getId()).list();
        init();
        DiseaseEntity dis = new DiseaseEntity(disease);
        session.saveOrUpdate(dis);
        tx.commit();

    }

    public Doctor findOrdDoctor(Patient p) {
        init();
        String id = p.getId();
        List<PatientEntity> list = session.createQuery("from PatientEntity where patient_id = :myid")
                .setParameter("myid", id).list();
        List<DoctorEntity> doctors = list.get(0).getDoctors();
        for (int i = 0; i < doctors.size(); i++){
            DoctorEntity doctor = doctors.get(i);
            if(doctor.getTypeDoctor().equals("General")){
                List<UserEntity> user = session.createQuery("from UserEntity where user_id= :myid").setParameter("myid", doctor.getId()).list();
                return new OrdDoctor(user.get(0));
            }
        }

        return null;
    }
}
