package ui.user.patient;

import data.dao.ProfileDao;
import data.dao.imp.ProfileDaoImpl;
import logical.disease;
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
class SeeSickness extends Temp {



    private myJFrame winMain, window2;
    private myJLabel from, until;
    private myJTextField ntext, ftext, itext;
    private myJButton search;
    private ArrayList<disease> sickness;
    private Patient myPatient;

    SeeSickness(Patient p) {
//check
        super();

        myPatient = p;
        winMain = getWindow("سابقه بیماری", true);

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
            window2 = getWindow("نتایج", false);


        Object rowData[][] = new myJTextField[sickness.size()][2];
        Object columnNames[] = { "تاریخ ثبت", "سابقه ی بیماری"};
        for (int i = 0; i < sickness.size(); i++){
            SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
            myJTextField t0 = new myJTextField("");
            myJTextField t1 = new myJTextField("");
            t0.setText(sdfr.format(sickness.get(i).getDateOfCreate()));
            t1.setText(sickness.get(i).getSigns());
        }
        myJTable table = new myJTable(rowData, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        window2.add(scrollPane, BorderLayout.CENTER);

        table.set(100, 200, 400, 300, "B Nazanin", 14);
        window2.add(table);

        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProfileDao pdao = new ProfileDaoImpl();
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
                sickness = pdao.getHistory(firstDate, secondDate, myPatient);
                // new showResult();
                window2.setVisible(true);
                winMain.setVisible(false);
            }
        });
        }
    }
