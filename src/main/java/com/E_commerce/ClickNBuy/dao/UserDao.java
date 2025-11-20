package com.E_commerce.ClickNBuy.dao;

import org.springframework.stereotype.Repository;

import com.E_commerce.ClickNBuy.entity.User;
import com.E_commerce.ClickNBuy.repository.UserRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UserDao {

	UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public boolean isEmailUnique(String email) {
		return !userRepository.existsByEmail(email);
	}

	public boolean isMobileUnique(Long mobile) {
		return !userRepository.existsByMobile(mobile);
	}
	
}
