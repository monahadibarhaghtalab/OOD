package ui.user;

/**
 * Created by a on 5/8/15.
 */

import data.dao.UserFuncDao;
import data.dao.imp.AdminDaoImpl;
import logical.user.patient.Patient;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.user.doctor.ListPatient;
import ui.user.doctor.LookforPateint;
import ui.user.doctor.SeeMessage;
import logical.user.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FirstPageAdmin extends Temp {
    private myJFrame window;
    private UserFuncDao adminDao;
    private Admin myAdmin;
//    private myJButton history;
//    private myJButton submitStatus;
    private myJButton showPatient;
    private myJButton consult;
    private myJButton inbox;

    public FirstPageAdmin(Admin admin){
        super();
        myAdmin = admin;
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
                adminDao = new AdminDaoImpl();
                ArrayList<User> tmp = adminDao.showListOfUser();
                ArrayList<Patient> patients = new ArrayList<Patient>();
                for (int i = 0; i< tmp.size(); i++){
                    patients.add((Patient) tmp.get(i));
                }
                new ListPatient(patients);
                //  window.setVisible(false);
            }
        });

        consult.set(150, start +  height, 300, height, "B Nazanin", 20);
        consult.setText("جستجوی بیمار");
        window.add(consult);

        consult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LookforPateint();
                //  window.setVisible(false);
            }
        });

        inbox.set(150, start + 2 * height, 300, height, "B Nazanin", 20);
        inbox.setText("مشاهده صندوق پیام");
        window.add(inbox);

        inbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminDao = new AdminDaoImpl();
                ArrayList<Message> messages =adminDao.readInbox(myAdmin);
                new SeeMessage(messages,"admin");
                //new Inbox(messages);
                //  window.setVisible(false);
            }
        });
    }
}
