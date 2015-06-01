package logical;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a on 6/1/15.
 */
public class Activity {
    public String type;
    public double calory;
    public Date DateOfCreate;


    public Activity(String type, double calory, Date d){
        this.type = type;
        this.calory = calory;
        DateOfCreate = d;
    }
}
