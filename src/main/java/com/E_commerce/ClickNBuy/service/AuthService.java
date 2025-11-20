package com.E_commerce.ClickNBuy.service;

import com.E_commerce.ClickNBuy.dto.ResponseDto;

import com.E_commerce.ClickNBuy.dto.UserDto;

public interface AuthService {
	 ResponseDto register(UserDto userDto);
	 
}
