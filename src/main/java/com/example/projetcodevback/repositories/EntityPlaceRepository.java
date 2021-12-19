package com.example.projetcodevback.repositories;

import com.example.projetcodevback.domain.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityPlaceRepository extends JpaRepository<PlaceEntity, Integer> {
}
