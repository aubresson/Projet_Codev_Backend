package com.codev.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Service
public class PollutionService implements IPollutionService {


    public LinkedHashMap<String, Object> getPollution(LinkedHashMap result) {
        LinkedHashMap<String, Object> newResult = new LinkedHashMap<>();
        newResult.put("city", ((LinkedHashMap)((LinkedHashMap)result.get("data")).get("city"))
                .get("name"));
        newResult.put("latitude", ((ArrayList)((LinkedHashMap)((LinkedHashMap)result.get("data")).get("city"))
                .get("geo")).get(0));
        newResult.put("longitude", ((ArrayList)((LinkedHashMap)((LinkedHashMap)result.get("data")).get("city"))
                .get("geo")).get(1));
        newResult.put("values", ((LinkedHashMap)result.get("data")).get("iaqi"));
        newResult.put("nextDays", ((LinkedHashMap)((LinkedHashMap)result.get("data")).get("forecast"))
                .get("daily"));
        return newResult;
    }

    public ArrayList<Object> getNearestStations(LinkedHashMap result){
        ArrayList<Object> newResult = new ArrayList<>();
        int nbStations = 0;
        for (Object station:(ArrayList)((LinkedHashMap)result.get("data")).get("stations")){
            if (nbStations++ < 5) {
                LinkedHashMap<String, Object> newHashMap = new LinkedHashMap<>();
                newHashMap.put("id", ((LinkedHashMap) station).get("idx"));
                newHashMap.put("address", ((LinkedHashMap) station).get("name"));
                newHashMap.put("latitude", ((ArrayList) ((LinkedHashMap) station).get("geo")).get(0));
                newHashMap.put("longitude", ((ArrayList) ((LinkedHashMap) station).get("geo")).get(1));
                newHashMap.put("distance", ((LinkedHashMap) station).get("distance"));
                newResult.add(newHashMap);
            }
        }
        return newResult;
    }
}

