package data.entities.entityfile;

import logical.user.doctor.Doctor;

import javax.persistence.*;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mona on 3/14/2015.
 */
@Inheritance(strategy=InheritanceType.JOINED)
@Table (name = "mydoctor")
@Entity
@AttributeOverride(name = "id", column = @Column(name = "doctor_id"))
public class DoctorEntity extends DoctorGen{

//    public String myusername;
//    public char[] mypassword;
//    public String myname;
//    public String myfamilyName;
//    public String id;

    String type;


    public DoctorEntity(Doctor obj){
        super(obj.getId());
        patients = new ArrayList<PatientEntity>();

        setTypeDoctor(obj.getType());
//        setMyusername(obj.getUsername());
//        setMypassword(obj.getPassword());
//        setMyname(obj.getName());
//        setMyfamilyName(obj.getFamilyName());


    }
//
    public DoctorEntity() {
    }


    @Column(name = "typeDoctor")
    @Basic

    public String getTypeDoctor() {
        return type;
    }

    public void setTypeDoctor(String typeDoctor) {
        this.type = typeDoctor;
    }

//
//    String typeDoctor;

//    public DoctorEntity(Doctor obj) {
//        super(obj.getUsername(), obj.getPassword(), obj.getName(), obj.getFamilyName(), obj.getId(), obj.getMytype());
//        patients = new ArrayList<PatientEntity>();
//    }






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
    private List<PatientEntity> patients;
//

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "doctors")
    public List<PatientEntity> getPatients() {
        return this.patients;
    }

    public void setPatients(List<PatientEntity> patients) {
        this.patients = patients;
    }
    public void addPatients(PatientEntity patient) {
        patients.add(patient);
    }


//    public Doctor getDoctor(){
//        return new Doctor(getMyusername())
//    }

//    private List<RecipeEntity> rcp;
//    @OneToMany(mappedBy = "doctor")
//    public List<RecipeEntity> getRcp() {
//        return rcp;
//    }
//
//    public void setRcp(List<RecipeEntity> rcp) {
//        this.rcp = rcp;
//    }
//
//    public void addRec(RecipeEntity rc) {
//        rcp.add(rc);
//    }



}
