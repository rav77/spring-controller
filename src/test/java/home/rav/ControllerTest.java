package home.rav;

import home.rav.controller.UserController;
import home.rav.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    private final Logger logger = LoggerFactory.getLogger(ControllerTest.class);

    @Autowired
    private UserController userController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(userController);
        logger.info("Context loads");
    }

    @Test
    void getUsers() throws Exception {

        mockMvc.perform(post("/users/add").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Tom\", \"age\": 27}")).andExpect(status().is2xxSuccessful());
        mockMvc.perform(post("/users/add").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Bob\", \"age\": 28}")).andExpect(status().is2xxSuccessful());

        mockMvc.perform(get("/users/get")).andDo(print()).andExpect(status().isOk());
        mockMvc.perform(get("/users/get/2")).andDo(print()).andExpect(status().isOk());
    }

}
