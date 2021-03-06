package ui.user.patient;

//import data.dao.ProfileDao;
//import data.dao.imp.ProfileDaoImpl;
import data.dao.PatientDao;
import data.dao.imp.PatientDaoImpl;
import data.typeDetector;
import logical.user.PhysicalState;
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
import java.util.Date;

/**
 * Created by Mona on 3/30/2015.
 */
class SubmitStatus extends Temp {


    private myJLabel labelDate;

    private myJFrame window;
    private typeDetector detector;


    private myJLabel date;
    private myJLabel name;
    private myJLabel height;
    private myJLabel weight;
    private myJLabel pressure;
    private myJLabel glycemia;
    private Doctor myDoctor;

    private myJTextField dtext;
    private myJTextField ntext;
    private myJTextField htext;
    private myJTextField wtext;
    private myJTextField ptext;
    private myJTextField gtext;

    private myJButton enter;

    private myJButton connect;
    Patient myPatient;

    protected SubmitStatus(Patient p){
        super();
        super.profile1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);

            }
        });
        detector = new typeDetector();
        window = getWindow("ثبت وضعیت جسمانی", true);

        myPatient = p;

        date = new myJLabel("تاریخ");
        date = date.set(400, 200, 250, 20, "B Nazanin", 20);
        window.add(date);

        name = new myJLabel("نام");
        name = name.set(400, 250, 250, 20, "B Nazanin", 20);
        window.add(name);

        height = new myJLabel("قد");
        height = height.set(400, 300, 250, 20, "B Nazanin", 20);
        window.add(height);

        weight = new myJLabel("وزن");
        weight = weight.set(400, 350, 250, 20, "B Nazanin", 20);
        window.add(weight);

        pressure = new myJLabel("فشار خون");
        pressure = pressure.set(400, 400, 250, 20, "B Nazanin", 20);
        window.add(pressure);

        glycemia = new myJLabel("قند خون");
        glycemia = glycemia.set(400, 450, 250, 20, "B Nazanin", 20);
        window.add(glycemia);

        dtext = new myJTextField("");
        dtext.set(150, 200, 150, 20, "B Nazanin", 20);
        window.add(dtext);

        htext = new myJTextField("");
        htext.set(150, 250, 150, 20, "B Nazanin", 20);
        htext.setText(myPatient.getName()+" "+myPatient.getFamilyName());
        window.add(htext);

        ntext = new myJTextField("");
        ntext.set(150, 300, 150, 20, "B Nazanin", 20);
        window.add(ntext);

        wtext = new myJTextField("");
        wtext.set(150, 350, 150, 20, "B Nazanin", 20);
        window.add(wtext);

        ptext = new myJTextField("");
        ptext.set(150, 400, 150, 20, "B Nazanin", 20);
        window.add(ptext);

        gtext = new myJTextField("");
        gtext.set(150, 450, 150, 20, "B Nazanin", 20);
        window.add(gtext);

        enter = new myJButton(false);
        enter.setText("ثبت");
        enter.set(200, 500, 100, 40, "B Nazanin", 20);
        window.add(enter);
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date inputDate = null;
                try {
                    inputDate = dateFormat.parse(dtext.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                System.out.println(ntext.getText());
                PhysicalState physicalState = new PhysicalState(Double.parseDouble(ntext.getText()), Double.parseDouble(wtext.getText()), Double.parseDouble(ptext.getText()),Double.parseDouble(gtext.getText()),inputDate,myPatient.getId());
                PatientDao pdao = (PatientDao)detector.getPatientDao(Main.SaveType);
                pdao.addPhysicalState(myPatient, physicalState);
                JOptionPane.showMessageDialog(null, "وضعیت جسمانی ثبت شد.", "اطلاعات"
                        , JOptionPane.INFORMATION_MESSAGE);

                window.setVisible(false);
            }
        });







//            // favoritePizza will be null if the user clicks Cancel
//            System.out.printf("Favorite pizza is %s.\n", favoritePizza);
//            System.exit(0);


        }
    }

