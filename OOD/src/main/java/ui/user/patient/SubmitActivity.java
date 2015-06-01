package ui.user.patient;

/**
 * Created by a on 6/1/15.
 */

import data.dao.ProfileDao;
import data.dao.imp.ProfileDaoImpl;
import logical.Activity;
import logical.user.PhysicalState;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;
import ui.element.*;
import ui.user.Temp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import data.dao.ProfileDao;
import data.dao.imp.ProfileDaoImpl;
import logical.user.PhysicalState;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mona on 3/30/2015.
 */
public class SubmitActivity extends Temp {


    private myJLabel labelDate;

    private myJFrame window;

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
    private myJComboBox jb;
    Patient myPatient;

    protected SubmitActivity(Patient p){
        super();
        window = getWindow("ثبت وضعیت بدنی", true);

        myPatient = p;

        date = new myJLabel("تاریخ");
        date = date.set(400, 200, 250, 20, "B Nazanin", 20);
        window.add(date);

        name = new myJLabel("میزان کالری:");
        name = name.set(400, 250, 250, 20, "B Nazanin", 20);
        window.add(name);

       height = new myJLabel("نوع فعالیت");
        height = height.set(400, 300, 250, 20, "B Nazanin", 20);
        window.add(height);
//
//        weight = new myJLabel("وزن");
//        weight = weight.set(400, 350, 250, 20, "B Nazanin", 20);
//        window.add(weight);
//
//        pressure = new myJLabel("فشار خون");
//        pressure = weight.set(400, 400, 250, 20, "B Nazanin", 20);
//        window.add(pressure);
//
//        glycemia = new myJLabel("قند خون");
//        glycemia = weight.set(400, 450, 250, 20, "B Nazanin", 20);
//        window.add(glycemia);

        dtext = new myJTextField("");
        dtext.set(150, 200, 150, 20, "B Nazanin", 20);
        window.add(dtext);

        htext = new myJTextField("");
        htext.set(150, 250, 150, 20, "B Nazanin", 20);
        htext.setText(myPatient.getName()+" "+myPatient.getFamilyName());
        window.add(htext);
        String[] types = new String[] { "دوچرخه سواری", "بدن سازی"};
        jb = new myJComboBox();
        // jb = new JComboBox();


        jb.set(150, 400, 150, 20, "B Nazanin", 20);
        jb.addItem( "دوچرخه سواری");
        jb.addItem("بدن سازی");
       // detail.addItem("دکتر سلامتی - متخصص تغذیه");


//        ntext = new myJTextField("");
//        ntext.set(150, 300, 150, 20, "B Nazanin", 20);
//        window.add(ntext);
//
//        wtext = new myJTextField("");
//        wtext.set(150, 350, 150, 20, "B Nazanin", 20);
//        window.add(wtext);
//
//        ptext = new myJTextField("");
//        ptext.set(150, 400, 150, 20, "B Nazanin", 20);
//        window.add(ptext);
//
//        gtext = new myJTextField("");
//        gtext.set(150, 450, 150, 20, "B Nazanin", 20);
//        window.add(gtext);

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
                Activity activity = new Activity((String)jb.getSelectedItem(), Double.parseDouble(htext.getText()),inputDate);
                ProfileDao pdao = new ProfileDaoImpl();
                pdao.addActivity(myPatient, activity);
                //  window.setVisible(false);
            }
        });



        connect = new myJButton(false);
        connect.setText("اتصال دستگاه به رایانه");
        connect.set(200, 400, 200, 40, "B Nazanin", 20);
        window.add(connect);

        final String[] devices = { "دستگاه شماره یک", "دستگاه شماره دو", "دستگاه شماره سه", "دستگاه شماره جهار" };

        connect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                JFrame frame = new JFrame("Input Dialog Example 3");
                String device = (String) JOptionPane.showInputDialog(frame,
                        "نام دستگاه مورد نظر را انتخاب کنید",
                        "انتخاب دستگاه",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        devices,
                        devices[0]);
            }
        });



//            // favoritePizza will be null if the user clicks Cancel
//            System.out.printf("Favorite pizza is %s.\n", favoritePizza);
//            System.exit(0);


    }
}

