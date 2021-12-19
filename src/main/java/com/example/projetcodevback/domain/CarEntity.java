package com.example.projetcodevback.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "car", schema = "codev", catalog = "")
public class CarEntity {
    private int id;
    private String modele;
    private String marque;
    private String carburant;
    private int annee;
    private Collection<UserCarEntity> userCarsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "modele")
    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Basic
    @Column(name = "marque")
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Basic
    @Column(name = "carburant")
    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    @Basic
    @Column(name = "annee")
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

        CarEntity carEntity = (CarEntity) o;

        if (id != carEntity.id) return false;
        if (annee != carEntity.annee) return false;
        if (modele != null ? !modele.equals(carEntity.modele) : carEntity.modele != null) return false;
        if (marque != null ? !marque.equals(carEntity.marque) : carEntity.marque != null) return false;
        if (carburant != null ? !carburant.equals(carEntity.carburant) : carEntity.carburant != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (modele != null ? modele.hashCode() : 0);
        result = 31 * result + (marque != null ? marque.hashCode() : 0);
        result = 31 * result + (carburant != null ? carburant.hashCode() : 0);
        result = 31 * result + annee;
        return result;
    }

    @OneToMany(mappedBy = "carByCarId")
    public Collection<UserCarEntity> getUserCarsById() {
        return userCarsById;
    }

    public void setUserCarsById(Collection<UserCarEntity> userCarsById) {
        this.userCarsById = userCarsById;
    }
}
