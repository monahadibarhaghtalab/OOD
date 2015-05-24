package logical;

import logical.user.doctor.Doctor;
import logical.user.patient.Patient;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a on 5/1/15.
 */
@MappedSuperclass
public class Recipe {
    public Doctor NameOfDoctor;
    public Patient NameOfPatient;
    public Date DateOfCreate;
    public ArrayList<String> medicines;

    public String id;

    public Recipe(Doctor doctor, Patient patient, Date d){
        NameOfDoctor = doctor;
        NameOfPatient = patient;
        DateOfCreate = d;
     //   this.medicines = medicines;

    }

    public Recipe() {
    }

    @Id
    @Column(name = "id" )
    public String getId() {
        return id;
    }


    public void setId(String id) {
        //  System.out.println(id +"IIIIIIIIIIIID");
        this.id = id;
    }

//
//    public Recipe(String username, String username1, Date date) {
//    }

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
