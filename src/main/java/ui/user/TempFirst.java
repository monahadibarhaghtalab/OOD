package ui.user;

import ui.element.myJFrame;
import ui.element.myJLabel;

import java.io.Serializable;

/**
 * Created by Mona on 4/14/2015.
 */
public class TempFirst implements Serializable {

    private myJFrame window;
    private myJLabel titleLabel;



    protected myJFrame getWindow(String title, boolean vis){

        window = new myJFrame("سامانه سلامت");
        window = window.makeWindow(window);
        window.setDefaultCloseOperation(myJFrame.DISPOSE_ON_CLOSE);
        //  window.pack();
        titleLabel = new myJLabel(title);
        titleLabel = titleLabel.set(300, 50, 600, 50, "B Nazanin", 30);

        window.add(titleLabel);

        //set if visible or not at first
        if(vis){
            window.setVisible(true);
        }
        else
            window.setVisible(false);
        return  window;
    }

   /* protected void  add(JComponent com, int x, int y, int w, int h, String text){
        com.set(x, y, w, h);
        com.setText(text);
        window.add(com);
    }
    */
}
