package academy.mindswap.mindswapappjapspring.services;

import academy.mindswap.mindswapappjapspring.persistence.entity.User;
import academy.mindswap.mindswapappjapspring.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(user -> users.add(user));

        /*for (User user : repository.findAll()){
            users.add(user);
        }*/
        return users;
    }

    public User getUserById(Long id) {
        Optional<User> byId = repository.findById(id);
        //    return byId.isPresent() ? byId.get() : null;
        return byId.orElse(null);
    }

    public User createUser(String firstName, String lastName) {
        return repository.save(new User(firstName, lastName));
    }

    public List<User> getUserByName(String name) {
        return repository.findByFirstName(name);
    }

    @Autowired
    public void setRepository(UserRepository userRepository) {
        this.repository = userRepository;
    }
}
