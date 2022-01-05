package com.codev.controllers;

import com.codev.services.AddressService;
import com.codev.services.CarPollutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;
    private final String baseURL = "https://api-adresse.data.gouv.fr/search/?";

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    private Object getAddresses(@RequestParam("zip_code") String zip_code)
    {
        final String uri = baseURL + "q=" + zip_code + "&type=municipality&limit=5&postcode=" + zip_code;

        Object result = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            result = addressService.list(Objects.requireNonNull(restTemplate.getForObject(uri, LinkedHashMap.class)));
            if (((ArrayList)result).size() == 0){
                return getAddresses(Integer.toString(Integer.parseInt(zip_code) + 1));
            }
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }
}
