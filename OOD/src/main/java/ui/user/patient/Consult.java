package ui.user.patient;

import data.dao.MessageDao;
import data.dao.imp.MessageDaoImpl;
import logical.user.Message;
import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;
import ui.element.*;
import ui.user.Temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import ui.user.patient.*;
/**
 * Created by Mona on 3/30/2015.
 */
class Consult extends Temp {


    private myJComboBox detail;
    private myJLabel nameDr;
    private myJFrame window;

        private myJLabel title;
        private myJLabel message;

        private myJTextField ttext;
        private myJTextField mtext;
        private Patient myPatient;
        private Doctor myDoctor;
        private myJButton send;

    private myJFrame winMain;

    private myJButton listDoctor;
    private User myUser;
    private myJLabel doctor;
    private MessageDao messagedao;



    public Consult(Patient p){
        super();

        myPatient = p;
        winMain = getWindow("انتخاب پزشک", true);

        listDoctor = new myJButton(false);
        listDoctor.setText("مشاهده لیست پزشکان بیمار");
        listDoctor.set(200, 300, 200, 100, "B Nazanin", 20);
        winMain.add(listDoctor);
        listDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new ListPatientDoctor(myPatient);
                //  window.setVisible(false);
            }
        });

//        doctor = new myJLabel();
//        doctor.setText("پزشک فعلی ");
//        doctor.set(300, 200, 100, 40, "B Nazanin", 20);
//        winMain.add(doctor);



    }
}
