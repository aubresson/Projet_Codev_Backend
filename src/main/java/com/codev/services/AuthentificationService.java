package com.codev.services;

import com.codev.domain.LogiParam;
import com.codev.domain.User;
import com.codev.domain.UserCodeId;
import com.codev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService implements IAuthentificationService {

    private final UserRepository userRepository;

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
            String mdp = user.getPassword();
            // on génère le mot de passe avec les données de connexion
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (!encoder.matches(pwd, mdp)){
                return null;
            }
        }
        assert user != null;
        userCodeId.setCode(user.getCode());
        userCodeId.setId(user.getId());
        return userCodeId;
    }
}
