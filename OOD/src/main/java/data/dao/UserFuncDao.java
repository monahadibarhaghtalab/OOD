package data.dao;

import logical.user.Message;

import java.util.ArrayList;

/**
 * Created by a on 5/8/15.
 */
public interface UserFuncDao extends UserDao{
    public ArrayList<Message> readInbox();
}
