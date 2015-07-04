package data.entities.entityObjectFile;

import logical.Activity;
import logical.Disease;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mona on 7/1/2015.
 */
public class DiseaseJSON {

    File file;
    public DiseaseJSON(File file){
        this.file = file;
    }

    public void saveHistory(String patientId, Disease dis){

        //String name, String doctor, String patient, Date d, ArrayList<String > signs

        JSONObject jsonFirst = Util.getJsonObject(patientId, "patient_id", file);
        JSONArray jsonDis = (JSONArray) jsonFirst.get("diseases");

        JSONObject obj = new JSONObject();
        obj.put("name", dis.getNameOfDisease());
        obj.put("doctor", dis.getNameOfDoctor());
        obj.put("date", Util.dateToString(dis.DateOfCreate));

        obj.put("signs", dis.getSigns());

        jsonDis.add(obj);
        Util.rewrite(file, patientId, "patient_id", jsonFirst);

    }


    public void savePatient(String patientId){
        JSONObject obj = new JSONObject();
        obj.put("patient_id", patientId);
        obj.put("diseases", new ArrayList<String>());

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            pw.println(obj.toString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Disease> getDiseases(String patientId){
        ArrayList<Disease> disArray = new ArrayList<Disease>();


        JSONObject jsonObject = (JSONObject) Util.getJsonObject(patientId, "patient_id", file);

        //(tring name, String doctor, String patient, Date d, ArrayList<String > signs
        JSONArray jArray = (JSONArray) jsonObject.get("diseases");

        for (int i = 0; i < jArray.size(); i++) {
            JSONObject jsonPhys = (JSONObject) jArray.get(i);

            String name = (String)jsonPhys.get("name");
            String doctor = (String) jsonPhys.get("doctor");
            Date date = Util.stringToDate((String) jsonPhys.get("date"));
            String PatientId = (String) jsonObject.get("patient_id");
            String signs = (String) jsonPhys.get("signs");
            ArrayList<String> signsArray = new ArrayList<String>();

            String[] temp = signs.split("\n");
            for(int j = 0; j < temp.length; j++){
                signsArray.add(temp[i]);
            }

            disArray.add(new Disease(name, doctor, PatientId, date, signsArray));
        }

        return disArray;


    }

}
