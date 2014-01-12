package com.perrin.tony.model;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by tonyperrin on 03/01/2014.
 */
public class LocationTest {
    @Test
    public void testLocation() {
        Location location = new Location(1.001, 1.234);
        Assert.assertEquals(location.getLongitude(), 1.001);
        Assert.assertEquals(location.getLatitude(), 1.234);
    }
}
