package com.codev.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "car", schema = "codev", catalog = "")
public class Car {
    private int id;
    private String modele;
    private String marque;
    private String carburant;
    private int annee;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "modele", nullable = false)
    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Basic
    @Column(name = "marque", nullable = false)
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Basic
    @Column(name = "carburant", nullable = false)
    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    @Basic
    @Column(name = "annee", nullable = false)
    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car carEntity = (Car) o;
        return id == carEntity.id && annee == carEntity.annee && Objects.equals(modele, carEntity.modele) && Objects.equals(marque, carEntity.marque) && Objects.equals(carburant, carEntity.carburant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modele, marque, carburant, annee);
    }
}
