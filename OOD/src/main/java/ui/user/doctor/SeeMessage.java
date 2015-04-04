package ui.user.doctor;

import ui.element.myJButton;
import ui.element.myJLabel;
import ui.user.Temp;

/**
 * Created by Mona on 3/30/2015.
 */
public class SeeMessage extends Temp {

    private int numMessage = 1;
    private myJButton[] arrayLabel;
    private int staticHeight;

    protected SeeMessage(){
        super("پیام ها");

        arrayLabel = new myJButton[numMessage];

        for (int i = 0; i < numMessage; i++){
            arrayLabel[i] = new myJButton(true);
            // arrayLabel[i] = arrayLabel[i].set()
        }




    }
}
