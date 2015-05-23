package data.entities.entityfile;

import logical.user.doctor.Doctor;

import javax.persistence.*;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mona on 3/14/2015.
 */
@Table (name = "mydoctor")
@Entity
@AttributeOverride(name = "id", column = @Column(name = "doctor_id"))
public class DoctorEntity extends Doctor{

//    public String myusername;
//    public char[] mypassword;
//    public String myname;
//    public String myfamilyName;
//    public String id;



    public DoctorEntity(Doctor obj) {
        setId(obj.id);
        patients = new ArrayList<PatientEntity>();
//        setMyusername(obj.getUsername());
//        setMypassword(obj.getPassword());
//        setMyname(obj.getName());
//        setMyfamilyName(obj.getFamilyName());


    }

    public DoctorEntity() {
    }

    @Column(name = "typeDoctor")
    @Basic
    String typeDoctor;
    public String getTypeDoctor() {
        return typeDoctor;
    }

    public void setTypeDoctor(String typeDoctor) {
        this.typeDoctor = typeDoctor;
    }



    private ArrayList<RecipeEntity> rcp;

//    @Id
//    @Column(name = "doctor_id" )
//    public String getId() {
//        return id;
//    }
//
//
//    public void setId(String id) {
//        //  System.out.println(id +"IIIIIIIIIIIID");
//        this.id = id;
//    }
//    @Column(name = "myusername")
//    @Basic
//    public String getMyusername(){
//        return myusername;
//    }
//    public void setMyusername(String myusername) {
//        this.myusername = myusername;
//    }
//
//
//    @Column(name = "mypassword")
//    @Basic
//    public char[] getMypassword(){
//        return mypassword;
//    }
//    public void setMypassword(char[] mypassword) {
//        this.mypassword = mypassword;
//    }
//
//    @Column(name = "myname")
//    @Basic
//    public String getMyname(){
//        return myname;
//    }
//    public void setMyname(String myfamilyName) {
//        this.myname = myname;
//    }
//
//    @Column(name = "myfamilyname")
//    @Basic
//    public String getMyfamilyName(){
//        return myfamilyName;
//    }
//    public void setMyfamilyName(String myfamilyName) {
//        this.myfamilyName = myfamilyName;
//    }
//
//
    private ArrayList<PatientEntity> patients;
//

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "doctors")
    public ArrayList<PatientEntity> getPatients() {
        return this.patients;
    }

    public void setPatients(ArrayList<PatientEntity> patients) {
        this.patients = patients;
    }
    public void addPatients(PatientEntity patient) {
        patients.add(patient);
    }


//    public Doctor getDoctor(){
//        return new Doctor(getMyusername())
//    }

    @OneToMany(mappedBy = "doctor")
    public ArrayList<RecipeEntity> getRcp() {
        return rcp;
    }

    public void setRcp(ArrayList<RecipeEntity> rcp) {
        this.rcp = rcp;
    }

    public void addRec(RecipeEntity rc) {
        rcp.add(rc);
    }



}
