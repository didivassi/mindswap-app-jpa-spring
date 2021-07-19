package academy.mindswap.mindswapappjapspring.controllers;

import academy.mindswap.mindswapappjapspring.persistence.entity.Teacher;
import academy.mindswap.mindswapappjapspring.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
    TeacherService  service;

    @GetMapping("/teachers")
    public Iterable<Teacher> getStudents() {
        return service.getTeachers();
    }

    @GetMapping("/teacher/{id}")
    public Teacher getStudentByID(@PathVariable(name="id") Long id) {
        return service.getTeacherById(id);
    }


    @Autowired
    public void setService(TeacherService service) {
        this.service = service;
    }
}
