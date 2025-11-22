package com.E_commerce.ClickNBuy.service;

import java.util.concurrent.TimeoutException;

import com.E_commerce.ClickNBuy.dto.OtpDto;

import com.E_commerce.ClickNBuy.dto.ResponseDto;

import com.E_commerce.ClickNBuy.dto.UserDto;

public interface AuthService {
	ResponseDto register(UserDto userDto);

	ResponseDto verifyOtp(OtpDto otpDto) throws TimeoutException;
}
