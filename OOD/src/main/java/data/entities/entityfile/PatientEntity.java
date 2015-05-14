package data.entities.entityfile;

//import logical.User;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Type;

import logical.user.patient.Patient;

import javax.persistence.*;

import java.io.Serializable;
import java.util.UUID;




@Entity
@Table(name = "Patient")
public class PatientEntity  extends UserEntity implements Serializable {
    private UUID guid;
    private String patientName;
    private String idCode;
    private String doctorName;
    //  private String problem;
    //  private UUID userId;

    //  private UserEntity user;

    public PatientEntity() { }


    public PatientEntity(Patient user) {
        super();
    }

//    @Id
//    @GenericGenerator(name = "generator", strategy = "uuid2", parameters = {})
//    @GeneratedValue(generator = "generator")
//    @Type(type = "uuid-binary")
//    @Column(name = "UUID")
//    public UUID getGuid() {
//        return guid;
//    }
//
//    public void setGuid(UUID guid) {
//        this.guid = guid;
//    }

    @Column(name = "patientname",
            nullable = false,
            length = 100)
    @Basic
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @Column(name = "IdCode",
            nullable = false,
            length = 23)
    @Basic
    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }


    @Column(name = "DoctorName",
            nullable = true,
            length = 100)
    @Basic
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
/*

    @ManyToOne
    @JoinColumn(name = "UserId",
            referencedColumnName = "Guid",
            updatable = false,
            insertable = false,
            nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

*/




}

