package data.entities.entityfile;

import logical.Recipe;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mona on 3/14/2015.
 */
@Table(name = "myrecipe")
@Entity
@AttributeOverride(name = "id", column = @Column(name = "recipe_id"))
public class RecipeEntity extends Recipe{


    public Doctor doctor;
    public Patient patient;
    public Date DateOfCreate;
    public ArrayList<String> medicines;


    public RecipeEntity(Recipe rcp) {
        super(rcp.NameOfDoctor, rcp.NameOfPatient, rcp.DateOfCreate);
    }



    @ManyToOne
    @JoinColumn(name = "doctor_id" , nullable = false)
//    private UserEntity sender;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }






    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
