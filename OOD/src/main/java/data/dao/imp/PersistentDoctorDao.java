package data.dao.imp;


import data.context.DatabaseContext;
import data.dao.inter.DoctorDao;
import data.entities.entityfile.DoctorEntity;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by root on 2/23/15.
 */
public class PersistentDoctorDao implements DoctorDao {

    @Override
    public List<DoctorEntity> getListDoctorProf(String prof) {
         return new DatabaseContext()
                 .getSession()
                 .createCriteria(DoctorEntity.class)
                 .add(Restrictions.eq("idCode", userId))
                 .list();
    }

    @Override
    public void savePatient(String Id) {

    }
}
