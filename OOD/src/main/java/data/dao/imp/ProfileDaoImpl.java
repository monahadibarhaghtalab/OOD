package data.dao.imp;

import data.dao.ProfileDao;

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
    public void addHistory(Profile p, disease d) {

    }

    @Override
    public void addPhysicalState(Profile p, PhysicalState ps) {

    }

    @Override
    public void addRecipe(Patient p, Recipe r) {

    }

    @Override
    public ArrayList<disease> getHistory(Date firstDate, Date secondDate, Profile p) {
        return null;
    }
}
