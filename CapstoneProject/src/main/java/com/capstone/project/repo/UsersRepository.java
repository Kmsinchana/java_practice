package com.capstone.project.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.project.dvo.Users;


public interface UsersRepository extends JpaRepository<Users, Long> {
	Optional<Users> findByUsername(String username);
//	Using Optional helps to:
//
//		Avoid NullPointerException.
//
//		Force the developer to handle the possibility that the user may not exist.
}
