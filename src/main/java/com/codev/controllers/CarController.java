package com.codev.controllers;

import com.codev.domain.Car;
import com.codev.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/user/{user_id}/{code}")
    public List<Car> list(@PathVariable int user_id, @PathVariable(value="code") String code) {
        List<Car> cars = null;
        try {
            cars = this.carService.list(user_id, code);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return cars;
    }

    @GetMapping("/favorite/{user_id}")
    public List<Car> listFavorite(@PathVariable int user_id, @RequestParam("code") String code) {
        List<Car> cars = null;
        try {
            cars = this.carService.listFavorite(user_id, code);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return cars;
    }

    @GetMapping("/lastCars/{user_id}")
    public List<Car> listLastCars(@PathVariable int user_id, @RequestParam("code") String code) {
        List<Car> cars = null;
        try {
            cars = this.carService.listLastCars(user_id, code);
        } catch (Exception e) {
            ResponseEntity.notFound().build();
        }
        return cars;
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable int id, @RequestBody Car car, @RequestParam("code") String code){
        return this.carService.update(id, car, code);
    }

    @PostMapping()
    public Car create(@RequestBody Car car, HttpServletResponse response){
        Car createdCar = carService.create(car);
        response.setStatus(HttpStatus.CREATED.value());
        return createdCar;
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id, @RequestParam("code") String code){
        try {
            this.carService.delete(id, code);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/user/delete/{user_id}")
    public ResponseEntity<Object> deleteForUser(@PathVariable int user_id, @RequestParam("car_id") int car_id,
                                                @RequestParam("code") String code){
        try {
            this.carService.deleteForUser(user_id, car_id, code);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/changeDateResearch/{user_id}")
    public ResponseEntity<Object> changeDateResearch(@PathVariable int user_id, @RequestParam("car_id") int car_id,
                                                     @RequestParam("code") String code){
        try {
            this.carService.changeDateResearch(user_id, car_id, code);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/changeFavorite/{user_id}")
    public ResponseEntity<Object> changeFavorite(@PathVariable int user_id, @RequestParam("car_id") int car_id,
                                                 @RequestParam("code") String code){
        try {
            this.carService.changeFavorite(user_id, car_id, code);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/user/add/{user_id}")
    public ResponseEntity<Object> addForUser(@PathVariable int user_id, @RequestParam("car_id") int car_id,
                                             @RequestParam("code") String code){
        try {
            this.carService.addForUser(user_id, car_id, code);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
