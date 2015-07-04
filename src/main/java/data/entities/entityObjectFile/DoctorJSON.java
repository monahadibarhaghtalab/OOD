package data.entities.entityObjectFile;

import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Mona on 7/2/2015.
 */
public class DoctorJSON {

    File file;
    File fileUser;
    public DoctorJSON(File file){
        this.file = file;
        fileUser = new File(System.getProperty("user.home"),"user.txt");
    }

    public void savePatient(String doctorId, String patientId){

        //(String type, double calory, Date d, String PatientId, long start, long end, double during)

        JSONObject jsonFirst = Util.getJsonObject(doctorId, "doctor_id", file);
        JSONArray jsonActivity = (JSONArray) jsonFirst.get("patients");

        JSONObject obj = new JSONObject();
        obj.put("patient_id", patientId);

        jsonActivity.add(obj);
        Util.rewrite(file,doctorId, "doctor_id", jsonFirst);

    }



    public void saveDoctor(User doctor){

        JSONObject obj = new JSONObject();
        obj.put("doctor_id", doctor.getId());
        obj.put("patients", new ArrayList<String>());

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file, true));
            pw.println(obj.toString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deletePatient(String doctorId, String patientId){

        //(String type, double calory, Date d, String PatientId, long start, long end, double during)

        JSONObject jsonFirst = Util.getJsonObject(doctorId, "doctor_id", file);
        JSONArray jsonActivity = (JSONArray) jsonFirst.get("patients");

        JSONObject obj = new JSONObject();
        obj.put("patient_id", patientId);

        jsonActivity.remove(obj);
        Util.rewrite(file,doctorId, "doctor_id", jsonFirst);

    }


    public ArrayList<Patient> getPatients(String doctorId){
        ArrayList<Patient> actArray = new ArrayList<Patient>();

        JSONObject jsonObject = (JSONObject) Util.getJsonObject(doctorId, "doctor_id", file);

        //(String type, double calory, Date d, String PatientId, long start, long end, double during)
        JSONArray jArray = (JSONArray) jsonObject.get("patients");

        File file = new File(System.getProperty("user.home"),"user.txt");
        for (int i = 0; i < jArray.size(); i++) {
            JSONObject jsonPhys = (JSONObject) jArray.get(i);
            JSONObject jsonUser = Util.getJsonObject((String) jsonPhys.get("patient_id"), "user_id", fileUser);
            actArray.add(new Patient(new UserJSON((String) jsonUser.get("user_id")).getUser()));
        }

        return actArray;


    }
}
