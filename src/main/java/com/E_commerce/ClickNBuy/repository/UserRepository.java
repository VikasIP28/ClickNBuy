package com.E_commerce.ClickNBuy.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.E_commerce.ClickNBuy.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	boolean existsByEmail(String email);

	boolean existsByMobile(Long mobile);
	
	Optional<User> findByEmail(String email);

}
