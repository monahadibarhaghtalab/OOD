package ui.user.doctor;

import data.dao.imp.DoctorDaoImpl;
import logical.user.Message;
import logical.user.doctor.Doctor;
import logical.user.patient.Patient;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.element.myJTextField;
import ui.user.Temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import ui.user.*;
/**
 * Created by Mona on 3/30/2015.
 */
public class SeeConsult extends Temp {

    private myJFrame winMain;

    private myJLabel name;
    private myJLabel family;
    private int numMessage;
    private myJTextField ntext;
    private myJTextField htext;
    private myJButton[] arrayLabel;
    private myJFrame[] arrayWin;
    private int staticHeight = 30;
    private ArrayList<Message> myConsults;

    public SeeConsult(ArrayList<Message> Consults){
        super();

        myConsults = Consults;
        numMessage = myConsults.size();
        winMain = getWindow("مشاوره ها", true);

        arrayLabel = new myJButton[numMessage];
        arrayWin = new myJFrame[numMessage];

        for (int i = 0; i < numMessage; i++){
            arrayWin[i] = getWindow("پیام", false);

            arrayLabel[i] = new myJButton(true);
            arrayLabel[i] = arrayLabel[i].set(300, 100 + i * staticHeight, 200, staticHeight, "B Nazanin", 16);
          System.out.println(myConsults.get(i).getTitle());
            arrayLabel[i].setText(myConsults.get(i).getSender().getName()+"   "+myConsults.get(i).getTitle());
//            arrayLabel[i].setBorderPainted(false);
//            arrayLabel[i].setFocusPainted(false);
//            arrayLabel[i].setContentAreaFilled(false);
            name = new myJLabel("نام فرستنده");
            name = name.set(400, 250, 250, 20, "B Nazanin", 20);
            arrayWin[i].add(name);

            family = new myJLabel("متن پیام");
            family =family.set(400, 300, 250, 20, "B Nazanin", 20);
            arrayWin[i].add(family);



            htext = new myJTextField("");
            htext.set(150, 250, 150, 20, "B Nazanin", 20);
            htext.setText(Consults.get(i).getSender().getName() + " "+Consults.get(i).getSender().getFamilyName());
            arrayWin[i].add(htext);

            ntext = new myJTextField("");
            ntext.set(150, 300, 150, 20, "B Nazanin", 20);
            ntext.setText(Consults.get(i).getContent());
            arrayWin[i].add(ntext);

            winMain.add(arrayLabel[i]);
            System.out.println("add!");

            final int finalI = i;
            myJButton accept = new myJButton(false);
            accept.setText("پاسخ");
            accept.set(300, 400, 100, 30, "B Nazanin", 18);
            //arrayWin[i].add(accept);
//            myJButton reject = new myJButton(false);
//            reject.setText("رد درخواست");
//            reject.set(300, 450, 30, 30, "B Nazanin", 18);
            accept.addActionListener(new ActionListener() {
                                         public void actionPerformed(ActionEvent e) {
                                                new ShowMessage(myConsults.get(finalI).getReceiver(),myConsults.get(finalI).getSender(), "پاسخ مشاوره");
                                         }
                                     });
            arrayWin[i].add(accept);
                    // arrayWin[i].add(reject);


                    arrayLabel[i].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // new showResult();
                            arrayWin[finalI].setVisible(true);
                            winMain.setVisible(false);
                        }
                    });


                }


            }
        }
