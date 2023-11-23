package com.example.backend.user;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//Query database to find matching email
	@Query("FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}