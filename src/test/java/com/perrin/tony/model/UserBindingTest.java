package com.perrin.tony.model;

import com.perrin.tony.exceptions.UserCreateException;
import com.perrin.tony.exceptions.UserGroupException;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by tonyperrin on 03/01/2014.
 */
public class UserBindingTest {
    @Test
    public void testUserAccount() throws UserCreateException {
        User user = new User("1234", "1234", new Location(1.001, 1.234));
        Assert.assertEquals(user.getAccount(), "1234");
    }

    @Test
    public void testUserGroupAccount() throws UserGroupException {
        User user = new User("1234", "1234", new Location(1.001, 1.234));
        Assert.assertEquals(user.getGroupID(), "1234");
    }

    @Test
    public void testUserLongLat() throws UserCreateException {
        User user = new User("tony perrin", "1234", new Location(1.001, 1.234));
        Assert.assertEquals(user.getLocation().getLongitude(), 1.001);
        Assert.assertEquals(user.getLocation().getLatitude(), 1.234);
    }
}
