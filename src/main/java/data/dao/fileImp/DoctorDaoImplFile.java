package data.dao.fileImp;

import data.dao.DoctorDao;
import data.dao.UserFuncDao;
import data.dao.imp.DaoImp;
import data.entities.entityObjectFile.*;
import logical.Activity;
import logical.Disease;
import logical.user.Message;
import logical.user.PhysicalState;
import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Mona on 6/30/2015.
 */
public class DoctorDaoImplFile  implements UserFuncDao, DoctorDao {
    @Override
    public ArrayList<Patient> showListOfPatient(Doctor doctor) {
        File file = new File(System.getProperty("user.home"),"doctor.txt");
//        PatientDoctorJSON pdjson = new PatientDoctorJSON(file);
//        ArrayList<String> patientIds = pdjson.getPatients(doctor.getId());
//        ArrayList<Patient> result = new ArrayList<Patient>();
//        for (int i = 0; i < patientIds.size(); i++){
//            result.add(new Patient(new UserJSON(patientIds.get(i)).getUser()));
//        }
//        return result;
        DoctorJSON doctorJson = new DoctorJSON(file);
        return doctorJson.getPatients(doctor.getId());
    }

    @Override
    public Patient searchPatient(Doctor doctor, String ID) {
        File file = new File(System.getProperty("user.home"),"doctor.txt");
        File fileUser = new File(System.getProperty("user.home"),"user.txt");
//        PatientDoctorJSON pdJson = new PatientDoctorJSON(file);
//        return new Patient(pdJson.searchPateint(ID, doctor.getId()).getUser());
        DoctorJSON doctorJson = new DoctorJSON(file);

        ArrayList<Patient> patients = doctorJson.getPatients(doctor.getId());
        for(int i = 0; i < patients.size(); i++){
            if(patients.get(i).getId().equals(ID)){
                return new Patient(new UserJSON(ID).getUser());
            }
        }
        return null;
    }

    @Override
    public void addPatient(Doctor receiver, String patientId) {
        File file  = new File(System.getProperty("user.home"),"doctor.txt");
        DoctorJSON doctorJSON = new DoctorJSON(file);
        doctorJSON.savePatient(receiver.getId(), patientId);

        File file1 = new File(System.getProperty("user.home"),"patient.txt");
        PatientJSON patientJSON = new PatientJSON(file1);
        patientJSON.saveDoctor(patientId, receiver);

        File filem = new File(System.getProperty("user.home"),"message.txt");
        MessageJSON messageJSON = new MessageJSON(filem);
        messageJSON.deleteMessage(receiver.getId(), "receiver_id");

    }

    @Override
    public ArrayList<Patient> showListOfUser(Doctor user) {
        return null;
    }

    @Override
    public ArrayList<Message> getConsults(Doctor myDoctor) {
        File file  = new File(System.getProperty("user.home"),"message.txt");
        MessageJSON message = new MessageJSON(file);
        return message.getMessages(myDoctor.getId(), "receiver_id", 1);
    }

