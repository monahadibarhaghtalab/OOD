package ui.element;

import javax.swing.*;
import java.io.Serializable;

/**
 * Created by Mona on 3/14/2015.
 */
public class myJTextField extends JTextField implements Serializable, Element{
    public myJTextField(String s){
        super(s);
    }
    public myJTextField set(int x, int y, int w, int l, String font, int size) {
        this.setHorizontalAlignment(JTextField.RIGHT);
        this.setBounds(x, y, w, l);
        this.setVisible(true);
        this.repaint();
        return this;
    }
}
