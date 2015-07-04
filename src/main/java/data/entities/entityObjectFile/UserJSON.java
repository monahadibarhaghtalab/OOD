package data.entities.entityObjectFile;

import logical.user.User;
import logical.user.patient.Patient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Mona on 6/29/2015.
 */
public class UserJSON {

    JSONObject userJSON;

    String user_id;
    String name;
    String familyName;
    String username;
    char[] password;
    String type;

    public UserJSON(String id){

        JSONParser parser = new JSONParser();

        try {
            File file = new File(System.getProperty("user.home"),"user.txt");
            Scanner rd = new Scanner(file);

            String line;
            while (rd.hasNext()) {
                line = rd.nextLine();

                Object obj = parser.parse(line);

                JSONObject jsonObject = (JSONObject) obj;

                String tempID = (String) jsonObject.get("user_id");

                if(tempID.equals(id)){

                    this.userJSON = jsonObject;
                    user_id = (String) jsonObject.get("user_id");
                    name = (String) jsonObject.get("name");
                    familyName = (String) jsonObject.get("familyName");
                    username = (String) jsonObject.get("username");
                    password = ((String) jsonObject.get("password")).toCharArray();
                    type = (String) jsonObject.get("type");
                    break;
                }
                System.out.println("Name: " + id);

            }
            rd.close();

//            System.out.println("In UserJson . get USer delete: "+ file.delete());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    public UserJSON() {

    }

    public void saveUser(User user){

        File file = new File(System.getProperty("user.home"),"user.txt");
        if(Util.getJsonObject(user.getId(), "user_id", file) == null) {
            try {
                PrintWriter pw = new PrintWriter(new FileWriter(new File(System.getProperty("user.home"),"user.txt"), true));

                JSONObject obj = new JSONObject();
                obj.put("user_id", user.getId());
                obj.put("name", user.getName());
                obj.put("familyName", user.getFamilyName());
                obj.put("username", user.getUsername());
                System.out.println("user :  " + user.getPassword());
                obj.put("password", new String(user.getPassword()));
                obj.put("type", user.getMytype());


                pw.println(obj.toString());

                pw.flush();
                pw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public User getUser(){
        return new User(username, password, name, familyName, user_id, type);
    }

    public JSONObject getUserJSON(){
        return userJSON;
    }
}
