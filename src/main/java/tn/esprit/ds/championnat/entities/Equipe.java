package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "equipe")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipe")
    private Long idEquipe;

    @Column(nullable = false, length = 100)
    private String libelle;

    @Column(name = "nb_points_total", nullable = false)
    private int nbPointsTotal;

    @Column(name = "classement_general", nullable = false)
    private int classementGeneral;

    @OneToMany(mappedBy = "equipe")
    private List<Pilote> pilotes;

    @OneToMany(mappedBy = "equipe")
    private List<Contrat> contrats;

    public Long getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNbPointsTotal() {
        return nbPointsTotal;
    }

    public void setNbPointsTotal(int nbPointsTotal) {
        this.nbPointsTotal = nbPointsTotal;
    }

    public int getClassementGeneral() {
        return classementGeneral;
    }

    public void setClassementGeneral(int classementGeneral) {
        this.classementGeneral = classementGeneral;
    }
}
