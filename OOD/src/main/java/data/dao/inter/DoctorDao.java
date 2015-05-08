package data.dao.inter;

import data.entities.entityfile.DoctorEntity;

import java.util.List;

/**
 * Created by Mona on 4/2/2015.
 */
public interface DoctorDao extends UserDao{

    List<DoctorEntity> getListDoctorProf(String prof);
    void savePatient(String Id);

}
