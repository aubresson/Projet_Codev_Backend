package com.codev.controllers;

import com.codev.domain.LogiParam;
import com.codev.domain.User;
import com.codev.domain.UserCodeId;
import com.codev.services.AuthentificationService;
import com.codev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/authentification")
public class AuthController {

    // Authorided va réaliser une instanciation de notre objet
    // à travers le constructeur de la classe
    private AuthentificationService authentificationService;

    @Autowired
    public AuthController(AuthentificationService authentificationService) {
        this.authentificationService = authentificationService;
    }


    //Authentification en méthode POST
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public  ResponseEntity<?> authentification(@RequestBody LogiParam unUti) {
        UserCodeId user;
        try {
            user = authentificationService.authentification(unUti);
            return ResponseEntity.ok(user);
        }
        catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }



}
