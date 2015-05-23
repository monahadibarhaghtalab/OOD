package data.entities.entityfile;

//import logical.User;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Type;

import logical.Recipe;
import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;

import javax.persistence.*;
import javax.print.Doc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;




@Entity
@Table(name = "mypatient")
@AttributeOverride(name = "id", column = @Column(name = "patient_id"))
public class PatientEntity  extends Patient {
//    public String myusername;
//    public char[] mypassword;
//    public String myname;
//    public String myfamilyName;
   // public String id;

//    public PatientEntity(Patient obj) {
//        setId(obj.getId());
//        doctors =  new ArrayList<DoctorEntity>();
////        setMyusername(obj.getUsername());
////        setMypassword(obj.getPassword());
////        setMyname(obj.getName());
////        setMyfamilyName(obj.getFamilyName());
//
//    }



    public PatientEntity(String username, char[] password, String name, String familyName, String id ) {
        super(username, password, name, familyName, id);

    }

    public PatientEntity() {
    }

//    public PatientEntity() {
//        super();
//    }

    public Patient getPatient() {
//        ArrayList<Doctor> doctors1 = new ArrayList<Doctor>();
//        ArrayList<DoctorEntity> doctorsEn =getDoctors();
//        for(int i= 0; i < doctorsEn.size(); i++){
//            doctors1.add(doctorsEn.get(i).getDoctor())
//        }
        return new Patient(getId());
    }

//    @Id
//    @Column(name = "patient_id" )
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




    private ArrayList<String> history;
    public void addHistory(String hist) {
        history.add(hist);

    }

    public ArrayList<String> getHistory() {
        return history;
    }
    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }



    private ArrayList<DoctorEntity> doctors ;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "patient_doctor", joinColumns = {
            @JoinColumn(name = "patient_id") },
            inverseJoinColumns = { @JoinColumn(name = "doctor_id") })

    public ArrayList<DoctorEntity> getDoctors() {
        return this.doctors;
    }

    public void setDoctors(ArrayList<DoctorEntity> doctors) {
        this.doctors = doctors;
    }
    public void addDoctors(DoctorEntity doctor) {
        doctors.add(doctor);
    }


    private ArrayList<RecipeEntity> rcp;
    @OneToMany(mappedBy = "patient")
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

