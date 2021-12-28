package com.codev.services;

import com.codev.domain.LogiParam;
import com.codev.domain.User;
import com.codev.domain.UserCodeId;
import com.codev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService implements IAuthentificationService {

    private UserRepository userRepository;

    @Autowired
    public AuthentificationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserCodeId authentification(LogiParam unUti)
    {
        User user;
        UserCodeId userCodeId = new UserCodeId();
        String pwd = unUti.getPassword();
        user = userRepository.findByUsername(unUti.getNomUtil());
        if (user != null) {
            try {
                String mdp = user.getPassword();
                // on génère le mot de passe avec les données de connexion
                if (!pwd.equals(mdp)) {
                    return null;
                }
            }
            catch (Exception e) {
                throw e;
            }
        }
        userCodeId.setCode(user.getCode());
        userCodeId.setId(user.getId());
        return userCodeId;
    }
}
