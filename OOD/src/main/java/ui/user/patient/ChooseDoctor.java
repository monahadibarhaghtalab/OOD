package ui.user.patient;

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
class ChooseDoctor extends Temp {

    private myJFrame winMain;

    private myJButton listDoctor;
    private Patient mypatient;
    private myJLabel doctor;


    protected ChooseDoctor(Patient patient){
        mypatient = patient;
        winMain = getWindow("انتخاب پزشک", true);

        listDoctor = new myJButton(false);
        listDoctor.setText("مشاهده لیست پزشکان");
        listDoctor.set(200, 300, 200, 100, "B Nazanin", 20);
        winMain.add(listDoctor);


        listDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new ListDoctor(mypatient );
                //  window.setVisible(false);
            }
        });

        doctor = new myJLabel();
        doctor.setText("پزشک فعلی ");
        doctor.set(300, 200, 100, 40, "B Nazanin", 20);
        winMain.add(doctor);



    }
}
