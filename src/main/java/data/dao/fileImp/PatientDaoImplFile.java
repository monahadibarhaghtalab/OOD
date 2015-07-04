package data.dao.fileImp;

import data.dao.PatientDao;
import data.dao.UserFuncDao;
import data.entities.entityObjectFile.*;
import logical.Activity;
import logical.Disease;
import logical.Recipe;
import logical.user.Message;
import logical.user.PhysicalState;
import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.doctor.ExpertDoctor;
import logical.user.doctor.OrdDoctor;
import logical.user.patient.Patient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Mona on 6/30/2015.
 */
public class PatientDaoImplFile implements UserFuncDao, PatientDao {
    @Override
    public ArrayList<Doctor> getAllDoctors(Patient p) {

        File file = new File(System.getProperty("user.home"),"patient.txt");
        PatientJSON actJson = new PatientJSON(file);

        return actJson.getDoctors(p.getId());
    }

    @Override
    public OrdDoctor getOrdDoc(Patient p) {
        File file = new File(System.getProperty("user.home"),"patient.txt");
        PatientJSON actJson = new PatientJSON(file);

        ArrayList<Doctor> act = actJson.getDoctors(p.getId());

        for(int i = 0 ; i < act.size(); i++){
            if(act.get(i).getType().equals("General")){
                return new OrdDoctor(act.get(i));
            }

        }
        return null;
    }

    @Override
    public void addHistory(Patient p, Disease d) {
        File file = new File(System.getProperty("user.home"),"disease.txt");
        DiseaseJSON dis = new DiseaseJSON(file);
        dis.saveHistory(p.getId(), d);

    }

    @Override
    public void addPhysicalState(Patient p, PhysicalState ps) {
        File file = new File(System.getProperty("user.home"),"physicalState.txt");
        PhysicalStateJSON phys = new PhysicalStateJSON(file);
        phys.savePhysicalState(p.getId(), ps);

    }

    @Override
    public void addRecipe(Patient p, Recipe r) {
        File file = new File(System.getProperty("user.home"),"recipe.txt");
        RecipeJSON rec = new RecipeJSON(file);
        rec.saveRecipe(p.getId(), r);
    }

    @Override
    public ArrayList<Disease> getHistory(Date firstDate, Date secondDate, Patient p) {

        File file = new File(System.getProperty("user.home"),"disease.txt");
        DiseaseJSON actJson = new DiseaseJSON(file);

        ArrayList<Disease> act = actJson.getDiseases(p.getId());
        ArrayList<Disease> actRes = new ArrayList<Disease>();
        for(int i = 0 ; i < act.size(); i++){
            if(act.get(i).getDateOfCreate().after(firstDate) && act.get(i).getDateOfCreate().before(secondDate)){
                actRes.add(act.get(i));
            }

        }
        return actRes;
    }

    @Override
    public ArrayList<Activity> getActivity(Date firstDate, Date secondDate, Patient myPatientProfile) {
        File file = new File(System.getProperty("user.home"),"activity.txt");
        ActivityJSON actJson = new ActivityJSON(file);

        ArrayList<Activity> act = actJson.getActivities(myPatientProfile.getId());
        ArrayList<Activity> actRes = new ArrayList<Activity>();
        for(int i = 0 ; i < act.size(); i++){
            if(act.get(i).DateOfCreate.after(firstDate) && act.get(i).DateOfCreate.before(secondDate)){
                actRes.add(act.get(i));
            }

        }
        return actRes;
    }

    @Override
    public void addActivity(Patient myPatientProfile, Activity activity) {
        File file = new File(System.getProperty("user.home"),"activity.txt");
        ActivityJSON act = new ActivityJSON(file);
        act.saveActivity(myPatientProfile.getId(), activity);
    }

    @Override
    public ArrayList<PhysicalState> getPhysicalState(Date firstDate, Date secondDate, Patient myPatientProfile) {
        File file = new File(System.getProperty("user.home"),"physicalState.txt");
        PhysicalStateJSON physJson = new PhysicalStateJSON(file);
        ArrayList<PhysicalState> phys = physJson.getPhysicalStates(myPatientProfile.getId());
        ArrayList<PhysicalState> physRes = new ArrayList<PhysicalState>();
        for(int i = 0 ; i < phys.size(); i++){
            if(phys.get(i).getDate().after(firstDate) && phys.get(i).getDate().before(secondDate)){
                physRes.add(phys.get(i));
            }

        }
        return physRes;
    }

