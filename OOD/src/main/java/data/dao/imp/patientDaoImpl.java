package data.dao.imp;

import antlr.debug.MessageAdapter;
import data.dao.PatientDao;
import data.dao.UserFuncDao;
import data.entities.entityfile.MessageEntity;
import data.entities.entityfile.UserEntity;
import logical.Activity;
import logical.Recipe;
import logical.disease;
import logical.user.Message;
import logical.user.PhysicalState;
import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.doctor.ExpertDoctor;
import logical.user.doctor.OrdDoctor;
import logical.user.patient.Patient;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by a on 5/8/15.
 */
public class PatientDaoImpl implements UserFuncDao, PatientDao {

    public static ArrayList<OrdDoctor> getListOfAllOrdDoctor(){
        return null;
    }

    public static ArrayList<OrdDoctor> getListOfOrdDoctor(String name, String familyName){
        return null;
    }

    public static ArrayList<ExpertDoctor> getListOfProDoctor(String name, String familyName){
        return null;
    }
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
    public ArrayList<User> showListOfUser(User user) {
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

    @Override
    public ArrayList<Message> getMessages(User user) {
        return null;
    }

    @Override
    public ArrayList<Doctor> getAllDoctors(Patient p) {
        return null;
    }

    @Override
    public OrdDoctor getOrdDoc(Patient p) {
        return null;
    }

    @Override
    public void addHistory(Patient p, disease d) {

    }

    @Override
    public void addPhysicalState(Patient p, PhysicalState ps) {

    }

    @Override
    public void addRecipe(Patient p, Recipe r) {

    }

    @Override
    public ArrayList<disease> getHistory(Date firstDate, Date secondDate, Patient p) {
        return null;
    }

    @Override
    public ArrayList<Activity> getActivity(Date firstDate, Date secondDate, Patient myPatientProfile) {
        return null;
    }

    @Override
    public void addActivity(Patient myPatientProfile, Activity activity) {

    }

    @Override
    public ArrayList<PhysicalState> getPhysicalState(Date firstDate, Date secondDate, Patient myPatientProfile) {
        return null;
    }
}
