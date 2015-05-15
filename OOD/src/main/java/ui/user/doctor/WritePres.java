package ui.user.doctor;

import data.dao.imp.patientDaoImpl;
import logical.Recipe;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.Temp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Mona on 4/5/2015.
 */
class WritePres extends Temp{
    private Patient mypatient;
    private Doctor mydoctor;
    private patientDaoImpl userdao;
    private myJFrame window;

    private myJLabel text;
    private myJLabel name;//to show to whom do we want to send
    private myJLabel labelType;

    private myJTextField utext;
    private myJTextField ttext;
    private JPasswordField ptext;

    private myJButton send;




    public WritePres(Patient patient, Doctor doctor) {
        super();
        mypatient = patient;
        mydoctor = doctor;
        window = getWindow("تجویز دارو", true);

        text = new myJLabel("داروها");
        text = text.set(400, 200, 250, 20, "B Nazanin", 20);
        window.add(text);

        utext = new myJTextField("");
        utext.set(150, 200, 150, 200, "B Nazanin", 20);
        window.add(utext);


        send = new myJButton(false);
        send.setText("ثبت");
        send.set(200, 400, 100, 40, "B Nazanin", 20);
        window.add(send);

        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userdao = new patientDaoImpl();
                Recipe r = new Recipe(mydoctor.getUsername(), mypatient.getUsername(), new Date());
//medicines
                userdao.addRecipe(mypatient, r);

            }
        });

    }
}
