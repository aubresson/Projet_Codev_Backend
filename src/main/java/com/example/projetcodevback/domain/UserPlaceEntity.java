package com.example.projetcodevback.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_place", schema = "codev", catalog = "")
@IdClass(UserPlaceEntityPK.class)
public class UserPlaceEntity {
    private int userId;
    private int placeId;
    private UserEntity userByUserId;
    private PlaceEntity placeByPlaceId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "place_id")
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPlaceEntity that = (UserPlaceEntity) o;

        if (userId != that.userId) return false;
        if (placeId != that.placeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + placeId;
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
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    public PlaceEntity getPlaceByPlaceId() {
        return placeByPlaceId;
    }

    public void setPlaceByPlaceId(PlaceEntity placeByPlaceId) {
        this.placeByPlaceId = placeByPlaceId;
    }
}
