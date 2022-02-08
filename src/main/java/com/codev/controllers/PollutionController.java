package com.codev.controllers;

import com.codev.services.PollutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Objects;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/pollution")
public class PollutionController {
    private final String token = "fae9ff808ae67e1fb014cc038e677937b4511a5c";

    private final PollutionService pollutionService;
    private final String baseURL = "https://api.waqi.info/";

    @Autowired
    public PollutionController(PollutionService pollutionService) {
        this.pollutionService = pollutionService;
    }

    @GetMapping
    private Object getPollution(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude)
    {
        final String uri = baseURL + "feed/geo:" + latitude + ";" + longitude + "/?token=" + token;

        Object result = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            result = pollutionService.getPollution(Objects.requireNonNull(restTemplate.getForObject(uri, LinkedHashMap.class)));
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/nearestStations")
    private Object getNearestStations(@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude)
    {
        final String uri = baseURL + "mapq2/nearest?geo=1/" + latitude + "/" + longitude;

        Object result = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            result = pollutionService.getNearestStations(Objects.requireNonNull(restTemplate.getForObject(uri, LinkedHashMap.class)));
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping("/{station_id}")
    private Object getPollution(@PathVariable int station_id)
    {
        final String uri = baseURL + "feed/@" + station_id + "/?token=" + token;

        Object result = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            result = pollutionService.getPollution(Objects.requireNonNull(restTemplate.getForObject(uri, LinkedHashMap.class)));
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return result;
    }
}
