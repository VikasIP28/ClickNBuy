package com.E_commerce.ClickNBuy.service.Impl;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.E_commerce.ClickNBuy.dao.UserDao;
import com.E_commerce.ClickNBuy.dto.ResponseDto;
import com.E_commerce.ClickNBuy.dto.UserDto;
import com.E_commerce.ClickNBuy.entity.Role;
import com.E_commerce.ClickNBuy.entity.User;
import com.E_commerce.ClickNBuy.exception.DataExistsException;
import com.E_commerce.ClickNBuy.service.AuthService;
import com.E_commerce.ClickNBuy.util.EmailSender;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    UserDao userDao;
    PasswordEncoder encoder;
    EmailSender emailSender;

    @Override
    public ResponseDto register(UserDto userDto) {

        // Check unique email and mobile
        if (userDao.isEmailUnique(userDto.getEmail()) && userDao.isMobileUnique(userDto.getMobile())) {

            // Generate OTP
            int otp = new Random().nextInt(100000, 1000000);

            // Send OTP to Email
            emailSender.sendOtp(userDto.getEmail(), otp, userDto.getName());

            // Save User with OTP and expiry time
            User user = new User();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setPassword(encoder.encode(userDto.getPassword()));
            user.setMobile(userDto.getMobile());
            user.setOtp(otp);
            user.setOtpExpiryTime(LocalDateTime.now().plusMinutes(5));
            user.setRole(Role.valueOf("ROLE_" + userDto.getRole()));
            user.setStatus(false);
            // createdtime will be set automatically by @CreationTimestamp

            userDao.saveUser(user);

            return new ResponseDto("Otp Sent Success, Verify within 5 minutes", userDto);
        }

        // If Email or Mobile already exists
        if (!userDao.isEmailUnique(userDto.getEmail())) {
            throw new DataExistsException("Email Already Exists : " + userDto.getEmail());
        } else {
            throw new DataExistsException("Mobile Already Exists : " + userDto.getMobile());
        }
    }
}
