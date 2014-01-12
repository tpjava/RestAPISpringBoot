package com.perrin.tony.controller;

import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.perrin.tony.controller.responses.BadRequestResponse;
import com.perrin.tony.controller.responses.OKResponse;
import com.perrin.tony.controller.responses.Response;
import com.perrin.tony.dao.UserEntity;
import com.perrin.tony.dao.impl.UserDaoImpl;
import com.perrin.tony.impl.DatabaseHolder;
import com.perrin.tony.impl.Utils;
import com.perrin.tony.model.User;
import com.perrin.tony.model.Location;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tonyperrin on 02/01/2014.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public  @ResponseBody Response userGet(
            @RequestParam (value="name", required = false,  defaultValue="World") String name) throws Exception {
        return new BadRequestResponse("You cannot request all users.");
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Response userPost(
            @RequestParam (value="account", required = true) String account ,
            @RequestParam (value="groupID", required = true) String groupID ,
            @RequestParam (value="longitude", required = true) double longitude,
            @RequestParam (value="latitude", required = true) double latitude) {
        try {
            User user = new User(account, groupID, new Location(longitude, latitude));
            UserEntity userEntity = new UserEntity(user);
            DatabaseHolder databaseConfig = Utils.getDatabaseConfig();
            DBCollection collection = new Mongo(databaseConfig.getIP(), databaseConfig.getPort()).getDB(databaseConfig.getName()).getCollection(databaseConfig.getCollection());
            UserDaoImpl userDaoImpl = new UserDaoImpl(collection);
            userDaoImpl.insert(userEntity);
            return new OKResponse("Successfully added/updated user location");
        } catch (Exception e) {
            return new BadRequestResponse("There was an error adding/updating your user location");
        }
    }
}