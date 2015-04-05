package ui.user.patient;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.Temp;

import javax.swing.*;

/**
 * Created by Mona on 3/30/2015.
 */
class SubmitStatus extends Temp {

    private myJFrame window;

    private myJLabel labelDate;

    private myJTextField dtext;

    private myJButton connect;

    protected SubmitStatus(){
        super();
        window = getWindow("ثبت وضعیت بدنی", true);



        labelDate = new myJLabel("تاریخ");
        labelDate = labelDate.set(400, 250, 250, 20, "B Nazanin", 20);
        window.add(labelDate);



        dtext = new myJTextField("");
        dtext.setBounds(150, 250, 150, 20);
        window.add(dtext);



        connect = new myJButton(false);
        connect.setText("اتصال دستگاه به رایانه");
        connect.set(200, 400, 200, 40, "B Nazanin", 20);
        window.add(connect);
    }
}
