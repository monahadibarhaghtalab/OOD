package ui.user;

import ui.element.myJFrame;
import ui.element.myJLabel;

import java.io.Serializable;

/**
 * Created by Mona on 3/15/2015.
 */
public class Temp implements Serializable {
    private myJFrame window;
    private myJLabel titleLabel;

    protected Temp(String title){
        window = new myJFrame("سامانه سلامت");
        window = window.makeWindow(window);
        window.setDefaultCloseOperation(myJFrame.EXIT_ON_CLOSE);
        window.pack();
        titleLabel = new myJLabel(title);
        titleLabel = titleLabel.set(150, 50, 600, 50, "B Nazanin", 30);

    }

    protected myJFrame getWindow(){
//        if(vis){
//            window.setVisible(true);
//        }
//        else
//            window.setVisible(false);
        return  window;
    }

   /* protected void  add(JComponent com, int x, int y, int w, int h, String text){
        com.set(x, y, w, h);
        com.setText(text);
        window.add(com);
    }
    */


}
