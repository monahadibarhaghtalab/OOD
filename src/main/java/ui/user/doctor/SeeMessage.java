package ui.user.doctor;

import data.dao.UserFuncDao;
import data.dao.imp.AdminDaoImpl;
import data.dao.imp.DoctorDaoImpl;
import data.dao.imp.PatientDaoImpl;
import logical.user.doctor.OrdDoctor;
import logical.user.doctor.Doctor;
import logical.user.Message;
import logical.user.User;
import logical.user.patient.Patient;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.Temp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import main.Main;
/**
 * Created by Mona on 3/30/2015.
 */
public class SeeMessage extends Temp {

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
    myJTextField nametext;
    myJLabel recname;



    public SeeMessage(ArrayList<Message> mymessages, String type){
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

            Ltype = new myJLabel("نوع کاربر ");
            Ltype =Ltype.set(400, 350, 250, 20, "B Nazanin", 20);
            arrayWin[i].add(Ltype);

            recname = new myJLabel("نام بیمار");
            recname =recname.set(400, 400, 250, 20, "B Nazanin", 20);



            htext = new myJTextField("");
            htext.set(150, 250, 150, 20, "B Nazanin", 20);
            htext.setText(messages.get(i).getSender().getName() + " "+messages.get(i).getSender().getFamilyName());
            arrayWin[i].add(htext);

            ntext = new myJTextField("");
            ntext.set(150, 300, 150, 20, "B Nazanin", 20);
            ntext.setText(messages.get(i).getContent());
            arrayWin[i].add(ntext);

            ttext = new myJTextField("");
            ttext.set(150, 350, 150, 20, "B Nazanin", 20);
            ttext.setText(Main.nameMap.get(messages.get(i).getSender().getMytype()));
            arrayWin[i].add(ttext);




            if(type.equals("doctor")){
              //  recname.setText();
                nametext = new myJTextField("");
                nametext.set(150, 400, 150, 20, "B Nazanin", 20);
                System.out.println("patientID: "+messages.get(i).getPatientId());
                Patient p = new PatientDaoImpl().getPatientByID(messages.get(i).getPatientId());
                nametext.setText(p.getName()+" "+p.getFamilyName());
                arrayWin[i].add(nametext);
                arrayWin[i].add(recname);
            }

            arrayLabel[i] = new myJButton(true);
            arrayLabel[i] = arrayLabel[i].set(300, 120 + i * staticHeight, 200, staticHeight, "B Nazanin", 16);
            arrayLabel[i].setText(messages.get(i).getSender().getName()+"   "+messages.get(i).getTitle());
//            arrayLabel[i].setBorderPainted(false);
//            arrayLabel[i].setFocusPainted(false);
//            arrayLabel[i].setContentAreaFilled(false);

            winMain.add(arrayLabel[i]);
            //final int finalmyI = i;
            myJButton accept = new myJButton(false);
            accept.setText("قبول");
            accept.set(320, 450, 70, 30, "B Nazanin", 18);
            final int finalTemp = i;
            final String finalType = type;
            accept.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(finalType.equals("doctor")) {
                        myUserdao = new DoctorDaoImpl();
                        DoctorDaoImpl tempMyUserDao = (DoctorDaoImpl)myUserdao;
                        System.out.println("id: " + messages.get(finalTemp).PatientId);
                        tempMyUserDao.addPatient( new Doctor(messages.get(finalTemp).getReceiver(), messages.get(finalTemp).getReceiver().getMytype()), messages.get(finalTemp).getPatientId());
                        JOptionPane.showMessageDialog(arrayWin[finalTemp],
                                "بیمار مورد نظر ثبت شد.", "اطلاعات",JOptionPane.INFORMATION_MESSAGE);

                        arrayWin[finalTemp].setVisible(false);
                        UserFuncDao userdao = new DoctorDaoImpl();
                      //  myUserdao.deleteMsgUserSend(messages.get(finalTemp).getSender());
                        ArrayList<Message> newmessages =userdao.getMessages(messages.get(finalTemp).getReceiver());
                        new SeeMessage(newmessages,"doctor");
                        //second argument is patient ID
                       // tempMyUserDao.addPatient( messages.get(finalTemp).getReceiver(),  Integer.parseInt());
                    }
                    //  window.setVisible(false);
                    if(finalType.equals("admin")) {
                        User t = messages.get(finalTemp).getSender();
                        System.out.println("sender:"+messages.get(finalTemp).getSender().getClass());
                        System.out.println(OrdDoctor.class);
                        System.out.println(t.getClass().equals(Doctor.class));
                        System.out.println("type:"+t.getMytype());
                        if (t.getMytype().equals("Spec") || t.getMytype().equals("General") ) {
                            myUserdao = new DoctorDaoImpl();
                            System.out.println("Doctors");
                        }
                        if (t.getMytype().equals("patient")) {
                            myUserdao = new PatientDaoImpl();
                            System.out.println("patient");
                        }
                        System.out.println("sender: "+ messages.get(finalTemp).getSender());
                        myUserdao.SignUp(messages.get(finalTemp).getSender());
                        JOptionPane.showMessageDialog(arrayWin[finalTemp],
                                "کاربر مورد نظر ثبت شد  !",  "اطلاعات",JOptionPane.INFORMATION_MESSAGE);
                        arrayWin[finalTemp].setVisible(false);
                        UserFuncDao userdao = new AdminDaoImpl();
                        //userdao.deleteMsgUserSend(messages.get(finalTemp).getSender());
                        ArrayList<Message> newmessages =userdao.getMessages(messages.get(finalTemp).getReceiver());
                        new SeeMessage(newmessages,"admin");
                       // doctordao.addPatient((doctor) messages.get(finalTemp).getReceiver(), (patient) messages.get(finalTemp).getSender());
                    }


                }
            });

            myJButton reject = new myJButton(false);
            reject.setText("رد درخواست");
            reject.set(300, 500, 110, 30, "B Nazanin", 18);
            reject.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    User t = messages.get(finalTemp).getSender();
                    if(finalType.equals("doctor")) {
                        myUserdao = new DoctorDaoImpl();
                        //DoctorDaoImpl tempMyUserDao = (DoctorDaoImpl)myUserdao;
                        myUserdao.deleteMsgUserSend(t);
                        arrayWin[finalTemp].setVisible(false);
                        UserFuncDao userdao = new DoctorDaoImpl();
                        ArrayList<Message> newmessages =userdao.getMessages(messages.get(finalTemp).getReceiver());
                        new SeeMessage(newmessages,"doctor");
                       // new SeeMessage(newmessages,"doctor");
                        //second argument is patient ID
                        // tempMyUserDao.addPatient( messages.get(finalTemp).getReceiver(),  Integer.parseInt());
                    }
                    //  window.setVisible(false);
                    if(finalType.equals("admin")) {

                        if (t.getMytype().equals("Spec") || t.getMytype().equals("General") ) {
                            myUserdao = new DoctorDaoImpl();
                            System.out.println("Doctors");
                        }
                        if (t.getMytype().equals("patient")) {
                            myUserdao = new PatientDaoImpl();
                            System.out.println("patient");
                        }
                        System.out.println("sender: "+ messages.get(finalTemp).getSender());
                        myUserdao.deleteMsgUserSend(messages.get(finalTemp).getSender());

                        arrayWin[finalTemp].setVisible(false);
                        UserFuncDao userdao = new AdminDaoImpl();
                        ArrayList<Message> newmessages =userdao.getMessages(messages.get(finalTemp).getReceiver());
                        new SeeMessage(newmessages,"admin");
                        // doctordao.addPatient((doctor) messages.get(finalTemp).getReceiver(), (patient) messages.get(finalTemp).getSender());
                    }


                   // winMain.setVisible(true);
                }
            });

            labelsender = new myJLabel("فرستنده ");
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
