package ui.user.doctor;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.Temp;

import javax.swing.*;

/**
 * Created by Mona on 4/5/2015.
 */
class WritePres extends Temp{

    private myJFrame window;

    private myJLabel text;
    private myJLabel name;//to show to whom do we want to send
    private myJLabel labelType;

    private myJTextField utext;
    private myJTextField ttext;
    private JPasswordField ptext;

    private myJButton send;




    public WritePres() {
        super();
        window = getWindow("تجویز دارو", true);

        text = new myJLabel("داروها");
        text = text.set(400, 200, 250, 20, "B Nazanin", 20);
        window.add(text);

        utext = new myJTextField("");
        utext.set(150, 200, 150, 200, "B Nazanin", 20);
        window.add(utext);


        send = new myJButton(false);
        send.setText("ثبت");
        send.set(200, 400, 100, 40, "B Nazanin", 20);
        window.add(send);

    }
}
