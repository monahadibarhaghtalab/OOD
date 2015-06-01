package ui.user.patient;

import data.dao.MessageDao;
import data.dao.PatientDao;
import data.dao.UserFuncDao;
import data.dao.imp.PatientDaoImpl;
import logical.user.Message;
import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.doctor.OrdDoctor;
import logical.user.patient.Patient;
import ui.element.*;
import ui.user.ShowMessage;
import ui.user.Temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a on 5/24/15.
 */
public class ListPatientDoctor extends Temp {

    private UserFuncDao userdao;
    private myJFrame winMain, window2;
    private myJLabel from, until;
    private myJTextField ntext, ftext, itext;
    private myJButton search, search1;
    private ArrayList<Doctor> searchDoctor;
    private ButtonGroup bg;
    private Patient myUser;
    private MessageDao messagedao;

    public  ListPatientDoctor(Patient user){
        super();
        myUser = user;
        winMain = getWindow("لیست پزشکان", true);
        bg = new ButtonGroup();

        PatientDaoImpl patientDao =  new PatientDaoImpl();
        searchDoctor = patientDao.getAllDoctors(myUser);



        JRadioButton rowData[][] = new JRadioButton[searchDoctor.size()][2];
        Object columnNames[] = {"نام", "تخصص"};

        for (int i = 0; i < searchDoctor.size(); i++){
            rowData[i][0] = new JRadioButton();
            rowData[i][1] = new JRadioButton();
            rowData[i][0].setText(searchDoctor.get(i).getName() + " " + searchDoctor.get(i).getFamilyName());
            rowData[i][0].setActionCommand(Integer.toString(i));
            rowData[i][1].setText(searchDoctor.get(i).getType());
            bg.add(rowData[i][0]);
            //rowData[i][1].setText(searchDoctor.get(i).getFamilyName());
        }
        myJTable table = new myJTable(rowData, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        window2.add(scrollPane, BorderLayout.CENTER);

        search1 = new myJButton(false);
        search1.setText("فرستادن مشاوره");
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
                Message request = new Message(myUser, searchDoctor.get(Integer.parseInt(num)), new Date(),"","","0");
                new ShowMessage(request);
//                Message request = new Message(myUser, searchDoctor.get(Integer.parseInt(num)), new Date());
//                messagedao.sendMessage(request);

            }
        });

    }
}
