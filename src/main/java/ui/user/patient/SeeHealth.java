package ui.user.patient;

import data.dao.PatientDao;
import data.dao.imp.PatientDaoImpl;
import data.typeDetector;
import logical.user.PhysicalState;
import main.Main;
import ui.element.*;
import ui.user.Temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 4/4/2015.
 */
//class SeeHealth extends SeeResult {
//
//    SeeHealth(){
//        super("وضعیت جسمانی", "وضعیت جسمانی");
//    }
//
//
//}



//import data.dao.ProfileDao;

import logical.user.patient.Patient;
import ui.element.*;
import ui.user.Temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mona on 4/4/2015.
 */
class SeeHealth extends Temp {



    private myJFrame winMain, window2;
    private myJLabel from, until;
    private myJTextField ntext, ftext, itext;
    private myJButton search;
    private typeDetector detector;

    private ArrayList<PhysicalState> sickness;
    private Patient myPatient;

    SeeHealth(Patient p) {
//check
        super();
        super.profile1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                winMain.setVisible(false);

            }
        });
        myPatient = p;
        detector = new typeDetector();
        winMain = getWindow("وضعیت جسمانی ", true);

        from = new myJLabel("از تاریخ");
        from = from.set(400, 200, 250, 20, "B Nazanin", 20);
        winMain.add(from);

        until = new myJLabel("تا تاریخ");
        until = until.set(400, 250, 250, 20, "B Nazanin", 20);
        winMain.add(until);


        ntext = new myJTextField("");
        ntext.set(150, 200, 150, 20, "B Nazanin", 20);
        winMain.add(ntext);

        ftext = new myJTextField("");
        ftext.setBounds(150, 250, 150, 20);
        winMain.add(ftext);


        search = new myJButton(false);
        search.setText("جستجو");
        search.set(200, 400, 100, 40, "B Nazanin", 20);
        winMain.add(search);

        /*
        make the second window to show the result
         */


        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientDao pdao = (PatientDao)detector.getPatientDao(Main.SaveType);
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date firstDate = null;
                try {
                    firstDate = dateFormat.parse(ntext.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                Date secondDate = null;
                try {
                    secondDate = dateFormat.parse(ftext.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                System.out.println("patient: "+myPatient.getName()+" "+myPatient.getId());
                System.out.println("first: "+ntext.getText());
                System.out.println("first: "+ftext.getText());
                sickness = pdao.getPhysicalState(firstDate, secondDate, myPatient);
                // new showResult();

                window2 = getWindow("نتایج", false);




                String[] columnNames = {"قند خون",
                        "فشار خون","وزن","قد","تاریخ"
                };
                String[][] data = new String[sickness.size()][5];/*{
                   {"Kathy", "Smith",
                           "Snowboarding", new Integer(5), new Boolean(false)},
                   {"John", "Doe",
                           "Rowing", new Integer(3), new Boolean(true)},
                   {"Sue", "Black",
                           "Knitting", new Integer(2), new Boolean(false)},
                   {"Jane", "White",
                           "Speed reading", new Integer(20), new Boolean(true)},
                   {"Joe", "Brown",
                           "Pool", new Integer(10), new Boolean(false)}
           };*/
                if(sickness.size() == 0){
                    JOptionPane.showMessageDialog(null, "وضعیت جسمانی یافت نشد!", "اطلاعات"
                            , JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                for (int i = 0; i < sickness.size(); i++){
                    SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");

                    data[i][4] = sdfr.format(sickness.get(i).getDate());
                    data[i][3] = sickness.get(i).getHeight()+"";
                    data[i][2] = sickness.get(i).getWeight()+"";
                    data[i][1] = sickness.get(i).getPressure()+"";
                    data[i][0] = sickness.get(i).getGlycemia()+"";
                }

                System.out.println("hi");
                myJTable table = new myJTable(data, columnNames);
                System.out.println("hi2");
//                JScrollPane scrollPane = new JScrollPane(table);
//                //  window.add(scrollPane, BorderLayout.CENTER);
//                window2.add(scrollPane, BorderLayout.CENTER);
                table.set(100, 200, 450, 300, "B Nazanin", 14);
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setBounds(100, 200, 450, 300);
                // window2.getContentPane().add(scrollPane);
                // window2.pack();


                // scrollPane.setViewportView(table);
                window2.add(scrollPane);
                //window2.add(table);
                window2.setVisible(true);
                winMain.setVisible(false);
            }
        });
    }
}
