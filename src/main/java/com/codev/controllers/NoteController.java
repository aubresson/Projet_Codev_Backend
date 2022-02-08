package com.codev.controllers;

import com.codev.domain.Car;
import com.codev.services.CarService;
import com.codev.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping()
    public HashMap<String, Integer> list(@RequestParam(value = "carCO2") double carCO2, @RequestParam(value = "airCO2") double airCO2) {
        HashMap<String, Integer> result = new HashMap<>();
        try {
            result = this.noteService.calculate(carCO2, airCO2);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

}