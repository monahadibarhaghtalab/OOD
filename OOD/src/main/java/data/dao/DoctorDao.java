package data.dao;

import logical.user.doctor.Doctor;
import logical.user.patient.Patient;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public interface DoctorDao {
    public ArrayList<Patient> showListOfPatient(Doctor doctor);
    public Patient searchPatient(Doctor doctor, String ID);

}
