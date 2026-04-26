package tn.esprit.ds.championnat.controllers;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.ds.championnat.services.ChampionnatServicesImpl;
import tn.esprit.ds.championnat.services.IChampionnatServices;

import java.time.LocalDate;
import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("/Championnat")
public class ChampionnatController {
    IChampionnatServices championnatService;
    @GetMapping("/historiqueContrats")
    public HashMap<String, Float> historiqueContrats(@RequestParam String libelleEquipe) {
        return championnatService.historiqueContratsEquipe(libelleEquipe);
    }

    @GetMapping("/nbPoints")
    public Integer nbPoints(@RequestParam Long idEquipe, @RequestParam Long idChampionnat, @RequestParam String annee) {

        return championnatService.nbPointsParPilotesUneEquipeChampionnatPourUneAnne(idEquipe, idChampionnat, annee);
    }

    @GetMapping("/moyennePositions")
    public Float moyennePositions(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam String libelleP) {
        return championnatService.moyennePositionsEntreDeuxDate(startDate, endDate, libelleP);
    }
}
