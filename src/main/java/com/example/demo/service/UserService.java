package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Phone;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	private Phone phone;
	private User user;
	
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
		userRepository.save(this.user);
		
		
		return null;
	}
}
