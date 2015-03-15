package ui.element;

import javax.swing.*;
import java.io.Serializable;

/**
 * Created by Mona on 3/14/2015.
 */
public class myJTextField extends JTextField implements Serializable{
    public myJTextField(String s){
        super(s);
    }
    public myJTextField set(int x, int y, int w, int l) {
        this.setBounds(x, y, w, l);
        this.setVisible(true);
        return this;
    }
}
