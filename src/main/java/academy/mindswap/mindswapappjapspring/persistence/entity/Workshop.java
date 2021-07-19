package academy.mindswap.mindswapappjapspring.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "workshops")
@Table(name = "workshops")
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_to_present")
    private Date dateToPresent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id")
    private WorkshopTheme workshopTheme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edition")
    private Bootcamp edition;

    public Long getId() {
        return id;
    }

    public Date getDateToPresent() {
        return dateToPresent;
    }

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public WorkshopTheme getWorkshopTheme() {
        return workshopTheme;
    }

   /* @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Teacher getTeacher() {
        return teacher;
    }*/

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Bootcamp getEdition() {
        return edition;
    }
}
