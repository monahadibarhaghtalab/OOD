package data.entities;

import logical.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;



/**
 * Created by Mona on 3/14/2015.
 */

@Table(name = "Patient")
@Entity
public class PatientEntity extends UserEntity{
   // private UUID guid;
    private String patientName;
    private String idCode;
    private String doctorName;
    //  private String problem;
    //  private UUID userId;

    //  private UserEntity user;

    public PatientEntity() { }

    public PatientEntity(String patientName, String idCode, String doctorName) {
        setIdCode(idCode);
        setPatientName(patientName);
        setDoctorName(doctorName);
    }

//    @Id
//    @GenericGenerator(name = "generator", strategy = "uuid2", parameters = {})
//    @GeneratedValue(generator = "generator")
//    @Type(type = "uuid-binary")
//    @Column(name = "UUID" , columnDefinition="raw(16)")
//    public UUID getGuid() {
//        return guid;
//    }
//
//    public void setGuid(UUID guid) {
//        this.guid = guid;
//    }

    @Column(name = "PatientName",
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

