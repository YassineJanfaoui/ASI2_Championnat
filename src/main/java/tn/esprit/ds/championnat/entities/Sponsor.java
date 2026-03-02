package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sponsor")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sponsor")
    private Long idSponsor;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "pays", nullable = false, length = 50)
    private String pays;

    @Column(name = "budget_annuel", nullable = false)
    private Float budgetAnnuel;

    @Column(name = "bloquer_contrat", nullable = false)
    private Boolean bloquerContrat;

    private Boolean archived;
    private LocalDate dateCreation;
    private LocalDate dateDerniereModification;

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateDerniereModification() {
        return dateDerniereModification;
    }

    public void setDateDerniereModification(LocalDate dateDerniereModification) {
        this.dateDerniereModification = dateDerniereModification;
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    @OneToMany(mappedBy = "sponsor")
    private List<Contrat> contrats;

    public Long getIdSponsor() {
        return idSponsor;
    }

    public void setIdSponsor(Long idSponsor) {
        this.idSponsor = idSponsor;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Float getBudgetAnnuel() {
        return budgetAnnuel;
    }

    public void setBudgetAnnuel(Float budgetAnnuel) {
        this.budgetAnnuel = budgetAnnuel;
    }

    public Boolean getBloquerContrat() {
        return bloquerContrat;
    }

    public void setBloquerContrat(Boolean bloquerContrat) {
        this.bloquerContrat = bloquerContrat;
    }
}
