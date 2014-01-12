package com.perrin.tony.dao.impl;

import com.mongodb.*;
import com.perrin.tony.dao.GroupEntity;
import com.perrin.tony.dao.UserEntity;
import com.perrin.tony.model.Group;
import com.perrin.tony.model.Location;
import com.perrin.tony.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonyperrin on 04/01/2014.
 */
public class GroupDaoImpl {
    private DBCollection dbCollection;

    public GroupDaoImpl(DBCollection collection) {
        try {
            this.dbCollection = collection;
        } catch (Exception e) {
            throw new RuntimeException("Cannot connect to MongoDatabase.");
        }
    }

    public List<User> findGroupById(String id) {
        List<User> list = new ArrayList<User>();
        BasicDBObject findObject = new BasicDBObject();
        findObject.put("groupID", id);
        DBCursor cursor = dbCollection.find(findObject);

        while(cursor.hasNext()) {
            DBObject user = cursor.next();
            list.add(new User((String) user.get("_id"), (String)  user.get("groupID"), new Location((Double) user.get("longitude"), (Double) user.get("latitude"))));
        }
        return list;
    }
}
