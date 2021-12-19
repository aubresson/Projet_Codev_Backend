package com.example.projetcodevback.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserPlaceEntityPK implements Serializable {
    private int userId;
    private int placeId;

    @Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "place_id")
    @Id
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

        UserPlaceEntityPK that = (UserPlaceEntityPK) o;

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
}
