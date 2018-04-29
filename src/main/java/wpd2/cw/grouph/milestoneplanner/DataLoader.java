package wpd2.cw.grouph.milestoneplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import wpd2.cw.grouph.milestoneplanner.models.Milestone;
import wpd2.cw.grouph.milestoneplanner.models.Role;
import wpd2.cw.grouph.milestoneplanner.models.User;
import wpd2.cw.grouph.milestoneplanner.repository.RoleRepository;
import wpd2.cw.grouph.milestoneplanner.repository.UserRepository;
import wpd2.cw.grouph.milestoneplanner.services.IUserService;
import wpd2.cw.grouph.milestoneplanner.services.MilestoneService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/* This class seeds the application with some data on startup */
@Component
public class DataLoader implements ApplicationRunner {

    private IUserService userService;
    private MilestoneService milestoneService;
    private RoleRepository roleRepository;

    @Autowired
    public DataLoader(IUserService userService, MilestoneService milestoneService, RoleRepository r) {
        this.userService = userService;
        this.milestoneService = milestoneService;
        this.roleRepository = r;
    }

    public void run(ApplicationArguments args) {
        Role r1 = createRole("ROLE_ADMIN");
        Role r2 = createRole("ROLE_USER");

        /* Create sets for the roles */
        Set<Role> roleSetUser = new HashSet<>();
        Set<Role> roleSetUserAndAdmin = new HashSet<>();
        roleSetUser.add(r2);
        roleSetUserAndAdmin.add(r1);
        roleSetUserAndAdmin.add(r2);

        User u1 = createUser("lyle", "secret", roleSetUserAndAdmin);
        User u2 = createUser("dave", "secret", roleSetUser);
        User u3 = createUser("abdul", "secret", roleSetUserAndAdmin);
        createMilestone("title1", "description1", LocalDate.now(), u1);
        createMilestone("title2", "description2", LocalDate.now(), u1);
        createMilestone("title3", "description3", LocalDate.now(), u2);
    }

    public User createUser(String username, String pw, Set<Role> role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(pw);
        user.setRoles(role);
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

    public Role createRole(String name) {
        Role r = new Role();
        r.setName(name);
        roleRepository.save(r);
        return r;
    }
}