package com.example.projetcodevback.controllers;
import com.epul.cerisaie.mesExceptions.MonException;
import com.example.projetcodevback.domain.CarEntity;
import com.example.projetcodevback.domain.PlaceEntity;
import com.example.projetcodevback.service.CarService;
import com.example.projetcodevback.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "/ajout", method = RequestMethod.POST)
    public ResponseEntity ajoutPlace(@RequestBody PlaceEntity place)
            throws MonException, Exception {
        try {
            placeService.ajouterPlace(place);
            return ResponseEntity.ok().build();
        } catch (com.epul.cerisaie.mesExceptions.MonException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}