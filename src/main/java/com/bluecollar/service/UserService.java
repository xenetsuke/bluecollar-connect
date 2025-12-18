package com.bluecollar.service;

import com.bluecollar.dto.LoginDTO;
import com.bluecollar.dto.ResponseDTO;
import com.bluecollar.dto.UserDTO;
import com.bluecollar.exception.BlueCollarException;

public interface UserService {
	
	
	public UserDTO registerUser(UserDTO userDTO) throws BlueCollarException;

	public UserDTO loginUser( LoginDTO loginDTO) throws BlueCollarException;
	public Boolean sendOtp( String email) throws Exception;

	public Boolean verifyOtp( String email, String otp) throws BlueCollarException;

	public ResponseDTO changePassword( LoginDTO loginDTO) throws BlueCollarException;

	
}
