package com.codev.services;

import com.codev.domain.Car;
import com.codev.domain.Place;
import com.codev.domain.UserCar;
import com.codev.domain.UserPlace;
import com.codev.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class PlaceService implements IPlaceService {
    private final PlaceRepository placeRepository;
    private final UserPlaceRepository userPlaceRepository;
    private final UserRepository userRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository, UserPlaceRepository userPlaceRepository, UserRepository userRepository) {
        this.placeRepository = placeRepository;
        this.userPlaceRepository = userPlaceRepository;
        this.userRepository = userRepository;
    }

    public List<Place> list(int user_id, String code) {
        if (userRepository.correctCode(code, user_id) || userRepository.isAdmin(code)) {
            return this.placeRepository.listAll(user_id);
        }
        return null;
    }

    public List<Place> listFavorite(int user_id, String code) {
        if (userRepository.correctCode(code, user_id) || userRepository.isAdmin(code)) {
            return this.placeRepository.listFavorite(user_id);
        }
        return null;
    }

    public List<Place> listLastPlaces(int user_id, String code) {
        if (userRepository.correctCode(code, user_id) || userRepository.isAdmin(code)) {
            List<Place> places = this.placeRepository.listLastPlaces(user_id);
            List<Place> kept_places = new ArrayList<>();
            for (int i =0; i<3; i++){
                if (i == places.size()){
                    break;
                }
                kept_places.add(places.get(i));
            }
            return kept_places;
        }
        return null;
    }

    public Place get(int id) {
        return this.placeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Place create(Place place){
        return this.placeRepository.saveAndFlush(place);
    }

    public Place update(int id, Place place, String code){
        if (userRepository.isAdmin(code)) {
            if (this.placeRepository.existsById(id)) {
                Place newPlace = this.placeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
                if (place.getAddress() != null) {
                    newPlace.setAddress(place.getAddress());
                }
                if (place.getLatitude() != 0) {
                    newPlace.setLatitude(place.getLatitude());
                }
                if (place.getLongitude() != 0) {
                    newPlace.setLongitude(place.getLongitude());
                }
                return this.placeRepository.saveAndFlush(newPlace);
            }
        }
        return null;
    }

    public void delete(int id, String code) {
        if (userRepository.isAdmin(code)) {
            this.placeRepository.delete(this.get(id));
        }
    }

    public void deleteForUser(int user_id, int place_id, String code) {
        if (userRepository.correctCode(code, user_id) || userRepository.isAdmin(code)) {
            this.placeRepository.deleteForUser(user_id, place_id);
        }
    }

    public void changeDateResearch(int user_id, int place_id, String code) {
        if (userRepository.correctCode(code, user_id)) {
            UserPlace newUserPlace = this.placeRepository.findUserPlace(user_id, place_id);
            newUserPlace.setDate_research(new Date(Calendar.getInstance().getTime().getTime()));
            this.userPlaceRepository.saveAndFlush(newUserPlace);
        }
    }

    public void changeFavorite(int user_id, int place_id, String code) {
        if (userRepository.correctCode(code, user_id)) {
            UserPlace newUserPlace = this.placeRepository.findUserPlace(user_id, place_id);
            newUserPlace.setFavorite(newUserPlace.getFavorite().equals("yes")?"no":"yes");
            this.userPlaceRepository.saveAndFlush(newUserPlace);
        }
    }
}

