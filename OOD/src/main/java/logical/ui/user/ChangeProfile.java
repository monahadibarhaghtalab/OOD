package ui.user;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 4/14/2015.
 */
class ChangeProfile extends TempFirst {

    private myJButton changeInfo;
    private myJFrame  window;
    private myJButton changePass;


    private myJLabel type;
    private myJLabel typeDoctor;
    private myJLabel labelType;

    private myJTextField utext;
    private myJTextField ttext;



    ChangeProfile() {

        window = getWindow("ویرایش حساب کاربری", true);


        int start = 200;
        int height = 30;

        changeInfo = new myJButton(false);
        changePass = new myJButton(false);

        changeInfo.set(150, start, 300, height, "B Nazanin", 20);
        changeInfo.setText("تغییر اطلاعات شخصی");
        window.add(changeInfo);

        changePass.set(150, start + height, 300, height, "B Nazanin", 20);
        changePass.setText("تغییر رمز عبور");
        window.add(changePass);

        changePass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChangePass();
                //  window.setVisible(false);
            }
        });

        changeInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChangeInfo();
                //  window.setVisible(false);
            }
        });

    }
}
