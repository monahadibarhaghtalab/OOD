package ui.user.drugstore;

import ui.element.*;
import ui.user.Temp;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
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
        super();

        window1 = getWindow("ورود به عنوان داروخانه", true);

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

        window2 = getWindow("لیست داروها", false);

        //to make table with radio button

        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(new Object[][] { { "", new JRadioButton("") }},
                new Object[] {
                "نام دارو", "گرفته شده" });

        myJTable table = new myJTable(dm){
            public void tableChanged(TableModelEvent e) {
                super.tableChanged(e);
                repaint();
            }
        };

        ButtonGroup group1 = new ButtonGroup();
        group1.add((JRadioButton) dm.getValueAt(0, 1));
       ///should extend the row
        table.getColumn("JRadioButton").setCellRenderer(
                new RadioButtonRenderer());
        table.getColumn("JRadioButton").setCellEditor(
                new RadioButtonEditor(new JCheckBox()));
        JScrollPane scroll = new JScrollPane(table);
        window2.getContentPane().add(scroll);


        myJButton submit = new myJButton(false);
        submit.setText("ثبت");
        submit.set(300, 600, 50, 30, "B Nazanin", 20);

        window2.add(submit);


        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // new showResult();
                window2.setVisible(true);
                window1.setVisible(false);
            }
        });
    }







}
