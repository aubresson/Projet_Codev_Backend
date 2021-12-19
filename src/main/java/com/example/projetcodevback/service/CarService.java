package com.example.projetcodevback.service;

import com.example.projetcodevback.domain.CarEntity;
import com.example.projetcodevback.domain.UserEntity;
import com.example.projetcodevback.repositories.EntityCarRepository;
import com.example.projetcodevback.repositories.EntityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService implements ICarService{

    private EntityCarRepository carRepository;


    // on initialise à travers le constructeur
    @Autowired
    public CarService(EntityCarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // on insère une voiture
    @Override
    public void ajouterCar(CarEntity car) {
        try {
            carRepository.save(car);
        }
        catch (Exception e) {
            throw new com.epul.cerisaie.mesExceptions.MonException("Insert", "Sql", e.getMessage());
        }
    }
}
