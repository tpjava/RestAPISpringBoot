package com.perrin.tony.model;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by tonyperrin on 04/01/2014.
 */
public class GroupBindingTest {
    @Test
    public void testGroupInit() {
        Group group = new Group("123");
        Assert.assertEquals(group.getGroupId(), "123");
    }
}
