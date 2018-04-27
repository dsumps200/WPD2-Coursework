package wpd2.cw.grouph.milestoneplanner.repository;

import wpd2.cw.grouph.milestoneplanner.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    /* finds a user by the username: wrapped in Optional class in case username doesn't exist */
    //Optional<User> findByName(String username);

}