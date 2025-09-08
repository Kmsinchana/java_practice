package com.capstone.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.project.dvo.Application;
import com.capstone.project.dvo.Job;
import com.capstone.project.exception.JobNotFoundException;
import com.capstone.project.repo.ApplicationRepository;
import com.capstone.project.repo.JobRepository;

@Service
public class ApplicationService {
	
	@Autowired
	private ApplicationRepository applicationRepo;
	
	@Autowired
	private JobRepository jobRepo;
	
	public Application addApplication(Application application) {
		Job job = jobRepo.findById(application.getJob().getId())
		        .orElseThrow(() -> new JobNotFoundException("Job not found"));
		    application.setJob(job); 
		    return applicationRepo.save(application);
	}
	
	public List<Application> getAllApplication(){
		return applicationRepo.findAll();
	}
}
