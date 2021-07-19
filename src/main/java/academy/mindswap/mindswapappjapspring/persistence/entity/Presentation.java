package academy.mindswap.mindswapappjapspring.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "presentations")
@Table(name = "presentations")
public class Presentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_to_present")
    private Date dateToPresent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id")
    private PresentationTheme presentationTheme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id_card")
    private Student studentIdCard;

    public Long getId() {
        return id;
    }

    public Date getDateToPresent() {
        return dateToPresent;
    }

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public PresentationTheme getPresentationTheme() {
        return presentationTheme;
    }
}
