package data.dao.fileImp;

import data.dao.MessageDao;
import data.entities.entityObjectFile.MessageJSON;
import logical.user.Message;

import java.io.*;

/**
 * Created by Mona on 6/30/2015.
 */
public class MessageDaoImplFile implements MessageDao {
    @Override
    public void sendMessage(Message message) {
        File file = new File (System.getProperty("user.home"),"message.txt");


        MessageJSON messageJSON = new MessageJSON(file);
        System.out.println("in messageDao");
        messageJSON.saveMessage(message);



    }
}
