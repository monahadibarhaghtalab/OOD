package ui.user.patient;

import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.doctor.ExpertDoctor;
import logical.user.doctor.OrdDoctor;
import logical.user.patient.Patient;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.user.Temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 3/30/2015.
 */
public class ChooseDoctor extends Temp {

    private myJFrame winMain;

    private myJButton listDoctor;
    private User myUser;
    Patient myPatient;
    private myJLabel doctor;


    public ChooseDoctor(User user, Patient p){
        myUser = user;
        myPatient = p;
        winMain = getWindow("انتخاب پزشک", true);

        listDoctor = new myJButton(false);
        listDoctor.setText("مشاهده لیست پزشکان");
        listDoctor.set(200, 300, 200, 100, "B Nazanin", 20);
        winMain.add(listDoctor);


        listDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(myUser.getClass().equals(Doctor.class)||myUser.getClass().equals(ExpertDoctor.class)||myUser.getClass().equals(OrdDoctor.class)) {
                    Doctor d = (Doctor )myUser;
                    d.currentPatient = myPatient;
                   // myUser.currentPatient = myPatient;
                }
                new ListDoctor(myUser );
                //  window.setVisible(false);
            }
        });

//        doctor = new myJLabel();
//        doctor.setText("پزشک فعلی ");
//        doctor.set(300, 200, 100, 40, "B Nazanin", 20);
//        winMain.add(doctor);



    }
}
