package wpd2.cw.grouph.milestoneplanner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import wpd2.cw.grouph.milestoneplanner.models.Role;
import wpd2.cw.grouph.milestoneplanner.models.User;
import wpd2.cw.grouph.milestoneplanner.repository.RoleRepository;
import wpd2.cw.grouph.milestoneplanner.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        /* Give user the USER role, if no role already set */
        if (user.getRoles().size() == 0) {
            Set<Role> role = new HashSet<>();
            Role r = roleRepository.findByName("ROLE_USER");
            role.add(r);
            user.setRoles(role);
        }
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
