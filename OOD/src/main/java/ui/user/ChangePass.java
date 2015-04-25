package ui.user;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.TempFirst;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 4/14/2015.
 */
class ChangePass extends TempFirst {

    private myJFrame window;

    private myJLabel labelLastPass;
    private myJLabel labelCurrentPass;

    private myJTextField utext;
    private myJTextField ptext;

    private myJButton submit;

    ChangePass(){

        window = getWindow("", true);
        submit = new myJButton(false);

        labelLastPass = new myJLabel("رمز عبور قدیمی");
        labelLastPass = labelLastPass.set(400, 200, 250, 20, "B Nazanin", 20);
        window.add(labelLastPass);

        labelCurrentPass = new myJLabel("رمز عبور جدید");
        labelCurrentPass = labelCurrentPass.set(400, 250, 250, 20, "B Nazanin", 20);
        window.add(labelCurrentPass);


        utext = new myJTextField("");
        utext.set(150, 200, 150, 20, "B Nazanin", 20);
        window.add(utext);

        ptext = new myJTextField("");
        ptext.set(150, 200, 150, 20, "B Nazanin", 20);
        ptext.repaint();
        window.add(ptext);

       submit = new myJButton(false);
        submit.setText("ثبت");
        submit.set(100, 400, 100, 40, "B Nazanin", 20);
        window.add(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("monaaaaaaaa");
                new ChangeProfile();
                window.setVisible(false);
            }
        });
    }
}
