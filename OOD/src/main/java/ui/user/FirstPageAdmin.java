package ui.user;

/**
 * Created by a on 5/8/15.
 */

import data.dao.UserFuncDao;
import data.dao.imp.AdminDaoImpl;
import ui.element.myJButton;
import ui.element.myJFrame;
import logical.user.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class FirstPageAdmin extends Temp {
    private myJFrame window;
    private UserFuncDao adminDao;
//    private myJButton history;
//    private myJButton submitStatus;
//    private myJButton chooseDoctor;
//    private myJButton consult;
    private myJButton inbox;

    public FirstPageAdmin(){
        super();

        window = getWindow("ورود به عنوان مدیر سامانه", true);

//        history = new myJButton(false);
//        submitStatus = new myJButton(false);
//        chooseDoctor = new myJButton(false);
//        consult = new myJButton(false);
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
//        chooseDoctor.set(150, start + 2 * height, 300, height, "B Nazanin", 20);
//        chooseDoctor.setText(" انتخاب / تغییر پزشک");
//        window.add(chooseDoctor);
//
//        chooseDoctor.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new ChooseDoctor();
//                //  window.setVisible(false);
//            }
//        });
//
//        consult.set(150, start + 3 * height, 300, height, "B Nazanin", 20);
//        consult.setText("مشاوره");
//        window.add(consult);
//
//        consult.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new Consult();
//                //  window.setVisible(false);
//            }
//        });

        inbox.set(150, start + 4 * height, 300, height, "B Nazanin", 20);
        inbox.setText("مشاهده صندوق پیام");
        window.add(inbox);

        inbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminDao = new AdminDaoImpl();
                ArrayList<Message> messages =adminDao.readInbox();
                new Inbox(messages);
                //  window.setVisible(false);
            }
        });
    }
}
