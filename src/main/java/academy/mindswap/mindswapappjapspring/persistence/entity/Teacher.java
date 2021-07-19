package academy.mindswap.mindswapappjapspring.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "teachers")
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "teachers_bootcamps",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "bootcamp_id"))
    List<Bootcamp> bootcamps;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }



}
