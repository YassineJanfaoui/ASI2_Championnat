package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Pilote;
import tn.esprit.ds.championnat.repositories.PiloteRepository;

public class PiloteServicesImpl implements IPiloteServices{
    private PiloteRepository piloteRepository;
    @Override
    public String addPilote(Pilote p) {
        piloteRepository.save(p);
        return "Pilote ajouté!";
    }
}
