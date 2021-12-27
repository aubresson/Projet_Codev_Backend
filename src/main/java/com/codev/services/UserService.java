package com.codev.services;

import com.codev.domain.User;
import com.codev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> list() {
        return this.userRepository.findAll();
    }

    public User get(int id) {
        return this.userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public User create(User user){
        return this.userRepository.saveAndFlush(user);
    }

    public User update(int id, User user){
        if (this.userRepository.existsById(id)){
            User newUser = this.userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            if (user.getName() != null){
                newUser.setName(user.getName());
            }
            if (user.getFirstname() != null){
                newUser.setFirstname(user.getFirstname());
            }
            if (user.getUsername() != null){
                newUser.setUsername(user.getUsername());
            }
            if (user.getPassword() != null){
                newUser.setPassword(user.getPassword());
            }
            return this.userRepository.saveAndFlush(newUser);
        }
        return null;
    }

    public void delete(int id) {
        this.userRepository.delete(this.get(id));
    }
}

