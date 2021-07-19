package academy.mindswap.mindswapappjapspring.persistence.repository;

import academy.mindswap.mindswapappjapspring.persistence.entity.Bootcamp;
import academy.mindswap.mindswapappjapspring.persistence.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Long> {
    @Query(value = "SELECT * FROM students WHERE edition = :edition", nativeQuery = true)
    List<Student> findByEdition(@Param("edition") Long edition);
}
