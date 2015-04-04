package ui.element;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.Serializable;

/**
 * Created by Mona on 4/4/2015.
 */
public class myJTable extends JTable implements Serializable, Element {

    public myJTable(Object[][] rowElement, Object[] colName) {
        super(rowElement, colName);
    }

    public myJTable(DefaultTableModel dm) {
        super(dm);
    }


    @Override
    public JTable set(int x, int y, int w, int l, String font, int size) {


        this.setBounds(x, y, w, l);
        this.setVisible(true);
        this.setFont(new Font(font, Font.PLAIN, size));


         return this;
    }
}
