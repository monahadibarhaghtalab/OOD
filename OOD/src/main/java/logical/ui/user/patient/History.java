package ui.user.patient;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.user.Temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 3/30/2015.
 */
class History extends Temp{

    private myJFrame window;

    private myJButton seeHealth;
    private myJButton sicknessHis;
    private myJButton seeActivity;


    protected History(){
        super();

        window = getWindow("سوابق", true);

        seeHealth = new myJButton(false);
        sicknessHis = new myJButton(false);
        seeActivity = new myJButton(false);


        int start = 200;
        int height = 30;

        seeHealth.set(150, start, 300, height, "B Nazanin", 20);
        seeHealth.setText("مشاهده وضعیت جسمانی");
        window.add(seeHealth);

        seeHealth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SeeHealth();
                //  window.setVisible(false);
            }
        });

        sicknessHis.set(150, start + height, 300, height, "B Nazanin", 20);
        sicknessHis.setText("سوابق بیماری");
        window.add(sicknessHis);

        sicknessHis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SeeSickness();
                //  window.setVisible(false);
            }
        });

        seeActivity.set(150, start + 2 * height, 300, height, "B Nazanin", 20);
        seeActivity.setText("میزان فعالیت بدنی");
        window.add(seeActivity);

        seeActivity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SeeActiviy();
                //  window.setVisible(false);
            }
        });


    }

}
