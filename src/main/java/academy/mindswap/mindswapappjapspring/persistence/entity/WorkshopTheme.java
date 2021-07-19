package academy.mindswap.mindswapappjapspring.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "workshop_themes")
@Table(name = "workshop_themes")
public class WorkshopTheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theme;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "workshopTheme")
    private List<Workshop> workshopList;

    public Long getId() {
        return id;
    }


    public String getTheme() {
        return theme;
    }
}
