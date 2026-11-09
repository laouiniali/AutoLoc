package tn.esprit.autoloc.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/paiement")
public class PaiementController {

    private final IPaiementService paiementService;

    public PaiementController(IPaiementService paiementService) {
        this.paiementService = paiementService;
    }

    @PostMapping("/addPaiement")
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @PutMapping("/updatePaiement")
    public Paiement updatePaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @GetMapping("/getAllPaiement")
    public List<Paiement> getAllPaiements() {
        return paiementService.afficherAllPaiement();
    }

    @GetMapping("/getPaiement/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return paiementService.afficherPaiementById(id);
    }

    @DeleteMapping("/deletePaiement/{id}")
    public void deletePaiement(@PathVariable Long id) {
        paiementService.supprimerPaiement(id);
    }
}
