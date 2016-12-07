package com.mgmtp.controller;
import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static
        org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by Tan Dat on 07/12/2016.
 */
public class HomeControllerTest {
    @Test
    public void testHome() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("index"));
    }

}