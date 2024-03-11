package com.se.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.se.user.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("SELECT u FROM User u WHERE u.username =:username")
	Optional<User> findByUsername(@Param("username") String username);
}
