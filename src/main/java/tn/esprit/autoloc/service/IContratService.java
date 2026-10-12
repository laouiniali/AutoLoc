package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domaine.Contrat;

import java.util.List;

public interface IContratService  {
    Contrat ajouterContrat(Contrat contrat);
    Contrat modifierContrat(Contrat contrat);



    Contrat afficherContratById(Long id);


    List<Contrat> afficherAllContrats();
    void supprimerContratById(Long id);

}
