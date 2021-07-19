package academy.mindswap.mindswapappjapspring.controllers;


import academy.mindswap.mindswapappjapspring.persistence.entity.Teacher;
import academy.mindswap.mindswapappjapspring.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bootcamp/{idBootcamp}")
public class BootcampTeacherController {

    TeacherService service;

    @GetMapping("/teachers")
    public List<Teacher> getTeachers(@PathVariable(name = "idBootcamp") Long id) {
        return service.getTeachersByEdition(id);
    }

    @GetMapping("/teacher/{id}")
    public Teacher getTeacherByID(@PathVariable(name="id") Long id) {
        return service.getTeacherById(id);
    }



    @Autowired
    public void setService(TeacherService service) {
        this.service = service;
    }
}
