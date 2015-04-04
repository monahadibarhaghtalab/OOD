package ui.user.doctor;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.user.Temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 3/30/2015.
 */
class SeeConsult extends Temp {

    private myJFrame winMain;

    private int numMessage = 1;
    private myJButton[] arrayLabel;
    private myJFrame[] arrayWin;
    private int staticHeight = 30;

    protected SeeConsult(){
        super();

        winMain = getWindow("مشاوره ها", true);

        arrayLabel = new myJButton[numMessage];
        arrayWin = new myJFrame[numMessage];

        for (int i = 0; i < numMessage; i++){
            arrayWin[i] = getWindow("پیام", false);


            arrayLabel[i] = new myJButton(true);
            arrayLabel[i] = arrayLabel[i].set(500, 60 + i * staticHeight,400, staticHeight, "B Nazanin", 16);

//            arrayLabel[i].setBorderPainted(false);
//            arrayLabel[i].setFocusPainted(false);
//            arrayLabel[i].setContentAreaFilled(false);

            winMain.add(arrayLabel[i]);

            myJButton accept = new myJButton(false);
            accept.setText("پاسخ");
            accept.set(300, 400, 30, 30, "B Nazanin", 18);

//            myJButton reject = new myJButton(false);
//            reject.setText("رد درخواست");
//            reject.set(300, 450, 30, 30, "B Nazanin", 18);

            arrayWin[i].add(accept);
           // arrayWin[i].add(reject);

            final int finalI = i;
            arrayLabel[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // new showResult();
                    arrayWin[finalI].setVisible(true);
                    winMain.setVisible(false);
                }
            });


        }



    }
}
