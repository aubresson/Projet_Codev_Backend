package com.codev.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_place", schema = "codev", catalog = "")
@IdClass(UserPlacePK.class)
public class UserPlace {
    private int userId;
    private int placeId;
    private User userByUserId;
    private Place placeByPlaceId;

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

        UserPlace userPlace = (UserPlace) o;

        if (userId != userPlace.userId) return false;
        if (placeId != userPlace.placeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + placeId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Place getPlaceByPlaceId() {
        return placeByPlaceId;
    }

    public void setPlaceByPlaceId(Place placeByPlaceId) {
        this.placeByPlaceId = placeByPlaceId;
    }
}
