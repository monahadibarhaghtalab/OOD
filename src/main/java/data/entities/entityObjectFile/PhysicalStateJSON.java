package data.entities.entityObjectFile;

import logical.user.PhysicalState;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Mona on 6/30/2015.
 */
public class PhysicalStateJSON {

    File file;

    public PhysicalStateJSON(File file){
        this.file = file;
    }
    public ArrayList<PhysicalState> getPhysicalStates(String patientId){
        ArrayList<PhysicalState> psArray = new ArrayList<PhysicalState>();

;

        JSONObject jsonObject = (JSONObject) Util.getJsonObject(patientId, "patient_id", file);


        JSONArray jArray = (JSONArray) jsonObject.get("physicalStates");

        for (int i = 0; i < jArray.size(); i++) {
            JSONObject jsonPhys = (JSONObject) jArray.get(i);

            double height = Double.parseDouble((String) jsonPhys.get("height"));
            double weight =Double.parseDouble((String)jsonPhys.get("weight"));
            double pressure =Double.parseDouble((String)jsonPhys.get("pressure"));
            double  glycemia =Double.parseDouble((String) jsonPhys.get("glycemia"));
            Date date = Util.stringToDate((String) jsonPhys.get("date"));
            String PatientId = (String) jsonPhys.get("patientId");
            psArray.add(new PhysicalState(height, weight, pressure,glycemia, date, PatientId));
        }

        return psArray;


    }



//    public ArrayList<PhysicalState> getPhysicalStatesByDate(Date dateFilter){
//        ArrayList<PhysicalState> psArray = new ArrayList<PhysicalState>();
//
//        ;
//
//        JSONObject jsonObject = (JSONObject) Util.getJsonObject(Util.dateToString(dateFilter), "date", file);
//
//
//        JSONArray jArray = (JSONArray) jsonObject.get("physicalStates");
//
//        for (int i = 0; i < jArray.size(); i++) {
//            JSONObject jsonPhys = (JSONObject) jArray.get(i);
//
//            double height = Double.parseDouble((String) jsonObject.get("height"));
//            double weight =Double.parseDouble((String)jsonObject.get("weight"));
//            double pressure =Double.parseDouble((String)jsonObject.get("pressure"));
//            double  glycemia =Double.parseDouble((String) jsonObject.get("glycemia"));
//            Date date = Util.stringToDate((String) jsonObject.get("date"));
//            String PatientId = (String) jsonObject.get("patientId");
//            psArray.add(new PhysicalState(height, weight, pressure,glycemia, date, PatientId));
//        }
//
//        return psArray;
//
//
//    }

    public void savePhysicalState(String patientId, PhysicalState phys){


            // public PhysicalState(double height, double weight, double pressure, double glycemia, Date date, String PatientId){

            JSONObject jsonFirst = Util.getJsonObject(patientId, "patient_id", file);
            JSONArray jsonActivity = (JSONArray) jsonFirst.get("physicalStates");

            JSONObject obj = new JSONObject();
            obj.put("height", phys.getHeight() + "");
            obj.put("weight", phys.getWeight() + "");
            obj.put("pressure", phys.getPressure()+"");
            obj.put("glycemia", phys.getGlycemia()+"");
            obj.put("date", Util.dateToString(phys.getDate()));



            jsonActivity.add(obj);
            Util.rewrite(file, patientId, "patient_id", jsonFirst);


    }

    public PhysicalState getPhysicalState(String patientId){
        // public PhysicalState(double height, double weight, double pressure, double glycemia, Date date, String PatientId){
        JSONObject jsonObject = getJsonObject(patientId, "patient_id");
        double height =(Double) jsonObject.get("height");
        double weight =(Double) jsonObject.get("weight");
        double pressure =(Double) jsonObject.get("pressure");
        double  glycemia =(Double) jsonObject.get("glycemia");
        Date date = (Date)jsonObject.get("date");
        String PatientId = (String) jsonObject.get("patientId");
        return new PhysicalState(height, weight, pressure,glycemia, date, PatientId);

    }


    public void savePatient(String patientId){
        JSONObject obj = new JSONObject();
        obj.put("patient_id", patientId);
        obj.put("physicalStates", new ArrayList<String>());

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            pw.println(obj.toString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private JSONObject getJsonObject(String id, String compare) {

        ArrayList<String> patients = new ArrayList<String>();
        JSONParser parser = new JSONParser();

        try {

            Scanner rd = new Scanner(file);
            String line;
            while (rd.hasNext()) {
                line = rd.nextLine();

                Object obj = parser.parse(line);

                JSONObject jsonObject = (JSONObject) obj;
                String tempId = (String) jsonObject.get(compare);

                if (tempId.equals(id)) {
                    return jsonObject;
                }


            }
            rd.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return null;
    }

}
