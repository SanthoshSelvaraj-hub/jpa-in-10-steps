package com.example.learning.jpa.jpain10steps;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.learning.jpa.jpain10steps.entity.User;
import com.example.learning.jpa.jpain10steps.service.UserDAOService;
import com.example.learning.jpa.jpain10steps.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{
	
	private static final Logger log= LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		User user = new User("Jill","Admin");
		userRepository.save(user);
		
		
		Optional<User> userWithIdOne = userRepository.findById(1L);
		log.info("New user  is retrived: "+ userWithIdOne);
		
		List<User> users = userRepository.findAll();
		log.info("New user  is AllUsers: "+ users);
		
	}

}
