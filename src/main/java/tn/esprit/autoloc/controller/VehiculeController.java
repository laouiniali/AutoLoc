package tn.esprit.autoloc.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/vehicule")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    public VehiculeController(IVehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @PostMapping("/addVehicule")
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @PutMapping("/updateVehicule")
    public Vehicule updateVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @GetMapping("/getAllVehicules")
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.modifierAllVehicule();
    }

    @GetMapping("/getVehicule/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id) {
        return vehiculeService.afficherVehiculeById(id);
    }

    @DeleteMapping("/deleteVehicule/{id}")
    public void deleteVehicule(@PathVariable Long id) {
        vehiculeService.supprimerVehicule(id);
    }
}
