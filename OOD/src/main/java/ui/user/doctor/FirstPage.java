package ui.user.doctor;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.user.Temp;

import java.io.Serializable;

/**
 * Created by Mona on 3/15/2015.
 */
public class FirstPage extends Temp {
    private myJFrame window;

    private myJButton historyPatient;
    private myJButton seeMessage;
    private myJButton seeConsult;
    private myJButton getReport;
    private myJButton seeList;

    public FirstPage(){
        super();

        window = getWindow();

        historyPatient = new myJButton();
        seeMessage = new myJButton();
        seeConsult = new myJButton();
        getReport = new myJButton();
        seeList = new myJButton();

        historyPatient.set(200, 200, 100, 30);
        historyPatient.setText("مشاهده سوابق بیمار");
        window.add(historyPatient);

    }


}
