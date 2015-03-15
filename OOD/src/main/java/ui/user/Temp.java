package ui.user;

import ui.element.myJFrame;

import java.awt.event.ActionEvent;
import java.io.Serializable;

/**
 * Created by Mona on 3/15/2015.
 */
public class Temp implements Serializable {
    private myJFrame window;

    protected Temp(){
        window = new myJFrame("سامانه سلامت");
        window = window.makeWindow(window);
        window.setDefaultCloseOperation(myJFrame.EXIT_ON_CLOSE);
    }

    protected myJFrame getWindow(){
        return  window;
    }


}
