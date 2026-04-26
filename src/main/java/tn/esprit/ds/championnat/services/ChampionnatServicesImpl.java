package tn.esprit.ds.championnat.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ds.championnat.entities.Championnat;
import tn.esprit.ds.championnat.entities.Equipe;
import tn.esprit.ds.championnat.repositories.ChampionnatRepository;
import tn.esprit.ds.championnat.repositories.ContratRepository;
import tn.esprit.ds.championnat.repositories.PositionRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class ChampionnatServicesImpl implements IChampionnatServices{

    ContratRepository contratRepository;
    PositionRepository positionRepository;

    @Override
    public Championnat addChampAndAssociatedCourses(Championnat c) {
        return null;
    }

    @Override
    public HashMap<String, Float> historiqueContratsEquipe(String libelleEquipe) {
        List<Object[]> rows = contratRepository.findHistoriqueByEquipeLibelle(libelleEquipe);
        HashMap<String, Float> result = new HashMap<>();
        for (Object[] row : rows) {
            result.put((String) row[0], (Float) row[1]);
        }
        return result;
    }

    @Override
    public Integer nbPointsParPilotesUneEquipeChampionnatPourUneAnne(Long idEquipe, Long idChampionnat, String annee) {
        return positionRepository.sumPointsByEquipeAndChampionnatAndAnnee(idEquipe, idChampionnat, Integer.parseInt(annee));
    }

    @Override
    public Float moyennePositionsEntreDeuxDate(LocalDate startDate, LocalDate endDate, String libelleP) {
        return positionRepository.avgClassementBetweenDates(libelleP, startDate, endDate);
    }
}
