package tn.esprit.ds.championnat.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "detail_championnat")
public class DetailChampionnat {

    @Id
    @Column(length = 50)
    private String code;

    @Column(nullable = false, length = 255)
    private String description;

    @OneToOne(mappedBy = "detailChampionnat")
    private Championnat championnat;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
