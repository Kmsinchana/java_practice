package com.capstone.project.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.capstone.project.dvo.Users;
import com.capstone.project.repo.UsersRepository;

@Component
public class AdminUserInitializar {

	@Bean
	public CommandLineRunner createadminUser(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
		return args ->{
			if(usersRepository.findByUsername("admin").isEmpty()) {
				Users admin = new Users();
				admin.setUsername("admin");
				admin.setRole("Role_admin");
				admin.setPassword(passwordEncoder.encode("admin1234"));
				
				usersRepository.save(admin);
				System.out.println("default user created");
			}
		};
	}
}
