package ui.user.doctor;

import ui.element.myJFrame;
import ui.element.myJTable;
import ui.user.Temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by Mona on 4/14/2015.
 */
class ListPatient extends Temp{


        private myJFrame window;
       ListPatient() {
            window = getWindow("لیست بیماران", true);

           Object rowData[][] = {{"تست", "تست"}};
           Object columnNames[] = {"", ""};
           myJTable table = new myJTable(rowData, columnNames);

           JScrollPane scrollPane = new JScrollPane(table);
           window.add(scrollPane, BorderLayout.CENTER);

           table.set(100, 200, 400, 300, "B Nazanin", 14);
           window.add(table);
//
//           search.addActionListener(new ActionListener() {
//               public void actionPerformed(ActionEvent e) {
//                   // new showResult();
//                   window.setVisible(true);
//                   //winMain.setVisible(false);
//               }
//           });
       }
}
