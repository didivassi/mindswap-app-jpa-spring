package academy.mindswap.mindswapappjapspring.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity(name = "bootcamps")
@Table(name="bootcamps")
public class Bootcamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long edition;
    @Column(nullable = false, length = 100)
    private String location;
    @Column(nullable = false, name="starting_date")
    private Date startingDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bootcamp")
    private List<Student> studentList;

    @ManyToMany(mappedBy = "bootcamps")
    private List<Teacher> teacherList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "edition")
    private List<Workshop> workshopList;

    public Bootcamp() {
    }

    public Bootcamp(String location, Date startingDate) {
        this.location = location;
        this.startingDate = startingDate;
    }

    public Bootcamp(Long edition, String location, Date startingDate) {
        this.edition = edition;
        this.location = location;
        this.startingDate = startingDate;
    }

    public Long getEdition() {
        return edition;
    }

    public String getLocation() {
        return location;
    }

    public Date getStartingDate() {
        return startingDate;
    }

   /* @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public List<Student> getStudentList() {
        return studentList;
    }*/

    /*@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public List<Teacher> getTeacherList() {
        return teacherList;
    }*/

    @Override
    public String toString() {
        return "Bootcamp{" +
                "edition=" + edition +
                ", location='" + location + '\'' +
                ", startingDate=" + startingDate +
                '}';
    }
}
