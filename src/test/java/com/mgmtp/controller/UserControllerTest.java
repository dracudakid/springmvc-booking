package com.mgmtp.controller;

import com.mgmtp.repository.UserRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by Tan Dat on 08/12/2016.
 */
public class UserControllerTest{
    @Test
    public void testUsers() throws Exception {
        UserRepository mockRepository = mock(UserRepository.class);
        UserController controller = new UserController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/users.jsp")).build();
        mockMvc.perform(get("/users")).andExpect(view().name("users"));
    }
}