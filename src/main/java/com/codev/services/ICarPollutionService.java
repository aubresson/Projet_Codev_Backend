package com.codev.services;

import java.util.LinkedHashMap;

public interface ICarPollutionService {

    Object list(LinkedHashMap result);

    Object listCars(LinkedHashMap result);

    Object getPollution(LinkedHashMap result);
}
