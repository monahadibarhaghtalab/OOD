package ui.user.general;

import ui.element.*;
import ui.user.TempFirst;
import ui.user.doctor.FirstPageDoctor;
import ui.user.drugstore.FirstPageDrug;
import ui.user.patient.FirstPagePatient;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 3/14/2015.
 */
public class Welcome extends TempFirst {
    private static int height;
    private static int width;

    private myJFrame window;
    private myJLabel name;

    private myJLabel labelUser;
    private myJLabel labelPass;
    private myJLabel labelType;

    private myJTextField utext;
    private myJTextField ttext;
    private JPasswordField ptext;

    private myJComboBox type;

    private myJButton enter;
    private myJButton enroll;




    public Welcome() {
        super();
        window = getWindow("", true);
       // window.setLayout(new FlowLayout());
      //  windowanel window = new windowanel();

        name = new myJLabel("به سامانه سلامت خوش آمدید");
        //name = new myJLabel("Hi welcome");
        name = name.set(100, 50, 500, 50, "B Jadid Bold", 40);
        window.add(name);

        labelUser = new myJLabel("نام کاربری");
        labelUser = labelUser.set(400, 200, 250, 20, "B Nazanin", 20);
        window.add(labelUser);

        labelPass = new myJLabel("رمز عبور ");
        labelPass = labelPass.set(400, 250, 250, 20, "B Nazanin", 20);
        window.add(labelPass);

        labelType= new myJLabel("نوع کاربر");
        labelType = labelType.set(400, 300, 250, 20, "B Nazanin", 20);
        window.add(labelType);

        utext = new myJTextField("");
        utext.set(150, 200, 150, 20, "B Nazanin", 20);
        window.add(utext);

        ptext = new JPasswordField();
        ptext.setBounds(150, 250, 150, 20);
        window.add(ptext);

//        ttext = new myJTextField("");
//        ttext.set(150, 300, 150, 20, "B Nazanin", 20);
//        window.add(ttext);


        type = new myJComboBox();
        type.set(150, 300, 150, 20, "B Nazanin", 20);
        type.addItem("پزشک");
        type.addItem("بیمار");
        type.addItem("داروخانه");

        window.add(type);

        enter = new myJButton(false);
        enter.setText("ورود");
        enter.set(300, 400, 100, 40, "B Nazanin", 20);
        window.add(enter);

        enroll = new myJButton(false);
        enroll.setText("ثبت نام");
        enroll.set(100, 400, 100, 40, "B Nazanin", 20);
        window.add(enroll);


      //  window.getContentPane().add(window);
        enroll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("monaaaaaaaa");
                new Enroll();
                window.setVisible(false);
            }
        });


//
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

             //   System.out.println(type.getSelectedItem() + " fmmmmmmmmmmmm");

//                System.out.println(ttext.getText().equals("پزشک"));
                actionEnter();
            }
        });

//        ttext.getDocument().addDocumentListener(new DocumentListener() {
//            public void changedUpdate(DocumentEvent e) {
//                actionEnter();
//            }
//
//            public void removeUpdate(DocumentEvent e) {
//                actionEnter();
//            }
//
//            public void insertUpdate(DocumentEvent e) {
//                actionEnter();
//            }
//        });





    }

    void actionEnter(){
        if(type.getSelectedItem().toString().equals("پزشک")){
            enter.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   // System.out.println("monaaaaaaaa");
                    new FirstPageDoctor();
                    window.setVisible(false);
                }
            });
        }
        else if(type.getSelectedItem().toString().equals("بیمار")){
            System.out.println("monaaaaaaaaaaaaaaaa ");
            enter.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FirstPagePatient();
                    window.setVisible(false);
                }
            });
        }
        else if (type.getSelectedItem().toString().equals("داروخانه")){
            enter.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new FirstPageDrug();
                    window.setVisible(false);
                }
            });
        }

    }

}
