package com.codev.services;

import com.codev.domain.Car;

import java.util.HashMap;
import java.util.List;

public interface INoteService {
    HashMap<String, Integer> calculate(double carCO2, double airCO2);

}
