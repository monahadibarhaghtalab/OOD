package ui.user.doctor;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJTextField;
import ui.element.myJLabel;
import ui.user.Temp;
import ui.user.patient.FirstPagePatient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 3/15/2015.
 */
class LookforPateint  extends Temp {

    private myJFrame window1, window2;
    private myJLabel name, family, docNum;
    private myJTextField ntext, ftext, dtext;
    private myJButton search;


    protected LookforPateint() {
        super();

        window1 = getWindow("جستجوی بیمار", true);

        name = new myJLabel("نام");
        name = name.set(400, 200, 250, 20, "B Nazanin", 20);
        window1.add(name);

        family = new myJLabel("نام خانوادگی");
        family = family.set(400, 250, 250, 20, "B Nazanin", 20);
        window1.add(family);

        docNum = new myJLabel("شماره پرونده");
        family = family.set(400, 300, 250, 20, "B Nazanin", 20);
        window1.add(docNum);

        ntext = new myJTextField("");
        ntext.set(150, 200, 150, 20, "B Nazanin", 20);
        window1.add(ntext);

        ftext = new myJTextField("");
        ftext.setBounds(150, 250, 150, 20);
        window1.add(ftext);

        dtext = new myJTextField("");
        dtext.setBounds(150, 300, 150, 20);
        window1.add(dtext);

        search = new myJButton(false);
        search.setText("جستجو");
        search.set(200, 400, 100, 40, "B Nazanin", 30);
        window1.add(search);

        window2 = getWindow("لیست بیماران", false);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window2.setVisible(true);
                window1.setVisible(false);
            }
        });
    }
}
