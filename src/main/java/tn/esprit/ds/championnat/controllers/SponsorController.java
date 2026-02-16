package tn.esprit.ds.championnat.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.championnat.entities.Sponsor;
import tn.esprit.ds.championnat.services.ISponsorServices;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/sponsor")
public class SponsorController {
    ISponsorServices sponsorServices;

    @GetMapping("/add-sponsor")
    public Sponsor addSponsor(@RequestBody Sponsor s){
        return sponsorServices.ajouterSponsor(s);
    }
    @GetMapping("/add-sponsors")
    public List<Sponsor> addSponsors(@RequestBody List<Sponsor> sponsors)
    {
        return sponsorServices.ajouterSponsors(sponsors);
    }
    @PutMapping("/update-sponsor")
    public Sponsor updateSponsor(@RequestBody Sponsor s){
        return sponsorServices.modifierSponsor(s);
    }
    @DeleteMapping("/delete-sponsor/{id}")
    public void deleteSponsor(@PathVariable("id") Long id)
    {
        sponsorServices.supprimerSponsor(id);
    }
}
