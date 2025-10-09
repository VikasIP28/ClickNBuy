package com.E_commerce.ClickNBuy.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Email;

@Getter
@Setter
public class UserDto {
	
	@NotNull
	@Email
	private String Email;
	
	@NotNull
	private String Password;
	
	@NotNull
	private long Mobile;
	
	@NotNull
	private String Role;
}
