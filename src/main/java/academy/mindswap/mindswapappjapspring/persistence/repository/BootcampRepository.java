package academy.mindswap.mindswapappjapspring.persistence.repository;

import academy.mindswap.mindswapappjapspring.persistence.entity.Bootcamp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BootcampRepository extends CrudRepository<Bootcamp, Long> {

    @Query(value = "SELECT * FROM bootcamps WHERE location = :location", nativeQuery = true)
    List<Bootcamp> findByLocation(@Param("location") String location);
}
