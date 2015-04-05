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
class SubmitHealth extends Temp {


    private myJFrame window;

    private myJLabel date;
    private myJLabel name;
    private myJLabel height;
    private myJLabel weight;
    private myJLabel pressure;

    private myJTextField dtext;
    private myJTextField ntext;
    private myJTextField htext;
    private myJTextField wtext;
    private myJTextField ptext;

    private myJButton enter;


    public SubmitHealth() {
        super();
        window = getWindow("ثبت وضعیت جسمانی", true);


        date = new myJLabel("تاریخ");
        date = date.set(400, 200, 250, 20, "B Nazanin", 20);
        window.add(date);

        name = new myJLabel("نام");
        name = name.set(400, 250, 250, 20, "B Nazanin", 20);
        window.add(name);

        height = new myJLabel("قد");
        height = height.set(400, 300, 250, 20, "B Nazanin", 20);
        window.add(height);

        weight = new myJLabel("وزن");
        weight = weight.set(400, 350, 250, 20, "B Nazanin", 20);
        window.add(weight);

        pressure = new myJLabel("فشار خون");
        pressure = weight.set(400, 400, 250, 20, "B Nazanin", 20);
        window.add(pressure);

        dtext = new myJTextField("");
        dtext.set(150, 200, 150, 20, "B Nazanin", 20);
        window.add(dtext);

        htext = new myJTextField("");
        htext.set(150, 250, 150, 20, "B Nazanin", 20);
        window.add(htext);

        ntext = new myJTextField("");
        ntext.set(150, 300, 150, 20, "B Nazanin", 20);
        window.add(ntext);

        wtext = new myJTextField("");
        wtext.set(150, 350, 150, 20, "B Nazanin", 20);
        window.add(wtext);

        ptext = new myJTextField("");
        ptext.set(150, 400, 150, 20, "B Nazanin", 20);
        window.add(ptext);

        enter = new myJButton(false);
        enter.setText("ثبت");
        enter.set(200, 500, 100, 40, "B Nazanin", 20);
        window.add(enter);
    }
}