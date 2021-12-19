package com.example.projetcodevback.service;

import com.example.projetcodevback.domain.CarEntity;
import com.example.projetcodevback.domain.PlaceEntity;
import com.example.projetcodevback.repositories.EntityCarRepository;
import com.example.projetcodevback.repositories.EntityPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceService implements IPlaceService{
    private EntityPlaceRepository placeRepository;

    // on initialise à travers le constructeur
    @Autowired
    public PlaceService(EntityPlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    // on insère une place
    @Override
    public void ajouterPlace(PlaceEntity place) {
        try {
            placeRepository.save(place);
        }
        catch (Exception e) {
            throw new com.epul.cerisaie.mesExceptions.MonException("Insert", "Sql", e.getMessage());
        }
    }
}


