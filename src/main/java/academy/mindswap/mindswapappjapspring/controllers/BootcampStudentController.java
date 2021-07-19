package academy.mindswap.mindswapappjapspring.controllers;

import academy.mindswap.mindswapappjapspring.persistence.entity.Student;
import academy.mindswap.mindswapappjapspring.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bootcamp/{idBootcamp}")
public class BootcampStudentController {

    StudentService service;


    @GetMapping("/students")
    public List<Student> getStudents(@PathVariable(name = "idBootcamp") Long id) {
        return service.getStudentsByEdition(id);
    }

    @GetMapping("/student/{id}")
    public Student getStudentByID(@PathVariable(name="id") Long id) {
        return service.getStudentById(id);
    }

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }
}
