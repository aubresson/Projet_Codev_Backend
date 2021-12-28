package com.codev.services;

import com.codev.domain.Car;
import com.codev.domain.User;

import java.util.List;

public interface ICarService {

    List<Car> list(int user_id, String code);
    List<Car> listFavorite(int user_id, String code);
    List<Car> listLastCars(int user_id, String code);
    Car get(int id);
    Car create(Car car);
    Car update(int id, Car car, String code);
    void delete(int id, String code);
    void deleteForUser(int user_id, int car_id, String code);
    void changeDateResearch(int user_id, int car_id, String code);
    void changeFavorite(int user_id, int car_id, String code);

}
