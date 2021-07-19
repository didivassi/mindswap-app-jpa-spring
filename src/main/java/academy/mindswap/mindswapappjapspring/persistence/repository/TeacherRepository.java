package academy.mindswap.mindswapappjapspring.persistence.repository;


import academy.mindswap.mindswapappjapspring.persistence.entity.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository  extends CrudRepository<Teacher,Long> {

    @Query(value = "SELECT * FROM teachers LEFT JOIN teachers_bootcamps on teacher_id=id WHERE bootcamp_id = :edition", nativeQuery = true)
    List<Teacher> findByEdition(@Param("edition") Long edition);

}
