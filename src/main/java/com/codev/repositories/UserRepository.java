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

    @Query("SELECT CASE WHEN COUNT(user) > 0 THEN true ELSE false END FROM User user WHERE user.code = :code " +
            "AND user.id = :id")
    boolean correctCode(@Param("code") String code, @Param("id") int id);

    @Query("SELECT CASE WHEN COUNT(user) > 0 THEN true ELSE false END FROM User user WHERE user.code = :code " +
            "AND user.role = 'admin'")
    boolean isAdmin(@Param("code") String code);
}
