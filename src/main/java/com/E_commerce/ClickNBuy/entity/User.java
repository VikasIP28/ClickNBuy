package com.E_commerce.ClickNBuy.entity;


import java.time.LocalDateTime;

import com.E_commerce.ClickNBuy.entity.Role;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private Long mobile;
	
	@CreationTimestamp
	private LocalDateTime createdtime;
	private int otp;
	private LocalDateTime otpExpiryTime;
	
	@Enumerated
	private Role role;
	private boolean status;

}
