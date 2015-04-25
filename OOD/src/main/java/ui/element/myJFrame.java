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
//
        window.setSize(600,700);
//
        window.setLocationRelativeTo(null);


        window.setLayout(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(myJFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
        return window;




    }
}
