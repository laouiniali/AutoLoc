package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domaine.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class IServiceContratImp implements IContratService{
    private ContratRepository contratRepository;
    @Override
    public Contrat ajouterContrat(Contrat contrat) {
       return contratRepository.save(contrat);
    }

    @Override
    public Contrat modifierContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat afficherContratById(Long idContrat) {
        return contratRepository.findById(Math.toIntExact(idContrat)).orElse(null);

    }

    @Override
    public List<Contrat> afficherAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public void supprimerContratById(Long idContrat) {
        contratRepository.deleteById(Math.toIntExact(idContrat));

    }
}
