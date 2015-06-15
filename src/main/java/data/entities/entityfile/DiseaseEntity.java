package data.entities.entityfile;

import logical.Disease;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mona on 6/3/2015.
 */

@Inheritance(strategy= InheritanceType.JOINED)
@Entity
@Table(name = "mydisease")
@AttributeOverride(name = "id", column = @Column(name = "disease_id"))
public class DiseaseEntity extends DiseaseGen {

    String nameSign = "";
    private String nameOfDisease;
    private Date dateOfCreate;
    private String idDoctor;
    private String idPatient;
    private String signs;

    public DiseaseEntity(){}

    public DiseaseEntity(Disease dis) {

        setDoctor(dis.NameOfDoctor);
        setName(dis.getNameOfDisease());
        setPatient(dis.getNameOfPatient());
        setDate(dis.getDateOfCreate());
        setSigns(dis.getSigns());

    }

    @Column(name = "myname")
    @Basic

    public String getName() {
        return nameOfDisease;
    }

    public void setName(String name) {
        this.nameOfDisease = name;
    }



    @Column(name = "myDate")
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
        return idPatient;
    }

    public void setPatient(String patient) {
        this.idPatient = patient;
    }


    @Column(name = "doctor_id")
    @Basic
    public String getDoctor() {
        return idDoctor;
    }

    public void setDoctor(String doctor) {
        this.idDoctor = doctor;
    }

    @Column(name = "signs")
    @Basic
    public String getSigns() {
        return signs;
    }
    public void setSigns(String signs) {
        this.signs = signs;
    }


}
