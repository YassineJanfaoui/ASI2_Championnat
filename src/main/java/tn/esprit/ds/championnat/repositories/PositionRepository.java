package tn.esprit.ds.championnat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.ds.championnat.entities.Position;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position,Long> {

    @Query("SELECT SUM(p.nbPoints) FROM Position p JOIN p.pilote pi JOIN pi.equipe e JOIN p.course c JOIN c.championnats ch WHERE e.idEquipe = :idEquipe AND ch.idChampionnat = :idChampionnat AND ch.annee = :annee")
    Integer sumPointsByEquipeAndChampionnatAndAnnee(@Param("idEquipe") Long idEquipe, @Param("idChampionnat") Long idChampionnat, @Param("annee") Integer annee);

    @Query("SELECT AVG(p.classement) FROM Position p JOIN p.pilote pi JOIN p.course c WHERE pi.libelleP = :libelleP AND c.dateCourse BETWEEN :startDate AND :endDate")
    Float avgClassementBetweenDates(@Param("libelleP") String libelleP, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<Position> findByPiloteLibelleP(String libelleP);
}
