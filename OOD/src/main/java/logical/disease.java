package logical;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a on 5/1/15.
 */
public class Disease {
    private String NameOfDisease;
    private String NameOfDoctor;
    private String NameOfPatient;
    private ArrayList<String> signs;
    private Date DateOfCreate;

    public String getNameOfDisease() {
        return NameOfDisease;
    }

    public void setNameOfDisease(String nameOfDisease) {
        NameOfDisease = nameOfDisease;
    }

    public String getNameOfDoctor() {
        return NameOfDoctor;
    }

    public void setNameOfDoctor(String nameOfDoctor) {
        NameOfDoctor = nameOfDoctor;
    }

    public String getNameOfPatient() {
        return NameOfPatient;
    }

    public void setNameOfPatient(String nameOfPatient) {
        NameOfPatient = nameOfPatient;
    }

    public Date getDateOfCreate() {
        return DateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        DateOfCreate = dateOfCreate;
    }
}
