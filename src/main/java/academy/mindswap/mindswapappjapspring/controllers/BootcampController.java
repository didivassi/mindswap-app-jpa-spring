package academy.mindswap.mindswapappjapspring.controllers;

import academy.mindswap.mindswapappjapspring.persistence.entity.Bootcamp;
import academy.mindswap.mindswapappjapspring.persistence.repository.BootcampRepository;
import academy.mindswap.mindswapappjapspring.services.BootcampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BootcampController {

    private BootcampService service;

    @GetMapping("/bootcamps")
    public Iterable<Bootcamp> getBootcamps() {
        return service.getBootcamps();
    }



    @GetMapping("/bootcamps/")
    public List<Bootcamp> getBootcampsByLocation(@RequestParam(name = "location") String location) {
        return service.getBootcampsByLocation(location);
    }

    @GetMapping("/bootcamp/{id}")
    public Bootcamp getBootcampByID(@PathVariable(name="id") Long id) {
        return service.getBootcampById(id);
    }


    @Autowired
    public void setService(BootcampService service) {
        this.service = service;
    }
}
