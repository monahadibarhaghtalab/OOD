package ui.user.doctor;

import data.dao.UserFuncDao;
import data.dao.imp.DoctorDaoImpl;
import data.dao.imp.patientDaoImpl;
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
public class LookforPateint  extends Temp {
    private UserFuncDao userdao;
    private Patient p;
    private Doctor d;
    private  myJButton seeHistory;
    private myJFrame window1, window2;
    private myJLabel name, family, docNum;
    private myJTextField ntext, ftext, dtext;
    private myJButton search;

    private myJButton submitHealth, referencePro, addHistory, changePro, archive, prescript;


    public LookforPateint() {
        super();

        window1 = getWindow("جستجوی بیمار", true);

       // window1anel window1 = new window1anel();

        name = new myJLabel("نام");
        name = name.set(300, 200, 50, 20, "B Nazanin", 20);
        window1.add(name);


        family = new myJLabel("نام خانوادگی");
        family = family.set(300, 250, 50, 20, "B Nazanin", 20);
        window1.add(family);

        docNum = new myJLabel("شماره پرونده");
        family = family.set(300, 300, 50, 20, "B Nazanin", 20);
        window1.add(docNum);



        search = new myJButton(false);
        search.setText("جستجو");
        search.set(200, 400, 100, 40, "B Nazanin", 20);
        window1.add(search);

        window1.setLayout(new FlowLayout(FlowLayout.CENTER));
        //window1.pack();
        //window1.setVisible(true);

     //   window1.getContentPane().add(window1);

        window2 = getWindow("لیست بیماران", false);

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
        window2.add(ntext);

        ftext = new myJTextField("");
        ftext.set(150, 250, 50, 20, "B Nazanin", 20);
        window2.add(ftext);

        ntext.setText(p.getName());
        ftext.setText(p.getFamilyName());


        submitHealth.setText("ثبت وضعیت جسمانی");
        submitHealth.set(400, 400, 150, 40, "B Nazanin", 20);
        window2.add(submitHealth);

        submitHealth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SubmitHealth();
                //  window.setVisible(false);
            }
        });

        referencePro.setText("ارجاع به پزشک متخصص");
        referencePro.set(200, 400, 150, 40, "B Nazanin", 20);
        window2.add(referencePro);

        referencePro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RefPro();
                //  window.setVisible(false);
            }
        });

        addHistory.setText("افزودن سوابق بیمار");
        addHistory.set(400, 460, 150, 40, "B Nazanin", 20);
        window2.add(addHistory);

        addHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddHistiory(p, d);
                //  window.setVisible(false);
            }
        });

        changePro.setText("تغییر پزشک متخصص");
        changePro.set(200, 460, 150, 40, "B Nazanin", 20);
        window2.add(changePro);

        changePro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RefPro();
                //  window.setVisible(false);
            }
        });

        archive.setText("آرشیو");
        archive.set(400, 520, 150, 40, "B Nazanin", 20);
        window2.add(archive);

        prescript.setText("تجویز دارو");
        prescript.set(200, 520, 150, 40, "B Nazanin", 20);
        window2.add(prescript);

        prescript.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new WritePres(p, d);
                //  window.setVisible(false);
            }
        });
        seeHistory.setText("مشاهده سابقه بیماری");
        seeHistory.set(300, 580, 150, 40, "B Nazanin", 20);
        window2.add(seeHistory);

        seeHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SeeHistory();
                //  window.setVisible(false);
            }
        });
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userdao = new DoctorDaoImpl();

                ArrayList<User> tmp = userdao.search();
                if (tmp.size() != 0){
                    p = (Patient) tmp.get(0);
                    d = new patientDaoImpl().findOrdDoctor(p);
                }

                window2.setVisible(true);
                window1.setVisible(false);
            }
        });
    }
}
