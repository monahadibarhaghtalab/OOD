package ui.user.doctor;

/**
 * Created by a on 6/23/15.
 */

import logical.user.patient.Patient;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.user.Temp;
import ui.user.patient.SeeActiviy;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import logical.user.patient.Patient;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.user.Temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 3/30/2015.
 */
class ChooseTypeOfReport extends Temp {

    private myJFrame window;

    private myJButton seeHealth;
    private myJButton sicknessHis;
    private myJButton seeActivity;
    private Patient myPatient;


    protected ChooseTypeOfReport(){
        super();
        super.profile1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);

            }
        });
      //  myPatient = p;
        window = getWindow("انتخاب نوع گزارش", true);

        seeHealth = new myJButton(false);
        sicknessHis = new myJButton(false);
        seeActivity = new myJButton(false);


        int start = 200;
        int height = 30;

        seeHealth.set(150, start, 300, height, "B Nazanin", 20);
        seeHealth.setText("گزارش برحسب نوع بیماری");
        window.add(seeHealth);

        seeHealth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GetReportDisease();
             //   new SeeHealth(myPatient);
                //  window.setVisible(false);
            }
        });

        sicknessHis.set(150, start + height, 300, height, "B Nazanin", 20);
        sicknessHis.setText("گزارش برحسب فشار/قند خون");
        window.add(sicknessHis);

        sicknessHis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GetReportpressure();

                //  new SeeSickness(myPatient);
                //  window.setVisible(false);
            }
        });

        seeActivity.set(150, start + 2 * height, 300, height, "B Nazanin", 20);
        seeActivity.setText("گزارش بر حسب فعالیت بدنی");
        window.add(seeActivity);

        seeActivity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GetReportActivity();

                // new SeeActiviy(myPatient);
                //  window.setVisible(false);
            }
        });


    }

}
