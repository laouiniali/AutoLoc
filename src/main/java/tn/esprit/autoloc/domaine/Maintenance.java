package tn.esprit.autoloc.domaine;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "maintenance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;

    //@Column(nullable = false)
    private LocalDate dateDebut;

    private LocalDate dateFin;

    //@Column(length = 500)
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    //@JoinColumn(name = "vehicule_id", nullable = false)
    private Vehicule vehicule;
}
