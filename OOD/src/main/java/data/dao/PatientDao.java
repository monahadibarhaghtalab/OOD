package data.dao;

import logical.Activity;
import logical.Recipe;
import logical.disease;
import logical.user.PhysicalState;
import logical.user.doctor.Doctor;
import logical.user.doctor.OrdDoctor;
import logical.user.patient.Patient;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a on 5/1/15.
 */
public interface PatientDao {
    public ArrayList<Doctor> getAllDoctors(Patient p);
    public OrdDoctor getOrdDoc(Patient p);
    public void addHistory(Patient p, disease d);
    public void addPhysicalState(Patient p, PhysicalState ps);
    public void addRecipe(Patient p, Recipe r);
    public ArrayList<disease> getHistory(Date firstDate, Date secondDate, Patient p);
    public  ArrayList<Activity> getActivity(Date firstDate, Date secondDate,Patient myPatientProfile);
    public void addActivity(Patient myPatientProfile, Activity activity);
    public ArrayList<PhysicalState>getPhysicalState(Date firstDate,Date secondDate,Patient myPatientProfile);

}
