package ui.user.doctor;

import data.dao.DoctorDao;
import data.dao.UserFuncDao;
import data.dao.imp.DoctorDaoImpl;
import logical.user.doctor.Doctor;
import logical.user.Message;
import logical.user.patient.Patient;
import logical.user.User;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.user.Temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Mona on 3/15/2015.
 */
public class FirstPageDoctor extends Temp {
    public myJFrame window;
    private DoctorDaoImpl doctordao;
    private Doctor myDoctor;
    private myJButton historyPatient;
    private myJButton seeMessage;
    private myJButton seeConsult;
    private myJButton getReport;
    private myJButton seeList;
    public int start;
    public int height;

    public  FirstPageDoctor(Doctor doctor){
        super();
        myDoctor = doctor;
        window = getWindow("ورود به عنوان پزشک", true);
        myDoctor = doctor;
        doctordao = new DoctorDaoImpl();
        historyPatient = new myJButton(false);
        seeMessage = new myJButton(false);
        seeConsult = new myJButton(false);
        getReport = new myJButton(false);
        seeList = new myJButton(false);

        start = 200;
        height = 30;

        historyPatient.set(150, start, 300, height, "B Nazanin", 20);
        historyPatient.setText("مشاهده سوابق بیمار");
        window.add(historyPatient);

        historyPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LookforPateint(myDoctor);
                //  window.setVisible(false);
            }
        });

        seeMessage.set(150, start + height, 300, height, "B Nazanin", 20);
        seeMessage.setText("مشاهده درخواست ها");
        window.add(seeMessage);

        seeMessage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //noe doctor

                ArrayList<Message> messages = doctordao.getMessages(myDoctor);
                new SeeMessage(messages,"doctor");
                //  window.setVisible(false);
            }
        });

        seeConsult.set(150, start + 2 * height, 300, height, "B Nazanin", 20);
        seeConsult.setText("مشاهده متن مشاوره");
        window.add(seeConsult);

        seeConsult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Message> consults = doctordao.getConsults(myDoctor);
                new SeeConsult(consults);
                //  window.setVisible(false);
            }
        });

        getReport.set(150, start + 3 * height, 300, height, "B Nazanin", 20);
        getReport.setText("دریافت گزارش");
        window.add(getReport);

        getReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GetReport();
                //  window.setVisible(false);
            }
        });
//
        seeList.set(150, start + 4 * height, 300, height, "B Nazanin", 20);
        seeList.setText("مشاهده لیست بیماران");
        window.add(seeList);

        seeList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<User> tmp = doctordao.showListOfUser(myDoctor);
                ArrayList<Patient> patients = new ArrayList<Patient>();
                for (int i = 0; i< tmp.size(); i++){
                    patients.add((Patient) tmp.get(i));
                }
                new ListPatient(patients);
                //  window.setVisible(false);
            }
        });

    }


}
