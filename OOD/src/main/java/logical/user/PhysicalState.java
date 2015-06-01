package logical.user;

import java.util.Date;

/**
 * Created by a on 5/23/15.
 */
public class PhysicalState {
    private double height;
    private double weight;
    private double pressure;
    private double glycemia;
    private Date date;

    public PhysicalState(double height, double weight, double pressure, double glycemia, Date date){
        this.height = height;
        this.weight = weight;
        this.pressure = pressure;
        this.glycemia = glycemia;
        this.date = date;
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
