package wpd2.cw.grouph.milestoneplanner.repository;

import wpd2.cw.grouph.milestoneplanner.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}