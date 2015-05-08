package data.dao;

import logical.user.admin;
import logical.user.message;

import java.util.ArrayList;

/**
 * Created by a on 5/1/15.
 */
public interface AdminDao {
    public ArrayList<message> readInbox();
    public admin getAdmin();
}
