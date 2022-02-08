package com.codev.controllers;

import com.codev.domain.Place;
import com.codev.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/places")
public class PlaceController {
    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/user/{user_id}")
    public List<Place> list(@PathVariable int user_id, @RequestParam("code") String code) {
        List<Place> places = null;
        try {
            places = this.placeService.list(user_id, code);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return places;
    }

    @GetMapping("/favorite/{user_id}")
    public List<Place> listFavorite(@PathVariable int user_id, @RequestParam("code") String code) {
        List<Place> places = null;
        try {
            places = this.placeService.listFavorite(user_id, code);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return places;
    }

    @GetMapping("/lastPlaces/{user_id}")
    public List<Place> listLastCars(@PathVariable int user_id, @RequestParam("code") String code) {
        List<Place> places = null;
        try {
            places = this.placeService.listLastPlaces(user_id, code);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return places;
    }

    @PutMapping("/{id}")
    public Place update(@PathVariable int id, @RequestBody Place place, @RequestParam("code") String code){
        return this.placeService.update(id, place, code);
    }

    @PostMapping()
    public Place create(@RequestBody Place place, HttpServletResponse response){
        Place createdPlace = placeService.create(place);
        response.setStatus(HttpStatus.CREATED.value());
        return createdPlace;
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id, @RequestParam("code") String code){
        try {
            this.placeService.delete(id, code);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/user/delete/{user_id}")
    public ResponseEntity<Object> deleteForUser(@PathVariable int user_id, @RequestParam("place_id") int place_id,
                                                @RequestParam("code") String code){
        try {
            this.placeService.deleteForUser(user_id, place_id, code);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/changeDateResearch/{user_id}")
    public ResponseEntity<Object> changeDateResearch(@PathVariable int user_id, @RequestParam("place_id") int place_id,
                                                     @RequestParam("code") String code){
        try {
            this.placeService.changeDateResearch(user_id, place_id, code);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/changeFavorite/{user_id}")
    public ResponseEntity<Object> changeFavorite(@PathVariable int user_id, @RequestParam("place_id") int place_id,
                                                 @RequestParam("code") String code){
        try {
            this.placeService.changeFavorite(user_id, place_id, code);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/user/add/{user_id}")
    public ResponseEntity<Object> addForUser(@PathVariable int user_id, @RequestParam("place_id") int place_id,
                                                 @RequestParam("code") String code){
        try {
            this.placeService.addForUser(user_id, place_id, code);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
