package wpd2.cw.grouph.milestoneplanner;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthorizationTest {

    @Autowired
    private MockMvc mvc;

    private String base = "http://localhost/";


    @Test
    public void getIndex() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /* Tests to ensure that, by default, access to the admin page is prevented, and redirects to login */
    @Test
    public void preventAccessToAdmin() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/admin"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl(this.base + "login"));
    }

    @Test
    public void preventAccessToMilestones() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/milestones"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl(this.base + "login"));
    }

    @Test
    public void preventAccessToCreateMilestone() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/milestones/create"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl(this.base + "login"));
    }

    @Test
    public void allowAccessToLogin() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    public void allowAccessToRegister() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/register"))
                .andExpect(status().isOk());
    }

    @Test
    public void allowAccessToIndex() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk());
    }
}