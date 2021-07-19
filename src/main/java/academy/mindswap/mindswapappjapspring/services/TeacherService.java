package academy.mindswap.mindswapappjapspring.services;

import academy.mindswap.mindswapappjapspring.persistence.entity.Student;
import academy.mindswap.mindswapappjapspring.persistence.entity.Teacher;
import academy.mindswap.mindswapappjapspring.persistence.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    TeacherRepository repository;

    public Iterable<Teacher> getTeachers() {
        return repository.findAll();
    }

    public List<Teacher> getTeachersByEdition(Long edition) {
        return repository.findByEdition(edition);
    }

    public Teacher getTeacherById(Long id) {
        Optional<Teacher> byId = repository.findById(id);
        return byId.orElse(null);
    }

    @Autowired
    public void setRepository(TeacherRepository repository) {
        this.repository = repository;
    }
}
