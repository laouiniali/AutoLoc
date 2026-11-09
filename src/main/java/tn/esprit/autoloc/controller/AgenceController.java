package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agences")
public class AgenceController {

    private final IAgenceService agenceService;

    @PostMapping({"/ajouterAgence"})
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @GetMapping({"/afficherTousAgences"})
    public List<Agence> afficherTousAgences() {
        return agenceService.afficherAllAgence();
    }

    @PutMapping({"/modifierAgence/{id}", "/{id}"})
    public Agence modifierAgence(@PathVariable Long id, @RequestBody Agence agence) {
        agence.setIdAgence(id);
        return agenceService.modifierAgence(agence);
    }

    @GetMapping({ "/afficherAgence/{id}"})
    public Agence afficherAgence(@PathVariable Long id) {
        return agenceService.afficherAgence(id);
    }

    @DeleteMapping({ "/supprimerAgence/{id}"})
    public void supprimerAgence(@PathVariable Long id) {
        agenceService.supprimerAgence(id);
    }
}
