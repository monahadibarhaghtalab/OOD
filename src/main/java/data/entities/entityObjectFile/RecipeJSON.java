package data.entities.entityObjectFile;

import logical.Recipe;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mona on 7/2/2015.
 */
public class RecipeJSON {


    File file;
    public RecipeJSON(File file){
        this.file = file;
    }

    public void saveRecipe(String patientId, Recipe rec){

        //String doctor, String patient, Date d, ArrayList<String> medicines

        JSONObject jsonFirst = Util.getJsonObject(patientId, "patient_id", file);
        JSONArray jsonDis = (JSONArray) jsonFirst.get("recipes");

        JSONObject obj = new JSONObject();
        obj.put("doctor", rec.idOfDoctor);
        obj.put("date", Util.dateToString(rec.DateOfCreate));

        obj.put("medicines", rec.getMedicines());

        jsonDis.add(obj);
        Util.rewrite(file, patientId, "patient_id", jsonFirst);

    }


    public void savePatient(String patientId){
        JSONObject obj = new JSONObject();
        obj.put("patient_id", patientId);
        obj.put("recipes", new ArrayList<String>());

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            pw.println(obj.toString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Recipe> getRecipe(String patientId){
        ArrayList<Recipe> disArray = new ArrayList<Recipe>();


        JSONObject jsonObject = (JSONObject) Util.getJsonObject(patientId, "patient_id", file);

        //String doctor, String patient, Date d, ArrayList<String> medicines
        JSONArray jArray = (JSONArray) jsonObject.get("recipe");

        for (int i = 0; i < jArray.size(); i++) {
            JSONObject jsonPhys = (JSONObject) jArray.get(i);

            String doctor = (String) jsonObject.get("doctor");
            Date date = Util.stringToDate((String) jsonObject.get("date"));
            String PatientId = (String) jsonObject.get("patient_id");
            ArrayList<String> medicines = (ArrayList<String>) jsonObject.get("medicines");


            disArray.add(new Recipe(doctor,PatientId,date, medicines));
        }

        return disArray;


    }
}
