package data.dao;

import logical.user.Message;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a on 5/1/15.
 */
public interface DoctorDao extends UserFuncDao{
    public ArrayList<Patient> showListOfPatient(Doctor doctor);
    public Patient searchPatient(Doctor doctor, String ID);

    public void addPatient(Doctor receiver, String patientId);


    //ArrayList<Message> getMessages(Doctor myDoctor);
    public ArrayList<Patient> showListOfUser(Doctor user);
    ArrayList<Message> getConsults(Doctor myDoctor);
    public ArrayList<Integer>getCountpress(Double firstPre,Double secondPre,Double firstglo,Double secondglo,Date firstDate,Date secondDate);
    public ArrayList<Integer>getCountActivity(Double minglo, Double maxglo,Date firstDate,Date secondDate);
    public ArrayList<Integer>getCountDisease(String name,Date firstDate,Date secondDate);
    public void deleteDoctorPatient(String patientId, String doctorId);
}
