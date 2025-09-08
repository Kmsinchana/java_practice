package com.capstone.project.dvo;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fullName;
	private String email;
	@ManyToOne
	@JoinColumn(name="jobId",nullable = false)
	@JsonBackReference
	private Job job;
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Application(long id, String fullName, String email, Job job) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.job = job;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, fullName, id, job);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Application other = (Application) obj;
		return Objects.equals(email, other.email) && Objects.equals(fullName, other.fullName) && id == other.id
				&& Objects.equals(job, other.job);
	}
	@Override
	public String toString() {
		return "Application [id=" + id + ", fullName=" + fullName + ", email=" + email + ", job=" + job + "]";
	}
	
}
