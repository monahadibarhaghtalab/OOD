package ui.element;

import javax.swing.*;
import java.io.Serializable;

/**
 * Created by Mona on 3/14/2015.
 */
public class myJButton extends JButton implements Serializable {

    public myJButton set(int x, int y, int w, int l) {
        this.setBounds(x, y, w, l);
        this.setVisible(true);
        return this;
    }
}
