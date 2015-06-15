package ui.user;

import data.dao.*;
import data.dao.imp.AdminDaoImpl;
import data.dao.imp.DoctorDaoImpl;
import data.dao.imp.MessageDaoImpl;
import data.dao.imp.PatientDaoImpl;
import logical.user.Admin;
import logical.user.Message;
import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.doctor.ExpertDoctor;
import logical.user.doctor.OrdDoctor;
import logical.user.patient.Patient;
import ui.element.*;
import ui.user.doctor.SeeConsult;
import ui.user.general.Welcome;
import ui.user.patient.FirstPagePatient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by a on 5/22/15.
 */
public class ShowMessage  extends TempFirst {

    private UserDao userdao;
    private MessageDao messagedao;
    private Admin admin;
    private myJComboBox type;
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
    private Message myMessage;
    private User isender;
    private User ireceiver;


    private myJButton enter;


    public ShowMessage(final User sender, final User receiver, String title) {
        super();
        //myMessage = m;
        //change
        // tempUser = user;

        window = getWindow("پیام", true);
        final String mytitle = title;
//
//        date = new myJLabel("نام");
//        date = date.set(400, 200, 250, 20, "B Nazanin", 20);
//        window.add(date);

        name = new myJLabel("نام گیرنده");
        name = name.set(400, 250, 250, 20, "B Nazanin", 20);
        window.add(name);

        family = new myJLabel("متن پیام");
        family =family.set(400, 300, 250, 20, "B Nazanin", 20);
        window.add(family);



//        idCode = new myJLabel("کد ملی ");
//        idCode = idCode.set(400, 350, 250, 20, "B Nazanin", 20);
//        window.add(idCode);
//
//
//        labelUser = new myJLabel("نام کاربری");
//        labelUser = labelUser.set(400, 400, 250, 20, "B Nazanin", 20);
//        window.add(labelUser);
//
//        labelPass = new myJLabel("رمز عبور ");
//        labelPass = labelPass.set(400, 450, 250, 20, "B Nazanin", 20);
//        window.add(labelPass);
//
//        type = new myJComboBox();
//        type.set(150, 500, 150, 20, "B Nazanin", 20);
//        type.addItem("پزشک عمومی");
//        type.addItem("پزشک متخصص");
//        type.addItem("بیمار");
//        type.addItem("داروخانه");
//        window.add(type);



//        dtext = new myJTextField("");
//        dtext.set(150, 200, 150, 20, "B Nazanin", 20);
//        window.add(dtext);

        htext = new myJTextField(receiver.getName()+" "+receiver.getFamilyName());
        htext.set(150, 250, 150, 20, "B Nazanin", 20);
       window.add(htext);

        ntext = new myJTextField("");
        ntext.set(150, 300, 150, 200, "B Nazanin", 20);

        window.add(ntext);



//        wtext = new myJTextField("");
//        wtext.set(150, 350, 150, 20, "B Nazanin", 20);
//        window.add(wtext);
//
//
//
//
//
//        utext = new myJTextField("");
//        utext.set(150, 400, 150, 20, "B Nazanin", 20);
//        window.add(utext);
//
//        ptext = new JPasswordField();
//        ptext.setBounds(150, 450, 150, 20);
//        window.add(ptext);


        enter = new myJButton(false);
        enter.setText("ثبت");
        enter.set(200, 550, 100, 40, "B Nazanin", 20);
        window.add(enter);

        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messagedao = new MessageDaoImpl();

                //System.out.println(receiver.getId());
                JOptionPane.showMessageDialog(null, "پیام مورد نظر ثبت شد.", "اطلاعات",
                        JOptionPane.INFORMATION_MESSAGE);
                if(sender.getMytype().equals("patient")){
                    Message request = new Message(sender, receiver, new Date(),ntext.getText(),mytitle,"0",1);
                    messagedao.sendMessage(request);

                    new FirstPagePatient(new Patient(sender.getUsername(), sender.getPassword(), sender.getName(), sender.getFamilyName(),  sender.getId()));

                }
                else if(sender.getMytype().equals("Spec") || sender.getMytype().equals("General")){
                    Message request = new Message(sender, receiver, new Date(),ntext.getText(),mytitle,"0",0);
                    messagedao.sendMessage(request);
                    DoctorDao doctordao = new DoctorDaoImpl();

                    ArrayList<Message> consults = doctordao.getConsults(new Doctor(receiver.getUsername(), receiver.getPassword(), receiver.getName(), receiver.getFamilyName(), receiver.getId(),receiver.getMytype()));

                    new SeeConsult(consults);
                }

            }
        });
    }
}
