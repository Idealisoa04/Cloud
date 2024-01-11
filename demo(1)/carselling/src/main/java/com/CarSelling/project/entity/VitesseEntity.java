package com.CarSelling.project.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "vitesse", schema = "public", catalog = "carselling")
public class VitesseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idvitesse")
    private Integer idvitesse;
    @Basic
    @Column(name = "nomvitesse")
    private String nomvitesse;

    public Integer getIdvitesse() {
        return idvitesse;
    }

    public void setIdvitesse(Integer idvitesse) {
        this.idvitesse = idvitesse;
    }

    public String getNomvitesse() {
        return nomvitesse;
    }

    public void setNomvitesse(String nomvitesse) {
        this.nomvitesse = nomvitesse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VitesseEntity that = (VitesseEntity) o;
        return Objects.equals(idvitesse, that.idvitesse) && Objects.equals(nomvitesse, that.nomvitesse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idvitesse, nomvitesse);
    }
}
