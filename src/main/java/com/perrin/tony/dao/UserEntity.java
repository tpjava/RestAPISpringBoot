package com.perrin.tony.dao;

import com.perrin.tony.model.User;

/**
 * Created by tonyperrin on 04/01/2014.
 */

public class UserEntity {

    private String account;
    private String groupID;
    private double longitude;
    private double latitude;

    public UserEntity(User user) {
        this.account = user.getAccount();
        this.groupID = user.getGroupID();
        this.longitude = user.getLocation().getLongitude();
        this.latitude = user.getLocation().getLatitude();
    }

    public String getAccount() {
        return account;
    }

    public String getGroupID() {
        return groupID;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
