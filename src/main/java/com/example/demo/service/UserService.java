package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.exception.Exception;
import com.example.demo.model.Phone;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	private Phone phone;
	private User user;
	private UserDTO userDTO;
	private Exception exception;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}

	public ResponseEntity<Object> saveUser(User user) {
		// TODO Auto-generated method stub
		
		for (Phone phones : user.getPhones()) {
			this.phone = new Phone(phones.getNumber(), phones.getCountryCode());
			//System.out.println(this.phone);
		}
		
		this.user = new User(user.getName(), user.getEmail(), user.getPassword(), new Date(), new Date(), new Date(), false, user.getPhones());
		//System.out.println(this.user);
		if (userRepository.save(this.user) != null) {
			
			this.userDTO = new UserDTO();
			this.userDTO.setId(this.user.getId());
			this.userDTO.setCreated(this.user.getCreated());
			this.userDTO.setModified(this.user.getModified());
			this.userDTO.setLastLogin(this.user.getLastLogin());
			this.userDTO.setIsActive(this.user.getIsActive());
			
			return new ResponseEntity<>(this.userDTO, HttpStatus.OK);
			
		} else {
			
			this.exception = new Exception("No es posible realizar la operación. Intente más tarde");
			return new ResponseEntity<>(this.exception, HttpStatus.OK);
			
		}
	}
}
