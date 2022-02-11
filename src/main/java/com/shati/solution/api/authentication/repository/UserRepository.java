package com.shati.solution.api.authentication.repository;

import com.shati.solution.api.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM USERS u WHERE u.email = ?1 and u.password = ?2", nativeQuery = true)
    User getByUserAndPass(String email, String password);

    @Query(value = "SELECT * FROM USERS u WHERE u.status = ?1", nativeQuery = true)
    List<User> findInnactive(String status);

    @Query(value = "SELECT * FROM USERS u WHERE u.user_id = ?1", nativeQuery = true)
    User findByUserId(String userId);

    @Query(value = "SELECT user_id FROM USERS u", nativeQuery = true)
    List<String> getAllUserId();
}
