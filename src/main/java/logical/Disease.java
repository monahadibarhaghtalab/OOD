package logical;

import data.entities.entityfile.DiseaseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by a on 5/1/15.
 */
public class Disease {
    public String NameOfDisease;
    public String NameOfDoctor;
    public String NameOfPatient;
    public ArrayList<String> signs;
    public Date DateOfCreate;

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

    public Disease(String name, String doctor, String patient, Date d, ArrayList<String > signs){
        setNameOfDisease(name);
        setNameOfDoctor(doctor);
        setNameOfPatient(patient);
        setDateOfCreate(d);
        this.signs = signs;
    }

    public Disease(DiseaseEntity ds){
        setNameOfDisease(ds.getName());
        setNameOfDoctor(ds.getDoctor());
        setNameOfPatient(ds.getPatient());
        setDateOfCreate(ds.getDate());
        this.signs = new ArrayList<String>(Arrays.asList(ds.getSigns().split("\n")));
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
