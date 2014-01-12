package com.perrin.tony.dao.impl;

import com.mongodb.*;
import com.perrin.tony.dao.UserDao;
import com.perrin.tony.dao.UserEntity;
import com.perrin.tony.model.User;
import org.apache.commons.dbcp.BasicDataSource;

/**
 * Created by tonyperrin on 04/01/2014.
 */

public class UserDaoImpl {
    private DBCollection dbCollection;

    public UserDaoImpl(DBCollection collection) {
        try {
            this.dbCollection = collection;
        } catch (Exception e) {
            throw new RuntimeException("Cannot connect to MongoDatabase.");
        }
    }

    public boolean insert(UserEntity user) {
        BasicDBObject insertObject = new BasicDBObject();
        insertObject.put("_id", user.getAccount());
        insertObject.put("groupID", user.getGroupID());
        insertObject.put("longitude", user.getLongitude());
        insertObject.put("latitude", user.getLatitude());
        return dbCollection.update(new BasicDBObject("_id", user.getAccount()), insertObject, true, false).getError() == null ? true : false;
    }
}
