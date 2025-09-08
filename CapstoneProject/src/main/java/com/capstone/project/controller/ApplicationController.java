package com.capstone.project.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.capstone.project.DTO.ApplicationDTO;
import com.capstone.project.mapper.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.project.dvo.Application;
import com.capstone.project.dvo.Job;
import com.capstone.project.service.ApplicationService;
import com.capstone.project.service.JobService;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {
	
	@Autowired
	private ApplicationService service;
	
	@Autowired
	private JobService jobService;

	@Autowired
	private ApplicationMapper applicationMapper;
	
	@PostMapping
    public ResponseEntity<String> addApplication(@RequestBody Application application) {
        Job job = jobService.getJobById(application.getJob().getId());
        application.setJob(job);

       service.addApplication(application);

        return ResponseEntity.ok("Application submitted successfully.");
    }
	
	@GetMapping
	public List<ApplicationDTO> getAllApplication(){
		return service.getAllApplication().stream().map(applicationMapper::toDto).collect(Collectors.toList());
	}
}
