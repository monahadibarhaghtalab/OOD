package ui.user.patient;

import logical.user.doctor.OrdDoctor;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
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
        window = getWindow("لیست پزشک", true);

        String[] columnNames = {"نام خانوادگی",
                "نام",
        };
        String[][] data = new String[mydoctors.size()][2];/*{
                   {"Kathy", "Smith",
                           "Snowboarding", new Integer(5), new Boolean(false)},
                   {"John", "Doe",
                           "Rowing", new Integer(3), new Boolean(true)},
                   {"Sue", "Black",
                           "Knitting", new Integer(2), new Boolean(false)},
                   {"Jane", "White",
                           "Speed reading", new Integer(20), new Boolean(true)},
                   {"Joe", "Brown",
                           "Pool", new Integer(10), new Boolean(false)}
           };*/
        if(mydoctors.size() == 0){
            myJLabel nofound;
            nofound = new myJLabel("پزشک با مشخصات داده شده یافت نشد!");
            nofound = nofound.set(300, 100, 200, 20, "B Nazanin", 20);
            window.add(nofound);
        }
        for (int i = 0; i < mydoctors.size(); i++){

            data[i][1] = mydoctors.get(i).getName();
            data[i][0] = mydoctors.get(i).getFamilyName();
        }

        System.out.println("hi");
        myJTable table = new myJTable(data, columnNames);
        System.out.println("hi2");
       // JScrollPane scrollPane = new JScrollPane(table);
       // window.add(scrollPane, BorderLayout.CENTER);
        table.set(100, 200, 400, 300, "B Nazanin", 14);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 200, 400, 300);
        // window2.getContentPane().add(scrollPane);
        // window2.pack();


        // scrollPane.setViewportView(table);
        window.add(scrollPane);
       // window.add(table);
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
