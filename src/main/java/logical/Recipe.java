package logical;

import data.entities.entityfile.RecipeEntity;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by a on 5/1/15.
 */
public class Recipe {
    public String idOfDoctor;
    public String idOfPatient;
    public Date DateOfCreate;
    public ArrayList<String> medicines;

    public String id;

    public Recipe(String doctor, String patient, Date d, ArrayList<String> medicines){
        idOfDoctor = doctor;
        idOfPatient = patient;
        DateOfCreate = d;
        this.medicines = medicines;
    }


    public Recipe(RecipeEntity rcp){
        idOfDoctor = rcp.getDoctor();
        idOfPatient = rcp.getPatient();
        DateOfCreate = rcp.getDate();
        this.medicines = new ArrayList<String>(Arrays.asList(rcp.getMedicine().split(",")));
    }
    public Recipe() {
    }


//    public Recipe(String idOfDoctor, String idOfPatient, Date dateOfCreate) {
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
