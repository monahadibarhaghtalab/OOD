package ui.user.doctor;

/**
 * Created by a on 6/23/15.
 */

import data.dao.DoctorDao;
import data.dao.imp.DoctorDaoImpl;
import data.typeDetector;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by Mona on 3/30/2015.
 */
class GetReportActivity extends Temp {

    private myJFrame window2;
    private myJFrame winMain;
    private typeDetector detector;
    private myJLabel typeSickness;
    private myJLabel midHeight;
    private myJLabel midWeight;
    private myJLabel end;
    private myJTextField ttext;
    private myJTextField htext;
    private myJTextField wtext;
    private myJTextField utext;

    private myJButton report;

    protected GetReportActivity(){
        super();
        super.profile1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                winMain.setVisible(false);

            }
        });
        detector = new typeDetector();
        winMain = getWindow("گزارش تجمیعی", true);


        typeSickness = new myJLabel("حداقل میزان کالری:");
        typeSickness = typeSickness.set(400, 200, 250, 20, "B Nazanin", 20);
        winMain.add(typeSickness);

        midHeight = new myJLabel("حداکثر میزان کالری:");
        midHeight = midHeight.set(400, 250, 250, 20, "B Nazanin", 20);
        winMain.add(midHeight);

        midWeight= new myJLabel("از تاریخ:");
        midWeight = midWeight.set(400, 300, 250, 20, "B Nazanin", 20);
        winMain.add(midWeight);

        end= new myJLabel("از تاریخ:");
        end = end.set(400, 350, 250, 20, "B Nazanin", 20);
        winMain.add(end);

        ttext = new myJTextField("");
        ttext.set(150, 200, 150, 20, "B Nazanin", 20);
        winMain.add(ttext);

        htext = new myJTextField("");
        htext.setBounds(150, 250, 150, 20);
        winMain.add(htext);

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
                ArrayList<Integer> number = docDao.getCountActivity(Double.parseDouble(ttext.getText()), Double.parseDouble(htext.getText()), firstDate,secondDate);

                DrawGraph mainPanel = new DrawGraph(number);


                // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                window2.setLayout(new FlowLayout());
//                window2.getContentPane().add(mainPanel);
//                window2.pack();
//                window2.setVisible(true);
//                window2.setVisible(true);
//                winMain.setVisible(false);



                JScrollPane scrollPane = new JScrollPane(mainPanel);
                //   JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

                //  scrollPane.add(mainPanel);
                scrollPane.setBounds(100, 100, 850, 650);
                // window2.getContentPane().add(scrollPane);
                // window2.pack();

                window2.setBounds(100,100,1080,1080);
                // scrollPane.setViewportView(table);
                window2.add(scrollPane);
                //  frame.setLocationByPlatform(true);
                window2.add(scrollPane);
                window2.setVisible(true);

                winMain.setVisible(false);            }
        });

    }


}
