package academy.mindswap.mindswapappjapspring.services;

import academy.mindswap.mindswapappjapspring.persistence.entity.Bootcamp;
import academy.mindswap.mindswapappjapspring.persistence.entity.User;
import academy.mindswap.mindswapappjapspring.persistence.repository.BootcampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BootcampService {

    private BootcampRepository repository;

    public Iterable<Bootcamp> getBootcamps() {
        //List<Bootcamp> bootcamps = new ArrayList<>();
        //repository.findAll().forEach(bootcamps::add);
        //return bootcamps;
        return repository.findAll();
    }

    public List<Bootcamp> getBootcampsByLocation(String location){
        return repository.findByLocation(location);
    }

    public Bootcamp getBootcampById(Long id) {
        Optional<Bootcamp> byId = repository.findById(id);
        //    return byId.isPresent() ? byId.get() : null;
        return byId.orElse(null);
    }

    @Autowired
    public void setRepository(BootcampRepository repository) {
        this.repository = repository;
    }
}
