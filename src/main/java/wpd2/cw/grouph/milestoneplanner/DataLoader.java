package wpd2.cw.grouph.milestoneplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import wpd2.cw.grouph.milestoneplanner.models.User;
import wpd2.cw.grouph.milestoneplanner.repository.UserRepository;
import wpd2.cw.grouph.milestoneplanner.services.IUserService;

@Component
public class DataLoader implements ApplicationRunner {

    private IUserService userService;

    @Autowired
    public DataLoader(IUserService userService) {
        this.userService = userService;
    }

    public void run(ApplicationArguments args) {
        User user = new User();
        user.setUsername("lyle");
        user.setPassword("secret123");
        userService.save(user);
    }
}