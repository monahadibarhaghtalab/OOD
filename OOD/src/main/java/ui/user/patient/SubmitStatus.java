package ui.user.patient;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.Temp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 3/30/2015.
 */
class SubmitStatus extends Temp {

    private myJFrame window;

    private myJLabel labelDate;

    private myJTextField dtext;

    private myJButton connect;

    protected SubmitStatus(){
        super();
        window = getWindow("ثبت وضعیت بدنی", true);



        labelDate = new myJLabel("تاریخ");
        labelDate = labelDate.set(400, 250, 250, 20, "B Nazanin", 20);
        window.add(labelDate);



        dtext = new myJTextField("");
        dtext.setBounds(150, 250, 150, 20);
        window.add(dtext);



        connect = new myJButton(false);
        connect.setText("اتصال دستگاه به رایانه");
        connect.set(200, 400, 200, 40, "B Nazanin", 20);
        window.add(connect);

        final String[] devices = { "دستگاه شماره یک", "دستگاه شماره دو", "دستگاه شماره سه", "دستگاه شماره جهار" };

        connect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                JFrame frame = new JFrame("Input Dialog Example 3");
                String device = (String) JOptionPane.showInputDialog(frame,
                        "نام دستگاه مورد نظر را انتخاب کنید",
                        "انتخاب دستگاه",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        devices,
                        devices[0]);
            }
        });



//            // favoritePizza will be null if the user clicks Cancel
//            System.out.printf("Favorite pizza is %s.\n", favoritePizza);
//            System.exit(0);


        }
    }

