package com.codev.services;

import com.codev.domain.User;
import com.codev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> list(String code) {
        if (userRepository.isAdmin(code)) {
            return this.userRepository.findAll();
        }
        return null;
    }

    public User get(int id, String code) {
        if (userRepository.isAdmin(code)) {
            return this.userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        }
        return null;
    }

    public User get(int id) {
        return this.userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public User create(User user){
        user.setCode(UUID.randomUUID().toString());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("user");
        return this.userRepository.saveAndFlush(user);
    }

    public User update(int id, User user, String code){
        if (this.userRepository.existsById(id)) {
            User newUser = this.userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            if (userRepository.correctCode(code, newUser.getId()) || userRepository.isAdmin(code)) {
                if (user.getName() != null) {
                    newUser.setName(user.getName());
                }
                if (user.getFirstname() != null) {
                    newUser.setFirstname(user.getFirstname());
                }
                if (user.getUsername() != null) {
                    newUser.setUsername(user.getUsername());
                }
                if (user.getPassword() != null) {
                    newUser.setPassword(user.getPassword());
                }
                return this.userRepository.saveAndFlush(newUser);
            }
        }
        return null;
    }

    public void delete(int id, String code) {
        if (userRepository.correctCode(code, id) || userRepository.isAdmin(code)) {
            this.userRepository.delete(this.get(id));
        }
    }
}

