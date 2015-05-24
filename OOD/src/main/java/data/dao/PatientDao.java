package data.dao;

import logical.user.doctor.Doctor;
import logical.user.doctor.OrdDoctor;
import logical.user.patient.Patient;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public interface PatientDao {
    public ArrayList<Doctor> getAllDoctors(Patient p);
    public OrdDoctor getOrdDoc(Patient p);


}
