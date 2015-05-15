package data.dao.imp;

import data.context.DatabaseContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Mona on 5/15/2015.
 */
public class DaoImp {
    Session session;
    Transaction tx;

    public DaoImp(){
        session = new DatabaseContext().getSession();
        tx = session.beginTransaction();
    }
}
