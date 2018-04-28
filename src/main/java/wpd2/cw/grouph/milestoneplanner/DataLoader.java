package wpd2.cw.grouph.milestoneplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import wpd2.cw.grouph.milestoneplanner.models.Milestone;
import wpd2.cw.grouph.milestoneplanner.models.User;
import wpd2.cw.grouph.milestoneplanner.repository.UserRepository;
import wpd2.cw.grouph.milestoneplanner.services.IUserService;
import wpd2.cw.grouph.milestoneplanner.services.MilestoneService;

import java.time.LocalDate;

/* This class seeds the application with some data on startup */
@Component
public class DataLoader implements ApplicationRunner {

    private IUserService userService;
    private MilestoneService milestoneService;

    @Autowired
    public DataLoader(IUserService userService, MilestoneService milestoneService) {
        this.userService = userService;
        this.milestoneService = milestoneService;
    }

    public void run(ApplicationArguments args) {
        User u1 = createUser("lyle", "secret");
        User u2 = createUser("dave", "secret");
        User u3 = createUser("abdul", "secret");
        createMilestone("title1", "description1", LocalDate.now(), u1);
        createMilestone("title2", "description2", LocalDate.now(), u1);
        createMilestone("title3", "description3", LocalDate.now(), u2);
    }

    public User createUser(String username, String pw) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(pw);
        userService.save(user);
        return user;
    }

    public void createMilestone(String title, String desc, LocalDate intended, User creator) {
        Milestone m = new Milestone();
        m.setTitle(title);
        m.setDescription(desc);
        m.setIntendedDueDate(intended);
        m.setUser(creator);
        milestoneService.save(m);
    }
}