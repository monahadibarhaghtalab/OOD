package data.entities.entityfile;

//import logical.User;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Type;

import logical.user.doctor.Doctor;
import logical.user.patient.Patient;

import javax.persistence.*;
import javax.print.Doc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;




@Entity
@Table(name = "Patient")
public class PatientEntity  implements Serializable {
//    public String myusername;
//    public char[] mypassword;
//    public String myname;
//    public String myfamilyName;
    public String id;

    public PatientEntity(Patient obj) {
        setId(obj.getId());
        doctors =  new ArrayList<DoctorEntity>();
//        setMyusername(obj.getUsername());
//        setMypassword(obj.getPassword());
//        setMyname(obj.getName());
//        setMyfamilyName(obj.getFamilyName());

    }

    public PatientEntity() {
    }

    public Patient getPatient() {
        ArrayList<Doctor> doctors1 = new ArrayList<Doctor>();
        ArrayList<DoctorEntity> doctorsEn =getDoctors();
        for(int i= 0; i < doctorsEn.size(); i++){
            doctors1.add(doctorsEn.get(i).getDoctor())
        }
        return new Patient(getId(), getDoctors().getListDoctor());
    }

    @Id
    @Column(name = "patient_id" )
    public String getId() {
        return id;
    }


    public void setId(String id) {
        //  System.out.println(id +"IIIIIIIIIIIID");
        this.id = id;
    }

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



}

