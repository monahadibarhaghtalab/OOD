package data.dao.imp;
import data.context.DatabaseContext;
import data.dao.*;
import data.entities.entityfile.*;
import logical.user.doctor.Doctor;
import logical.user.Message;
import logical.user.patient.Patient;
import logical.user.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        init();
        DoctorEntity doctor = new DoctorEntity(new Doctor(user, user.getMytype()));
        session.save(doctor);
        System.out.println("in sign up!!!! &&&&&&& doctor!!! *****");
        tx.commit();
        deleteMsgUserSend(user);

    }

    @Override
    public void Login(User user) {

    }

    @Override
    public User getUser(String username) {

        //return doctor
        init();
        List<UserEntity> list = session.createQuery("from UserEntity where myusername= :myusername").setParameter("myusername", username).list();
        List<DoctorEntity> doctor = session.createQuery("from DoctorEntity where doctor_id= :id").setParameter("id", list.get(0).getId()).list();
        return new Doctor(list.get(0), doctor.get(0).getTypeDoctor());

    }



    @Override
    public ArrayList<User> search() {
        //nothing
        return null;
    }

    @Override
    public ArrayList<Patient> showListOfUser(Doctor doctor) {
        //nothing

        return null;
    }

    @Override
    public ArrayList<Patient> showListOfPatient(Doctor doctor) {
        //liste bimaran pezash az db khande return mishavad
        init();
        String id = doctor.getId();
        List<DoctorEntity> listDoctor = session.createQuery("from DoctorEntity where doctor_id= :myid").setParameter("myid", id).list();
        System.out.println("list doctor in show listOfPatient id:" + listDoctor.get(0).getId());
        List<PatientEntity> patientsEn = listDoctor.get(0).getPatients();
        System.out.println("list patient in show listOfPatient size:" + patientsEn.size());
        ArrayList<Patient> patients = new ArrayList<Patient>();
        for(int i = 0; i < patientsEn.size(); i++){
            List<UserEntity> user = session.createQuery("from UserEntity where user_id= :myid").setParameter("myid", patientsEn.get(i).getId()).list();
            patients.add(new Patient(user.get(0)));
        }

        return patients;


    }

    @Override
    public Patient searchPatient(Doctor doctor, String ID) {
        //bimar ba code melli ID az db khande shode return mishavad
        init();
        String id = doctor.getId();
        List<DoctorEntity> listDoctor = session.createQuery("from DoctorEntity where doctor_id= :myid").setParameter("myid", id).list();

        List<PatientEntity> patientsEn = listDoctor.get(0).getPatients();
        //ArrayList<Patient> patients = new ArrayList<Patient>();
        for(int i = 0; i < patientsEn.size(); i++){
            String pID = patientsEn.get(i).getId();
            if(pID.equals(ID)){
                List<UserEntity> user = session.createQuery("from UserEntity where user_id= :myid").setParameter("myid", ID).list();
                return new Patient(user.get(0));
            }
        }

        return null;
    }

    @Override
    public void addPatient(Doctor receiver, String patientId) {
        init();
        System.out.println("patient id input : " + patientId);
        List<PatientEntity> patient = session.createQuery("from PatientEntity where patient_id= :myid").setParameter("myid", patientId).list();
        System.out.println("patient id: " + patient.get(0).getId());
        List<DoctorEntity> doctor= session.createQuery("from DoctorEntity where doctor_id= :myid").setParameter("myid", receiver.getId()).list();
        System.out.println("doctor id: " + doctor.get(0).getId());
//        doctor.get(0).addPatients(patient.get(0));
        List<DoctorEntity> drTemp = patient.get(0).getDoctors();
        drTemp.add(doctor.get(0));
        session.update(patient.get(0));
        tx.commit();

        deleteMsgUserRec(receiver);
    }




    @Override
    public ArrayList<Message> getConsults(Doctor myDoctor) {
        init();
        List<MessageEntity> list = session.createQuery("from MessageEntity where reciver_id= :receiver and mytype = :type").setParameter("receiver", new UserEntity(myDoctor)).setParameter("type", 1).list();
        ArrayList<Message> messages = new ArrayList<Message>();

        for(int i = 0; i < list.size(); i++){
            messages.add(new Message(list.get(i)));
        }
        return messages;
    }

    @Override
    public ArrayList<Integer> getCountpress(Double firstPre, Double secondPre, Double firstglo, Double secondglo, Date firstDate, Date secondDate) {
        init();
        ArrayList<Integer> result = new ArrayList<Integer>();

        int num = numMonth(firstDate, secondDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(firstDate);
        int month = cal.get(Calendar.MONTH)+ 1;
        int year = cal.get(Calendar.YEAR);

        for(int i = 0; i < num; i++){
            int numPer = 0;
            List<PhysicalStateEntity> phs = session.createQuery("from PhysicalStateEntity where mypressure >= :firstPre and mypressure <= :secondPre " +
                    "and myglycemia >= :firstglo and  myglycemia <= :secondglo " +
                    "and month(mydate) = :monthDate and year(mydate) = :yearDate")
                    .setParameter("firstPre", firstPre).setParameter("secondPre", secondPre).
                            setParameter("firstglo", firstglo).setParameter("secondglo", secondglo).
                            setParameter("monthDate", (month + i)%12).setParameter("yearDate", year + (month + i)/12).list();

            numPer = phs.size();

            result.add(numPer);
        }
        return result;
    }

    @Override
    public ArrayList<Integer> getCountActivity(Double minglo, Double maxglo, Date firstDate, Date secondDate) {
        init();
        ArrayList<Integer> result = new ArrayList<Integer>();

        int num = numMonth(firstDate, secondDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(firstDate);
        int month = cal.get(Calendar.MONTH)+ 1;
        int year = cal.get(Calendar.YEAR);

        for(int i = 0; i < num; i++){
            int numPer = 0;
            List<ActivityEntity> phs = session.createQuery("from ActivityEntity where mycalory >= :minglo and mycalory <= :maxglo " +
                    "and month(mydate) = :monthDate and year(mydate) = :yearDate")
                    .setParameter("minglo", minglo).setParameter("maxglo", maxglo).
                            setParameter("monthDate", (month + i)%12).setParameter("yearDate", year+ (month + i)/12).list();

            numPer = phs.size();

            result.add(numPer);
        }
        return result;
    }

    @Override
    public ArrayList<Integer> getCountDisease(String name, Date firstDate, Date secondDate) {
        init();
        ArrayList<Integer> result = new ArrayList<Integer>();

        int num = numMonth(firstDate, secondDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(firstDate);
        int month = cal.get(Calendar.MONTH)+ 1;
        int year = cal.get(Calendar.YEAR);

        for(int i = 0; i < num; i++){
            int numPer = 0;
            List<DiseaseEntity> phs = session.createQuery("from DiseaseEntity where myname = :name " +
                    "and month(mydate) = :monthDate and year(mydate) = :yearDate")
                    .setParameter("name", name).
                            setParameter("monthDate", (month + i)%12).setParameter("yearDate", year + (month + i)/12).list();

            numPer = phs.size();

            result.add(numPer);
        }
        return result;
    }

    @Override
    public void deleteDoctorPatient(String patientId, String doctorId) {
        init();

        List<PatientEntity> patient = session.createQuery("from PatientEntity where patient_id= :myid").setParameter("myid", patientId).list();
        List<DoctorEntity> doctor= session.createQuery("from DoctorEntity where doctor_id= :myid").setParameter("myid", doctorId).list();

        List<DoctorEntity> drTemp = patient.get(0).getDoctors();
        drTemp.remove(doctor.get(0));
        session.update(patient.get(0));
        tx.commit();


    }


    @Override
    public ArrayList<Message> getMessages(User user) {
        init();
        List<MessageEntity> list = session.createQuery("from MessageEntity where reciver_id= :receiver and mytype = :type").setParameter("receiver", user.getId()).setParameter("type", 0).list();
        ArrayList<Message> messages = new ArrayList<Message>();

        for(int i = 0; i < list.size(); i++){
            messages.add(new Message(list.get(i)));
        }
        return messages;
    }


    //maybe should change
    @Override
    public ArrayList<Message> readInbox(User user) {
        List<MessageEntity> list = session.createQuery("from MessageEntity where receiver= :receiver").setParameter("receiver", user.getId()).list();
//        ArrayList<Message> messages = new ArrayList<Message>();
//
//        for(int i = 0; i < list.size(); i++){
//            messages.add(list.get(i).getMessage());
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

    }

    public void deleteMsgUserRec(User user) {

        Session session;
        Transaction tx;

        session = new DatabaseContext().getSession();
        tx = session.beginTransaction();

        Query query = session.createQuery("delete MessageEntity where reciver_id= :rec and mytype = :type");
        query.setParameter("rec", user.getId()).setParameter("type", 0);
        int result = query.executeUpdate();

        tx.commit();

    }

    public int numMonth(Date first, Date second){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(first);
        int year1 = cal1.get(Calendar.YEAR);
        int month1 = cal1.get(Calendar.MONTH);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(second);
        int year2 = cal2.get(Calendar.YEAR);
        int month2 = cal2.get(Calendar.MONTH);

        return (year2 - year1) * 12 + (month2 - month1) + 1;


    }

    public Date makeDate(Date first, int numMonth){

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(first);
        int year = cal1.get(Calendar.YEAR);
        int month = cal1.get(Calendar.MONTH)+ numMonth;
        int day = cal1.get(Calendar.DAY_OF_MONTH);

        String date = year + "/" + month + "/" + day;
        Date utilDate = null;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            utilDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("utilDate:" + utilDate);
        return utilDate;
    }
}
