package academy.mindswap.mindswapappjapspring.controllers;


import academy.mindswap.mindswapappjapspring.persistence.entity.Student;
import academy.mindswap.mindswapappjapspring.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    StudentService service;

    @GetMapping("/students")
    public Iterable<Student> getStudents() {
        return service.getStudents();
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
