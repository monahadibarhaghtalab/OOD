package data.dao.fileImp;

import data.dao.AdminDao;
import data.dao.UserFuncDao;
import data.dao.imp.DaoImp;
import data.entities.entityObjectFile.MessageJSON;
import data.entities.entityObjectFile.UserJSON;
import data.entities.entityObjectFile.Util;
import logical.user.Message;
import logical.user.User;
import logical.user.patient.Patient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//import org.json.JSONObject;

/**
 * Created by Mona on 6/24/2015.
 */
public class AdminDaoImplFile extends DaoImp implements UserFuncDao, AdminDao {

    @Override
    public ArrayList<Message> readInbox() {

        return null;
    }

    @Override
    public Patient searchPatient(String PatientID) {

        UserJSON user = new UserJSON(PatientID);
        return new Patient(user.getUser());
    }

    @Override
    public ArrayList<Patient> showListOfAllPatients() {
        File file = new File (System.getProperty("user.home"), "patient.txt");
        ArrayList<String> patientIds = Util.getObjects("patient_id", file);
        ArrayList<Patient> patientRes = new ArrayList<Patient>();
        for(int i = 0; i < patientIds.size(); i++){
            patientRes.add(new Patient(new UserJSON(patientIds.get(i)).getUser()));
        }
      return  patientRes;
    }

    @Override
    public void addAdmin(User user) {
        File file = new File (System.getProperty("user.home"), "user.txt");
        UserJSON userJSON = new UserJSON();
        userJSON.saveUser(user);
    }

    @Override
    public ArrayList<Message> getMessages(User user) {

        File file = new File (System.getProperty("user.home"),"message.txt");
        MessageJSON msg = new MessageJSON(file);
        return msg.getMessages(user.getId(), "receiver_id", 0);

    }

    @Override
    public ArrayList<Message> readInbox(User user) {


        return null;
    }

    @Override
    public void deleteMsgUserSend(User user) {

        File file = new File (System.getProperty("user.home"),"user.txt");
        MessageJSON message = new MessageJSON(file);
        message.deleteMessage(user.getId(), "sender_id");
        }




    @Override
    public void SignUp(User user) {

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(new File(System.getProperty("user.home"),"user.txt"), true));
            UserJSON userJson = new UserJSON(user.getId());
            pw.println(userJson.getUserJSON().toString());

            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            File file1 = new File(System.getProperty("user.home"), nameFile);
            Scanner rd = new Scanner(file1);

            String line;
            while (rd.hasNext()) {
                line = rd.nextLine();

                Object obj = parser.parse(line);

                JSONObject jsonObject = (JSONObject) obj;

                String tempUsername = (String) jsonObject.get("username");

                if (tempUsername.equals(username)) {

                    userID = (String) jsonObject.get("user_id");
                    rd.close();
                    break;
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }




        UserJSON user = new UserJSON(userID);
        return  user.getUser();
    }

    @Override
    public ArrayList<User> search() {
        return null;
    }



}