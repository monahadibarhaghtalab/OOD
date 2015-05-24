package logical;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a on 5/1/15.
 */
public class disease {
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

    public disease(String name, String doctor, String patient, Date d, ArrayList<String > signs){
        setNameOfDisease(name);
        setNameOfDoctor(doctor);
        setNameOfPatient(patient);
        setDateOfCreate(d);
        this.signs = signs;
    }

    public String getSigns() {
        String ans = "";
        for(int i = 0; i < signs.size(); i++){
            ans+=signs.get(i);
            ans+="\n";
        }
        return ans;
    }

    public void setSigns(ArrayList<String> signs) {
        this.signs = signs;
    }
}
