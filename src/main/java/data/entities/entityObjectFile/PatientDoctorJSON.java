//package data.entities.entityObjectFile;
//
//import logical.user.doctor.Doctor;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Scanner;
//
///**
// * Created by Mona on 6/30/2015.
// */
//public class PatientDoctorJSON {
//
//
//    JSONObject jsonObjectPD;
//    File file;
//
//    public PatientDoctorJSON(File file) {
//        this.file = file;
//    }
//
//    public UserJSON searchPateint(String idPatient, String idDoctor) {
//        UserJSON patientJson = null;
//       JSONObject doctorJson =  getJsonObject(idDoctor, "doctor_id");
//        JSONArray patients = (JSONArray) doctorJson.get("patients");
//        for (int i = 0; i < patients.size(); i++) {
//            if (patients.get(i).toString().equals(idPatient)){
//                patientJson = new UserJSON(patients.get(i).toString());
//                 break;
//        }
//        }
//
//        return patientJson;
//    }
//
//    public ArrayList<String> getPatients(String idDoctor) {
//        ArrayList<String> patients = new ArrayList<String>();
//        JSONParser parser = new JSONParser();
//        Scanner rd = null;
//        try {
//
//            Scanner sc = new Scanner(file);
//            String line;
//            while (rd.hasNext()) {
//                line = rd.nextLine();
//
//                Object obj = parser.parse(line);
//
//                JSONObject jsonObject = (JSONObject) obj;
//                String tempIdDoctor = (String) jsonObject.get("doctor_id");
//
//                if (tempIdDoctor.equals(idDoctor)) {
//                    JSONArray jArray = (JSONArray) jsonObject.get("patients");
//                    for (int i = 0; i < jArray.size(); i++) {
//                        patients.add(jArray.get(i).toString());
//                    }
//                    return patients;
//
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    public ArrayList<Doctor> getDoctors()
//
//
//
//    public void addPatientToDoctor(String idPatient, String idDoctor) {
//        JSONObject jsonObject = getJsonObject(idDoctor, "doctor_id");
//        JSONArray patient = (JSONArray) jsonObject.get("patients");
//        patient.add(idPatient);
//
//    }
//
//    public void addDoctorToPatient(String idPatient, String idDoctor) {
//
//        JSONObject jsonObject = getJsonObject(idPatient, "patient_id");
//        JSONArray patient = (JSONArray) jsonObject.get("doctors");
//        patient.add(idPatient);
//
//    }
//
//    public void removeDoctorFromPatient(String patientId, String doctorId){
//        JSONObject jsonObject = getJsonObject(patientId, "patient_id");
//        JSONArray patient = (JSONArray) jsonObject.get("doctors");
//        patient.remove(patient);
//
//    }
//
//
//    public void removePatientFromDoctor(String patientId, String doctorId){
//        JSONObject jsonObject = getJsonObject(doctorId, "doctor_id");
//        JSONArray patient = (JSONArray) jsonObject.get("patients");
//        patient.remove(patient);
//
//    }
//
//    public JSONObject getJsonObject(String id, String compare) {
//
//        ArrayList<String> patients = new ArrayList<String>();
//        JSONParser parser = new JSONParser();
//        Scanner rd = null;
//        try {
//
//            Scanner sc = new Scanner(file);
//            String line;
//            while (rd.hasNext()) {
//                line = rd.nextLine();
//
//                Object obj = parser.parse(line);
//
//                JSONObject jsonObject = (JSONObject) obj;
//                String tempId = (String) jsonObject.get(compare);
//
//                if (tempId.equals(id)) {
//                    return jsonObject;
//                }
//
//
//            }
//        } catch (FileNotFoundException e1) {
//            e1.printStackTrace();
//        } catch (ParseException e1) {
//            e1.printStackTrace();
//        }
//        return null;
//    }
//}
