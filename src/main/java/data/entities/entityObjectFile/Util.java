package data.entities.entityObjectFile;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Mona on 7/1/2015.
 */
public class Util {

    public static String dateToString(Date date){

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        return df.format(date);
    }

    public static Date stringToDate(String date)  {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date firstDate = null;

        try {
            firstDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return firstDate;
    }


    public  static JSONObject getJsonObject(String id, String compare, File file) {


        System.out.println("in get Json!! " + file.getName());
        JSONParser parser = new JSONParser();

        try {

            Scanner rd = new Scanner(file);
            String line;
            while (rd.hasNext()) {
                line = rd.nextLine();

                Object obj = parser.parse(line);

                JSONObject jsonObject = (JSONObject) obj;
                String tempId = (String) jsonObject.get(compare);

                if (tempId.equals(id)) {
                    rd.close();
//                    System.out.println("getJson delete: " + file.delete());

                    return jsonObject;
                }


            }



        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (org.json.simple.parser.ParseException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public static void rewrite(File file, String id, String filter,  JSONObject jsonFirst) {
        JSONParser parser = new JSONParser();
        Scanner rd = null;
        try {

            File messageBefore = file;
            rd = new Scanner(messageBefore);

//            File temp1 = new File("src\\dataBase\\temp1.txt");
            File messageAfter = new File(System.getProperty("user.home"),"temp"+file.getName());
            PrintWriter pw = new PrintWriter(new FileWriter(messageAfter, true));
            String line;
            while (rd.hasNext()) {
                line = rd.nextLine();

                Object obj = parser.parse(line);

                JSONObject jsonObject1 = (JSONObject) obj;

                String idTemp = (String)jsonObject1.get(filter);

                if (!idTemp.equals(id)) {

                    pw.println(jsonObject1.toString());
                }
                else
                    pw.println(jsonFirst.toString());


            }

            pw.flush();
            pw.close();
            rd.close();
//            messageBefore.createNewFile();
            boolean delete = messageBefore.delete();
            System.out.println("delete result: " + delete);

//            messageAfter.createNewFile();
            boolean rename = messageAfter.renameTo(messageBefore);
            System.out.println("rename result: " + rename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public static void deleteLine(JSONObject jsonObject, String nameFile) {

        JSONParser parser = new JSONParser();
        Scanner rd = null;
        try {

            File messageBefore = new File(nameFile);
            rd = new Scanner(messageBefore);
            File messageAfter = new File(System.getProperty("user.home"),"temp"+messageBefore.getName());
            PrintWriter pw = new PrintWriter(new FileWriter(messageAfter, true));
            String line;
            while (rd.hasNext()) {
                line = rd.nextLine();

                Object obj = parser.parse(line);

                JSONObject jsonObject1 = (JSONObject) obj;

                if (!jsonObject.equals(jsonObject1)) {

                    pw.println(jsonObject1.toString());
                }

            }

            pw.flush();
            pw.close();

            rd.close();

//            messageBefore.createNewFile();
            boolean delete = messageBefore.delete();
            System.out.println("in deleteline delete: " + delete);

//            messageAfter.createNewFile();
            messageAfter.renameTo(messageBefore);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static ArrayList<String> getObjects (String compare, File file){
        ArrayList<String> res = new ArrayList<String>();

        JSONParser parser = new JSONParser();

        try {

            Scanner rd = new Scanner(file);
            String line;
            while (rd.hasNext()) {
                line = rd.nextLine();

                Object obj = parser.parse(line);

                JSONObject jsonObject = (JSONObject) obj;
                res.add((String) jsonObject.get(compare));


            }
            rd.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (org.json.simple.parser.ParseException e1) {
            e1.printStackTrace();
        }
        return res;
    }
}

