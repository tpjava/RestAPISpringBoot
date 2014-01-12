package com.perrin.tony.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mortbay.jetty.webapp.WebAppContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by tonyperrin on 04/01/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppContext.class})
@WebAppConfiguration
public class GroupControllerTest {

    @Mock
    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new GroupController()).build();

    @Test
    public void testGroupControllerGetAccount() throws Exception {
        mockMvc.perform(get("/group/1234"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testGroupControllerNoAccount() throws Exception {
        mockMvc.perform(get("/group/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("400")))
                .andDo(print());
    }

    @Test
    public void testAddGroup() throws Exception {
        mockMvc.perform(post("/group/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("400")))
                .andDo(print());
    }

    @Test
    public void testAddGroupAccount() throws Exception {
        mockMvc.perform(post("/group/1234"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is("400")))
                .andDo(print());
    }
}
