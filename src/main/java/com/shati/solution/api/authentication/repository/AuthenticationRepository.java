package com.shati.solution.api.authentication.repository;

import com.shati.solution.api.authentication.model.Authentication;
import com.shati.solution.api.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {

    @Query(value = "SELECT * FROM AUTHENTICATION a WHERE a.user_id_id = ?1 and a.auth_token = ?2 and a.channel_initials = ?3", nativeQuery = true)
    Authentication findByUserAndTokenAndChannel(User userId, String authToken, String channel);
}
