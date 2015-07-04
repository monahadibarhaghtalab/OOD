package data.entities.entityObjectFile;

import logical.Activity;
import logical.user.Message;
import logical.user.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Mona on 6/29/2015.
 */
public class MessageJSON {

    String message_id;
    String content;
    Date date;
    String title;
    String receiver_id;
    String sender_id;
    int type;

    File file ;

    JSONObject jsonObject;



    public MessageJSON(File file) {
        this.file = file;
    }

    //User sender, User receiver, Date date, String content, String title, String id, int type


    public ArrayList<Message> getMessages(String id, String filter, int typeNum) {

        ArrayList<Message> msgArray = new ArrayList<Message>();



            JSONParser parser = new JSONParser();

            try {

                Scanner rd = new Scanner(file);
                String line;
                while (rd.hasNext()) {
                    line = rd.nextLine();

                    Object obj = parser.parse(line);

                    JSONObject jsonObject = (JSONObject) obj;
                    String tempId = (String) jsonObject.get(filter);

                    if (tempId.equals(id)) {
                        int type = Integer.parseInt((String) jsonObject.get("type"));
                        if (type == typeNum) {
                            String content = (String) jsonObject.get("content");
                            Date date =  Util.stringToDate((String) jsonObject.get("date"));
                            String title = (String) jsonObject.get("title");
                            String receiver_id = (String) jsonObject.get("receiver_id");
                            String sender_id = (String) jsonObject.get("sender_id");
                            String PatientId = (String) jsonObject.get("PatientId");
                            msgArray.add(new Message(new UserJSON(sender_id).getUser(), new UserJSON(receiver_id).getUser(), date, content, title, PatientId, type));

                        }


                    }
                }
                rd.close();
            }catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (org.json.simple.parser.ParseException e1) {
                e1.printStackTrace();
            }

        return  msgArray;
    }




    public void deleteMessage(String id, String filter) {
        JSONParser parser = new JSONParser();

        try {
            String nameFile = "message.txt";
            Scanner rd = new Scanner(new File(System.getProperty("user.home"),nameFile));

            String line;
            while (rd.hasNext()) {
                line = rd.nextLine();

                Object obj = parser.parse(line);

                JSONObject jsonObject = (JSONObject) obj;

                String tempID = (String) jsonObject.get(filter);

                if (tempID.equals(id)) {
                    rd.close();
                    Util.deleteLine(jsonObject, nameFile);
                    break;
                }


            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void deleteLine(JSONObject jsonObject, String nameFile) {

        JSONParser parser = new JSONParser();
        Scanner rd = null;
        try {

            File messageBefore = new File(nameFile);
            rd = new Scanner(messageBefore);
            File messageAfter = new File(System.getProperty("user.home"),"temp.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(messageAfter , true));
            String line;
            while (rd.hasNext()) {
                line = rd.nextLine();

                Object obj = parser.parse(line);

                JSONObject jsonObject1 = (JSONObject) obj;

                if (!jsonObject.equals(jsonObject1)) {

                    pw.println(jsonObject.toString());
                }

            }
            pw.flush();
            pw.close();
            rd.close();

            messageBefore.delete();


            messageAfter.renameTo(messageBefore);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void saveMessage(Message message) {

        try {


            PrintWriter pw = new PrintWriter(new FileWriter(file, true));

            JSONObject obj = new JSONObject();


            obj.put("content", message.getContent());
            obj.put("date", Util.dateToString(message.getDateOdCreate()));
            obj.put("title", message.getTitle());
            obj.put("receiver_id", message.getReceiver().getId());
            obj.put("sender_id", message.getSender().getId());
            obj.put("type", message.getType() + "");
            obj.put("PatientId", message.getPatientId());

            User receiver = message.getReceiver();
            User sender = message.getSender();
            UserJSON userJSONRec = new UserJSON();
            UserJSON userJSONSen = new UserJSON();
            userJSONRec.saveUser(receiver);
            userJSONSen.saveUser(sender);

            pw.println(obj.toString());

            pw.flush();
            pw.close();

            System.out.println("messageSaveSucc");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
