package data.entities.entityObjectFile;

import logical.Activity;
import logical.user.PhysicalState;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mona on 7/1/2015.
 */
public class ActivityJSON {

    File file;
    public ActivityJSON(File file){
        this.file = file;
    }

    public void saveActivity(String patientId, Activity act){

        //(String type, double calory, Date d, String PatientId, long start, long end, double during)

        JSONObject jsonFirst = Util.getJsonObject(patientId, "patient_id", file);
        JSONArray jsonActivity = (JSONArray) jsonFirst.get("activities");

        JSONObject obj = new JSONObject();
        obj.put("calory", act.calory + "");
        obj.put("date", Util.dateToString(act.DateOfCreate));
        obj.put("start", act.StartTime + "");
        obj.put("end", act.endTime+"");
        obj.put("type", act.type);
        obj.put("during", act.duringTime + "");

        jsonActivity.add(obj);
        Util.rewrite(file, patientId, "patient_id", jsonFirst);

    }

    public void savePatient(String patientId){
        JSONObject obj = new JSONObject();
        obj.put("patient_id", patientId);
        obj.put("activities", new ArrayList<String>());

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            pw.println(obj.toString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Activity> getActivities(String patientId){
        ArrayList<Activity> actArray = new ArrayList<Activity>();

        ;

        JSONObject jsonObject = (JSONObject) Util.getJsonObject(patientId, "patient_id", file);

        //(String type, double calory, Date d, String PatientId, long start, long end, double during)
        JSONArray jArray = (JSONArray) jsonObject.get("activities");

        for (int i = 0; i < jArray.size(); i++) {
            JSONObject jsonPhys = (JSONObject) jArray.get(i);

           String type = (String)jsonPhys.get("type");
            double calory = Double.parseDouble((String) jsonPhys.get("calory"));
            long start =Long.parseLong((String) jsonPhys.get("start"));
            long end =Long.parseLong((String)jsonPhys.get("end"));
            double  during =Double.parseDouble((String) jsonPhys.get("during"));
            Date date = Util.stringToDate((String) jsonPhys.get("date"));
            String PatientId = (String) jsonPhys.get("patient_id");
           actArray.add(new Activity(type, calory, date, PatientId, start, end, during));
        }

        return actArray;


    }
}
