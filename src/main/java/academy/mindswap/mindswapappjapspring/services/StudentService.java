package academy.mindswap.mindswapappjapspring.services;



import academy.mindswap.mindswapappjapspring.persistence.entity.Student;
import academy.mindswap.mindswapappjapspring.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository repository;

    public Iterable<Student> getStudents() {
        return repository.findAll();
    }

    public List<Student> getStudentsByEdition(Long edition) {
        return repository.findByEdition(edition);
    }

    public Student getStudentById(Long id) {
        Optional<Student> byId = repository.findById(id);
        return byId.orElse(null);
    }


    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.repository = studentRepository;
    }
}
