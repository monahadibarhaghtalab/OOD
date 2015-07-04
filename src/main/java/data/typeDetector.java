package data;

import data.dao.*;
import data.dao.fileImp.AdminDaoImplFile;
import data.dao.fileImp.DoctorDaoImplFile;
import data.dao.fileImp.MessageDaoImplFile;
import data.dao.fileImp.PatientDaoImplFile;
import data.dao.imp.AdminDaoImpl;
import data.dao.imp.DoctorDaoImpl;
import data.dao.imp.MessageDaoImpl;
import data.dao.imp.PatientDaoImpl;

/**
 * Created by a on 6/30/15.
 */
public class typeDetector {
    private AdminDao adminDao;
    private DoctorDao doctorDao;
    private MessageDao messageDao;
    private PatientDao patientDao;

    public typeDetector(){

    }

    public UserDao getAdminDao(String type){
        if(type.equals("DB"))
            return new AdminDaoImpl();
        else  if(type.equals("FILE"))
            return new AdminDaoImplFile();
        return null;

    }


    public AdminDao getAdminDao1(String type){
        if(type.equals("DB"))
            return new AdminDaoImpl();
        else  if(type.equals("FILE"))
            return new AdminDaoImplFile();
        return null;

    }
    public UserDao getDoctorDao(String type){
        if(type.equals("DB"))
            return new DoctorDaoImpl();
        else  if(type.equals("FILE"))
            return new DoctorDaoImplFile();
        return null;

    }

    public MessageDao getMessageDao(String type){
        if(type.equals("DB"))
            return new MessageDaoImpl();
        else  if(type.equals("FILE"))
            return  new MessageDaoImplFile();
        return null;

    }

    public UserDao getPatientDao(String type){
       System.out.println("Type of DAta: " + type);
        if(type.equals("DB"))
            return new PatientDaoImpl();
        else  if(type.equals("FILE")) {
            System.out.println("salaaaaaaaaaam");
            return new PatientDaoImplFile();
        }
        return null;

    }
}
