package ui.user.doctor;

import com.sun.javafx.scene.control.skin.TableColumnHeader;
import data.dao.PatientDao;
import data.dao.ProfileDao;
import data.dao.imp.PatientDaoImpl;
import data.dao.imp.ProfileDaoImpl;
import logical.Disease;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;
import ui.element.*;
import ui.user.Temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mona on 4/20/2015.
 */
public class SeeHistory  extends Temp{
    private myJFrame winMain, window2;
    private myJLabel from, until;
    private myJTextField ntext, ftext, itext;
    private myJButton search;
    private Patient myPatient;
    private Doctor myDoctor;
    private ArrayList<Disease> histories;


    private myJFrame win;
    public SeeHistory(Patient p, Doctor d){
        myPatient = p;
        myDoctor = d;
        winMain = getWindow("مشاهده سوابق بیمار", true);





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


            search.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    PatientDao pdao = new PatientDaoImpl();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date firstDate = null;
                    try {
                        firstDate = dateFormat.parse(ntext.getText());
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
                    Date secondDate = null;
                    try {
                        secondDate = dateFormat.parse(ftext.getText());
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }


                    histories = pdao.getHistory(firstDate, secondDate, myPatient);

                    window2 = getWindow("نتایج", false);



                    String[] columnNames = {"تاریخ",
                            "علایم ","نام بیماری"
                    };
                    String[][] data = new String[histories.size()][3];/*{
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
                    if(histories.size() == 0){
                        JOptionPane.showMessageDialog(null, "سابقه ی بیماری با مشخصات داده شده یافت نشد.", "اطلاعات"
                                , JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    for (int i = 0; i < histories.size(); i++){
                        SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");

                        data[i][0] = sdfr.format(histories.get(i).getDateOfCreate());
                        data[i][2] = histories.get(i).getNameOfDisease();
                        data[i][1] = histories.get(i).getSigns();
                    }

                    System.out.println("yes");
                    myJTable table = new myJTable(data, columnNames);
                    System.out.println("hi2");
//                    window2.add(new JScrollPane(table));
//                    window2.add(table.getTableHeader(), BorderLayout.NORTH);
//                    window2.add(table, BorderLayout.CENTER);
                    table.set(100, 200, 400, 300, "B Nazanin", 14);

                   JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setBounds(100, 200, 400, 300);
                   // window2.getContentPane().add(scrollPane);
                   // window2.pack();


                   // scrollPane.setViewportView(table);
                    window2.add(scrollPane);
                 //   window2.setLayout(new BorderLayout());
                   // window2.add(scrollPane, BorderLayout.CENTER);
                 //   window2.add(new JScrollPane(table), BorderLayout.CENTER);
                   // window2.add(new JScrollPane(table));

                   // window2.add(table);


                    // new showResult();
                    window2.setVisible(true);
                    winMain.setVisible(false);
                }
            });
        }
    }

