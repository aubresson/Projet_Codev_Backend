package com.codev.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserCarPK implements Serializable {
    private int userId;
    private int carId;

    @Column(name = "user_id", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "car_id", nullable = false)
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

        UserCarPK userCarPK = (UserCarPK) o;

        if (userId != userCarPK.userId) return false;
        if (carId != userCarPK.carId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + carId;
        return result;
    }
}
