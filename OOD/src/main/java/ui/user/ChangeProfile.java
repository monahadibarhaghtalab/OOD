package ui.user;

import ui.element.myJButton;
import ui.element.myJFrame;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 4/14/2015.
 */
public class ChangeProfile extends TempFirst {

    private myJFrame  window;
    private myJButton changePass;

    ChangeProfile() {

        window = getWindow("حساب کاربری ", true);

        changePass = new myJButton(false);


        int start = 200;
        int height = 30;

        changePass.set(150, start, 300, height, "B Nazanin", 20);
        changePass.setText("تغییر رمز عبور");
        window.add(changePass);

        changePass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChangePass();
                //  window.setVisible(false);
            }
        });

    }
}
