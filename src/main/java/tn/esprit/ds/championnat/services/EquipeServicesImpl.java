package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.repositories.EquipeRepository;

public class EquipeServicesImpl implements IEquipeServices{
    private EquipeRepository equipeRepository;
    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);

    }
}
