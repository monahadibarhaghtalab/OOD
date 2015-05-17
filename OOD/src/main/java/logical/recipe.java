package logical;

import logical.user.doctor.Doctor;
import logical.user.patient.Patient;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a on 5/1/15.
 */
public class Recipe {
    public Doctor NameOfDoctor;
    public Patient NameOfPatient;
    public Date DateOfCreate;
    public ArrayList<String> medicines;

    public Recipe(Doctor doctor, Patient patient, Date d){
        NameOfDoctor = doctor;
        NameOfPatient = patient;
        DateOfCreate = d;
        medicines = new ArrayList<String>();

    }

    public ArrayList<String> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<String> medicines) {
        this.medicines = medicines;
    }
    public  void addMedicine(String medicine){
        medicines.add(medicine);
    }
}
