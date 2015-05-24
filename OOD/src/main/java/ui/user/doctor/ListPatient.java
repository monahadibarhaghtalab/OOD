package ui.user.doctor;

import logical.user.patient.Patient;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJTable;
import ui.user.Temp;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Mona on 4/14/2015.
 */
public class ListPatient extends Temp{
        private ArrayList<Patient> mypatients;

        private myJFrame window;
       public ListPatient(ArrayList<Patient> patients) {
           mypatients = patients;
            window = getWindow("لیست بیماران", true);

           myJButton rowData[][] = new myJButton[patients.size()][2];
           Object columnNames[] = {"نام", "نام خانوادگی"};

           for (int i = 0; i < patients.size(); i++){
               rowData[i][0] = new myJButton(false);
               rowData[i][1] = new myJButton(false);
               rowData[i][0].setText(mypatients.get(i).getName());
               rowData[i][1].setText(mypatients.get(i).getFamilyName());
           }
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
