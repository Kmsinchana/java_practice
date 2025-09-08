package com.capstone.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.project.dvo.Application;
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
