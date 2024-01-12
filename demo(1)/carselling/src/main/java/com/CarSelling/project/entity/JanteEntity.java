package com.CarSelling.project.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "jante", schema = "public", catalog = "carselling")
public class JanteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idjante")
    private Integer idjante;
    @Basic
    @Column(name = "nomjante")
    private String nomjante;

    public Integer getIdjante() {
        return idjante;
    }

    public void setIdjante(Integer idjante) {
        this.idjante = idjante;
    }

    public String getNomjante() {
        return nomjante;
    }

    public void setNomjante(String nomjante) {
        this.nomjante = nomjante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JanteEntity that = (JanteEntity) o;
        return Objects.equals(idjante, that.idjante) && Objects.equals(nomjante, that.nomjante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idjante, nomjante);
    }
}
