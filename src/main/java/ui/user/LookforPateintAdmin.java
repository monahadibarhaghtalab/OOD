package ui.user;

/**
 * Created by a on 5/21/15.
 */

import data.dao.AdminDao;
import data.dao.PatientDao;
import data.dao.UserFuncDao;
import data.dao.imp.AdminDaoImpl;
import data.dao.imp.DoctorDaoImpl;
import logical.user.User;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.doctor.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import data.dao.UserFuncDao;
import data.dao.imp.DoctorDaoImpl;
import data.dao.imp.PatientDaoImpl;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;
import logical.user.User;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJTextField;
import ui.element.myJLabel;
import ui.user.Temp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Mona on 3/15/2015.
 */
public class LookforPateintAdmin  extends Temp {
    private UserFuncDao userdao;
    private Patient p;
    private Doctor d;
    private myJButton seeHistory;
    private myJFrame window1, window2;
    private myJLabel name, family, docNum;
    private myJTextField ntext, ftext, dtext;
    private myJButton search;

    private myJButton submitHealth, referencePro, addHistory, changePro, archive, prescript;


    public LookforPateintAdmin() {
        super();

        window1 = getWindow("جستجوی بیمار", true);

        // window1anel window1 = new window1anel();

        docNum = new myJLabel("کد ملی");
        docNum = docNum.set(300, 200, 50, 20, "B Nazanin", 20);
       // window1.add(docNum);

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
        window1.add(docNum);


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

//        window1.setLayout(new FlowLayout(FlowLayout.CENTER));
        //window1.pack();
        //window1.setVisible(true);

        //   window1.getContentPane().add(window1);

        window2 = getWindow("پرونده ی بیمار", false);


//        submitHealth = new myJButton(false);
//        referencePro = new myJButton(false);
//        addHistory = new myJButton(false);
//        changePro = new myJButton(false);
//        archive = new myJButton(false);
//        prescript = new myJButton(false);
        seeHistory = new myJButton(false);

        window2.add(name); window2.add(family); //window2.add(docNum);

        dtext = new myJTextField("");
        dtext.set(150, 200, 50, 20, "B Nazanin", 20);


        ftext = new myJTextField("");
        ftext.set(150, 250, 50, 20, "B Nazanin", 20);





//        submitHealth.setText("ثبت وضعیت جسمانی");
//        submitHealth.set(400, 400, 150, 40, "B Nazanin", 20);
//        window2.add(submitHealth);
//
//        submitHealth.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new SubmitHealth(p, d);
//                //  window.setVisible(false);
//            }
//        });
//
//        referencePro.setText("ارجاع به پزشک متخصص");
//        referencePro.set(200, 400, 150, 40, "B Nazanin", 20);
//        window2.add(referencePro);
//
//        referencePro.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new RefPro();
//                //  window.setVisible(false);
//            }
//        });
//
//        addHistory.setText("افزودن سوابق بیمار");
//        addHistory.set(400, 460, 150, 40, "B Nazanin", 20);
//        window2.add(addHistory);
//
//        addHistory.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new AddHistiory(p, d);
//                //  window.setVisible(false);
//            }
//        });
//
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
//
//        archive.setText("آرشیو");
//        archive.set(400, 520, 150, 40, "B Nazanin", 20);
//        window2.add(archive);
//
//        prescript.setText("تجویز دارو");
//        prescript.set(200, 520, 150, 40, "B Nazanin", 20);
//        window2.add(prescript);
//
//        prescript.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new WritePres(p, d);
//                //  window.setVisible(false);
//            }
//        });

        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminDao admindao = new AdminDaoImpl();
                PatientDao pdao = new PatientDaoImpl();

                p = admindao.searchPatient(ntext.getText());
                d = pdao.getOrdDoc(p);
                dtext.setText(p.getName());
                System.out.println("name: "+p.getName()+" family:"+p.getFamilyName());
                ftext.setText(p.getFamilyName());
                window2.add(dtext);
                window2.add(ftext);

                seeHistory.setText("مشاهده سابقه بیماری");
                seeHistory.set(400, 400, 200, 40, "B Nazanin", 20);
                window2.add(seeHistory);

                seeHistory.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        new SeeHistory(p,d);
                        //  window.setVisible(false);
                    }
                });


                window2.setVisible(true);
                window1.setVisible(false);
            }
        });
    }
}
