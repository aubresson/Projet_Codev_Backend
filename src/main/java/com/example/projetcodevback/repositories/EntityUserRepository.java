package com.example.projetcodevback.repositories;

import com.example.projetcodevback.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityUserRepository extends JpaRepository<UserEntity, Integer> {
}
