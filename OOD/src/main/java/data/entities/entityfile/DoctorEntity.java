package data.entities.entityfile;

import logical.user.doctor.Doctor;

import java.util.ArrayList;

/**
 * Created by Mona on 3/14/2015.
 */
public class DoctorEntity {
    Doctor user;
    private ArrayList<PatientEntity> patients;

    public DoctorEntity(Doctor user) {
        this.user = user;
    }

    public ArrayList<PatientEntity> getPatients() {
        return patients;
    }
}
