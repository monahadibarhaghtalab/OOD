package data.entities.entityfile;

import logical.user.doctor.Doctor;
import logical.user.patient.Patient;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mona on 3/14/2015.
 */
public class PrescriptionEntity {

    public Doctor NameOfDoctor;
    public Patient NameOfPatient;
    public Date DateOfCreate;
    public ArrayList<String> medicines;


}
