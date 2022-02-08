package com.codev.services;

import com.codev.domain.Car;
import com.codev.domain.UserCar;
import com.codev.repositories.CarRepository;
import com.codev.repositories.UserCarRepository;
import com.codev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Service
public class NoteService implements INoteService {

    @Autowired
    public NoteService() {}

    public HashMap<String, Integer> calculate(double carCO2, double airCO2){
        HashMap<String, Integer> result = new HashMap<>();
        result.put("note", 100 - Math.min(100, Math.max(0, (int)(0.2*carCO2+2*airCO2))));
        return result;
    }
}

