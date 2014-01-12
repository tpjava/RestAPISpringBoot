package com.perrin.tony.dao.impl;

import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.perrin.tony.dao.UserEntity;
import com.perrin.tony.exceptions.UserCreateException;
import com.perrin.tony.impl.DatabaseHolder;
import com.perrin.tony.impl.Utils;
import com.perrin.tony.model.Location;
import com.perrin.tony.model.User;
import junit.framework.Assert;
import org.junit.Test;

import java.net.UnknownHostException;
import java.util.Properties;

/**
 * Created by tonyperrin on 04/01/2014.
 */

public class UserDaoImplTest {
    @Test
    public void testUserInsert() throws UserCreateException, UnknownHostException {
        User user = new User("account001", "1234", new Location(1.001,1.235678));
        UserEntity userEntity = new UserEntity(user);
        DatabaseHolder databaseConfig = Utils.getDatabaseConfig();
        DBCollection collection = new Mongo(databaseConfig.getIP(), databaseConfig.getPort()).getDB(databaseConfig.getName()).getCollection(databaseConfig.getCollection());
        UserDaoImpl userDaoImpl = new UserDaoImpl(collection);
        Assert.assertTrue(userDaoImpl.insert(userEntity));
    }
}
