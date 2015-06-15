package ui.user.patient;

import data.dao.PatientDao;
import data.dao.UserFuncDao;
import data.dao.imp.PatientDaoImpl;
import logical.user.Message;
import logical.user.doctor.OrdDoctor;
import logical.user.patient.Patient;
import logical.user.User;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.Temp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Mona on 3/30/2015.
 */
public class FirstPagePatient extends Temp {
    private myJFrame window;
    private Patient myPatient;
    private UserFuncDao pationtdao;
    private myJButton history;
    private myJButton submitStatus;
    private myJButton chooseDoctor;
    private myJButton consult;
    private myJButton inbox;
    private myJButton list;
    private myJButton activity;
    private myJLabel name, family;
    private myJTextField ntext, ftext;
    public FirstPagePatient( Patient patient){
        super();
        myPatient = patient;
        window = getWindow("ورود به عنوان بیمار", true);

        history = new myJButton(false);
        submitStatus = new myJButton(false);
        chooseDoctor = new myJButton(false);
        consult = new myJButton(false);
        inbox = new myJButton(false);
        list = new myJButton(false);
        activity = new myJButton(false);

        int start = 300;
        int height = 30;

        name = new myJLabel("پزشک عمومی فعلی:");
        name = name.set(300, 200, 160, 20, "B Nazanin", 20);
        window.add(name);

        ntext = new myJTextField("");
        ntext.set(150, 200, 120, 20, "B Nazanin", 20);

        OrdDoctor ord = new PatientDaoImpl().getOrdDoc(myPatient);
        if(ord==null){
            ntext.setText("ندارد");
        }
        else
            ntext.setText(ord.getName() + " "+ ord.getFamilyName());
        window.add(ntext);


        history.set(150, start, 300, height, "B Nazanin", 20);
        history.setText("مشاهده سوابق");
        window.add(history);

        history.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new History(myPatient);
                //  window.setVisible(false);
            }
        });

        submitStatus.set(150, start + height, 300, height, "B Nazanin", 20);
        submitStatus.setText("ثبت وضعیت جسمانی");
        window.add(submitStatus);

        submitStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SubmitStatus(myPatient);
                //  window.setVisible(false);
            }
        });

        chooseDoctor.set(150, start + 2 * height, 300, height, "B Nazanin", 20);
        chooseDoctor.setText(" انتخاب / تغییر پزشک");
        window.add(chooseDoctor);

        chooseDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChooseDoctor(myPatient,myPatient);
                //  window.setVisible(false);
            }
        });

        consult.set(150, start + 3 * height, 300, height, "B Nazanin", 20);
        consult.setText("مشاوره");
        window.add(consult);

        consult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Consult(myPatient);
                //  window.setVisible(false);
            }
        });

        inbox.set(150, start + 4 * height, 300, height, "B Nazanin", 20);
        inbox.setText("مشاهده صندوق پیام");
        window.add(inbox);

        inbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientDaoImpl pdao = new PatientDaoImpl();
               ArrayList<Message> messages=pdao.getMessages(myPatient);
                if(messages.size() == 0){
                    JOptionPane.showMessageDialog(null, "پیامی یافت نشد!","اطلاعات"
                            , JOptionPane.INFORMATION_MESSAGE);
                }
                else
                new Inbox(messages);
                //  window.setVisible(false);
            }
        });

        list.set(150, start + 5 * height, 300, height, "B Nazanin", 20);
        list.setText("مشاهده لیست پزشکان عمومی");
        window.add(list);

        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // pationtdao = new patientDaoImpl();

                ArrayList<OrdDoctor> doctor = PatientDaoImpl.getListOfAllOrdDoctor();
                if(doctor.size() == 0){
                    JOptionPane.showMessageDialog(null, "پزشکی یافت نشد!", "اطلاعات",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else
                     new ShowListOfDoctor(doctor);
                //  window.setVisible(false);
            }
        });

        activity.set(150, start + 6 * height, 300, height, "B Nazanin", 20);
        activity.setText("ثبت فعالیت بدنی");
        window.add(activity);

        activity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // pationtdao = new patientDaoImpl();

                new SubmitActivity(myPatient);
                //  window.setVisible(false);
            }
        });
    }
}
