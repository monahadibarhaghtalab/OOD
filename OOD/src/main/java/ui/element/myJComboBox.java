package ui.element;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Mona on 4/13/2015.
 */
public class myJComboBox extends JComboBox {
    public myJComboBox set(int x, int y, int w, int l, String font, int size){
        this.setBounds(x, y, w, l);
        //this.setHorizontalAlignment(JTextField.RIGHT);
        this.setVisible(true);
        this.setFont(new Font(font, Font.PLAIN, size));
        ((JLabel)this.getRenderer()).setHorizontalAlignment(JLabel.RIGHT);
        this.repaint();
        return this;
    }
}
