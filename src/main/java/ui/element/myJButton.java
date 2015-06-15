package ui.element;

import ui.user.Temp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

/**
 * Created by Mona on 3/14/2015.
 */
public class myJButton extends JButton implements Serializable, Element {

    public myJButton(boolean flat){
        if(flat){
            this.setBorderPainted(false);
            this.setFocusPainted(false);
            this.setContentAreaFilled(false);
        }
    }
    public myJButton set(int x, int y, int w, int l, String font, int size) {
        this.setBounds(x, y, w, l);
        this.setVisible(true);
        this.setFont(new Font(font, Font.PLAIN, size));
        this.repaint();
        return this;
    }

    /*
    public myJButton addAction(Temp next, Temp current){
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new next();
                window.setVisible(false);
            }
        });
    }
    */

}
