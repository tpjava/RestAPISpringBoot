package com.perrin.tony.dao.impl;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.perrin.tony.dao.GroupEntity;
import com.perrin.tony.dao.UserEntity;
import com.perrin.tony.exceptions.UserCreateException;
import com.perrin.tony.impl.DatabaseHolder;
import com.perrin.tony.impl.Utils;
import com.perrin.tony.model.Group;
import com.perrin.tony.model.Location;
import com.perrin.tony.model.User;
import de.bwaldvogel.mongo.MongoServer;
import de.bwaldvogel.mongo.backend.memory.MemoryBackend;
import junit.framework.Assert;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Properties;

/**
 * Created by tonyperrin on 04/01/2014.
 */
public class GroupDaoImplTest {
    @Test
    public void testGroup() throws UserCreateException {
        MongoServer server = new MongoServer(new MemoryBackend());  //mock mongo instance.
        InetSocketAddress serverAddress = server.bind();
        DatabaseHolder databaseConfig = Utils.getDatabaseConfig();
        MongoClient client = new MongoClient(new ServerAddress(serverAddress));
        DBCollection collection = client.getDB(databaseConfig.getName()).getCollection(databaseConfig.getCollection());
        UserDaoImpl userDaoImpl = new UserDaoImpl(collection);
        User userOne = new User("account1", "group1", new Location(1.001, 1.234));
        User userTwo = new User("account2", "group1", new Location(1.234, 2.345));
        UserEntity userEntityOne = new UserEntity(userOne);
        UserEntity userEntityTwo = new UserEntity(userTwo);
        userDaoImpl.insert(userEntityOne);
        userDaoImpl.insert(userEntityTwo);
        GroupDaoImpl groupDaoImpl = new GroupDaoImpl(collection);
        Group group = new Group("group1");
        GroupEntity groupEntity = new GroupEntity(group.getGroupId());
        List<User> list =  groupDaoImpl.findGroupById(groupEntity.getGroupID());
        Assert.assertTrue(list.size() == 2);
        Assert.assertEquals(list.get(0).getGroupID(), "group1");
        Assert.assertEquals(list.get(1).getGroupID(), "group1");
    }
}
