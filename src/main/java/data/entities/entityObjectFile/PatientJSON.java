package data.entities.entityObjectFile;

import logical.Activity;
import logical.user.doctor.Doctor;
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
public class PatientJSON {

    File file;
    File fileUser;
    public PatientJSON(File file){
        this.file = file;
        fileUser = new File(System.getProperty("user.home"),"user.txt");
    }

    public void saveDoctor(String patientId, Doctor doctor){

        //(String type, double calory, Date d, String PatientId, long start, long end, double during)

        JSONObject jsonFirst = Util.getJsonObject(patientId, "patient_id", file);
        JSONArray jsonActivity = (JSONArray) jsonFirst.get("doctors");

        JSONObject obj = new JSONObject();
        obj.put("doctor_id", doctor.getId());
        obj.put("type", doctor.getType());

        jsonActivity.add(obj);
        Util.rewrite(file, patientId, "patient_id", jsonFirst);

    }

    public void savePatient(String patientId){
        JSONObject obj = new JSONObject();
        obj.put("patient_id", patientId);
        obj.put("doctors", new ArrayList<String>());

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            pw.println(obj.toString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteDoctor(String patientId, String doctorId){

        JSONObject jsonFirst = Util.getJsonObject(patientId, "patient_id", file);
        JSONArray jsonActivity = (JSONArray) jsonFirst.get("doctors");

        Doctor doctor = new Doctor(new UserJSON(doctorId).getUser(), new UserJSON(doctorId).getUser().getMytype());
        JSONObject obj = new JSONObject();
        obj.put("doctor_id", doctor.getId());
        obj.put("type", doctor.getType());

        jsonActivity.remove(obj);
        Util.rewrite(file, patientId, "patient_id", jsonFirst);


    }

    public ArrayList<Doctor> getDoctors(String patientId){
        ArrayList<Doctor> actArray = new ArrayList<Doctor>();


        JSONObject jsonObject = (JSONObject) Util.getJsonObject(patientId, "patient_id", file);

        //(String type, double calory, Date d, String PatientId, long start, long end, double during)
        JSONArray jArray = (JSONArray) jsonObject.get("doctors");

        File file = new File(System.getProperty("user.home"),"user.txt");
        for (int i = 0; i < jArray.size(); i++) {
            JSONObject jsonPhys = (JSONObject) jArray.get(i);

            String type = (String)jsonPhys.get("type");
            JSONObject jsonUser = Util.getJsonObject((String) jsonPhys.get("doctor_id"), "user_id", fileUser);
            actArray.add(new Doctor(new UserJSON((String) jsonUser.get("user_id")).getUser(), type));
        }

        return actArray;


    }
}
