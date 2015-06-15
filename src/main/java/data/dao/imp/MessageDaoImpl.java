package data.dao.imp;

import data.context.DatabaseContext;
import data.dao.MessageDao;
import data.entities.entityfile.MessageEntity;
import data.entities.entityfile.UserEntity;
import logical.user.*;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * Created by a on 5/8/15.
 */
public class MessageDaoImpl extends DaoImp implements MessageDao {
    Session se3, se1,se2;
    Transaction tx1, tx2, tx3;


    @Override
    public void sendMessage(Message message) {
        //save message in to receiver's db
        se1 = new DatabaseContext().getSession();
        tx1 = se1.beginTransaction();

        se2 = new DatabaseContext().getSession();
        tx2 = se2.beginTransaction();

        UserEntity rec = new UserEntity(message.getReceiver());
        se1.saveOrUpdate(rec);
        tx1.commit();

        UserEntity sender = new UserEntity(message.getSender());
        se2.saveOrUpdate(sender);
        tx2.commit();

        MessageEntity messageEntity = new MessageEntity(sender, rec,  message);
        System.out.println("in send Message ! ");

        se3 = new DatabaseContext().getSession();
        tx3 = se3.beginTransaction();

        se3.save(messageEntity);
        System.out.println("in send Message ! : sender_id : "+messageEntity.getSender().getId());
        tx3.commit();
        System.out.println("after save message ! ");

    }
}
