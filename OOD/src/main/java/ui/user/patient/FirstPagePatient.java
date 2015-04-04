package ui.user.patient;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.user.Temp;
import ui.user.doctor.LookforPateint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 3/30/2015.
 */
public class FirstPagePatient extends Temp {
    private myJFrame window;

    private myJButton history;
    private myJButton seeMessage;
    private myJButton seeConsult;
    private myJButton getReport;
    private myJButton seeList;

    public FirstPagePatient(){
        super("ورود به عنوان بیمار");

        window = getWindow();

        history = new myJButton(false);
        seeMessage = new myJButton(false);
        seeConsult = new myJButton(false);
        getReport = new myJButton(false);
        seeList = new myJButton(false);

        int start = 200;
        int height = 30;

        history.set(150, start, 300, height, "B Nazanin", 20);
        history.setText( "مشاهده سوابق");
        window.add(history);

        history.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new History();
                //  window.setVisible(false);
            }
        });

        seeMessage.set(150, start + height, 300, height, "B Nazanin", 20);
        seeMessage.setText("مشاهده پیام ها");
        window.add(seeMessage);

        seeConsult.set(150, start + 2 * height, 300, height, "B Nazanin", 20);
        seeConsult.setText("مشاهده متن مشاوره");
        window.add(seeConsult);

        getReport.set(150, start + 3 * height, 300, height, "B Nazanin", 20);
        getReport.setText("دریافت گزارش");
        window.add(getReport);

        seeList.set(150, start + 4 * height, 300, height, "B Nazanin", 20);
        seeList.setText("مشاهده لیست بیماران");
        window.add(seeList);

    }
}
