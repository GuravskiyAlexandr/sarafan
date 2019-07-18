package letscode.sarafan.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "usr")
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(of = {"id", "name"})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.IdName.class)
    private Long id;
    @Column(unique = true, length = 190)
    private String idGoogle;
    @JsonView(Views.IdName.class)
    private String name;
    @JsonView(Views.IdName.class)
    private String userpic;
    @JsonView(Views.FullProfile.class)
    private String email;
    @JsonView(Views.FullProfile.class)
    private String gender;
    @JsonView(Views.FullProfile.class)
    private String locale;
    @JsonView(Views.FullProfile.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastVisit;


    @JsonView(Views.FullProfile.class)
    @OneToMany(
            mappedBy = "subscriber",
//            удаляем все при разрыве связи
            orphanRemoval = true
    )
    private Set<UserSubscription> subscriptions = new HashSet<>();


    @JsonView(Views.FullProfile.class)
    @OneToMany(
            mappedBy = "channel",
//            удаляем все при разрыве связи
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private Set<UserSubscription> subscribers = new HashSet<>();


    public User(Long idGoogle, String name) {
        this.id = idGoogle;
        this.name = name;
    }
}