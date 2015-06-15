package ui.user.patient;

//import data.dao.ProfileDao;
// data.dao.imp.ProfileDaoImpl;
import data.dao.PatientDao;
import data.dao.imp.PatientDaoImpl;
import logical.Activity;

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
 * Created by a on 6/1/15.
 */
public class SeeActiviy extends Temp {
    private myJFrame winMain, window2;
    private myJLabel from, until;
    private myJTextField ntext, ftext, itext;
    private myJButton search;
    private ArrayList<Activity> sickness;
    private Patient myPatient;

    public SeeActiviy(Patient p) {
//check
        super();

        myPatient = p;
        winMain = getWindow("فعالیت بدنی ", true);

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
                PatientDao pdao = new PatientDaoImpl();
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
                sickness = pdao.getActivity(firstDate, secondDate, myPatient);


                window2 = getWindow("نتایج", false);



                String[] columnNames = {"مشخصات",
                        "تاریخ",
                };
                String[][] data = new String[sickness.size()][2];/*{
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
                    JOptionPane.showMessageDialog(null, " فعالیت بدنی یافت نشد!", "اطلاعات"
                            , JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                for (int i = 0; i < sickness.size(); i++){
                    SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("dateActivity: " + sickness.get(i).DateOfCreate);
                    data[i][1] = sdfr.format(sickness.get(i).DateOfCreate);
                    data[i][0] = sickness.get(i).type+" : "+sickness.get(i).calory;
                }

                System.out.println("hi");
                myJTable table = new myJTable(data, columnNames);
                System.out.println("hi2");
              //  JScrollPane scrollPane = new JScrollPane(table);
                //  window.add(scrollPane, BorderLayout.CENTER);
               // window2.add(scrollPane, BorderLayout.CENTER);

                table.set(100, 200, 400, 300, "B Nazanin", 14);
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setBounds(100, 200, 450, 300);
                // window2.getContentPane().add(scrollPane);
                // window2.pack();


                // scrollPane.setViewportView(table);
                window2.add(scrollPane);
               // window2.add(table);
                // new showResult();
                window2.setVisible(true);
                winMain.setVisible(false);
            }
        });
    }
}
