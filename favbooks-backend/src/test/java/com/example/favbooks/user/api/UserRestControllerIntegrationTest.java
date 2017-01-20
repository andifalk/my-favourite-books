package com.example.favbooks.user.api;

import com.example.favbooks.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by afa on 1/20/17.
 */
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
@AutoConfigureRestDocs(outputDir = "build/generated-snippets/users")
@WebMvcTest(controllers = UserRestController.class)
@WithMockUser
@RunWith(SpringRunner.class)
public class UserRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void verifyFindAllUsers() throws Exception {
        this.mockMvc
                .perform(get("/users"))
                .andExpect(status().isOk())
                .andDo(document("findAllUsers"));
    }

}