package ui.user.patient;

import data.dao.PatientDao;
import data.dao.UserFuncDao;
import data.dao.imp.patientDaoImpl;
import logical.user.doctor.OrdDoctor;
import logical.user.user;
import ui.element.myJButton;
import ui.element.myJFrame;
import ui.element.myJLabel;
import ui.user.Temp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Mona on 3/30/2015.
 */
class ChooseDoctor extends Temp {

    private myJFrame winMain;

    private myJButton listDoctor;

    private myJLabel doctor;
    private UserFuncDao pationtdao;

    protected ChooseDoctor(){

        winMain = getWindow("انتخاب پزشک", true);

        listDoctor = new myJButton(false);
        listDoctor.setText("مشاهده لیست پزشکان");
        listDoctor.set(200, 300, 200, 100, "B Nazanin", 20);
        winMain.add(listDoctor);


        listDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pationtdao = new patientDaoImpl();
                ArrayList<OrdDoctor> doctor = new ArrayList<OrdDoctor>();
                ArrayList<user> temp = pationtdao.showListOfUser();
                for (int i = 0; i < temp.size();i++){
                    doctor.add((OrdDoctor)temp.get(i));
                }
                new ListDoctor( doctor);
                //  window.setVisible(false);
            }
        });

        doctor = new myJLabel();
        doctor.setText("پزشک فعلی ");
        doctor.set(300, 200, 100, 40, "B Nazanin", 20);
        winMain.add(doctor);



    }
}
