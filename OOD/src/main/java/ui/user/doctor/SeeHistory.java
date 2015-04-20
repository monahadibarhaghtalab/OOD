package ui.user.doctor;

import ui.element.*;
import ui.user.Temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 4/20/2015.
 */
class SeeHistory  extends Temp{
    private myJFrame winMain, window2;
    private myJLabel from, until;
    private myJTextField ntext, ftext, itext;
    private myJButton search;


    private myJFrame win;
    SeeHistory(){
        win = getWindow("مشاهده سوابق بیمار", true);





            from = new myJLabel("از تاریخ");
            from = from.set(400, 200, 250, 20, "B Nazanin", 20);
            winMain.add(from);

            until = new myJLabel("تا تاریخ");
            until = until.set(400, 250, 250, 20, "B Nazanin", 20);
            winMain.add(until);


            ntext = new myJTextField("");
            ntext.set(150, 200, 150, 20, "B Nazanin", 20);
            winMain.add(ntext);

            ftext = new myJTextField("");
            ftext.setBounds(150, 250, 150, 20);
            winMain.add(ftext);


            search = new myJButton(false);
            search.setText("جستجو");
            search.set(200, 400, 100, 40, "B Nazanin", 20);
            winMain.add(search);

        /*
        make the second window to show the result
         */
            window2 = getWindow("نتایج", false);


            Object rowData[][] = { { "تست", "تست"}  };
            Object columnNames[] = { "", ""};
            myJTable table = new myJTable(rowData, columnNames);

            JScrollPane scrollPane = new JScrollPane(table);
            window2.add(scrollPane, BorderLayout.CENTER);

            table.set(100, 200, 400, 300, "B Nazanin", 14);
            window2.add(table);

            search.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // new showResult();
                    window2.setVisible(true);
                    winMain.setVisible(false);
                }
            });
        }
    }

