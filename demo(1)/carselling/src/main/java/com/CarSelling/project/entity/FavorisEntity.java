package com.CarSelling.project.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "favoris", schema = "public", catalog = "carselling")
public class FavorisEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "idannonce")
    private Integer idannonce;

    @Basic
    @Column(name = "etat")
    private Integer etat;
    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "idutilisateur")
    private UtilisateurEntity utilisateurByIdUtilisateur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdannonce() {
        return idannonce;
    }

    public void setIdannonce(Integer idannonce) {
        this.idannonce = idannonce;
    }


    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }





    public UtilisateurEntity getUtilisateurByIdUtilisateur() {
        return utilisateurByIdUtilisateur;
    }

    public void setUtilisateurByIdUtilisateur(UtilisateurEntity utilisateurByIdUtilisateur) {
        this.utilisateurByIdUtilisateur = utilisateurByIdUtilisateur;
    }
}
