package com.codev.repositories;

import com.codev.domain.Car;
import com.codev.domain.UserCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query("SELECT cars.car FROM UserCar cars WHERE cars.user.id = :user_id")
    List<Car> listAll(@Param("user_id") Integer user_id);

    @Query("SELECT cars.car FROM UserCar cars WHERE cars.user.id = :user_id AND cars.favorite = 'yes'")
    List<Car> listFavorite(@Param("user_id") Integer user_id);

    @Query("SELECT cars.car FROM UserCar cars WHERE cars.user.id = :user_id ORDER BY cars.date_research DESC")
    List<Car> listLastCars(@Param("user_id") Integer user_id);

    @Transactional
    @Modifying
    @Query("DELETE FROM UserCar cars WHERE cars.user.id = :user_id AND cars.car.id = :car_id")
    void deleteForUser(@Param("user_id") Integer user_id, @Param("car_id") Integer car_id);

    @Query("SELECT userCars FROM UserCar userCars WHERE userCars.user.id = :user_id AND userCars.car.id = :car_id")
    UserCar findUserCar(int user_id, int car_id);

    @Query("SELECT car FROM Car car WHERE car.modele = :modele " +
            "AND car.marque = :marque AND car.carburant = :carburant " +
            "AND car.annee = :annee")
    Car getCar(@Param("modele") String modele, @Param("marque") String marque,
                   @Param("carburant") String carburant, @Param("annee") int annee);
}
