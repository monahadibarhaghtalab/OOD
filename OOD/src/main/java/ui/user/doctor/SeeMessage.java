package ui.user.doctor;

import data.dao.UserFuncDao;
import data.dao.imp.DoctorDaoImpl;
import data.dao.imp.PatientDaoImpl;
import logical.user.doctor.OrdDoctor;
import logical.user.doctor.Doctor;
import logical.user.doctor.ExpertDoctor;
import logical.user.Message;
import logical.user.patient.Patient;
import logical.user.User;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.Temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Mona on 3/30/2015.
 */
public class SeeMessage extends Temp {

    private myJFrame winMain;
    private myJLabel name;
    private myJLabel family;
    private int numMessage;
    private myJTextField ntext;
    private myJTextField htext;
    private myJButton[] arrayLabel;
    private myJFrame[] arrayWin;
    private int staticHeight = 30;
    private myJLabel labelsender;
    private myJTextField sendertext;
    private UserFuncDao myUserdao;
    private ArrayList<Message> messages;



    public SeeMessage(ArrayList<Message> mymessages, String type){
        super();
        messages = mymessages;
        numMessage = messages.size();

        winMain = getWindow("پیام ها", true);

        arrayLabel = new myJButton[numMessage];
        arrayWin = new myJFrame[numMessage];

        for (int i = 0; i < numMessage; i++){
            arrayWin[i] = getWindow(messages.get(i).getTitle(), false);


            name = new myJLabel("نام فرستنده");
            name = name.set(400, 250, 250, 20, "B Nazanin", 20);
            arrayWin[i].add(name);

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

            arrayLabel[i] = new myJButton(true);
            arrayLabel[i] = arrayLabel[i].set(300, 80 + i * staticHeight, 200, staticHeight, "B Nazanin", 16);
            arrayLabel[i].setText(messages.get(i).getTitle());
//            arrayLabel[i].setBorderPainted(false);
//            arrayLabel[i].setFocusPainted(false);
//            arrayLabel[i].setContentAreaFilled(false);

            winMain.add(arrayLabel[i]);

            myJButton accept = new myJButton(false);
            accept.setText("قبول");
            accept.set(320, 400, 70, 30, "B Nazanin", 18);
            final int finalTemp = i;
            final String finalType = type;
            accept.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(finalType.equals("doctor")) {
                        myUserdao = new DoctorDaoImpl();
                        DoctorDaoImpl tempMyUserDao = (DoctorDaoImpl)myUserdao;

                        tempMyUserDao.addPatient( (Doctor)messages.get(finalTemp).getReceiver(), messages.get(finalTemp).getPatientId());

                        //second argument is patient ID
                       // tempMyUserDao.addPatient( messages.get(finalTemp).getReceiver(),  Integer.parseInt());
                    }
                    //  window.setVisible(false);
                    if(finalType.equals("admin")) {
                        User t = messages.get(finalTemp).getSender();
                        if (t.getClass().equals(Doctor.class)|| t.getClass().equals(OrdDoctor.class) || t.getClass().equals(ExpertDoctor.class))
                            myUserdao = new DoctorDaoImpl();
                        if (t.getClass().equals(Patient.class))
                            myUserdao = new PatientDaoImpl();

                        myUserdao.SignUp(messages.get(finalTemp).getSender());
                       // doctordao.addPatient((doctor) messages.get(finalTemp).getReceiver(), (patient) messages.get(finalTemp).getSender());
                    }
                }
            });

            myJButton reject = new myJButton(false);
            reject.setText("رد درخواست");
            reject.set(300, 450, 110, 30, "B Nazanin", 18);


            labelsender = new myJLabel("نام کاربری");
            labelsender = labelsender.set(400, 250, 250, 20, "B Nazanin", 20);
            arrayWin[i].add(labelsender);

            sendertext = new myJTextField(messages.get(i).getSender().getName() +" "+ messages.get(i).getSender().getFamilyName());
            sendertext.set(150, 250, 150, 20, "B Nazanin", 20);
            arrayWin[i].add(sendertext);

//            typrtext = new myJTextField(messages.get(i).getSender().getName() +" "+ messages.get(i).getSender().getFamilyName());
//            typetext.set(150, 400, 150, 20, "B Nazanin", 20);
//            arrayWin[i].add(typetext);

            arrayWin[i].add(accept);
            arrayWin[i].add(reject);

            final int finalI = i;
            arrayLabel[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // new showResult();
                    arrayWin[finalI].setVisible(true);
                    winMain.setVisible(false);
                }
            });
        }






    }
}
