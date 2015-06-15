package data.entities.entityfile;


import logical.user.PhysicalState;
import logical.user.patient.Patient;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mona on 6/2/2015.
 */

@Inheritance(strategy=InheritanceType.JOINED)
@Entity
@Table(name = "myphysicalstate")
@AttributeOverride(name = "id", column = @Column(name = "physicalstate_id"))
public class PhysicalStateEntity  extends PhysicalStateGen{



    private double height;
    private double weight;
    private double pressure;
    private double glycemia;
    private Date date;

    private String PatientId;

    public PhysicalStateEntity(){

    }

    public PhysicalStateEntity(PhysicalState phs) {
//        super(phs.getHeight(), phs.getWeight(), phs.getPressure(), phs.getGlycemia(), phs.getDate(), phs.PatientId);
        setHeight(phs.getHeight());
        setWeight(phs.getWeight());
        setPressure(phs.getPressure());
        setGlycemia(phs.getGlycemia());
        setDate(phs.getDate());
        setPatient(phs.PatientId);
    }


    @Column(name = "myheight")
    @Basic

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }



    @Column(name = "myweight")
    @Basic

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }



    @Column(name = "mypressure")
    @Basic
    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }



    @Column(name = "myglycemia")
    @Basic
    public double getGlycemia() {
        return glycemia;
    }
    public void setGlycemia(double glycemia) {
        this.glycemia = glycemia;
    }



    @Column(name = "mydate")
    @Basic
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



//    @ManyToOne
//    @JoinColumn(name = "patient_id" , nullable = false)
    @Column(name = "patient_id")
    @Basic
    public String getPatient() {
        return PatientId;
    }
    public void setPatient(String patient) {
        this.PatientId = patient;
    }
}
