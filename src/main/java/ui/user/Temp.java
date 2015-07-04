package ui.user;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.user.general.Welcome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 3/15/2015.
 */
public class Temp extends TempFirst{

    public myJButton profile;


    private myJFrame window;
    private myJLabel titleLabel;
    public  myJButton profile1 = new myJButton(false);



   public myJFrame getWindow(String title, boolean vis){

        window = new myJFrame("سامانه سلامت");
        window = window.makeWindow(window);
        window.setDefaultCloseOperation(myJFrame.DISPOSE_ON_CLOSE);
        //  window.pack();
        titleLabel = new myJLabel(title);
        titleLabel = titleLabel.set(300, 50, 600, 50, "B Nazanin", 30);



        window.add(titleLabel);

        profile = new myJButton(false);
        profile.setText("خروج ");
        profile.set(90, 50, 100, 40, "B Nazanin", 16);
      // profile1 = new myJButton(false);
       profile1.setText("بازگشت ");
       profile1.set(90, 90, 100, 40, "B Nazanin", 16);

       profile.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               //window1.setVisible(false);
               java.awt.Window win[] = java.awt.Window.getWindows();
               for (int i = 0; i < win.length; i++) {
                   win[i].dispose();
               }

               new Welcome();

               //  window.setVisible(false);
           }
       });


        window.add(profile);
       window.add(profile1);



       //set if visible or not at first
        if(vis){
            window.setVisible(true);
        }
        else
            window.setVisible(false);
        return  window;
    }



}
