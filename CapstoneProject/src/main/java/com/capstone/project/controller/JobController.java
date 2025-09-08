package com.capstone.project.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.capstone.project.DTO.JobDTO;
import com.capstone.project.dvo.ScheduleRequest;
import com.capstone.project.mapper.JobMapper;
import com.capstone.project.schedular.DynamicJobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.project.dvo.Job;
import com.capstone.project.service.JobService;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class JobController {
	@Autowired
	private JobService service;
	private final DynamicJobScheduler scheduler;
	@Autowired
	private JobMapper jobMapper;

	public JobController(JobService service, DynamicJobScheduler scheduler) {
		this.service = service;
		this.scheduler = scheduler;
	}

	@PostMapping("/schedule")
	public ResponseEntity<String> scheduleJob(@RequestBody ScheduleRequest request) {
		scheduler.scheduleJob(request.getJob(), request.getCronExpression());
		return ResponseEntity.ok("Job scheduled with cron: " + request.getCronExpression());
	}
	@GetMapping
	public List<JobDTO> getAllJob(){
		return service.getAllJob().stream().map(jobMapper::toDTO).collect(Collectors.toList());
	}
	
	@PostMapping
	public JobDTO add(@RequestBody JobDTO jobDTO) {
		Job job = jobMapper.toEntity(jobDTO);
		Job saved = service.addJob(job);
		return jobMapper.toDTO(saved);
	}
	
	@GetMapping("/{id}")
	public JobDTO findJobById(@PathVariable long id) {
		Job finaljob = service.getJobById(id);
		return jobMapper.toDTO(finaljob);
	}
	
	@GetMapping("/search")
	public List<JobDTO> searchJobs(@RequestParam String title, @RequestParam String location) {
	   List<Job> jobs = service.searchJob(title, location);
	   return jobs.stream().map(jobMapper::toDTO).collect(Collectors.toList());
	}

}
