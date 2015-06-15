package ui.user.patient;

import data.dao.UserFuncDao;
import data.dao.imp.AdminDaoImpl;
import data.dao.imp.DoctorDaoImpl;
import data.dao.imp.PatientDaoImpl;
import logical.user.Message;
import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.doctor.OrdDoctor;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.Temp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Mona on 3/30/2015.
 */
class Inbox extends Temp {

    private myJFrame winMain;
    private myJLabel name;
    private myJLabel family;
    private myJLabel Ltype;
    private int numMessage;
    private myJTextField ntext;
    private myJTextField htext;
    private myJTextField ttext;
    private myJButton[] arrayLabel;
    private myJFrame[] arrayWin;
    private int staticHeight = 30;
    private myJLabel labelsender;
    private myJTextField sendertext;
    private UserFuncDao myUserdao;
    private ArrayList<Message> messages;



    public Inbox(ArrayList<Message> mymessages){
        super();
        messages = mymessages;
        numMessage = messages.size();
        System.out.println(messages.size()+ "  size message! ");
        winMain = getWindow("پیام ها", true);

        arrayLabel = new myJButton[numMessage];
        arrayWin = new myJFrame[numMessage];

        for (int i = 0; i < numMessage; i++){
            arrayWin[i] = getWindow(messages.get(i).getSender().getName()+"   "+messages.get(i).getTitle(), false);


            name = new myJLabel("نام فرستنده");
            name = name.set(400, 250, 250, 20, "B Nazanin", 20);
            //  arrayWin[i].add(name);

            family = new myJLabel("متن پیام");
            family =family.set(400, 300, 250, 20, "B Nazanin", 20);
            arrayWin[i].add(family);

            htext = new myJTextField("");
            htext.set(150, 250, 150, 20, "B Nazanin", 20);
            htext.setText(messages.get(i).getSender().getName() + " "+messages.get(i).getSender().getFamilyName());
            arrayWin[i].add(htext);

            ntext = new myJTextField("");
            ntext.set(150, 300, 150, 20, "B Nazanin", 20);
            ntext.setText(messages.get(i).getContent());
            arrayWin[i].add(ntext);

            final int finalI = i;
            arrayLabel[i] = new myJButton(true);
            arrayLabel[i] = arrayLabel[i].set(300, 120 + i * staticHeight, 200, staticHeight, "B Nazanin", 16);
            arrayLabel[i].setText(messages.get(i).getSender().getName()+"   "+messages.get(i).getTitle());
            arrayLabel[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // new showResult();
                    arrayWin[finalI].setVisible(true);
                    winMain.setVisible(false);
                }
            });
            winMain.add(arrayLabel[i]);
            //final int finalmyI = i;

        }






    }
}
