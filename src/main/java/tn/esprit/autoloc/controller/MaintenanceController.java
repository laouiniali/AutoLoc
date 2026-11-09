package tn.esprit.autoloc.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    public MaintenanceController(IMaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping("/addMaintenance")
    public Maintenance addMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @PutMapping("/updateMaintenance")
    public Maintenance updateMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @GetMapping("/getAllMaintenance")
    public List<Maintenance> getAllMaintenances() {
        return maintenanceService.afficherAllMaintenance();
    }

    @GetMapping("/getMaintenance/{id}")
    public Maintenance getMaintenanceById(@PathVariable Long id) {
        return maintenanceService.afficherMaintenanceById(id);
    }

    @DeleteMapping("/deleteMaintenance/{id}")
    public void deleteMaintenance(@PathVariable Long id) {
        maintenanceService.supprimerMaintenance(id);
    }
}
