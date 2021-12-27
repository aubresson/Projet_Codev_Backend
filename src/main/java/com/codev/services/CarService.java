package com.codev.services;

import com.codev.domain.Car;
import com.codev.domain.User;
import com.codev.domain.UserCar;
import com.codev.repositories.CarRepository;
import com.codev.repositories.UserCarRepository;
import com.codev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class CarService implements ICarService {
    private final CarRepository carRepository;
    private final UserCarRepository userCarRepository;

    @Autowired
    public CarService(CarRepository carRepository, UserCarRepository userCarRepository) {
        this.carRepository = carRepository;
        this.userCarRepository = userCarRepository;
    }

    public List<Car> list(int user_id) {
        return this.carRepository.listAll(user_id);
    }

    public List<Car> listFavorite(int user_id) {
        return this.carRepository.listFavorite(user_id);
    }

    public List<Car> listLastCars(int user_id) {
        return this.carRepository.listLastCars(user_id);
    }

    public Car get(int id) {
        return this.carRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Car create(Car car){
        return this.carRepository.saveAndFlush(car);
    }

    public Car update(int id, Car car){
        if (this.carRepository.existsById(id)){
            Car newCar = this.carRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            if (car.getMarque() != null){
                newCar.setMarque(car.getMarque());
            }
            if (car.getModele() != null){
                newCar.setModele(car.getModele());
            }
            if (car.getCarburant() != null){
                newCar.setCarburant(car.getCarburant());
            }
            if (car.getAnnee() != 0){
                newCar.setAnnee(car.getAnnee());
            }
            return this.carRepository.saveAndFlush(newCar);
        }
        return null;
    }

    public void delete(int id) {
        this.carRepository.delete(this.get(id));
    }

    public void deleteForUser(int user_id, int car_id) {
        this.carRepository.deleteForUser(user_id, car_id);
    }

    public void changeDateResearch(int user_id, int car_id) {
        UserCar newUserCar = this.carRepository.findUserCar(user_id, car_id);
        newUserCar.setDate_research(new Date(Calendar.getInstance().getTime().getTime()));
        this.userCarRepository.saveAndFlush(newUserCar);
    }

    public void changeFavorite(int user_id, int car_id) {
        UserCar newUserCar = this.carRepository.findUserCar(user_id, car_id);
        newUserCar.setFavorite(newUserCar.getFavorite().equals("yes")?"no":"yes");
        this.userCarRepository.saveAndFlush(newUserCar);
    }
}

