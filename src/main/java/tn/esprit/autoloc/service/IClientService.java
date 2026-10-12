package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domaine.Client;

import java.util.List;

public interface IClientService {
    Client ajouterClient(Client client);
    Client modifierClient(Client client);

    Client afficherClientById(Long id);
    List<Client> afficherAllClients();


    void supprimerClientById(Long id);

}
