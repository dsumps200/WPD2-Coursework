package wpd2.cw.grouph.milestoneplanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import wpd2.cw.grouph.milestoneplanner.models.User;
import wpd2.cw.grouph.milestoneplanner.services.UserService;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {
    @Autowired
    private HomeController homeController;

    @Autowired
    private UserService userService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void homeTest() throws Exception {
        assertThat(homeController).isNotNull();
        mvc.perform(get("/"))
                .andDo(print()).andExpect(content().string(containsString("Welcome to the Milestone Planner Application")));
    }

    @Test
    public void userExists() throws Exception {
        User user = new User();
        user.setUsername("lyle"); user.setPassword("pw");
        assertThat(userService.loadUserByUsername(user.getUsername()) != null);
    }
}
