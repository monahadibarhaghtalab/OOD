package ui.user.doctor;

import ui.element.*;
import ui.user.Temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 3/30/2015.
 */
class TotalReport extends Temp {

    private myJFrame window2;
    private myJFrame winMain;
    private myJLabel typeSickness;
    private myJLabel midHeight;
    private myJLabel midWeight;

    private myJTextField ttext;
    private myJTextField htext;
    private myJTextField wtext;

    private myJButton report;

    protected TotalReport(){
        super();

        winMain = getWindow("گزارش تجمیعی", true);


        typeSickness = new myJLabel("نوع بیماری");
        typeSickness = typeSickness.set(400, 200, 250, 20, "B Nazanin", 20);
        winMain.add(typeSickness);

        midHeight = new myJLabel("میانگین وزن بیمار");
        midHeight = midHeight.set(400, 250, 250, 20, "B Nazanin", 20);
        winMain.add(midHeight);

        midWeight= new myJLabel("تاریخ");
        midWeight = midWeight.set(400, 300, 250, 20, "B Nazanin", 20);
        winMain.add(midWeight);

        ttext = new myJTextField("");
        ttext.set(150, 200, 150, 20, "B Nazanin", 20);
        winMain.add(ttext);

        htext = new myJTextField("");
        htext.setBounds(150, 250, 150, 20);
        winMain.add(htext);

        wtext = new myJTextField("");
        wtext.set(150, 300, 150, 20, "B Nazanin", 20);
        winMain.add(wtext);

        report = new myJButton(false);
        report.setText("گزارش");
        report.set(200, 400, 100, 40, "B Nazanin", 20);
        winMain.add(report);


        /*
        make the second window to show the result
         */
        window2 = getWindow("" +
                "گزارش تجمیعی", false);


//        Object rowData[][] = { { "نوع بیماری", "نام بیمار"}  };
//        Object columnNames[] = { "", ""};
//       myJTable table = new myJTable(rowData, columnNames);
//
//        JScrollPane scrollPane = new JScrollPane(table);
//        window2.add(scrollPane, BorderLayout.CENTER);
//
//        table.set(100, 200, 400, 300, "B Nazanin", 14);
 //       window2.add(table);

        report.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // new showResult();
                window2.setVisible(true);
                winMain.setVisible(false);
            }
        });

    }


}
