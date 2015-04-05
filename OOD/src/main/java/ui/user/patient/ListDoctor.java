package ui.user.patient;

import ui.element.*;
import ui.user.Temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 4/4/2015.
 */
class ListDoctor extends Temp{


    private myJFrame winMain, window2;
    private myJLabel from, until;
    private myJTextField ntext, ftext, itext;
    private myJButton search;


    protected ListDoctor(){
        super();

        winMain = getWindow("لیست پزشکان", true);

        from = new myJLabel("محل مطب");
        from = from.set(400, 200, 250, 20, "B Nazanin", 20);
        winMain.add(from);

        until = new myJLabel("نام");
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
        search.set(200, 400, 100, 40, "B Nazanin", 30);
        winMain.add(search);

        /*
        make the second window to show the result
         */

        window2 = getWindow("لیست پزشکان", false);


        Object rowData[][] = { {"Test", "Test" }  };
        Object columnNames[] = { "", ""};
        myJTable table = new myJTable(rowData, columnNames);

        JScrollPane scrollPane = new JScrollPane(table);
        window2.add(scrollPane, BorderLayout.CENTER);

        search = new myJButton(false);
        search.setText("فرستادن درخواست");
        search.set(200, 500, 100, 40, "B Nazanin", 20);
        window2.add(search);

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
