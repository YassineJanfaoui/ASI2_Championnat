package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.repositories.EquipeRepository;
import tn.esprit.ds.championnat.repositories.PiloteRepository;

@Service
@AllArgsConstructor
public class PiloteServicesImpl implements IPiloteServices{
    private PiloteRepository piloteRepository;
    private EquipeRepository equipeRepository;
    @Override
    public String addPilote(Pilote p) {
        piloteRepository.save(p);
        return "Pilote ajouté!";
    }

    @Override
    public Pilote AffecterPiloteAEquipe(String libP, String libEq){
        Pilote p= new Pilote();
        return p;
    }
}
