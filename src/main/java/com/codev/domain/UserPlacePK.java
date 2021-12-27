package com.codev.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserPlacePK implements Serializable {
    private int userId;
    private int placeId;

    @Column(name = "user_id", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "place_id", nullable = false)
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
        UserPlacePK that = (UserPlacePK) o;
        return userId == that.userId && placeId == that.placeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, placeId);
    }
}
