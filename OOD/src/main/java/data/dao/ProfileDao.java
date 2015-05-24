package data.dao;


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
    public void addHistory(Profile p, disease d);
    public void addPhysicalState(Profile p, PhysicalState ps);
    public void addRecipe(Patient p, Recipe r);
    public ArrayList<disease> getHistory(Date firstDate, Date secondDate, Profile p);
}
