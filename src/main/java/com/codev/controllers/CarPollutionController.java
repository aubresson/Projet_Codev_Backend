package com.codev.controllers;

import com.codev.services.CarPollutionService;
import com.codev.services.PollutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Objects;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/car_pollution")
public class CarPollutionController {

    private CarPollutionService carPollutionService;
    private final String baseURL = "https://public.opendatasoft.com/api/records/1.0/search/?dataset=vehicules-commercialises&";

    @Autowired
    public CarPollutionController(CarPollutionService carPollutionService) {
        this.carPollutionService = carPollutionService;
    }

    @GetMapping("/marques")
    private Object getMarques()
    {
        final String uri = baseURL + "rows=0&facet=marque";

        Object result = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            result = carPollutionService.list(Objects.requireNonNull(restTemplate.getForObject(uri, LinkedHashMap.class)));
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/modeles")
    private Object getModeles(@RequestParam("marque") String marque)
    {
        final String uri = baseURL + "rows=0&refine.marque=" + marque +
                "&facet=modele_utac";

        Object result = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            result = carPollutionService.list(Objects.requireNonNull(restTemplate.getForObject(uri, LinkedHashMap.class)));
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/carburants")
    private Object getCarburant(@RequestParam("marque") String marque, @RequestParam("modele") String modele)
    {
        final String uri = baseURL + "rows=0&refine.marque=" + marque
                + "&refine.modele_utac=" + modele + "&facet=carburant";

        Object result = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            result = carPollutionService.list(Objects.requireNonNull(restTemplate.getForObject(uri, LinkedHashMap.class)));
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/annees")
    private Object getAnnees(@RequestParam("marque") String marque, @RequestParam("modele") String modele,
                             @RequestParam("carburant") String carburant)
    {
        final String uri = baseURL + "?rows=0&refine.marque=" + marque
                + "&refine.modele_utac=" + modele + "&refine.carburant=" + carburant
                + "&facet=annee";

        Object result = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            result = carPollutionService.list(Objects.requireNonNull(restTemplate.getForObject(uri, LinkedHashMap.class)));
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/listCars")
    private Object listCars(@RequestParam("marque") String marque, @RequestParam("modele") String modele,
                             @RequestParam("carburant") String carburant, @RequestParam("annee") String annee)
    {
        final String uri = baseURL + "rows=1000&refine.carburant="
        + carburant  + "&refine.marque=" + marque + "&refine.modele_utac=" + modele
        + "&refine.annee=" + annee;


        Object result = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            result = carPollutionService.listCars(Objects.requireNonNull(restTemplate.getForObject(uri, LinkedHashMap.class)));
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/getPollution")
    private Object getPollution(@RequestParam("designation_car") String designation_car)
    {
        final String uri = baseURL + "q=" + designation_car.replaceAll("\\s","+") + "&rows=1";

        Object result = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            result = carPollutionService.getPollution(Objects.requireNonNull(restTemplate.getForObject(uri, LinkedHashMap.class)));
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }
}
