package com.codev.repositories;

import com.codev.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT users FROM User users WHERE users.username = :username")
    User findByUsername(@Param("username") String username);
}
