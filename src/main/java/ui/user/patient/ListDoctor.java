package ui.user.patient;

import data.dao.MessageDao;
import data.dao.UserFuncDao;
import data.dao.imp.MessageDaoImpl;
import data.dao.imp.PatientDaoImpl;
import data.dao.imp.UserDaoImpl;

import logical.user.doctor.Doctor;
import logical.user.doctor.ExpertDoctor;
import logical.user.doctor.OrdDoctor;
import logical.user.Message;
import logical.user.patient.Patient;
import logical.user.User;
import main.Main;
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
    private myJLabel name, family, docNum;
    private myJTextField ntext1;
    final private boolean inSearch1 = false;
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


        messagedao = new MessageDaoImpl();



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
                if(myUser.getMytype().equals("patient")) {
                    System.out.println("find General");
                    ArrayList<OrdDoctor> tmp = PatientDaoImpl.getListOfOrdDoctor(ntext.getText(), ftext.getText());
                    searchDoctor = new ArrayList<Doctor>();
                    for(int i = 0; i < tmp.size(); i++){
                        searchDoctor.add(tmp.get(i));
                    }
                    System.out.println("size of doctor:"+searchDoctor.size());
                }
//takhasos
                if(myUser.getMytype().equals("Spec") ||myUser.getMytype().equals("General") ) {
                    ArrayList<ExpertDoctor> tmp = PatientDaoImpl.getListOfProDoctor(ntext.getText(), ftext.getText());
                    searchDoctor = new ArrayList<Doctor>();
                    for(int i = 0; i < tmp.size(); i++){
                        searchDoctor.add(tmp.get(i));
                    }                }

             //   window2.setVisible(false);
                //  winMain.setVisible(false);

                System.out.println("show list of doctor !! ");
                window2 = getWindow("لیست پزشکان", false);



                String[] columnNames = {" تخصص",
                        " نام پزشک",
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

                    data[i][1] = i + 1 +" "+searchDoctor.get(i).getName() + " " + searchDoctor.get(i).getFamilyName();
                    data[i][0] = Main.nameMap.get(searchDoctor.get(i).getType());

                }

                System.out.println("hi");
                myJTable table = new myJTable(data, columnNames);
                System.out.println("hi2");
                //JScrollPane scrollPane = new JScrollPane(table);
               // window2.add(scrollPane, BorderLayout.CENTER);

                search1 = new myJButton(false);
                search1.setText("فرستادن درخواست");
                search1.set(200, 150, 100, 40, "B Nazanin", 20);
                window2.add(search1);

                table.set(100, 200, 400, 300, "B Nazanin", 14);
                JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setBounds(100, 200, 400, 300);
                // window2.getContentPane().add(scrollPane);
                // window2.pack();


                // scrollPane.setViewportView(table);
                window2.add(scrollPane);
               // window2.add(table);

                docNum = new myJLabel("شماره سطر");
                docNum = docNum.set(300, 100, 100, 20, "B Nazanin", 20);
                window2.add(docNum);
                ntext1 = new myJTextField("");
                ntext1.set(150, 100, 50, 20, "B Nazanin", 20);
                window2.add(ntext1);
                System.out.println("go to window 2!");
                        window2.setVisible(true);
                        winMain.setVisible(false);


                search1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // new showResult();
                       // String num = bg.getSelection().getActionCommand();
                        Message request;

                        if (myUser.getMytype().equals("patient")) {
                            System.out.println("patientid in sending: "+myUser.getId());
                            request = new Message(myUser, searchDoctor.get(Integer.parseInt(ntext1.getText()) - 1), new Date(), "درخواست پذیرش", "درخواست پذیرش", myUser.getId(),0);
                        }
                        else {
                            Doctor d = (Doctor)myUser;
                            System.out.println("vurrent patientid in sending doctor: "+d.currentPatient.getId());
                            request = new Message(myUser, searchDoctor.get(Integer.parseInt(ntext1.getText()) - 1), new Date(), "درخواست پذیرش", "درخواست پذیرش", d.currentPatient.getId(),0);
                        }
                        messagedao.sendMessage(request);
                        JOptionPane.showMessageDialog(null, "درخواست ثبت شد.", "اطلاعات"
                                , JOptionPane.INFORMATION_MESSAGE);

                        window2.setVisible(false);
                        winMain.setVisible(true);
                        return;

                    }

                });


            }
        });



        /*
        make the second window to show the result
         */



    }
}
