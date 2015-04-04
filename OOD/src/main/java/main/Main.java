package main;

import data.context.DatabaseContext;
import data.entities.PatientEntity;
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
            session = new DatabaseContext().getSession();
            tx = session.beginTransaction();

            PatientEntity user = new PatientEntity("Mona", "12345", "Salehi");
            session.save(user);


            tx.commit();
            System.out.println("Everything saved successfully");
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
