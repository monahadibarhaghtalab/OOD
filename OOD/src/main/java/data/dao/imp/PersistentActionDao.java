package data.dao.imp;


import data.dao.ActionDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.UUID;

/**
 * Created by root on 2/23/15.
 */
public class PersistentActionDao implements ActionDao {
    @Override
    public List<ActionEntity> allActions() {
        return new DatabaseContext()
                .getSession()
                .createCriteria(ActionEntity.class)
                .list();
    }

    @Override
    public List<ActionEntity> getActionsOfUser(UUID userId) {
        return new DatabaseContext()
                .getSession()
                .createCriteria(ActionEntity.class)
                .add(Restrictions.eq("userId", userId))
                .list();
    }

    @Override
    public void save(ActionEntity action) {
        Session session = null;
        Transaction tx = null;
        try {
            session = new DatabaseContext().getSession();
            tx = session.beginTransaction();

            session.save(action);

            tx.commit();
        } catch (Exception ex) {
            if (tx != null)
                tx.rollback();
            throw new RuntimeException(ex);
        } finally {
            if (session != null)
                session.close();
        }
    }
}
