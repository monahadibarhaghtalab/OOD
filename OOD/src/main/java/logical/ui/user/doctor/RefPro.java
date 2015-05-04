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
class RefPro extends Temp {
    private myJTextField ntext;
    private myJLabel nameDr;
    private myJFrame window;

    private myJLabel text;
    private myJLabel name;//to show to whom do we want to send
    private myJLabel labelType;

    private myJTextField utext;
    private myJTextField ttext;
    private JPasswordField ptext;

    private myJButton send;




    public RefPro() {
        super();
        window = getWindow("ارجاع به پزشک متخصص", true);

        text = new myJLabel("متن پیام");
        text = text.set(400, 200, 250, 20, "B Nazanin", 20);
        window.add(text);

        utext = new myJTextField("");
        utext.set(150, 200, 150, 200, "B Nazanin", 20);
        window.add(utext);

        nameDr = new myJLabel("نام پزشک");
        nameDr = nameDr.set(400, 400, 250, 20, "B Nazanin", 20);
        window.add(nameDr);

        ntext = new myJTextField("");
        ntext.set(150, 400, 150, 40, "B Nazanin", 20);
        window.add(ntext);

        send = new myJButton(false);
        send.setText("ارسال");
        send.set(200, 500, 100, 40, "B Nazanin", 20);
        window.add(send);

    }
}