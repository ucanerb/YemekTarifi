package com.caner.repository;

import com.caner.repository.entity.Auth;
import com.caner.repository.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IAuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth> findOptionalByUsername(String username);
    Optional<Auth> findOptionalByUsernameAndPassword(String username, String password);
    List<Auth> findByRole(ERole role);
    Optional<Auth> findOptionalByEmail(String email);
}
