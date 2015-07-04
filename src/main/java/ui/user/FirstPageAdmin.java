package ui.user;

/**
 * Created by a on 5/8/15.
 */

import data.dao.AdminDao;
import data.dao.UserFuncDao;
import data.dao.imp.AdminDaoImpl;
import data.typeDetector;
import logical.user.patient.Patient;
import main.Main;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.user.doctor.ListPatient;
import ui.user.doctor.LookforPateint;
import ui.user.doctor.SeeMessage;
import logical.user.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FirstPageAdmin extends Temp {
    private myJFrame window;
    private AdminDao adminDao;
    private Admin myAdmin;
    private typeDetector detector;

    //    private myJButton history;
//    private myJButton submitStatus;
    private myJButton showPatient;
    private myJButton consult;
    private myJButton inbox;
    private myJButton seeHist;

    public FirstPageAdmin(Admin admin){
        super();
        System.out.println(super.profile1);
        super.profile1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);

            }
        });
        myAdmin = admin;
        detector = new typeDetector();
        window = getWindow("ورود به عنوان مدیر سامانه", true);

//        history = new myJButton(false);
//        submitStatus = new myJButton(false);
        showPatient = new myJButton(false);
        consult = new myJButton(false);
        inbox = new myJButton(false);

        int start = 200;
        int height = 30;

//        history.set(150, start, 300, height, "B Nazanin", 20);
//        history.setText("مشاهده سوابق");
//        window.add(history);
//
//        history.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new History();
//                //  window.setVisible(false);
//            }
//        });
//
//        submitStatus.set(150, start + height, 300, height, "B Nazanin", 20);
//        submitStatus.setText("ثبت وضعیت بدنی");
//        window.add(submitStatus);
//
//        submitStatus.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new SubmitStatus();
//                //  window.setVisible(false);
//            }
//        });
//
        showPatient.set(150, start , 300, height, "B Nazanin", 20);
        showPatient.setText("مشاهده ی لیست بیماران");
        window.add(showPatient);

        showPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminDao = (AdminDao)detector.getAdminDao(Main.SaveType);

                ArrayList<Patient> patients = adminDao.showListOfAllPatients();
                if(patients.size() == 0){
                    JOptionPane.showMessageDialog(null, "بیماری یافت نشد!","اطلاعات",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    new ListPatient(patients);
                }
                //  window.setVisible(false);
            }
        });

        consult.set(150, start +  height, 300, height, "B Nazanin", 20);
        consult.setText("جستجوی بیمار");
        window.add(consult);

        consult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LookforPateintAdmin();
                //  window.setVisible(false);
            }
        });

        inbox.set(150, start + 2 * height, 300, height, "B Nazanin", 20);
        inbox.setText("مشاهده صندوق پیام");
        window.add(inbox);

        inbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminDao = (AdminDao)detector.getAdminDao(Main.SaveType);
                ArrayList<Message> messages =adminDao.getMessages(myAdmin);
                if(messages.size() == 0){
                    JOptionPane.showMessageDialog(null, "پیامی یافت نشد!","اطلاعات"
                            , JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    new SeeMessage(messages,"admin");
                //new Inbox(messages);
                //  window.setVisible(false);
            }
        });

//        seeHist.set(150, start + 3 * height, 300, height, "B Nazanin", 20);
//        seeHist.setText("مشاهده صندوق پیام");
//        window.add(seeHist);
//
//        seeHist.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                adminDao = new AdminDaoImpl();
//                ArrayList<Message> messages =adminDao.readInbox(myAdmin);
//                new SeeMessage(messages,"admin");
//                //new Inbox(messages);
//                //  window.setVisible(false);
//            }
//        });
    }
}
