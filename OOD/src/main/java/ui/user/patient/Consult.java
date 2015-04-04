package ui.user.patient;

import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.Temp;

/**
 * Created by Mona on 3/30/2015.
 */
class Consult extends Temp {


        private myJFrame window;

        private myJLabel title;
        private myJLabel message;

        private myJTextField ttext;
        private myJTextField mtext;

        private myJButton send;




        protected Consult() {
            super();
            window = getWindow("", true);


            title = new myJLabel("موضوع");
            title = title.set(400, 200, 250, 20, "B Nazanin", 20);
            window.add(title);

            message = new myJLabel("متن پیام");
            message = message.set(400, 250, 250, 200, "B Nazanin", 20);
            window.add(message);


            ttext = new myJTextField("");
            ttext.set(150, 200, 150, 20, "B Nazanin", 20);
            window.add(ttext);

            mtext = new myJTextField("");
            mtext.setBounds(150, 250, 150, 20);
            window.add(mtext);


            send = new myJButton(false);
            send.setText("ارسال");
            send.set(200, 500, 100, 40, "B Nazanin", 20);
            window.add(send);


    }
}
