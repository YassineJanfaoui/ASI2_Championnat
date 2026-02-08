package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pilote")
public class Pilote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pilote")
    private Long idPilote;

    @Column(name = "libelle_p", nullable = false, length = 100)
    private String libelleP;

    @Column(name = "nb_points_total", nullable = false)
    private int nbPointsTotal;

    @Column(name = "classement_general", nullable = false)
    private int classementGeneral;

    @OneToMany(mappedBy = "pilote")
    private List<Position> positions;

    @ManyToOne
    private Equipe equipe;

    public Long getIdPilote() {
        return idPilote;
    }

    public void setIdPilote(Long idPilote) {
        this.idPilote = idPilote;
    }

    public String getLibelleP() {
        return libelleP;
    }

    public void setLibelleP(String libelleP) {
        this.libelleP = libelleP;
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
