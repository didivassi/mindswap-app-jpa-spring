package academy.mindswap.mindswapappjapspring.persistence.repository;

import academy.mindswap.mindswapappjapspring.persistence.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "SELECT * FROM users WHERE first_name = :firstName", nativeQuery = true)
    List<User> findByFirstName(@Param("firstName") String firstName);
}
