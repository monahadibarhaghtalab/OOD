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
}
