package ui.user.patient;

import logical.user.doctor.OrdDoctor;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJTable;
import ui.user.Temp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class ShowListOfDoctor extends Temp {
    private ArrayList<OrdDoctor> mydoctors;

    private myJFrame window;
    ShowListOfDoctor(ArrayList<OrdDoctor> doctors) {
        mydoctors = doctors;
        window = getWindow("لیست بیماران", true);

        myJButton rowData[][] = new myJButton[doctors.size()][2];
        Object columnNames[] = {"نام", "نام خانوادگی"};

        for (int i = 0; i < doctors.size(); i++){

            rowData[i][0].setText(doctors.get(i).getName());
            rowData[i][1].setText(doctors.get(i).getFamilyName());
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
