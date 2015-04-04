package ui.user.drugstore;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.Temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 3/30/2015.
 */
public class FirstPageDrug extends Temp {

    private myJFrame window1, window2;
    private myJLabel name, family, idCode;
    private myJTextField ntext, ftext, itext;
    private myJButton search;


    public FirstPageDrug(){
        super("ورود به عنوان داروخانه");

        window1 = getWindow();

        name = new myJLabel("نام");
        name = name.set(400, 200, 250, 20, "B Nazanin", 20);
        window1.add(name);

        family = new myJLabel("نام خانوادگی");
        family = family.set(400, 250, 250, 20, "B Nazanin", 20);
        window1.add(family);

        idCode = new myJLabel("کد ملی");
        family = family.set(400, 300, 250, 20, "B Nazanin", 20);
        window1.add(idCode);

        ntext = new myJTextField("");
        ntext.set(150, 200, 150, 20, "B Nazanin", 20);
        window1.add(ntext);

        ftext = new myJTextField("");
        ftext.setBounds(150, 250, 150, 20);
        window1.add(ftext);

        itext = new myJTextField("");
        itext.setBounds(150, 300, 150, 20);
        window1.add(itext);

        search = new myJButton(false);
        search.setText("جستجو");
        search.set(200, 400, 100, 40, "B Nazanin", 30);
        window1.add(search);

        /*
        make the second window to show the result
         */



        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new showResult();
                window1.setVisible(false);
            }
        });
    }







}
