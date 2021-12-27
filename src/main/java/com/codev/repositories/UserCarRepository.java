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
public interface UserCarRepository extends JpaRepository<UserCar, Integer> {
}
