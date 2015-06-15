package data.dao;


import logical.Disease;
import logical.Profile;
import logical.Recipe;
import logical.user.PhysicalState;
import logical.user.patient.Patient;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a on 5/23/15.
 */
public interface ProfileDao {
    public void addHistory(Profile p, Disease d);
    public void addPhysicalState(Profile p, PhysicalState ps);
    public void addRecipe(Patient p, Recipe r);
    public ArrayList<Disease> getHistory(Date firstDate, Date secondDate, Patient p);
}
