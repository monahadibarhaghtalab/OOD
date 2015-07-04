package ui.user.doctor;

import logical.user.patient.Patient;
import ui.element.*;
import ui.user.Temp;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by Mona on 4/14/2015.
 */
public class ListPatient extends Temp{
        private ArrayList<Patient> mypatients;


    private myJLabel name, family, docNum;
    private myJTextField ntext, ftext, dtext;
    private myJButton search;


        private myJFrame window;
   // window.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
       public ListPatient(ArrayList<Patient> patients) {
           super();
           super.profile1.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   window.setVisible(false);

               }
           });
           mypatients = patients;
            window = getWindow("لیست بیماران", true);

           myJLabel rowData[][] = new myJLabel[mypatients.size()][2];
         //  Object columnNames[] = {"نام", "نام خانوادگی"};

         /*  for (int i = 0; i < patients.size(); i++){
               myJTextField t0 = new myJTextField("");
               myJTextField t1 = new myJTextField("");
              // t0.setText(mypatients.get(i).getName());
              // t0.setText("raha");
              // t1.setText(mypatients.get(i).getFamilyName());
               rowData[i][0] = new myJLabel("raha");
               rowData[i][0] = new myJLabel("mor");
               System.out.println("hello");
               System.out.println(mypatients.get(i).getName());
              // rowData[i][1] = t1;
           }*/
           String[] columnNames = {"نام خانوادگی",
                   "نام",
                   };
           String[][] data = new String[mypatients.size()][2];/*{
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

           for (int i = 0; i < mypatients.size(); i++){

                data[i][1] = mypatients.get(i).getName();
               data[i][0] = mypatients.get(i).getFamilyName();
           }

          // System.out.println("hi");
           myJTable table = new myJTable(data, columnNames);
         //  System.out.println("hi2");
           //JScrollPane scrollPane = new JScrollPane(table);
           //window.add(scrollPane, BorderLayout.CENTER);

           table.set(100, 200, 400, 300, "B Nazanin", 14);
           JScrollPane scrollPane = new JScrollPane(table);
           scrollPane.setBounds(100, 200, 400, 300);
           // window2.getContentPane().add(scrollPane);
           // window2.pack();


           // scrollPane.setViewportView(table);
           window.add(scrollPane);
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
