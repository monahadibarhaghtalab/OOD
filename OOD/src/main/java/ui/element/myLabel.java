package ui.element;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * Created by Mona on 3/14/2015.
 */

public class myLabel extends Label implements Serializable{
   public myLabel(){
        super();
    }
    public myLabel(String s){
        super(s);
    }

    public myLabel set(int x, int y, int w, int l, String font, int size){
        this.setBounds(x, y, w, l);
        this.setVisible(true);
        this.setFont(new Font(font, Font.PLAIN, size));
        return this;
    }
}