package com.example.projetcodevback.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_car", schema = "codev", catalog = "")
@IdClass(UserCarEntityPK.class)
public class UserCarEntity {
    private int userId;
    private int carId;
    private UserEntity userByUserId;
    private UserEntity userByUserId_0;
    private UserEntity userByUserId_1;
    private CarEntity carByCarId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "car_id")
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

        UserCarEntity that = (UserCarEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId_0() {
        return userByUserId_0;
    }

    public void setUserByUserId_0(UserEntity userByUserId_0) {
        this.userByUserId_0 = userByUserId_0;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId_1() {
        return userByUserId_1;
    }

    public void setUserByUserId_1(UserEntity userByUserId_1) {
        this.userByUserId_1 = userByUserId_1;
    }

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id", nullable = false)
    public CarEntity getCarByCarId() {
        return carByCarId;
    }

    public void setCarByCarId(CarEntity carByCarId) {
        this.carByCarId = carByCarId;
    }
}
