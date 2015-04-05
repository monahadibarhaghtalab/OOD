package ui.user.doctor;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.user.Temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 3/30/2015.
 */
class GetReport extends Temp {
    private myJFrame window;

    private myJButton  getTotal;
    private myJButton  getIndiv;

    protected GetReport(){
        super();

        window = getWindow("دریافت گزارش", true);

        getTotal = new myJButton(false);
        getTotal.setText("دریافت گزارش تجمیعی");
        getTotal = getTotal.set(200, 200, 200, 50, "B Nazanin", 20);
        window.add(getTotal);

        getTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TotalReport();
                //  window.setVisible(false);
            }
        });


        getIndiv = new myJButton(false);
        getIndiv.setText("دریافت گزارش فردی");
        getIndiv = getIndiv.set(200, 300, 200, 50, "B Nazanin", 20);
        window.add(getIndiv);

        getTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new IndivReport();
                //  window.setVisible(false);
            }
        });

    }
}
