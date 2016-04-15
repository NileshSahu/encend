package integration;

import com.personal.spring.boot.App;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Nilesh on 4/15/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest
public class UserControllerIT {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testAddUser() throws Exception {
        this.mockMvc.perform(put("/add?id=1&name=Nilesh&city=Pune&address=Pune&department=IT").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("Nilesh"))
                .andExpect(jsonPath("$.city").value("Pune"))
                .andExpect(jsonPath("$.department").value("IT"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        this.mockMvc.perform(post("/update?id=1&name=Nilesh-1&city=Pune&address=Pune&department=IT").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("Nilesh-1"))
                .andExpect(jsonPath("$.city").value("Pune"))
                .andExpect(jsonPath("$.department").value("IT"));
    }

    @Test
    public void testUGetUsers() throws Exception {
        this.mockMvc.perform(get("/list").accept(MediaType.parseMediaType("application/json;charset=UTF-8"))).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.users[0].name").value("Nilesh-1"))
                .andExpect(jsonPath("$.users[0].city").value("Pune"))
                .andExpect(jsonPath("$.users[0].department").value("IT"));
    }

    @Test
    public void testZGetUserDetail() throws Exception {
        this.mockMvc.perform(get("/details/{Id}",1).accept(MediaType.parseMediaType("application/json;charset=UTF-8"))).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Nilesh"))
                .andExpect(jsonPath("$.city").value("Pune"))
                .andExpect(jsonPath("$.department").value("IT"));
    }
}
