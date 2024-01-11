package com.CarSelling.project.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "categorie", schema = "public", catalog = "carselling")
public class CategorieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcategorie")
    private Integer idcategorie;
    @Basic
    @Column(name = "nomcategorie")
    private String nomcategorie;

    public Integer getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Integer idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getNomcategorie() {
        return nomcategorie;
    }

    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieEntity that = (CategorieEntity) o;
        return Objects.equals(idcategorie, that.idcategorie) && Objects.equals(nomcategorie, that.nomcategorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcategorie, nomcategorie);
    }
}