    @Override
    public ArrayList<Integer> getCountpress(Double firstPre, Double secondPre, Double firstglo, Double secondglo, Date firstDate, Date secondDate) {
        int num = numMonth(firstDate, secondDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(firstDate);
        int month = cal.get(Calendar.MONTH)+ 1;
        int year = cal.get(Calendar.YEAR);

        File file = new File(System.getProperty("user.home"),"patient.txt");

        ArrayList<Integer> numPhys = new ArrayList<Integer>();

        JSONParser parser = new JSONParser();



        for(int j = 0; j <num; j++) {
            try {

                numPhys.add(0);
                Scanner rd = new Scanner(file);
                String line;

                while (rd.hasNext()) {
                    line = rd.nextLine();

                    Object obj = parser.parse(line);

                    JSONObject jsonObject = (JSONObject) obj;
                    String tempId = (String) jsonObject.get("patient_id");

                    File file1 = new File(System.getProperty("user.home"),"physicalState.txt");

                    PhysicalStateJSON phy = new PhysicalStateJSON(file1);

                    ArrayList<PhysicalState> physSpec = phy.getPhysicalStates(tempId);

                    for (int i = 0; i < physSpec.size(); i++) {
                        Calendar calTemp = Calendar.getInstance();
                        calTemp.setTime(physSpec.get(i).getDate());

                        int monthTemp = calTemp.get(Calendar.MONTH)+1;
                        int yearTemp = calTemp.get(Calendar.YEAR);
                        if (monthTemp == (month + j)%12 && yearTemp == year + (month + j)/12
                                && physSpec.get(i).getPressure() >= firstPre && physSpec.get(i).getPressure()<= secondPre
                                && physSpec.get(i).getGlycemia() >= firstglo && physSpec.get(i).getGlycemia() <= secondglo){
                            int tempNum = numPhys.get(j)+ 1;
                            numPhys.add(j, tempNum);
                        }
                    }


                }
                rd.close();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (org.json.simple.parser.ParseException e1) {
                e1.printStackTrace();
            }
        }
        return numPhys;
    }

    @Override
    public ArrayList<Integer> getCountActivity(Double minglo, Double maxglo, Date firstDate, Date secondDate) {
        int num = numMonth(firstDate, secondDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(firstDate);
        int month = cal.get(Calendar.MONTH)+ 1;
        int year = cal.get(Calendar.YEAR);

        File file = new File(System.getProperty("user.home"),"patient.txt");

        ArrayList<Integer> numPhys = new ArrayList<Integer>();

        JSONParser parser = new JSONParser();



        for(int j = 0; j <num; j++) {
            try {

                numPhys.add(0);
                Scanner rd = new Scanner(file);
                String line;

                while (rd.hasNext()) {
                    line = rd.nextLine();

                    Object obj = parser.parse(line);

                    JSONObject jsonObject = (JSONObject) obj;
                    String tempId = (String) jsonObject.get("patient_id");

                    File file1 = new File(System.getProperty("user.home"),"activity.txt");

                    ActivityJSON activityJSON = new ActivityJSON(file1);
                    ArrayList<Activity> actSpec =activityJSON.getActivities(tempId);

                    for (int i = 0; i < actSpec.size(); i++) {
                        Calendar calTemp = Calendar.getInstance();
                        calTemp.setTime(actSpec.get(i).DateOfCreate);

                        int monthTemp = calTemp.get(Calendar.MONTH)+ 1;
                        int yearTemp = calTemp.get(Calendar.YEAR);
                        if (monthTemp == (month + j)%12 && yearTemp == year + (month + j)/12
                                && actSpec.get(i).calory >= minglo && actSpec.get(i).calory<= maxglo){
                            int tempNum = numPhys.get(j)+ 1;
                            numPhys.add(j, tempNum);
                        }
                    }


                }
                rd.close();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (org.json.simple.parser.ParseException e1) {
                e1.printStackTrace();
            }

        }
        return numPhys;
    }

    @Override
    public ArrayList<Integer> getCountDisease(String name, Date firstDate, Date secondDate) {
        int num = numMonth(firstDate, secondDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(firstDate);
        int month = cal.get(Calendar.MONTH)+ 1;
        int year = cal.get(Calendar.YEAR);

        File file = new File(System.getProperty("user.home"),"patient.txt");

        ArrayList<Integer> numPhys = new ArrayList<Integer>();

        JSONParser parser = new JSONParser();


        for(int j = 0; j <num; j++) {
            try {

                numPhys.add(0);
                Scanner rd = new Scanner(file);
                String line;

                while (rd.hasNext()) {
                    line = rd.nextLine();

                    Object obj = parser.parse(line);

                    JSONObject jsonObject = (JSONObject) obj;
                    String tempId = (String) jsonObject.get("patient_id");

                    File file1 = new File(System.getProperty("user.home"),"disease.txt");

                    DiseaseJSON diseaseJSON = new DiseaseJSON(file1);
                    ArrayList<Disease>disSpec = diseaseJSON.getDiseases(tempId);

                    for (int i = 0; i < disSpec.size(); i++) {
                        Calendar calTemp = Calendar.getInstance();
                        calTemp.setTime(disSpec.get(i).DateOfCreate);

                        int monthTemp = calTemp.get(Calendar.MONTH)+ 1;
                        int yearTemp = calTemp.get(Calendar.YEAR);
                        if (monthTemp == (month + j)%12 && yearTemp == year + (month + j)/12
                                && disSpec.get(i).getNameOfDisease().equals(name)){
                            int tempNum = numPhys.get(j)+ 1;
                            numPhys.add(j, tempNum);
                        }
                    }


                }
                rd.close();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (org.json.simple.parser.ParseException e1) {
                e1.printStackTrace();
            }
        }
        return numPhys;
    }

    @Override
    public void deleteDoctorPatient(String patientId, String doctorId) {
        File file = new File(System.getProperty("user.home"),"patient.txt");
        PatientJSON patient = new PatientJSON(file);
        patient.deleteDoctor(patientId, doctorId);

        File file1 = new File(System.getProperty("user.home"),"doctor.txt");
        DoctorJSON doctor = new DoctorJSON(file);
        doctor.deletePatient(doctorId, patientId);



    }

    @Override
    public ArrayList<Message> getMessages(User user) {
        File file = new File(System.getProperty("user.home"),"message.txt");
        MessageJSON message = new MessageJSON(file);

        return message.getMessages(user.getId(), "receiver_id", 0);
    }

    @Override
    public ArrayList<Message> readInbox(User user) {
        return null;
    }

    @Override
    public void deleteMsgUserSend(User user) {
        File file = new File(System.getProperty("user.home"),"message.txt");
        MessageJSON message = new MessageJSON(file);

        message.deleteMessage(user.getId(), "sender_id");
    }

    @Override
    public void SignUp(User user) {
        UserJSON userJSON = new UserJSON();
        userJSON.saveUser(user);
        File file = new File(System.getProperty("user.home"),"doctor.txt");
        DoctorJSON doctorJSON = new DoctorJSON(file);
        doctorJSON.saveDoctor(user);
        File filemsg = new File(System.getProperty("user.home"),"message.txt");
        MessageJSON msg = new MessageJSON(filemsg);
        msg.deleteMessage(user.getId(), "sender_id");


    }

    @Override
    public void Login(User user) {

    }

    @Override
    public User getUser(String username) {

        String userID = null;
        JSONParser parser = new JSONParser();

        try {
            String nameFile = "user.txt";
            Scanner rd = new Scanner(new File(System.getProperty("user.home"), nameFile));

            String line;
            while (rd.hasNext()) {
                line = rd.nextLine();

                Object obj = parser.parse(line);

                JSONObject jsonObject = (JSONObject) obj;

                String tempUsername = (String) jsonObject.get("username");

                if (tempUsername.equals(username)) {

                    userID = (String) jsonObject.get("user_id");
                }


            }
            rd.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }




        UserJSON user = new UserJSON(userID);
        return  new Doctor(user.getUser(), user.getUser().getMytype());
    }

    @Override
    public ArrayList<User> search() {
        return null;
    }

    public int numMonth(Date first, Date second){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(first);
        int year1 = cal1.get(Calendar.YEAR);
        int month1 = cal1.get(Calendar.MONTH);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(second);
        int year2 = cal2.get(Calendar.YEAR);
        int month2 = cal2.get(Calendar.MONTH);

        return (year2 - year1) * 12 + (month2 - month1) + 1;


    }

}


