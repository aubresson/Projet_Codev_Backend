package com.codev.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Service
public class AddressService implements IAddressService {


    public ArrayList<Object> list(LinkedHashMap result) {
        ArrayList<Object> newResult = new ArrayList<>();
        for (Object address:(ArrayList)result.get("features")){
            LinkedHashMap<String, Object> newHashMap = new LinkedHashMap<>();
            newHashMap.put("adress", ((LinkedHashMap)((LinkedHashMap)address).get("properties")).get("label"));
            newHashMap.put("latitude", ((ArrayList)((LinkedHashMap)((LinkedHashMap)address).get("geometry")).get("coordinates"))
                    .get(1));
            newHashMap.put("longitude", ((ArrayList)((LinkedHashMap)((LinkedHashMap)address).get("geometry")).get("coordinates"))
                    .get(0));
            newResult.add(newHashMap);
        }
        return newResult;
    }
}

