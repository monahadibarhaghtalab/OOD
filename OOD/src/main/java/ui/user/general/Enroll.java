package ui.user.general;

import data.dao.AdminDao;
import data.dao.MessageDao;
import data.dao.UserDao;
import data.dao.UserFuncDao;
import data.dao.imp.AdminDaoImpl;
import data.dao.imp.DoctorDaoImpl;
import logical.user.admin;
import logical.user.doctor.OrdDoctor;
import logical.user.doctor.doctor;
import logical.user.doctor.expertDoctor;
import logical.user.message;
import logical.user.patient.patient;
import logical.user.user;
import ui.element.*;
import ui.user.TempFirst;
import ui.user.doctor.FirstPageDoctor;
import ui.user.drugstore.FirstPageDrug;
import ui.user.patient.FirstPagePatient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Mona on 4/20/2015.
 */
class Enroll  extends TempFirst {

    private UserDao userdao;
    private MessageDao messagedao;
    private admin admin;
    private  myJComboBox type;
    private myJFrame window;

    private myJLabel date;
    private myJLabel name;
    private myJLabel family;
    private myJLabel labelUser;
    private myJLabel labelPass;
    private myJLabel idCode;
    private myJLabel pressure;

    private myJTextField dtext;
    private myJTextField ntext;
    private myJTextField htext;
   // private myJTextField utext;
    //private JPasswordField passtext;
    private myJTextField wtext;
    //private myJTextField ptext;
    private myJTextField utext;
    private JPasswordField ptext;

    private myJButton enter;


    public Enroll(user user) {
        super();
        //change
       // tempUser = user;

        window = getWindow("ثبت نام", true);

//
//        date = new myJLabel("نام");
//        date = date.set(400, 200, 250, 20, "B Nazanin", 20);
//        window.add(date);

        name = new myJLabel("نام");
        name = name.set(400, 250, 250, 20, "B Nazanin", 20);
        window.add(name);

       family = new myJLabel("نام خانوادگی");
       family =family.set(400, 300, 250, 20, "B Nazanin", 20);
        window.add(family);



        idCode = new myJLabel("کد ملی ");
        idCode = idCode.set(400, 350, 250, 20, "B Nazanin", 20);
        window.add(idCode);


        labelUser = new myJLabel("نام کاربری");
        labelUser = labelUser.set(400, 400, 250, 20, "B Nazanin", 20);
        window.add(labelUser);

        labelPass = new myJLabel("رمز عبور ");
        labelPass = labelPass.set(400, 450, 250, 20, "B Nazanin", 20);
        window.add(labelPass);

        type = new myJComboBox();
        type.set(150, 500, 150, 20, "B Nazanin", 20);
        type.addItem("پزشک عمومی");
        type.addItem("پزشک متخصص");
        type.addItem("بیمار");
        type.addItem("داروخانه");
        window.add(type);



//        dtext = new myJTextField("");
//        dtext.set(150, 200, 150, 20, "B Nazanin", 20);
//        window.add(dtext);

        htext = new myJTextField("");
        htext.set(150, 250, 150, 20, "B Nazanin", 20);
        window.add(htext);

        ntext = new myJTextField("");
        ntext.set(150, 300, 150, 20, "B Nazanin", 20);
        window.add(ntext);



        wtext = new myJTextField("");
        wtext.set(150, 350, 150, 20, "B Nazanin", 20);
        window.add(wtext);





        utext = new myJTextField("");
        utext.set(150, 400, 150, 20, "B Nazanin", 20);
        window.add(utext);

        ptext = new JPasswordField();
        ptext.setBounds(150, 450, 150, 20);
        window.add(ptext);


        enter = new myJButton(false);
        enter.setText("ثبت");
        enter.set(200, 550, 100, 40, "B Nazanin", 20);
        window.add(enter);

        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("monaaaaaaaa");
                //check type of user
                UserFuncDao adminDao = new AdminDaoImpl();
                admin = (admin)adminDao.getUser("admin");
                if(type.getSelectedItem().toString().equals("پزشک عمومی")){
                    user tempUser = new OrdDoctor(htext.getText(), ptext.getPassword(),  utext.getText(), ntext.getText(),  Integer.parseInt(wtext.getText()));
                    message request = new message(tempUser, admin, new Date());
                    messagedao.sendMessage(request);
//

                }
                else if(type.getSelectedItem().toString().equals("پزشک متخصص")){
                    user tempUser = new expertDoctor(htext.getText(), ptext.getPassword(),  utext.getText(), ntext.getText(),  Integer.parseInt(wtext.getText()));
                    message request = new message(tempUser, admin, new Date());
                    messagedao.sendMessage(request);

                }
                else if(type.getSelectedItem().toString().equals("بیمار")){
                    user tempUser = new patient(htext.getText(), ptext.getPassword(),  utext.getText(), ntext.getText(),  Integer.parseInt(wtext.getText()));
                    message request = new message(tempUser, admin, new Date());
                    messagedao.sendMessage(request);
                }

                new Welcome();
                window.setVisible(false);
            }
        });
    }
}
