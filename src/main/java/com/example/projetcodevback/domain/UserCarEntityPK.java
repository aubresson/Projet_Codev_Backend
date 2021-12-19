package com.example.projetcodevback.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserCarEntityPK implements Serializable {
    private int userId;
    private int carId;

    @Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "car_id")
    @Id
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCarEntityPK that = (UserCarEntityPK) o;

        if (userId != that.userId) return false;
        if (carId != that.carId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + carId;
        return result;
    }
}
