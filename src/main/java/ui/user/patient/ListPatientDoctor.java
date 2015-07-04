package ui.user.patient;

import data.dao.MessageDao;
import data.dao.PatientDao;
import data.dao.UserFuncDao;
import data.dao.imp.PatientDaoImpl;
import data.typeDetector;
import logical.user.Message;
import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.doctor.OrdDoctor;
import logical.user.patient.Patient;
import main.Main;
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
    private typeDetector detector;
    private Patient myUser;
    private MessageDao messagedao;
    private myJLabel name, family, docNum;
    private myJTextField ntext1;
   // private myJButton mysearch;


    public  ListPatientDoctor(Patient user){
        super();
        myUser = user;
        winMain = getWindow("لیست پزشکان", true);
        bg = new ButtonGroup();
        detector = new typeDetector();
        PatientDao patientDao = (PatientDao)detector.getPatientDao(Main.SaveType);
        searchDoctor = patientDao.getAllDoctors(myUser);



        String[] columnNames = {"First Name",
                "Last Name",
        };
        String[][] data = new String[searchDoctor.size()][2];/*{
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
        if(searchDoctor.size() == 0){
            JOptionPane.showMessageDialog(null, " پزشک با مشخصات داده شده یافت نشد!", "اطلاعات"
                    , JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        for (int i = 0; i < searchDoctor.size(); i++){

            data[i][1] = i + 1+" "+searchDoctor.get(i).getName() + " " + searchDoctor.get(i).getFamilyName();
            data[i][0] = Main.nameMap.get (searchDoctor.get(i).getType());

        }

        System.out.println("hi");
        myJTable table = new myJTable(data, columnNames);
        System.out.println("hi2");
        JScrollPane scrollPane = new JScrollPane(table);
        winMain.add(scrollPane, BorderLayout.CENTER);


        search1 = new myJButton(false);
        search1.setText("فرستادن مشاوره");
        search1.set(200, 150, 100, 40, "B Nazanin", 20);
        winMain.add(search1);

        table.set(100, 200, 400, 300, "B Nazanin", 14);
        winMain.add(table);

        docNum = new myJLabel("شماره سطر");
        docNum = docNum.set(300, 100, 100, 20, "B Nazanin", 20);
        winMain.add(docNum);
        ntext1 = new myJTextField("");
        ntext1.set(150, 100, 50, 20, "B Nazanin", 20);
        winMain.add(ntext1);

//        search = new myJButton(false);
//        search.setText("انتخاب");
//        search.set(200, 150, 100, 40, "B Nazanin", 20);
      //  window2.add(search);

        search1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // new showResult();

               // Message request = new Message(myUser, , new Date(),"","","0");
                new ShowMessage(myUser, searchDoctor.get(Integer.parseInt(ntext1.getText()) -1),"درخواست مشاوره");
//                JOptionPane.showMessageDialog(null, "درخواست ثبت شد.", "اطلاعات"
//                        , JOptionPane.INFORMATION_MESSAGE);

//                Message request = new Message(myUser, searchDoctor.get(Integer.parseInt(num)), new Date());
//                messagedao.sendMessage(request);

            }
        });

    }
}
