package main;

import data.context.DatabaseContext;
<<<<<<< HEAD
//import data.entities.PatientEntity;
=======
<<<<<<< HEAD
//import data.entities.PatientEntity;
=======
import data.entities.entityfile.PatientEntity;
>>>>>>> 8811055fb541bc0d27c5edf7237993e31ef0c1d0
>>>>>>> 47c94e9c1d0f41233979693bf53419de80897aa8
import org.hibernate.Session;
import org.hibernate.Transaction;
import ui.user.general.Welcome;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Mona on 3/14/2015.
 */
public class Main {
    public static void main(String[] args){
        createSomeData();
        Welcome welcome = new Welcome();
    }



    private static void createSomeData() {
        Session session = null;
        Transaction tx = null;
      //  try {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 47c94e9c1d0f41233979693bf53419de80897aa8
//            session = new DatabaseContext().getSession();
//            tx = session.beginTransaction();
//
//            PatientEntity user = new PatientEntity("Mona2", "12345", "Hadi");
//            session.save(user);
//
//
//            tx.commit();
//            System.out.println("Everything saved successfully");
<<<<<<< HEAD
=======
=======
            session = new DatabaseContext().getSession();
            tx = session.beginTransaction();

            PatientEntity user = new PatientEntity("Mona2", "12345", "Hadi");
            session.save(user);

            System.out.println("after save!!");

            tx.commit();
            System.out.println("Everything saved successfully");
>>>>>>> 8811055fb541bc0d27c5edf7237993e31ef0c1d0
>>>>>>> 47c94e9c1d0f41233979693bf53419de80897aa8
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
