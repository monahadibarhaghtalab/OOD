package ui.user;

import logical.user.Message;
import ui.element.myJButton;
import ui.element.myJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by a on 5/8/15.
 */
class Inbox extends Temp {
    private myJFrame winMain;

   // private int numMessage = 1;
    private myJButton[] arrayLabel;
    private myJFrame[] arrayWin;
    private int staticHeight = 30;


    protected Inbox(ArrayList<Message> messages) {
        super();

        winMain = getWindow("پیام ها", true);

        arrayLabel = new myJButton[messages.size()];
        arrayWin = new myJFrame[messages.size()];

        for (int i = 0; i < messages.size(); i++) {
            arrayWin[i] = getWindow("پیام", false);


            arrayLabel[i] = new myJButton(true);
            arrayLabel[i] = arrayLabel[i].set(300, 80 + i * staticHeight, 200, staticHeight, "B Nazanin", 16);
            //should change
            arrayLabel[i].setText(messages.get(i).getContent());
//            arrayLabel[i].setBorderPainted(false);
//            arrayLabel[i].setFocusPainted(false);
//            arrayLabel[i].setContentAreaFilled(false);

            winMain.add(arrayLabel[i]);

//            myJButton accept = new myJButton(false);
//            accept.setText("قبول");
//            accept.set(300, 400, 30, 30, "B Nazanin", 18);
//
//            myJButton reject = new myJButton(false);
//            reject.setText("رد درخواست");
//            reject.set(300, 450, 30, 30, "B Nazanin", 18);
//
//            arrayWin[i].add(accept);
//            arrayWin[i].add(reject);

            final int finalI = i;
            arrayLabel[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // new showResult();
                    //show message in ui in each agree button call userdao.SignUp
                    arrayWin[finalI].setVisible(true);
                    winMain.setVisible(false);
                }
            });
        }
    }
}
