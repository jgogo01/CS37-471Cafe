// Natdanai Pinaves 6510405482
package ku.cs.kafe.repository;

import ku.cs.kafe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
