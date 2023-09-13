package com.scorecard.scoreboard.Repository;

 import com.scorecard.scoreboard.Enum.Role;
 import com.scorecard.scoreboard.Model.User;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;
 import org.springframework.transaction.annotation.Transactional;

 import java.util.Optional;
@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long>  {
    User findByUsername(String username);
    Optional<User> findByEmail(String email);
}





