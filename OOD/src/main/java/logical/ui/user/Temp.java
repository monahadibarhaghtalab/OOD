package ui.user;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 3/15/2015.
 */
public class Temp extends TempFirst{

    private myJButton profile;


    private myJFrame window;
    private myJLabel titleLabel;



   public myJFrame getWindow(String title, boolean vis){

        window = new myJFrame("سامانه سلامت");
        window = window.makeWindow(window);
        window.setDefaultCloseOperation(myJFrame.DISPOSE_ON_CLOSE);
        //  window.pack();
        titleLabel = new myJLabel(title);
        titleLabel = titleLabel.set(300, 50, 600, 50, "B Nazanin", 30);



        window.add(titleLabel);

        profile = new myJButton(false);
        profile.setText("حساب کاربری");
        profile.set(90, 50, 200, 40, "B Nazanin", 16);

        profile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("monaaaaaaaa");
                new Profile();
              //  window.setVisible(false);
            }
        });


        window.add(profile);

        //set if visible or not at first
        if(vis){
            window.setVisible(true);
        }
        else
            window.setVisible(false);
        return  window;
    }



}
