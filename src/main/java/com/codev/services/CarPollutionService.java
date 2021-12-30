package com.codev.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

@Service
public class CarPollutionService implements ICarPollutionService {


    public ArrayList<Object> list(LinkedHashMap result) {
        ArrayList<Object> newResult = new ArrayList<>();
        for (Object marque:(ArrayList)((LinkedHashMap)(((ArrayList)result.get("facet_groups")).get(0)))
                .get("facets")){
            LinkedHashMap<String, Object> newHashMap = new LinkedHashMap<>();
            newHashMap.put("name", ((LinkedHashMap)marque).get("name"));
            newHashMap.put("count", ((LinkedHashMap)marque).get("count"));
            newResult.add(newHashMap);
        }
        return newResult;
    }

    public HashSet<Object> listCars(LinkedHashMap result) {
        HashSet<Object> cars = new HashSet<>();
        for (Object car:(ArrayList)result.get("records")){
            cars.add(((LinkedHashMap)((LinkedHashMap)car).get("fields")).get("designation_commerciale"));
        }
        return cars;
    }

    public LinkedHashMap<String, Object> getPollution(LinkedHashMap result) {
        LinkedHashMap<String, Object> details = new LinkedHashMap<>();
        for (Object car:(ArrayList)result.get("records")){
            LinkedHashMap car_details = (LinkedHashMap)((LinkedHashMap)car).get("fields");
            details.put("name", car_details.get("designation_commerciale"));
            details.put("consommation_urbaine_100km", car_details.get("consommation_urbaine_l_100km"));
            details.put("consommation_extra_urbaine_100km", car_details.get("consommation_extra_urbaine_l_100km"));
            details.put("co2_emission", car_details.get("co2_g_km"));
            details.put("carburant", car_details.get("carburant"));
            details.put("annee", car_details.get("annee"));
        }
        return details;
    }
}

