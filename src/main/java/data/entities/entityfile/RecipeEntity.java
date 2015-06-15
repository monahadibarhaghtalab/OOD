package data.entities.entityfile;

import logical.Recipe;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Mona on 3/14/2015.
 */
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "myrecipe")
@Entity
@AttributeOverride(name = "id", column = @Column(name = "recipe_id"))
public class RecipeEntity extends RecipeGen{


//    public DoctorEntity doctor;
//    public PatientEntity patient;
//    public Date DateOfCreate;
//    public ArrayList<String> medicines;
    public String medString = "";
    private Date dateOfCreate;
     private String idOfPatient;
    private String idOfDoctor;

    public RecipeEntity(Recipe rcp) {
//        super(rcp.idOfDoctor, rcp.idOfPatient, rcp.DateOfCreate, rcp.medicines);
       setDoctor(rcp.idOfDoctor);
        setPatient(rcp.idOfPatient);
        setDate(rcp.DateOfCreate);
       ArrayList<String >medicines = rcp.getMedicines();

        for(int i = 0; i< medicines.size() - 1; i++){
            medString += rcp.medicines.get(i)+ ",";
        }
        medString += medicines.get(medicines.size() - 1);

        setMedicine(medString);
    }

    public RecipeEntity() {
    }


    @Column(name = "mydate")
    @Basic
    public Date getDate() {
        return dateOfCreate;
    }

    public void setDate(Date date) {
        this.dateOfCreate = date;
    }

    @Column(name = "mymedicines")
    @Basic
    public String getMedicine() {
        return medString;
    }

    public void setMedicine(String med) {
        this.medString = med;
    }

//    @ManyToOne
//    @JoinColumn(name = "doctor_id" , nullable = false)

    @Column(name = "doctor_id")
    @Basic
    public String getDoctor() {
        return idOfDoctor;
    }

    public void setDoctor(String doctor) {
        this.idOfDoctor = doctor;
    }






//    @ManyToOne
//    @JoinColumn(name = "patient_id", nullable = false)
    @Column(name = "patient_id")
    @Basic
    public String  getPatient() {
        return idOfPatient;
    }
    public void setPatient(String patient) {
        this.idOfPatient = patient;
    }
}
