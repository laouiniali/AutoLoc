package tn.esprit.autoloc.domaine;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    //@Column(nullable = false, length = 50)
    private String nom;

    //@Column(nullable = false, length = 50)
    private String prenom;

    //@Column(unique = true, length = 100)
    private String email;

    //@Column(length = 20)
    private String telephone;

    //@Column(unique = true, length = 30)
    private String numPermis;

    private LocalDate dateInscription;

    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Reservation> reservations;
}
