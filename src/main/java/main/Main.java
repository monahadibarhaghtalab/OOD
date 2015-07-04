package main;

import data.context.DatabaseContext;
//import data.entities.PatientEntity;
import data.dao.AdminDao;
import data.dao.UserDao;
import data.entities.autoentity.MakeDeviceEntity;
import data.entities.autoentity.MakeDoctorEntity;
import data.entities.entityObjectFile.Util;
import data.typeDetector;
import logical.user.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ui.user.general.Welcome;

import java.io.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Mona on 3/14/2015.
 */
public class Main {

    public static Map<String,String> nameMap = new HashMap<String,String>() {{
        put("General", "پزشک عمومی");
        put("Spec", "پزشک متخصص");
        put("patient", "بیمار");
    }};

    public static String SaveType;

    private  String getFile(String fileName) throws FileNotFoundException {

        //StringBuilder result = new StringBuilder("");

        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        System.out.println("loader: "+classLoader.getResource(fileName));
        File file = new File(System.getProperty("user.home"),"setting");
        Scanner scanner = new Scanner(file);
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
           // result.append(line).append("\n");
        }

        scanner.close();

        return line;

    }
    public static void main(String[] args) throws IOException, ParseException {
//read type from file


        createSomeData();
        Main obj = new Main();
       // String temp = obj.getFile("file/setting.txt");
        File file = new File(System.getProperty("user.home"),"setting.txt");
        Scanner rd1 = new Scanner(file);
        String temptype;
        temptype = rd1.nextLine();

        String[] t = temptype.split(":");
        SaveType = t[1];



        File file1 = new File(System.getProperty("user.home"),"init.txt");
        Scanner rd = new Scanner(file1);
        String line;
        line = rd.nextLine();

        JSONParser parser = new JSONParser();
        Object object = parser.parse(line);

        JSONObject jsonObject = (JSONObject) object;

        int flag = Integer.parseInt((String)jsonObject.get("flag"));

        rd.close();

        //String username, char[] password, String name, String familyName, String id, String type
        if (flag == 0) {
            typeDetector detector = new typeDetector();
            AdminDao adminDao = detector.getAdminDao1(Main.SaveType);

            String user_id = (String) jsonObject.get("user_id");
            String name = (String) jsonObject.get("name");
            String familyName = (String) jsonObject.get("familyName");
            String username = (String) jsonObject.get("username");
            char[] password = ((String) jsonObject.get("password")).toCharArray();
            String type = (String) jsonObject.get("type");
            adminDao.addAdmin(new User(username, password, name, familyName, user_id, type));


            JSONObject obj1 = new JSONObject();
            obj1.put("user_id", "1");
            obj1.put("name", "admin");
            obj1.put("familyName", "admin");
            obj1.put("username", "admin");
//            System.out.println("user :  " + user.getPassword());
            obj1.put("password", "admin");
            obj1.put("type", "admin");
            obj1.put("flag", "1");
            Util.rewrite(file1, "admin", "username", obj1);
        }


//            messageBefore.c




        System.out.println("type: " + SaveType);
        Welcome welcome = new Welcome();
    }



    private static void createSomeData() {
        Session session = null;
        Transaction tx = null;
      //  try {
//            session = new DatabaseContext().getSession();
//            tx = session.beginTransaction();
//
//            PatientEntity user = new PatientEntity("Mona2", "12345", "Hadi");
//            session.save(user);
//
//
//            tx.commit();
//            System.out.println("Everything saved successfully");
//        } catch (Exception ex) {
//            if (tx != null)
//                tx.rollback();
//            throw new RuntimeException(ex);
//        }
        //finally {
//            if (session != null)
//                session.close();
//        }
    }
}