    @Override
    public Patient getPatientByID(String Id) {
        return new Patient(new UserJSON(Id).getUser());
    }

    @Override
    public ArrayList<OrdDoctor> getListOfAllOrdDoctor() {
        File file = new File(System.getProperty("user.home"),"doctor.txt");
        ArrayList<String> doctorIds = Util.getObjects("doctor_id", file);
        System.out.println("get List of all ord Doctor: " + doctorIds.size() );
        ArrayList<OrdDoctor> ordDoctors = new ArrayList<OrdDoctor>();
        for(int i = 0; i < doctorIds.size(); i++){
            String type = new UserJSON(doctorIds.get(i)).getUser().getMytype();
            if(type.equals("General")){
                ordDoctors.add(new OrdDoctor(new Doctor(new UserJSON(doctorIds.get(i)).getUser(), type)));
            }
        }
        return ordDoctors;
    }

    @Override
    public ArrayList<ExpertDoctor> getListOfProDoctor(String text, String text1) {
        File file = new File(System.getProperty("user.home"),"doctor.txt");
        ArrayList<String> doctorIds = Util.getObjects("doctor_id", file);
        ArrayList<ExpertDoctor> expertDoctors = new ArrayList<ExpertDoctor>();
        for(int i = 0; i < doctorIds.size(); i++){
            User user = new UserJSON(doctorIds.get(i)).getUser();
            String type = new UserJSON(doctorIds.get(i)).getUser().getMytype();

            if(type.equals("Spec") && user.getName().equals(text) && user.getFamilyName().equals(text1)){
                expertDoctors.add(new ExpertDoctor(new Doctor(new UserJSON(doctorIds.get(i)).getUser(), type)));
            }
        }
        return expertDoctors;
    }

    @Override
    public ArrayList<OrdDoctor> getListOfOrdDoctor(String text, String text1) {
        File file = new File(System.getProperty("user.home"),"doctor.txt");
        ArrayList<String> doctorIds = Util.getObjects("doctor_id", file);
        System.out.println("get List of ord Doctor: " + doctorIds.size() );
        ArrayList<OrdDoctor> ordDoctors = new ArrayList<OrdDoctor>();
        for(int i = 0; i < doctorIds.size(); i++){
            User user = new UserJSON(doctorIds.get(i)).getUser();
            String type = new UserJSON(doctorIds.get(i)).getUser().getMytype();
            if(type.equals("General") && user.getName().equals(text) && user.getFamilyName().equals(text1)){
                ordDoctors.add(new OrdDoctor(new Doctor(new UserJSON(doctorIds.get(i)).getUser(), type)));
            }
        }
        return ordDoctors;
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

        File filep = new File(System.getProperty("user.home"),"patient.txt");
        PatientJSON patientJSON = new PatientJSON(filep);
        patientJSON.savePatient(user.getId());

        File filea = new File(System.getProperty("user.home"),"activity.txt");
        ActivityJSON activityJSON = new ActivityJSON(filea);
        activityJSON.savePatient(user.getId());

        File filed = new File(System.getProperty("user.home"),"disease.txt");
        DiseaseJSON diseaseJSON = new DiseaseJSON(filed);
        diseaseJSON.savePatient(user.getId());

        File fileph = new File(System.getProperty("user.home"),"physicalState.txt");
        PhysicalStateJSON physicalStateJSON = new PhysicalStateJSON(fileph);
        physicalStateJSON.savePatient(user.getId());

        File filer = new File(System.getProperty("user.home"),"recipe.txt");
        RecipeJSON recipeJSON = new RecipeJSON(filer);
        recipeJSON.savePatient(user.getId());



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
            File file = new File(System.getProperty("user.home"),nameFile);
            Scanner rd = new Scanner(file);

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
        return  new Patient(user.getUser());
    }

    @Override
    public ArrayList<User> search() {
        return null;
    }
}
