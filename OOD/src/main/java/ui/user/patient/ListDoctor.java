package ui.user.patient;

import data.dao.MessageDao;
import data.dao.UserFuncDao;
import data.dao.imp.PatientDaoImpl;
import data.dao.imp.UserDaoImpl;

import logical.user.doctor.Doctor;
import logical.user.doctor.ExpertDoctor;
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

    private UserFuncDao userdao;
    private myJFrame winMain, window2;
    private myJLabel from, until;
    private myJTextField ntext, ftext, itext;
    private myJButton search, search1;
    private ArrayList<Doctor> searchDoctor;
    private ButtonGroup bg;
    private User myUser;
    private MessageDao messagedao;

    protected ListDoctor(User user){
        super();
        myUser = user;
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



//takhasos
        

        search = new myJButton(false);
        search.setText("جستجو");
        search.set(200, 400, 100, 40, "B Nazanin", 20);
        winMain.add(search);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // new showResult();
               // userdao = new UserDaoImpl();
                //field problem
                if(myUser.getClass().equals(Patient.class)) {
                    ArrayList<OrdDoctor> tmp = PatientDaoImpl.getListOfOrdDoctor(ntext.getText(), ftext.getText());
                    searchDoctor = new ArrayList<Doctor>();
                    for(int i = 0; i < tmp.size(); i++){
                        searchDoctor.add(tmp.get(i));
                    }
                }
//takhasos
                if(myUser.getClass().equals(Doctor.class) || myUser.getClass().equals(OrdDoctor.class)) {
                    ArrayList<ExpertDoctor> tmp = PatientDaoImpl.getListOfProDoctor(ntext.getText(), ftext.getText());
                    searchDoctor = new ArrayList<Doctor>();
                    for(int i = 0; i < tmp.size(); i++){
                        searchDoctor.add(tmp.get(i));
                    }                }

                window2.setVisible(false);
                //  winMain.setVisible(false);
            }
        });



        /*
        make the second window to show the result
         */

        window2 = getWindow("لیست پزشکان", false);

        JRadioButton rowData[][] = new JRadioButton[searchDoctor.size()][2];
        Object columnNames[] = {"نام", "تخصص"};

        for (int i = 0; i < searchDoctor.size(); i++){

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
                Message request;

                if (myUser.getClass().equals(Patient.class)) {
                    request = new Message(myUser, searchDoctor.get(Integer.parseInt(num)), new Date(), "", "درخواست پذیرش", Integer.parseInt(myUser.getId()));
                }
                else {
                    Doctor d = (Doctor)myUser;
                    request = new Message(myUser, searchDoctor.get(Integer.parseInt(num)), new Date(), "", "درخواست پذیرش", Integer.parseInt(d.currentPatient.getId()));
                }
                messagedao.sendMessage(request);

            }
        });

    }
}
