package com.example.projetcodevback.repositories;

import com.example.projetcodevback.domain.CarEntity;
import com.example.projetcodevback.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityCarRepository extends JpaRepository<CarEntity, Integer> {
}
