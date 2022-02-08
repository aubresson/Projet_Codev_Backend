package com.codev.repositories;

import com.codev.domain.Place;
import com.codev.domain.UserPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
    @Query("SELECT places.place FROM UserPlace places WHERE places.user.id = :user_id")
    List<Place> listAll(@Param("user_id") Integer user_id);

    @Query("SELECT places.place FROM UserPlace places WHERE places.user.id = :user_id AND places.favorite = 'yes'")
    List<Place> listFavorite(@Param("user_id") Integer user_id);

    @Query("SELECT places.place FROM UserPlace places WHERE places.user.id = :user_id ORDER BY places.date_research DESC")
    List<Place> listLastPlaces(@Param("user_id") Integer user_id);

    @Transactional
    @Modifying
    @Query("DELETE FROM UserPlace places WHERE places.user.id = :user_id AND places.place.id = :place_id")
    void deleteForUser(@Param("user_id") Integer user_id, @Param("place_id") Integer place_id);

    @Query("SELECT userPlaces FROM UserPlace userPlaces WHERE userPlaces.user.id = :user_id AND userPlaces.place.id = :place_id")
    UserPlace findUserPlace(int user_id, int place_id);
}
