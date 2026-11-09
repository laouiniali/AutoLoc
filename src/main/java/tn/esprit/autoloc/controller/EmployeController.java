package tn.esprit.autoloc.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/employe")
public class EmployeController {

    private final IEmployeService employeService;

    public EmployeController(IEmployeService employeService) {
        this.employeService = employeService;
    }

    @PostMapping("/addEmploye")
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @PutMapping("/updateEmploye")
    public Employe updateEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @GetMapping("/getAllEmploye")
    public List<Employe> getAllEmployes() {
        return employeService.afficherAllEmploye();
    }

    @GetMapping("/getEmploye/{id}")
    public Employe getEmployeById(@PathVariable Long id) {
        return employeService.afficherEmployeById(id);
    }

    @DeleteMapping("/deleteEmploye/{id}")
    public void deleteEmploye(@PathVariable Long id) {
        employeService.supprimerEmploye(id);
    }
}
