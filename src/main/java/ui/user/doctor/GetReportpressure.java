package ui.user.doctor;

/**
 * Created by a on 6/23/15.
 */

import data.dao.DoctorDao;
import data.dao.imp.DoctorDaoImpl;
import data.typeDetector;
import logical.user.doctor.Doctor;
import main.Main;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.Temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import ui.element.*;
import ui.user.Temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mona on 3/30/2015.
 */
class GetReportpressure extends Temp {

    private JFrame window2;
    private myJFrame winMain;
    private typeDetector detector;
    private myJLabel typeSickness;
    private myJLabel midHeight;
    private myJLabel midWeight;
    private myJLabel mid;

    private myJTextField t1text;
    private myJTextField h1text;
    private myJTextField ttext;
    private myJTextField htext;
    private myJTextField wtext;
    private myJTextField utext;

    private myJButton report;

    protected GetReportpressure(){
        super();
        super.profile1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                winMain.setVisible(false);

            }
        });
        detector = new typeDetector();
        winMain = getWindow("گزارش تجمیعی", true);


        typeSickness = new myJLabel("فشار خون:");
        typeSickness = typeSickness.set(500, 200, 250, 20, "B Nazanin", 20);
        winMain.add(typeSickness);

        midHeight = new myJLabel("قند خون:");
        midHeight = midHeight.set(500, 250, 250, 20, "B Nazanin", 20);
        winMain.add(midHeight);

        midWeight= new myJLabel("از تاریخ:");
        midWeight = midWeight.set(500, 300, 250, 20, "B Nazanin", 20);
        winMain.add(midWeight);
        mid= new myJLabel("تا تاریخ:");
        mid = mid.set(500, 350, 250, 20, "B Nazanin", 20);
        winMain.add(mid);

//        ttext = new myJTextField("");
//        ttext.set(250, 200, 150, 20, "B Nazanin", 20);

        SpinnerModel model = new SpinnerNumberModel(0, 0, 25, 0.1);
        final JSpinner spinner1 = new JSpinner(model);
        spinner1.setBounds(250, 200, 150, 20);
        winMain.add(spinner1);

//        htext = new myJTextField("");
//        htext.setBounds(250, 250, 150, 20);
        SpinnerModel model1 = new SpinnerNumberModel(0, 0, 25, 0.1);
        final JSpinner spinner2 = new JSpinner(model1);
        spinner2.setBounds(100, 200, 150, 20);
        winMain.add(spinner2);


        SpinnerModel model2 = new SpinnerNumberModel(0, 0, 300, 0.5);
        final JSpinner spinner3 = new JSpinner(model2);
        spinner3.setBounds(250, 250, 150, 20);
        winMain.add(spinner3);

//        htext = new myJTextField("");
//        htext.setBounds(250, 250, 150, 20);
        SpinnerModel model3 = new SpinnerNumberModel(0, 0, 300, 0.5);

        final JSpinner spinner4 = new JSpinner(model3);
         spinner4.setBounds(100, 250, 150, 20);
        winMain.add(spinner4);

//        t1text = new myJTextField("");
//        t1text.set(100, 200, 150, 20, "B Nazanin", 20);
//        winMain.add(t1text);
//
//        h1text = new myJTextField("");
//        h1text.setBounds(100, 250, 150, 20);
//        winMain.add(h1text);

        wtext = new myJTextField("");
        wtext.set(150, 300, 150, 20, "B Nazanin", 20);
        winMain.add(wtext);

        utext = new myJTextField("");
        utext.set(150, 350, 150, 20, "B Nazanin", 20);
        winMain.add(utext);

        report = new myJButton(false);
        report.setText("گزارش");
        report.set(200, 400, 100, 40, "B Nazanin", 20);
        winMain.add(report);


        /*
        make the second window to show the result
         */
        window2 = getWindow("" +
                "گزارش تجمیعی", false);


//        Object rowData[][] = { { "نوع بیماری", "نام بیمار"}  };
//        Object columnNames[] = { "", ""};
//       myJTable table = new myJTable(rowData, columnNames);
//
//        JScrollPane scrollPane = new JScrollPane(table);
//        window2.add(scrollPane, BorderLayout.CENTER);
//
//        table.set(100, 200, 400, 300, "B Nazanin", 14);
        //       window2.add(table);

        report.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // new showResult();
                DoctorDao docDao = (DoctorDao)detector.getDoctorDao(Main.SaveType);
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date firstDate = null;
                try {
                    firstDate = dateFormat.parse(wtext.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                Date secondDate = null;
                try {
                    secondDate = dateFormat.parse(utext.getText());
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
                Double firstPre = (Double)spinner1.getValue();
                Double secondPre = (Double)spinner2.getValue();

                Double firstglo = (Double)spinner3.getValue();
                Double secondglo = (Double)spinner4.getValue();
                ArrayList<Integer> number = docDao.getCountpress(firstPre, secondPre, firstglo, secondglo,firstDate, secondDate);
                for(int i = 0; i < number.size();i++){
                    System.out.println(i + " " + number.get(i));
                }
                DrawGraph mainPanel = new DrawGraph(number);
               // window2.setSize(1650,1080);
               // window2.setExtendedState(JFrame.MAXIMIZED_BOTH);
//
//                window2.setLayout(new FlowLayout());
//                window2.getContentPane().add(mainPanel);
               // window2.pack();
                JScrollPane scrollPane = new JScrollPane(mainPanel);
             //   JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

              //  scrollPane.add(mainPanel);
                scrollPane.setBounds(100, 100, 850, 650);
                // window2.getContentPane().add(scrollPane);
                // window2.pack();

window2.setBounds(100,100,1080,1080);
                // scrollPane.setViewportView(table);
                window2.add(scrollPane);
                window2.setVisible(true);

                winMain.setVisible(false);
            }
        });

    }



}
