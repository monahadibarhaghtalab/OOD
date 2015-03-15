package ui.element;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class myJFrame extends JFrame implements Serializable {
    public myJFrame(String s){
        super(s);
    }

    public myJFrame makeWindow(myJFrame window) {
        window.getContentPane().setPreferredSize(new Dimension(600, 700));

        window.setSize(600,700);

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setLayout(null);
        window.setDefaultCloseOperation(myJFrame.EXIT_ON_CLOSE);
        return window;




    }
}
