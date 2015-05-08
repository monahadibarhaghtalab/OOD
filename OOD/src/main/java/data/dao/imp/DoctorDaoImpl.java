package data.dao.imp;
import data.dao.*;
import logical.user.doctor.doctor;
import logical.user.message;
import logical.user.patient.patient;
import logical.user.user;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public class DoctorDaoImpl implements UserFuncDao, DoctorDao {

    @Override
    public ArrayList<message> readInbox() {
        //list payam haye pezashk
        return null;
    }

    @Override
    public void SignUp(user user) {
        //save doctor into db

    }

    @Override
    public void Login(user user) {

    }

    @Override
    public user getUser(String username) {
        //return doctor
        return null;
    }

    @Override
    public void retriveData(user user) {
        //find message list
        //find consultation list
        //find patient list
    }

    @Override
    public ArrayList<user> search() {
        //nothing
        return null;
    }

    @Override
    public ArrayList<user> showListOfUser() {
        //nothing
        return null;
    }

    @Override
    public ArrayList<patient> showListOfPatient(doctor doctor) {
        //liste bimaran pezash az db khande return mishavad
        return null;
    }

    @Override
    public patient searchPatient(doctor doctor, int ID) {
        //bimar ba code melli ID az db khande shode return mishavad
        return null;
    }
}
