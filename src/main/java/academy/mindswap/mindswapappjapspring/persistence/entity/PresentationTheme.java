package academy.mindswap.mindswapappjapspring.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name="presentation_themes")
@Table(name="presentation_themes")
public class PresentationTheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String theme;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "presentationTheme")
    private List<Presentation> presentationList;

    public Long getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }
}
