package ui.user;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Mona on 4/24/2015.
 */
class ChangeInfo extends TempFirst{

    private  myJButton submit;
    private myJTextField ttext;
    private myJTextField utext;
    private myJLabel typeDoctor;
    private myJFrame window;
    private myJLabel type;

    ChangeInfo(){
        window = getWindow("تغییر اطلاعات شخصی", true);
     //   submit = new myJButton(false);

        type = new myJLabel("نوع کاربر");
        type = type.set(400, 200, 250, 20, "B Nazanin", 20);
        window.add(type);

        typeDoctor = new myJLabel("نوع تخصص");
        typeDoctor = typeDoctor.set(400, 250, 250, 20, "B Nazanin", 20);
        window.add(typeDoctor);


        utext = new myJTextField("پزشک");
        utext.set(150, 200, 150, 20, "B Nazanin", 20);
        window.add(utext);

        ttext = new myJTextField("عمومی");
        ttext.set(150, 200, 150, 20, "B Nazanin", 20);
        window.add(ttext);

        submit = new myJButton(false);
        submit.setText("ثبت");
        submit.set(100, 400, 100, 40, "B Nazanin", 20);
        window.add(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // System.out.println("monaaaaaaaa");
                new ChangeProfile();
                window.setVisible(false);
            }
        });
    }
}
