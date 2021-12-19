package com.example.projetcodevback.service;

import com.example.projetcodevback.domain.UserEntity;
import com.example.projetcodevback.repositories.EntityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private EntityUserRepository unUserRepository;

    // on initialise à travers le constructeur
    @Autowired
    public UserService(EntityUserRepository userRepostory) {
        this.unUserRepository = userRepostory;
    }

    // on insère un client
    @Override
    public void ajouterUser(UserEntity unU) {
        try {
            unUserRepository.save(unU);
        }
        catch (Exception e) {
            throw new com.epul.cerisaie.mesExceptions.MonException("Insert", "Sql", e.getMessage());
        }
    }
}
