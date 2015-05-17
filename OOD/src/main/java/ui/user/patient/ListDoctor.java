package ui.user.patient;

import data.dao.MessageDao;
import data.dao.UserFuncDao;
import data.dao.imp.PatientDaoImpl;
import logical.user.doctor.OrdDoctor;
import logical.user.Message;
import logical.user.patient.Patient;
import logical.user.User;
import ui.element.*;
import ui.user.Temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mona on 4/4/2015.
 */
class ListDoctor extends Temp{

    private UserFuncDao patientdao;
    private myJFrame winMain, window2;
    private myJLabel from, until;
    private myJTextField ntext, ftext, itext;
    private myJButton search, search1;
    private ArrayList<OrdDoctor> searchDoctor;
    private ButtonGroup bg;
    private Patient mypatient;
    private MessageDao messagedao;

    protected ListDoctor(Patient patient){
        super();
        mypatient = patient;
        winMain = getWindow("لیست پزشکان", true);
        bg = new ButtonGroup();
        from = new myJLabel("نام");
        from = from.set(400, 200, 250, 20, "B Nazanin", 20);
        winMain.add(from);

        until = new myJLabel("نام خانوادگی");
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
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // new showResult();
                patientdao = new PatientDaoImpl();
                //field problem
                ArrayList<User> temp = patientdao.search();

                searchDoctor = new ArrayList<OrdDoctor>();
                for (int i = 0; i< temp.size(); i++)
                    searchDoctor.add((OrdDoctor)temp.get(i));
                window2.setVisible(false);
                //  winMain.setVisible(false);
            }
        });



        /*
        make the second window to show the result
         */

        window2 = getWindow("لیست پزشکان", false);

        JRadioButton rowData[][] = new JRadioButton[searchDoctor.size()][1];
        Object columnNames[] = {"نام"};

        for (int i = 0; i < searchDoctor.size(); i++){

            rowData[i][0].setText(searchDoctor.get(i).getName() + " " + searchDoctor.get(i).getFamilyName());
            rowData[i][0].setActionCommand(Integer.toString(i));
            bg.add(rowData[i][0]);
            //rowData[i][1].setText(searchDoctor.get(i).getFamilyName());
        }
        myJTable table = new myJTable(rowData, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        window2.add(scrollPane, BorderLayout.CENTER);

        search1 = new myJButton(false);
        search1.setText("فرستادن درخواست");
        search1.set(200, 500, 100, 40, "B Nazanin", 20);
        window2.add(search1);

        table.set(100, 200, 400, 300, "B Nazanin", 14);
        window2.add(table);

        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // new showResult();

                window2.setVisible(true);
                winMain.setVisible(false);
            }
        });

        search1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // new showResult();
                String num = bg.getSelection().getActionCommand();
                Message request = new Message(mypatient, searchDoctor.get(Integer.parseInt(num)), new Date());
                messagedao.sendMessage(request);

            }
        });

    }
}
