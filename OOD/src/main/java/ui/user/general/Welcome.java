package ui.user.general;

import ui.element.myJFrame;
import ui.element.myJTextField;
import ui.element.myLabel;
import ui.element.myJButton;
import ui.user.Temp;
import ui.user.doctor.FirstPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

/**
 * Created by Mona on 3/14/2015.
 */
public class Welcome extends Temp {
    private static int height;
    private static int width;

    private myJFrame window;
    private myLabel name;

    private myLabel labelUser;
    private myLabel labelPass;

    private myJTextField utext;
    private JPasswordField ptext;

    private myJButton enter;




    public Welcome() {
        super();
        window = getWindow();

        name = new myLabel("به سامانه سلامت خوش آمدید");
        name = name.set(170, 50, 300, 30, "B Jadid", 30);
        window.add(name);

        labelUser = new myLabel("نام کاربری");
        labelUser = labelUser.set(400, 200, 250, 20, "B Nazanin", 20);
        window.add(labelUser);

        labelPass = new myLabel("رمز عبور ");
        labelPass = labelPass.set(400, 250, 250, 20, "B Nazanin", 20);
        window.add(labelPass);

        utext = new myJTextField("");
        utext.set(150, 200, 150, 20);
        window.add(utext);

        ptext = new JPasswordField();
        ptext.setBounds(150, 250, 150, 20);
        window.add(ptext);

        enter = new myJButton();
        enter.setText("ورود");
        enter.set(200, 300, 100, 40);
        window.add(enter);


        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new FirstPage();
            }
        });



    }


}
