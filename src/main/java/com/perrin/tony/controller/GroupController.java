package com.perrin.tony.controller;

import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.perrin.tony.controller.responses.BadRequestResponse;
import com.perrin.tony.controller.responses.OKResponse;
import com.perrin.tony.controller.responses.Response;
import com.perrin.tony.dao.GroupEntity;
import com.perrin.tony.dao.UserEntity;
import com.perrin.tony.dao.impl.GroupDaoImpl;
import com.perrin.tony.impl.DatabaseHolder;
import com.perrin.tony.impl.Utils;
import com.perrin.tony.model.Group;
import com.perrin.tony.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

/**
 * Created by tonyperrin on 04/01/2014.
 */
@Controller
@RequestMapping("/group")
public class GroupController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Response group() throws Exception {
        return new BadRequestResponse("You must supply a group id in the url format /group/{id} (example /group/1234.");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Object groupID(@PathVariable String id) throws Exception {
        try {
            Group group = new Group(id);
            GroupEntity groupEntity = new GroupEntity(group.getGroupId());
            DatabaseHolder databaseConfig = Utils.getDatabaseConfig();
            Mongo mongo = new Mongo(databaseConfig.getIP(), databaseConfig.getPort());
            DBCollection collection = mongo.getDB(databaseConfig.getName()).getCollection(databaseConfig.getCollection());
            GroupDaoImpl groupDaoImpl = new GroupDaoImpl(collection);
            List<User> list = groupDaoImpl.findGroupById(groupEntity.getGroupID());
            return list.size() > 0 ? list : new OKResponse("There were no users in the requested group.");
        } catch (Exception e) {
            return new BadRequestResponse("There was an error requesting the group id.");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Response create() throws Exception {
        return new BadRequestResponse("You cannot add a new group.");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public @ResponseBody Response createID() throws Exception {
        return new BadRequestResponse("You cannot add a new group.");
    }
}
