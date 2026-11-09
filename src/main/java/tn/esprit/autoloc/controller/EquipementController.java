package tn.esprit.autoloc.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/equipement")
public class EquipementController {

    private final IEquipementService equipementService;

    public EquipementController(IEquipementService equipementService) {
        this.equipementService = equipementService;
    }

    @PostMapping("/addEquipement")
    public Equipement addEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @PutMapping("/updateEquipement")
    public Equipement updateEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @GetMapping("/getAllEquipement")
    public List<Equipement> getAllEquipements() {
        return equipementService.afficherAllEquipement();
    }

    @GetMapping("/getEquipement/{id}")
    public Equipement getEquipementById(@PathVariable Long id) {
        return equipementService.afficherEquipmentById(id);
    }

    @DeleteMapping("/deleteEquipement/{id}")
    public void deleteEquipement(@PathVariable Long id) {
        equipementService.supprimerEquipement(id);
    }
}
