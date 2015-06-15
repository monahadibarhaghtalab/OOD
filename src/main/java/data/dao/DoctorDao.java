package data.dao;

import logical.user.Message;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public interface DoctorDao {
    public ArrayList<Patient> showListOfPatient(Doctor doctor);
    public Patient searchPatient(Doctor doctor, String ID);

    public void addPatient(Doctor receiver, String patientId);


    //ArrayList<Message> getMessages(Doctor myDoctor);
    public ArrayList<Patient> showListOfUser(Doctor user);
    ArrayList<Message> getConsults(Doctor myDoctor);

}
