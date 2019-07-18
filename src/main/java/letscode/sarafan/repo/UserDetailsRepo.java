package letscode.sarafan.repo;

import letscode.sarafan.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserDetailsRepo extends JpaRepository<User, Long> {

    Optional<User> findByIdGoogle(String idGoogle);

    @EntityGraph(attributePaths = {"subscriptions", "subscribers"})
    Optional<User> findById(Long user);


    @Query("SELECT  u FROM User u where u.idGoogle=:id")
    User containId(@Param("id") String idGoogle);
}
