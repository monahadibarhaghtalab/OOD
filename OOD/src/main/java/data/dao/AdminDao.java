package data.dao;

import logical.user.Admin;
import logical.user.Message;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public interface AdminDao {
    public ArrayList<Message> readInbox();
    public Admin getAdmin();
}
