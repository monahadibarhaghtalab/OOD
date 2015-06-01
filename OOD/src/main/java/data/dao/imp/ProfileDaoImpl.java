package data.dao.imp;

import data.dao.ProfileDao;

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
public class ProfileDaoImpl implements ProfileDao {

    @Override
    public void addHistory(Patient p, disease d) {

    }

    @Override
    public void addPhysicalState(Patient p, PhysicalState ps) {

    }

    @Override
    public void addRecipe(Patient p, Recipe r) {

    }

    @Override
    public ArrayList<disease> getHistory(Date firstDate, Date secondDate, Patient p) {
        return null;
    }

    @Override
    public ArrayList<Activity> getActivity(Date firstDate, Date secondDate, Patient myPatientProfile) {
        return null;
    }

    @Override
    public void addActivity(Patient myPatientProfile, Activity activity) {

    }

    @Override
    public ArrayList<PhysicalState> getPhysicalState(Date firstDate, Date secondDate, Patient myPatientProfile) {
        return null;
    }
}
