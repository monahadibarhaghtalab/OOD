package data.dao;

import data.entities.DoctorEntity;

import java.util.List;

/**
 * Created by Mona on 4/2/2015.
 */
public interface DoctorDao {

    List<DoctorEntity> getListDoctor(String prof);

}
