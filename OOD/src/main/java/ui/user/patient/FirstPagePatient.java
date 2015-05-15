package ui.user.patient;

import data.dao.UserFuncDao;
import data.dao.imp.patientDaoImpl;
import logical.user.doctor.OrdDoctor;
import logical.user.patient.Patient;
import logical.user.User;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.user.Temp;

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

    public FirstPagePatient(final Patient patient){
        super();
        myPatient = patient;
        window = getWindow("ورود به عنوان بیمار", true);

        history = new myJButton(false);
        submitStatus = new myJButton(false);
        chooseDoctor = new myJButton(false);
        consult = new myJButton(false);
        inbox = new myJButton(false);
        list = new myJButton(false);

        int start = 200;
        int height = 30;

        history.set(150, start, 300, height, "B Nazanin", 20);
        history.setText("مشاهده سوابق");
        window.add(history);

        history.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new History();
                //  window.setVisible(false);
            }
        });

        submitStatus.set(150, start + height, 300, height, "B Nazanin", 20);
        submitStatus.setText("ثبت وضعیت بدنی");
        window.add(submitStatus);

        submitStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SubmitStatus();
                //  window.setVisible(false);
            }
        });

        chooseDoctor.set(150, start + 2 * height, 300, height, "B Nazanin", 20);
        chooseDoctor.setText(" انتخاب / تغییر پزشک");
        window.add(chooseDoctor);

        chooseDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChooseDoctor(myPatient);
                //  window.setVisible(false);
            }
        });

        consult.set(150, start + 3 * height, 300, height, "B Nazanin", 20);
        consult.setText("مشاوره");
        window.add(consult);

        consult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Consult();
                //  window.setVisible(false);
            }
        });

        inbox.set(150, start + 4 * height, 300, height, "B Nazanin", 20);
        inbox.setText("مشاهده صندوق پیام");
        window.add(inbox);

        inbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Inbox();
                //  window.setVisible(false);
            }
        });

        list.set(150, start + 5 * height, 300, height, "B Nazanin", 20);
        list.setText("مشاهده لیست پزشکان عمومی");
        window.add(list);

        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pationtdao = new patientDaoImpl();
                ArrayList<OrdDoctor> doctor = new ArrayList<OrdDoctor>();
                ArrayList<User> temp = pationtdao.showListOfUser();
                for (int i = 0; i < temp.size();i++){
                    doctor.add((OrdDoctor)temp.get(i));
                }
                new ShowListOfDoctor(doctor);
                //  window.setVisible(false);
            }
        });
    }
}
