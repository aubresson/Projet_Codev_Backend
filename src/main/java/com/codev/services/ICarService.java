package com.codev.services;

import com.codev.domain.Car;
import com.codev.domain.User;

import java.util.List;

public interface ICarService {

    List<Car> list(int user_id);
    List<Car> listFavorite(int user_id);
    List<Car> listLastCars(int user_id);
    Car get(int id);
    Car create(Car car);
    Car update(int id, Car car);
    void delete(int id);
    void deleteForUser(int user_id, int car_id);
    void changeDateResearch(int user_id, int car_id);
    void changeFavorite(int user_id, int car_id);

}
