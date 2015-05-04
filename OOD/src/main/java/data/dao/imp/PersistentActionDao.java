package data.dao.imp;


import data.dao.DoctorDao;
import data.entities.DoctorEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.UUID;

/**
 * Created by root on 2/23/15.
 */
public class PersistentActionDao implements DoctorDao {

    @Override
    public List<DoctorEntity> getListDoctor(String prof) {
        return null;
    }
}
