package com.example.projetcodevback.controllers;

import com.example.projetcodevback.domain.CarEntity;
import com.example.projetcodevback.domain.UserEntity;
import com.example.projetcodevback.service.CarService;
import com.example.projetcodevback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epul.cerisaie.mesExceptions.MonException;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService ;


    @RequestMapping(value = "/ajout", method = RequestMethod.POST)
    public ResponseEntity ajoutCar(@RequestBody CarEntity car)
            throws MonException,Exception
    {
        try {
            carService.ajouterCar(car);
            return ResponseEntity.ok().build();
        }
        catch (com.epul.cerisaie.mesExceptions.MonException e) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
