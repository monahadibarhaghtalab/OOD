package ui.element;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * Created by Mona on 3/14/2015.
 */

public class myJLabel extends JLabel implements Serializable, Element{
    public myJLabel(){
        super();
    }
    public myJLabel(String s){
        super(s);
    }

    public myJLabel set(int x, int y, int w, int l, String font, int size){
        this.setBounds(x, y, w, l);
        //this.setHorizontalAlignment(JTextField.RIGHT);
        this.setVisible(true);
        this.setFont(new Font(font, Font.PLAIN, size));
        this.repaint();
        return this;
    }
}