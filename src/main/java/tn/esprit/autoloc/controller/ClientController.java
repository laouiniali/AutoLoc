package tn.esprit.autoloc.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @PutMapping("/updateClient")
    public Client updateClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @GetMapping("/getAllClient")
    public List<Client> getAllClients() {
        return clientService.afficherAllClient();
    }

    @GetMapping("/getClient/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.afficherClientById(id);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.supprimerClient(id);
    }
}
