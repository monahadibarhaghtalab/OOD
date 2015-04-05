package ui.user.doctor;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.user.Temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

/**
 * Created by Mona on 3/15/2015.
 */
public class FirstPageDoctor extends Temp {
    private myJFrame window;

    private myJButton historyPatient;
    private myJButton seeMessage;
    private myJButton seeConsult;
    private myJButton getReport;
    private myJButton seeList;

    public  FirstPageDoctor(){
        super();

        window = getWindow("ورود به عنوان پزشک", true);

        historyPatient = new myJButton(false);
        seeMessage = new myJButton(false);
        seeConsult = new myJButton(false);
        getReport = new myJButton(false);
        seeList = new myJButton(false);

        int start = 200;
        int height = 30;

        historyPatient.set(150, start, 300, height, "B Nazanin", 20);
        historyPatient.setText("مشاهده سوابق بیمار");
        window.add(historyPatient);

        historyPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LookforPateint();
                //  window.setVisible(false);
            }
        });

        seeMessage.set(150, start + height, 300, height, "B Nazanin", 20);
        seeMessage.setText("مشاهده درخواست ها");
        window.add(seeMessage);

        seeMessage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SeeMessage();
                //  window.setVisible(false);
            }
        });

        seeConsult.set(150, start + 2 * height, 300, height, "B Nazanin", 20);
        seeConsult.setText("مشاهده متن مشاوره");
        window.add(seeConsult);

        seeConsult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SeeConsult();
                //  window.setVisible(false);
            }
        });

        getReport.set(150, start + 3 * height, 300, height, "B Nazanin", 20);
        getReport.setText("دریافت گزارش");
        window.add(getReport);

        getReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GetReport();
                //  window.setVisible(false);
            }
        });
//
//        seeList.set(150, start + 4 * height, 300, height, "B Nazanin", 20);
//        seeList.setText("مشاهده لیست بیماران");
//        window.add(seeList);
//
//        historyPatient.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                new GetReport();
//                //  window.setVisible(false);
//            }
//        });

    }


}
