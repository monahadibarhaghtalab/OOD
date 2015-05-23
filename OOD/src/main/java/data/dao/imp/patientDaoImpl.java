package data.dao.imp;

import data.dao.UserFuncDao;
import data.entities.entityfile.*;
import logical.Disease;
import logical.Recipe;
import logical.user.Message;
import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 5/8/15.
 */
public class PatientDaoImpl extends DaoImp implements UserFuncDao{


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

        List<UserEntity> list = session.createSQLQuery("from myuser where myusername= :myusername").setParameter("myusername", username).list();

        return list.get(0).getUser();

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
    public ArrayList<Message> readInbox(User user) {
        //liste payamhaye bimar
        List<MessageEntity> list = session.createSQLQuery("from myMessage").list();
        ArrayList<Message> messageList = new ArrayList<Message>();

        for(int i = 0; i < list.size(); i++){
            messageList.add(list.get(i).getMessage());
        }
        return messageList;

    }

    public void addRecipe(Patient mypatient, Recipe r) {
        RecipeEntity rc = new RecipeEntity(r);
        session.save(r);
        List<PatientEntity> patient = session.createQuery("from mypatient where patient_id = :myid")
                .setParameter("myid", mypatient.getId()).list();
        patient.get(0). addRec(rc);


    }

    public void addHistory(Patient p, String hist) {
        List<PatientEntity> patient = session.createQuery("from mypatient where patient_id = :myid")
                .setParameter("myid", p.getId()).list();
        patient.get(0). addHistory(hist);

    }

    public Doctor findOrdDoctor(Patient p) {

        String id = p.getId();
        List<PatientEntity> list = session.createQuery("from mypatient where patient_id = :myid")
                .setParameter("myid", id).list();
        ArrayList<DoctorEntity> doctors = list.get(0).getDoctors();
        for (int i = 0; i < doctors.size(); i++){
            DoctorEntity doctor = doctors.get(i);
            if(doctor.getTypeDoctor().equals("General")){
                return new Doctor(doctor.getUsername(), doctor.getPassword(), doctor.getName(), doctor.getFamilyName(), doctor.getId(), "General");
            }
        }
        return null;
    }
}
