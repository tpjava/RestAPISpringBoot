package com.perrin.tony.controller;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mortbay.jetty.webapp.WebAppContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * Created by tonyperrin on 02/01/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppContext.class})
@WebAppConfiguration
public class UserControllerTest extends TestCase {
    @Mock
    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    @Test
    public void testUserController() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testAddUser() throws Exception {
        mockMvc.perform(post("/user").param("account", "hello_world").param("groupID", "1234").param("longitude", "1.001").param("latitude", "1.234"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testAddUserNoAccount() throws Exception {
        mockMvc.perform(post("/user").param("account", "").param("groupID", "1234").param("longitude","1.001").param("latitude","1.234"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("400")))
                .andDo(print());
    }
}
