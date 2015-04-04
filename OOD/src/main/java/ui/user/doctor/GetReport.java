package ui.user.doctor;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.user.Temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 3/30/2015.
 */
public class GetReport extends Temp {
    private myJFrame window;

    private myJButton  getTotal;
    private myJButton  getIndiv;

    protected GetReport(){
        super("دریافت گزارش");

        window = getWindow(true);

        getTotal = new myJButton(false);
        getTotal.setText("دریافت گزارش تجمیعی");
        getTotal = getTotal.set(200, 200, 100, 50, "B Nazanin", 30);
        window.add(getTotal);

        getTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GetReport();
                //  window.setVisible(false);
            }
        });


        getIndiv = new myJButton(false);
        getIndiv.setText("دریافت گزارش فردی");
        getIndiv = getIndiv.set(200, 200, 100, 50, "B Nazanin", 30);
        window.add(getIndiv);

        getTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GetReport();
                //  window.setVisible(false);
            }
        });

    }
}
