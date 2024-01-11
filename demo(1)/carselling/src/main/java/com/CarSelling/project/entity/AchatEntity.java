package com.CarSelling.project.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "achat", schema = "public", catalog = "carselling")
public class AchatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idachat")
    private Integer idachat;
    @Basic
    @Column(name = "idannonce")
    private Integer idannonce;
    @Basic
    @Column(name = "idclient")
    private Integer idclient;
    @Basic
    @Column(name = "etat")
    private Integer etat;

    public Integer getIdachat() {
        return idachat;
    }

    public void setIdachat(Integer idachat) {
        this.idachat = idachat;
    }

    public Integer getIdannonce() {
        return idannonce;
    }

    public void setIdannonce(Integer idannonce) {
        this.idannonce = idannonce;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
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
        AchatEntity that = (AchatEntity) o;
        return Objects.equals(idachat, that.idachat) && Objects.equals(idannonce, that.idannonce) && Objects.equals(idclient, that.idclient) && Objects.equals(etat, that.etat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idachat, idannonce, idclient, etat);
    }
}
