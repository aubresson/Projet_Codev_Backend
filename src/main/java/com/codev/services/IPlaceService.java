package com.codev.services;

import com.codev.domain.Place;

import java.util.List;

public interface IPlaceService {

    List<Place> list(int user_id, String code);
    List<Place> listFavorite(int user_id, String code);
    List<Place> listLastPlaces(int user_id, String code);
    Place get(int id);
    Place create(Place place);
    Place update(int id, Place place, String code);
    void delete(int id, String code);
    void addForUser(int user_id, int place_id, String code);
    void deleteForUser(int user_id, int place_id, String code);
    void changeDateResearch(int user_id, int place_id, String code);
    void changeFavorite(int user_id, int place_id, String code);

}
