package ui.user;

import data.dao.MessageDao;
import data.dao.UserDao;
import data.dao.UserFuncDao;
import data.dao.imp.AdminDaoImpl;
import logical.user.Admin;
import logical.user.Message;
import logical.user.User;
import logical.user.doctor.ExpertDoctor;
import logical.user.doctor.OrdDoctor;
import logical.user.patient.Patient;
import ui.element.*;
import ui.user.general.Welcome;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private myJButton enter;


    public ShowMessage(Message m) {
        super();
        myMessage = m;
        //change
        // tempUser = user;

        window = getWindow(m.getTitle(), true);

//
//        date = new myJLabel("نام");
//        date = date.set(400, 200, 250, 20, "B Nazanin", 20);
//        window.add(date);

        name = new myJLabel("نام فرستنده");
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

        htext = new myJTextField(m.getReceiver().getName()+" "+m.getReceiver().getFamilyName());
        htext.set(150, 250, 150, 20, "B Nazanin", 20);
       window.add(htext);

        ntext = new myJTextField("");
        ntext.set(150, 300, 150, 20, "B Nazanin", 20);

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

                Message request = new Message(myMessage.getReceiver(), myMessage.getSender(), new Date(),ntext.getText(),"پاسخ مشاوره",Integer.parseInt(myMessage.getSender().getId()));
                messagedao.sendMessage(request);
            }
        });
    }
}
