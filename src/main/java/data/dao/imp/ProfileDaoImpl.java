package data.dao.imp;

import data.dao.ProfileDao;

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
public class ProfileDaoImpl implements ProfileDao {

    @Override
    public void addHistory(Profile p, Disease d) {

    }

    @Override
    public void addPhysicalState(Profile p, PhysicalState ps) {

    }

    @Override
    public void addRecipe(Patient p, Recipe r) {

    }

    @Override
    public ArrayList<Disease> getHistory(Date firstDate, Date secondDate, Patient p) {
        return null;
    }
}
