package com.perrin.tony.model;

import com.perrin.tony.exceptions.UserCreateException;
import com.perrin.tony.exceptions.UserGroupException;
import com.perrin.tony.model.Location;

/**
 * Created by tonyperrin on 02/01/2014.
 */
public class User {
    private Location location;
    private String account;
    private String groupID;

    public User(String account, String groupID, Location location) throws UserCreateException {
        this.account = account;
        this.location = location;
        this.groupID = groupID;

        if(account == null || account.equals(""))
            throw new UserCreateException("User account info not present.");

        if(groupID == null || groupID.equals(""))
            throw new UserGroupException("Group account info is not present.");
    }

    public Location getLocation() {
        return location;
    }

    public String getAccount() {
        return account;
    }

    public String getGroupID() {
        return groupID;
    }
}
