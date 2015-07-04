package ui.user.doctor;

import data.dao.DoctorDao;
import data.dao.UserFuncDao;
import data.dao.imp.DoctorDaoImpl;
import data.typeDetector;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;
import logical.user.User;
import main.Main;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJTextField;
import ui.element.myJLabel;
import ui.user.Temp;
import ui.user.general.Welcome;
import ui.user.patient.ChooseDoctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Mona on 3/15/2015.
 */
public class LookforPateint  extends Temp {
    private DoctorDao docDao;
    private Patient p;
    private Doctor myDoctor;
    private typeDetector detector;

    private  myJButton seeHistory;
    private myJFrame window1, window2;
    private myJLabel name, family, docNum;
    private myJTextField ntext, ftext, dtext;
    private myJButton search;

    private myJButton submitHealth, referencePro, addHistory, changePro, archive, prescript;


    public LookforPateint(Doctor d) {
        super();
        super.profile1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window1.setVisible(false);

            }
        });

        myDoctor = d;
        detector = new typeDetector();
        window1 = getWindow("جستجوی بیمار", true);

       // window1anel window1 = new window1anel();
        docNum = new myJLabel("کد ملی");
        docNum = docNum.set(300, 200, 50, 20, "B Nazanin", 20);
        window1.add(docNum);

        name = new myJLabel("نام");
        name = name.set(300, 200, 50, 20, "B Nazanin", 20);
//        window1.add(name);
//
//
        family = new myJLabel("نام خانوادگی");
        family = family.set(300, 250, 100, 20, "B Nazanin", 20);
//        window1.add(family);
//
//        docNum = new myJLabel("کد ملی");
//        docNum = docNum.set(300, 300, 50, 20, "B Nazanin", 20);
//        window1.add(docNum);


        ntext = new myJTextField("");
        ntext.set(150, 200, 50, 20, "B Nazanin", 20);
        window1.add(ntext);

//        ftext = new myJTextField("");
//        ftext.set(150, 250, 50, 20, "B Nazanin", 20);
//        window2.add(ftext);
//
//        dtext = new myJTextField("");
//        dtext.set(150, 300, 50, 20, "B Nazanin", 20);
//        window1.add(ntext); window1.add(ftext); window1.add(dtext);

        search = new myJButton(false);
        search.setText("جستجو");
        search.set(200, 400, 100, 40, "B Nazanin", 20);
        window1.add(search);

       // window1.setLayout(new FlowLayout(FlowLayout.CENTER));
        //window1.pack();
        //window1.setVisible(true);

     //   window1.getContentPane().add(window1);




        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                docDao = (DoctorDao)detector.getDoctorDao(Main.SaveType);
                ArrayList<Patient> patients = docDao.showListOfPatient(myDoctor);
                boolean seen = false;
//                for(int i = 0; i < patients.size(); i++){
//                    if(patients.get(i).getId() == ntext.getText()){
//                        seen = true;
//                        break;
//                    }
//                }
//                if(!seen){
//                    JOptionPane.showMessageDialog(null, "بیمار با کد ملی داده شده یافت نشد!", "اطلاعات"
//                            , JOptionPane.INFORMATION_MESSAGE);
//                    new LookforPateint(myDoctor);
//                    return;
//
//                }
                p = docDao.searchPatient(myDoctor,ntext.getText());
System.out.println(p.getName());
                window2 = getWindow("پرونده ی بیمار", false);

                submitHealth = new myJButton(false);
                referencePro = new myJButton(false);
                addHistory = new myJButton(false);
                changePro = new myJButton(false);
                archive = new myJButton(false);
                prescript = new myJButton(false);
                seeHistory = new myJButton(false);

                window2.add(name); window2.add(family); //window2.add(docNum);

                ntext = new myJTextField("");
                ntext.set(150, 200, 50, 20, "B Nazanin", 20);


                ftext = new myJTextField("");
                ftext.set(150, 250, 50, 20, "B Nazanin", 20);


                dtext = new myJTextField("");
                dtext.set(150, 300, 50, 20, "B Nazanin", 20);
                //window1.add(ntext); window1.add(ftext); window1.add(dtext);


                ntext.setText(p.getName());
                ftext.setText(p.getFamilyName());


                submitHealth.setText("ثبت وضعیت جسمانی");
                submitHealth.set(400, 400, 200, 40, "B Nazanin", 20);
                window2.add(submitHealth);

                submitHealth.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new SubmitHealth(p, myDoctor);
                        //  window.setVisible(false);
                    }
                });

                referencePro.setText("ارجاع به پزشک متخصص/تغییر");
                referencePro.set(200, 400, 200, 40, "B Nazanin", 20);
                window2.add(referencePro);

                referencePro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new ChooseDoctor(myDoctor, p);
                        //  window.setVisible(false);
                    }
                });

                addHistory.setText("افزودن سوابق بیمار");
                addHistory.set(400, 460, 200, 40, "B Nazanin", 20);
                window2.add(addHistory);

                addHistory.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new AddHistiory(p, myDoctor);
                        //  window.setVisible(false);
                    }
                });

//        changePro.setText("تغییر پزشک متخصص");
//        changePro.set(200, 460, 150, 40, "B Nazanin", 20);
//        window2.add(changePro);
//
//        changePro.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new RefPro();
//                //  window.setVisible(false);
//            }
//        });

                archive.setText("آرشیو");
                archive.set(200, 460, 150, 40, "B Nazanin", 20);
                window2.add(archive);

                prescript.setText("تجویز دارو");
                prescript.set(400, 520, 200, 40, "B Nazanin", 20);
                window2.add(prescript);

                prescript.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new WritePres(p, myDoctor);
                        //  window.setVisible(false);
                    }
                });
                seeHistory.setText("مشاهده سابقه بیماری");
                seeHistory.set(200, 520, 200, 40, "B Nazanin", 20);
                window2.add(seeHistory);
                seeHistory.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new SeeHistory(p, myDoctor);
                        //  window.setVisible(false);
                    }
                });
                window2.add(ntext);
                window2.add(ftext);


                window2.setVisible(true);
                window1.setVisible(false);
            }
        });
    }
}
