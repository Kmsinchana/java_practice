package com.capstone.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.project.dvo.Job;
import com.capstone.project.exception.JobNotFoundException;
import com.capstone.project.repo.JobRepository;

@Service
public class JobService {
	
	@Autowired
	private JobRepository repo;
	
	public Job addJob(Job job) {
		return repo.save(job);
	}
	
	public List<Job> getAllJob() {
		return repo.findAll();
	}
	
	public Job getJobById(long id) {
		return repo.findById(id).orElseThrow(()->new JobNotFoundException("job not found with id: " +id));
	}
	
	public List<Job> searchJob(String title, String location) {
	    return repo.searchByTitleAndLocation(title, location);
	}
}
