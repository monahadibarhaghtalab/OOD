package data.dao.imp;

import data.context.DatabaseContext;
import data.dao.MessageDao;
import data.entities.entityfile.MessageEntity;
import logical.user.*;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * Created by a on 5/8/15.
 */
public class MessageDaoImpl extends DaoImp implements MessageDao {



    @Override
    public void sendMessage(Message message) {
        //save message in to receiver's db
        MessageEntity messageEntity = new MessageEntity(message);
        session.save(messageEntity);

    }
}
