package com.CarSelling.project.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "model", schema = "public", catalog = "carselling")
public class ModelEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmodel")
    private Integer idmodel;
    @Basic
    @Column(name = "nommodel")
    private String nommodel;
    @Basic
    @Column(name = "id_categorie")
    private Integer idCategorie;
    @Basic
    @Column(name = "id_marque")
    private Integer idMarque;
    @Basic
    @Column(name = "id_carburant")
    private Integer idCarburant;
    @Basic
    @Column(name = "id_vitesse")
    private Integer idVitesse;
    @Basic
    @Column(name = "nb_portes")
    private Integer nbPortes;
    @Basic
    @Column(name = "id_climatisation")
    private Integer idClimatisation;

    public Integer getIdmodel() {
        return idmodel;
    }

    public void setIdmodel(Integer idmodel) {
        this.idmodel = idmodel;
    }

    public String getNommodel() {
        return nommodel;
    }

    public void setNommodel(String nommodel) {
        this.nommodel = nommodel;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Integer getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public Integer getIdCarburant() {
        return idCarburant;
    }

    public void setIdCarburant(Integer idCarburant) {
        this.idCarburant = idCarburant;
    }

    public Integer getIdVitesse() {
        return idVitesse;
    }

    public void setIdVitesse(Integer idVitesse) {
        this.idVitesse = idVitesse;
    }

    public Integer getNbPortes() {
        return nbPortes;
    }

    public void setNbPortes(Integer nbPortes) {
        this.nbPortes = nbPortes;
    }

    public Integer getIdClimatisation() {
        return idClimatisation;
    }

    public void setIdClimatisation(Integer idClimatisation) {
        this.idClimatisation = idClimatisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelEntity that = (ModelEntity) o;
        return Objects.equals(idmodel, that.idmodel) && Objects.equals(nommodel, that.nommodel) && Objects.equals(idCategorie, that.idCategorie) && Objects.equals(idMarque, that.idMarque) && Objects.equals(idCarburant, that.idCarburant) && Objects.equals(idVitesse, that.idVitesse) && Objects.equals(nbPortes, that.nbPortes) && Objects.equals(idClimatisation, that.idClimatisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmodel, nommodel, idCategorie, idMarque, idCarburant, idVitesse, nbPortes, idClimatisation);
    }
}
