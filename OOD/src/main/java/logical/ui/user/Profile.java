package ui.user;

import ui.element.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 4/24/2015.
 */
public class Profile extends TempFirst{


    private myJButton change;
    private myJLabel typeF;
    private  myJLabel genF;
    private myJLabel gen;
    private myJLabel idCodeF;
    private myJLabel lastNameF;
    private myJLabel firstNameF;

    private myJFrame window;
    private myJLabel name;

    private myJLabel firstName;
    private myJLabel lastName;
    private myJLabel idCode;


    private myJLabel type;

    private myJButton enter;
    private myJButton enroll;




    public Profile() {
        super();
        window = getWindow("حساب کاربری", true);


        firstName = new myJLabel("نام");
        firstName = firstName.set(400, 200, 250, 20, "B Nazanin", 20);
        window.add(firstName);

        firstNameF = new myJLabel("زهرا");
        firstNameF = firstNameF.set(200, 200, 250, 20, "B Nazanin", 20);
        window.add(firstNameF);

        lastName = new myJLabel("نام خانوادگی");
        lastName = lastName.set(400, 250, 250, 20, "B Nazanin", 20);
        window.add(lastName);

        lastNameF = new myJLabel("مینایی");
        lastNameF = lastNameF.set(200, 250, 250, 20, "B Nazanin", 20);
        window.add(lastNameF);

        idCode = new myJLabel("کد ملی");
        idCode = idCode.set(400, 300, 250, 20, "B Nazanin", 20);
        window.add(idCode);

        idCodeF = new myJLabel("228123840");
        idCodeF = idCodeF.set(200, 300, 250, 20, "B Nazanin", 20);
        window.add(idCodeF);

        gen = new myJLabel("شماره نظام پزشکی");
        gen = gen.set(400, 350, 250, 20, "B Nazanin", 20);
        window.add(gen);

        genF = new myJLabel("123456789");
        genF = genF.set(200, 350, 250, 20, "B Nazanin", 20);
        window.add(genF);

        type = new myJLabel("نوع تخصص");
        type = type.set(400, 400, 250, 20, "B Nazanin", 20);
        window.add(type);

        typeF = new myJLabel("عمومی");
        typeF = typeF.set(200, 400, 250, 20, "B Nazanin", 20);
        window.add(typeF);

        change = new myJButton(false);
        change.setText("تغییر حساب کاربری");
        change.set(100, 450, 200, 40, "B Nazanin", 20);
        window.add(change);

        change.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("monaaaaaaaa");
                new ChangeProfile();
                window.setVisible(false);
            }
        });
    }
}
