package logical.user;

import data.entities.entityfile.PhysicalStateEntity;

import java.util.Date;

/**
 * Created by a on 5/23/15.
 */
public class PhysicalState {
    public double height;
    public double weight;
    public double pressure;
    public double glycemia;
    public Date date;
    public String PatientId;

    public PhysicalState(double height, double weight, double pressure, double glycemia, Date date, String PatientId){
        this.height = height;
        this.weight = weight;
        this.pressure = pressure;
        this.glycemia = glycemia;
        this.date = date;
        this.PatientId = PatientId;
    }

    public PhysicalState(PhysicalStateEntity phs){
        this.height = phs.getHeight();
        this.weight = phs.getWeight();
        this.pressure = phs.getPressure();
        this.glycemia = phs.getGlycemia();
        this.date = phs.getDate();
        this.PatientId =phs.getPatient();
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getGlycemia() {
        return glycemia;
    }

    public void setGlycemia(double glycemia) {
        this.glycemia = glycemia;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
