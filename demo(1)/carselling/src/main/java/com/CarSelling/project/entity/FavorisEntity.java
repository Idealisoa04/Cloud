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
    @Column(name = "id_utilisateur")
    private Integer idUtilisateur;
    @Basic
    @Column(name = "etat")
    private Integer etat;

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

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavorisEntity that = (FavorisEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(idannonce, that.idannonce) && Objects.equals(idUtilisateur, that.idUtilisateur) && Objects.equals(etat, that.etat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idannonce, idUtilisateur, etat);
    }
}
