package com.capstone.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.project.dvo.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
	
	@Query("SELECT j FROM Job j WHERE LOWER(j.title) LIKE %:title% AND LOWER(j.location) LIKE %:location%")
    List<Job> searchByTitleAndLocation(@Param("title") String title, @Param("location") String location);
}
