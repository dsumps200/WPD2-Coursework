package wpd2.cw.grouph.milestoneplanner.services;

import wpd2.cw.grouph.milestoneplanner.models.User;

public interface IUserService {
    void save(User user);

    User findByUsername(String username);
}