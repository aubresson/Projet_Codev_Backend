package com.codev.controllers;

import com.codev.domain.User;
import com.codev.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> list(@RequestParam("code") String code) {
        List<User> users = null;
        try {
            users = this.userService.list(code);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return users;
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int id, @RequestParam("code") String code){
        User movie = null;
        try{
            movie = this.userService.get(id, code);
        } catch (Exception e){
            ResponseEntity.notFound().build();
        }
        return movie;
    }

    @PutMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody User user, @RequestParam("code") String code){
        return this.userService.update(id, user, code);
    }

    @PostMapping()
    public User create(@RequestBody User user, HttpServletResponse response){
        User createdUser = userService.create(user);
        response.setStatus(HttpStatus.CREATED.value());
        return createdUser;
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id, @RequestParam("code") String code){
        try {
            this.userService.delete(id, code);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
