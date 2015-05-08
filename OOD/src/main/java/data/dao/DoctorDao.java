package data.dao;

import logical.user.doctor.doctor;
import logical.user.patient.patient;
import logical.user.user;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public interface DoctorDao {
    public ArrayList<patient> showListOfPatient(doctor doctor);
    public patient searchPatient(doctor doctor, int ID);

}
