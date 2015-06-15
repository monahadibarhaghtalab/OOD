package logical;

import data.entities.entityfile.ActivityEntity;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a on 6/1/15.
 */
public class Activity {
    public String type;
    public double calory;
    public Date DateOfCreate;
    public String PatientId;


    public Activity(String type, double calory, Date d, String PatientId){
        this.type = type;
        this.calory = calory;
        DateOfCreate = d;
        this.PatientId = PatientId;
    }

    public Activity(ActivityEntity act){
        this.type = act.getType();
        this.calory = act.getCalory();
        DateOfCreate = act.getDate();
        this.PatientId = act.getPatient();
    }
}
