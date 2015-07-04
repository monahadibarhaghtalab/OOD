package ui.user.patient;

import logical.user.patient.Patient;
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
    private Patient myPatient;


    protected History(Patient p){
        super();
        myPatient = p;
        super.profile1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);

            }
        });
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
                new SeeHealth(myPatient);
                //  window.setVisible(false);
            }
        });

        sicknessHis.set(150, start + height, 300, height, "B Nazanin", 20);
        sicknessHis.setText("سوابق بیماری");
        window.add(sicknessHis);

        sicknessHis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SeeSickness(myPatient);
                //  window.setVisible(false);
            }
        });

        seeActivity.set(150, start + 2 * height, 300, height, "B Nazanin", 20);
        seeActivity.setText("میزان فعالیت بدنی");
        window.add(seeActivity);

        seeActivity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SeeActiviy(myPatient);
                //  window.setVisible(false);
            }
        });


    }

}
