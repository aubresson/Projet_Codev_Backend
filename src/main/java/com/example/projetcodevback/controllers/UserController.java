package com.example.projetcodevback.controllers;

import com.example.projetcodevback.domain.UserEntity;
import com.example.projetcodevback.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epul.cerisaie.mesExceptions.MonException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService unUserService ;


    @RequestMapping(value = "/ajout", method = RequestMethod.POST)
    public ResponseEntity  ajoutClient(@RequestBody UserEntity unU)
            throws MonException,Exception
    {
        try {
            unUserService.ajouterUser(unU);
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
