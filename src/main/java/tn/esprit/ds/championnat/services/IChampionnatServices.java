package tn.esprit.ds.championnat.services;

import tn.esprit.ds.championnat.entities.Championnat;

import java.time.LocalDate;
import java.util.HashMap;

public interface IChampionnatServices {
    Championnat addChampAndAssociatedCourses(Championnat c);

    HashMap<String, Float> historiqueContratsEquipe(String libelleEquipe);

    Integer nbPointsParPilotesUneEquipeChampionnatPourUneAnne(Long idEquipe, Long idChampionnat, String annee);

    Float moyennePositionsEntreDeuxDate(LocalDate startDate, LocalDate endDate, String libelleP);
}
