package ui.user.doctor;

//import data.dao.ProfileDao;
//import data.dao.imp.ProfileDaoImpl;

import data.dao.PatientDao;
import data.dao.UserDao;
import data.dao.imp.PatientDaoImpl;
import data.typeDetector;
import logical.Disease;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;
import main.Main;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.Temp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by Mona on 4/5/2015.
 */
class AddHistiory extends Temp {
    private Patient p;
    private Doctor d;
    private typeDetector detector;

    private myJFrame window;
    private myJLabel date;
    private myJLabel name;
    private myJLabel type;
    private myJLabel sign;
    private myJLabel pressure;

    private myJTextField dtext;
    private myJTextField ttext;
    private myJTextField htext;
    private myJTextField stext;
    private myJTextField ptext;

    private myJButton enter;


    public AddHistiory(Patient patient, Doctor doctor) {
        super();
        super.profile1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);

            }
        });
        p = patient;
        d = doctor;
        detector = new typeDetector();
        window = getWindow("افزودن سابقه بیماری", true);


        date = new myJLabel("تاریخ");
        date = date.set(400, 200, 250, 20, "B Nazanin", 20);
        window.add(date);

        name = new myJLabel("نام بیمار");
        name = name.set(400, 250, 250, 20, "B Nazanin", 20);
        window.add(name);

        type = new myJLabel("نوع بیماری");
        type = type.set(400, 300, 250, 20, "B Nazanin", 20);
        window.add(type);

        sign = new myJLabel("علایم بیماری");
        sign = sign.set(400, 350, 250, 20, "B Nazanin", 20);
        window.add(sign);

        dtext = new myJTextField("");
        dtext.set(150, 200, 150, 20, "B Nazanin", 20);
        window.add(dtext);

        htext = new myJTextField("");
        htext.set(150, 250, 150, 20, "B Nazanin", 20);
        htext.setText(patient.getName()+" "+patient.getFamilyName());
        window.add(htext);

        ttext = new myJTextField("");
        ttext.set(150, 300, 150, 20, "B Nazanin", 20);
        window.add(ttext);

        stext = new myJTextField("");
        stext.set(150, 350, 150, 20, "B Nazanin", 20);
        window.add(stext);


        enter = new myJButton(false);
        enter.setText("ثبت");
        enter.set(200, 500, 100, 40, "B Nazanin", 20);
        window.add(enter);
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // PatientDao pdao = new PatientDaoImpl();
               PatientDao pdao = (PatientDao)detector.getPatientDao(Main.SaveType);

                String temp = stext.getText();
                String[] temp2 = temp.split("/");
                ArrayList<String> signs =new ArrayList<String>();
                Collections.addAll(signs, temp2);
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date inputDate = null;
                try {
                    inputDate = dateFormat.parse(dtext.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                Disease hist = new Disease(ttext.getText(), d.getId(),  p.getId(), inputDate, signs);
//signs
                pdao.addHistory(p, hist);
                JOptionPane.showMessageDialog(null, "سابقه ی بیماری ثبت شد.", "اطلاعات"
                        , JOptionPane.INFORMATION_MESSAGE);
                window.setVisible(false);

            }
        });
    }

}
