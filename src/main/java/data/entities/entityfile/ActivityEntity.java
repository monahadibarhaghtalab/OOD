package data.entities.entityfile;

import logical.Activity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mona on 6/3/2015.
 */

@Inheritance(strategy= InheritanceType.JOINED)
@Entity
@Table(name = "myactivity")
@AttributeOverride(name = "id", column = @Column(name = "activity_id"))
public class ActivityEntity extends ActivityGen {


    private String patientId;
    private String type;
    private double calory;
    private Date dateOfCreate;

    public ActivityEntity(){

    }

    public ActivityEntity(Activity act) {
//        super(act.type, act.calory, act.DateOfCreate, act.PatientId);
        setType(act.type);
        setCalory(act.calory);
        setDate(act.DateOfCreate);
        setPatient(act.PatientId);
    }


    @Column(name = "mytype")
    @Basic

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    @Column(name = "mycalory")
    @Basic

    public double getCalory() {
        return calory;
    }

    public void setCalory(double calory) {
        this.calory = calory;
    }



    @Column(name = "mydate")
    @Basic
    public Date getDate() {
        return dateOfCreate;
    }

    public void setDate(Date date) {
        this.dateOfCreate = date;
    }

    @Column(name = "patient_id")
    @Basic
    public String getPatient() {
        return patientId;
    }

    public void setPatient(String patient) {
        this.patientId = patient;
    }

}
