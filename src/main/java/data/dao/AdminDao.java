package data.dao;

import logical.user.Admin;
import logical.user.Message;
import logical.user.User;
import logical.user.patient.Patient;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public interface AdminDao extends UserFuncDao{
    public ArrayList<Message> readInbox();
   // public Admin getAdmin();
    public Patient searchPatient(String PatientID);
    public  ArrayList<Patient> showListOfAllPatients();

    public void addAdmin(User user);


}
