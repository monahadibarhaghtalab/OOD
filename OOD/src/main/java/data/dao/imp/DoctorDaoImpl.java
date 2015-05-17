package data.dao.imp;
import data.dao.*;
import data.entities.entityfile.DoctorEntity;
import data.entities.entityfile.MessageEntity;
import data.entities.entityfile.PatientEntity;
import data.entities.entityfile.UserEntity;
import logical.user.doctor.Doctor;
import logical.user.Message;
import logical.user.patient.Patient;
import logical.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 5/1/15.
 */
public class DoctorDaoImpl extends DaoImp implements UserFuncDao, DoctorDao {

//    Session session;
//    Transaction tx;
//
//    public DoctorDaoImpl(){
//        session = new DatabaseContext().getSession();
//        tx = session.beginTransaction();
//    }


    @Override
    public void SignUp(User user) {
        //save doctor into db

    }

    @Override
    public void Login(User user) {

    }

    @Override
    public User getUser(String username) {

        //return doctor

        List<UserEntity> list = session.createSQLQuery("from myuser where myusername= :myusername").setParameter("myusername", username).list();

        return list.get(0).getUser();

    }

    @Override
    public void retriveData(User user) {
        //find message list
        //find consultation list
        //find patient list
    }

    @Override
    public ArrayList<User> search() {
        //nothing
        return null;
    }

    @Override
    public ArrayList<User> showListOfUser() {
        //nothing
        return null;
    }

    @Override
    public ArrayList<Patient> showListOfPatient(Doctor doctor) {
        //liste bimaran pezash az db khande return mishavad
        String id = doctor.getId();
        List<DoctorEntity> listDoctor = session.createSQLQuery("from mydoctor where doctor_id= :myid").setParameter("myid", id).list();
        ArrayList<PatientEntity> patientsEn = listDoctor.get(0).getPatients();
        ArrayList<Patient> patients = new ArrayList<Patient>();
        for(int i = 0; i < patientsEn.size(); i++){
            patients.add(patientsEn.get(i).getPatient());
        }

        return patients;


    }

    @Override
    public Patient searchPatient(Doctor doctor, String ID) {
        //bimar ba code melli ID az db khande shode return mishavad
        String id = doctor.getId();
        List<DoctorEntity> listDoctor = session.createSQLQuery("from mydoctor where doctor_id= :myid").setParameter("myid", id).list();

        ArrayList<PatientEntity> patientsEn = listDoctor.get(0).getPatients();
        //ArrayList<Patient> patients = new ArrayList<Patient>();
        for(int i = 0; i < patientsEn.size(); i++){
            String pID = patientsEn.get(i).getId();
            if(pID.equals(ID)){
                return patientsEn.get(i).getPatient();
            }
        }

        return null;
    }

    @Override
    public void addPatient(Doctor receiver, Patient sender) {
        List<PatientEntity> patient = session.createSQLQuery("from mypatient where patient_id= :myid").setParameter("myid", sender.getId()).list();
        List<DoctorEntity> doctor= session.createSQLQuery("from mydoctor where doctor_id= :myid").setParameter("myid", receiver.getId()).list();;
        doctor.get(0).addPatients(patient.get(0));
    }

    //maybe should change
    @Override
    public ArrayList<Message> readInbox(User user) {
        List<MessageEntity> list = session.createSQLQuery("from mymessage where receiver= :receiver").setParameter("receiver", user.getId()).list();
        ArrayList<Message> messages = new ArrayList<Message>();

        for(int i = 0; i < list.size(); i++){
            messages.add(list.get(i).getMessage());
        }
        return messages;
    }
}
