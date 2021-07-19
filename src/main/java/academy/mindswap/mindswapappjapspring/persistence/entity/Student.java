package academy.mindswap.mindswapappjapspring.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity(name = "students")
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_card")
    private Long idCard;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edition")
    private Bootcamp bootcamp;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentIdCard")
    private List<Presentation> presentationList;

    public Student() {
    }

    public Student(Long idCard, String name, Bootcamp bootcamp) {
        this.idCard = idCard;
        this.name = name;
        this.bootcamp = bootcamp;
    }

    public Long getIdCard() {
        return idCard;
    }

    public String getName() {
        return name;
    }

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public List<Presentation> getPresentationList() {
        return presentationList;
    }
}
