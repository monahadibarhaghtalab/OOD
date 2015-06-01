package data.dao;


import logical.Activity;
import logical.Profile;
import logical.Recipe;
import logical.disease;
import logical.user.PhysicalState;
import logical.user.patient.Patient;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a on 5/23/15.
 */
public interface ProfileDao {
    public void addHistory(Patient p, disease d);
    public void addPhysicalState(Patient p, PhysicalState ps);
    public void addRecipe(Patient p, Recipe r);
    public ArrayList<disease> getHistory(Date firstDate, Date secondDate, Patient p);
    public  ArrayList<Activity> getActivity(Date firstDate, Date secondDate,Patient myPatientProfile);
    public void addActivity(Patient myPatientProfile, Activity activity);
    public ArrayList<PhysicalState>getPhysicalState(Date firstDate,Date secondDate,Patient myPatientProfile);
}
