package ui.user.general;

import ui.element.*;
import ui.user.TempFirst;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 4/20/2015.
 */
class Enroll  extends TempFirst {


    private  myJComboBox type;
    private myJFrame window;

    private myJLabel date;
    private myJLabel name;
    private myJLabel family;
    private myJLabel idCode;
    private myJLabel pressure;

    private myJTextField dtext;
    private myJTextField ntext;
    private myJTextField htext;
    private myJTextField wtext;
    private myJTextField ptext;

    private myJButton enter;


    public Enroll() {
        super();
        window = getWindow("ثبت نام", true);

//
//        date = new myJLabel("نام");
//        date = date.set(400, 200, 250, 20, "B Nazanin", 20);
//        window.add(date);

        name = new myJLabel("نام");
        name = name.set(400, 250, 250, 20, "B Nazanin", 20);
        window.add(name);

       family = new myJLabel("نام خانوادگی");
       family =family.set(400, 300, 250, 20, "B Nazanin", 20);
        window.add(family);

        idCode = new myJLabel("کد ملی ");
        idCode = idCode.set(400, 350, 250, 20, "B Nazanin", 20);
        window.add(idCode);

        type = new myJComboBox();
        type.set(150, 400, 150, 20, "B Nazanin", 20);
        type.addItem("پزشک");
        type.addItem("بیمار");
        type.addItem("داروخانه");
        window.add(type);



//        dtext = new myJTextField("");
//        dtext.set(150, 200, 150, 20, "B Nazanin", 20);
//        window.add(dtext);

        htext = new myJTextField("");
        htext.set(150, 250, 150, 20, "B Nazanin", 20);
        window.add(htext);

        ntext = new myJTextField("");
        ntext.set(150, 300, 150, 20, "B Nazanin", 20);
        window.add(ntext);

        wtext = new myJTextField("");
        wtext.set(150, 350, 150, 20, "B Nazanin", 20);
        window.add(wtext);
//
//        ptext = new myJTextField("");
//        ptext.set(150, 400, 150, 20, "B Nazanin", 20);
//        window.add(ptext);

        enter = new myJButton(false);
        enter.setText("ثبت");
        enter.set(200, 500, 100, 40, "B Nazanin", 20);
        window.add(enter);

        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("monaaaaaaaa");

                new Welcome();
                window.setVisible(false);
            }
        });
    }
}
