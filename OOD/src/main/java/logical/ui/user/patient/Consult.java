package ui.user.patient;

import ui.element.*;
import ui.user.Temp;

/**
 * Created by Mona on 3/30/2015.
 */
class Consult extends Temp {


    private myJComboBox detail;
    private myJLabel nameDr;
    private myJFrame window;

        private myJLabel title;
        private myJLabel message;

        private myJTextField ttext;
        private myJTextField mtext;

        private myJButton send;




        protected Consult() {
            super();
            window = getWindow("مشاوره", true);


            title = new myJLabel("موضوع");
            title = title.set(400, 200, 250, 20, "B Nazanin", 20);
            window.add(title);

            message = new myJLabel("متن پیام");
            message = message.set(400, 250, 250, 20, "B Nazanin", 20);
            window.add(message);


            ttext = new myJTextField("");
            ttext.set(150, 200, 150, 20, "B Nazanin", 20);
            window.add(ttext);

            mtext = new myJTextField("");
            mtext.setBounds(150, 230, 150, 200);
            window.add(mtext);

            nameDr = new myJLabel("نام پزشک");
            nameDr = message.set(400, 400, 250, 20, "B Nazanin", 20);
            window.add(nameDr);


            detail = new myJComboBox();
            detail.set(150, 400, 150, 20, "B Nazanin", 20);
            detail.addItem("دکتر مینایی - عمومی");
            detail.addItem("دکتر حقی-متخصص قلب");
            detail.addItem("دکتر سلامتی - متخصص تغذیه");


            send = new myJButton(false);
            send.setText("ارسال");
            send.set(200, 500, 100, 40, "B Nazanin", 20);
            window.add(send);


    }
}
