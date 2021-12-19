package com.example.projetcodevback.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "place", schema = "codev", catalog = "")
public class PlaceEntity {
    private int id;
    private String address;
    private double latitude;
    private double longitude;
    private Collection<UserPlaceEntity> userPlacesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "latitude")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaceEntity that = (PlaceEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "placeByPlaceId")
    public Collection<UserPlaceEntity> getUserPlacesById() {
        return userPlacesById;
    }

    public void setUserPlacesById(Collection<UserPlaceEntity> userPlacesById) {
        this.userPlacesById = userPlacesById;
    }
}
