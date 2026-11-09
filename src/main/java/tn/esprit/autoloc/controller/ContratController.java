package tn.esprit.autoloc.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratController {

    private final IContratService contratService;

    public ContratController(IContratService contratService) {
        this.contratService = contratService;
    }

    @PostMapping("/addContrat")
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @PutMapping("/updateContrat")
    public Contrat updateContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    @GetMapping("/getAllContrat")
    public List<Contrat> getAllContrats() {
        return contratService.afficherAllContrat();
    }

    @GetMapping("/getContrat/{id}")
    public Contrat getContratById(@PathVariable Long id) {
        return contratService.afficherContratById(id);
    }

    @DeleteMapping("/deleteContrat/{id}")
    public void deleteContrat(@PathVariable Long id) {
        contratService.supprimerContrat(id);
    }
}
