package com.capstone.project.dvo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String company;
	private String location;
	private String description;
	private String salaryRange;

	@ElementCollection
	private List<String> requiredSkills;
	
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Application> applications = new ArrayList<>();
	
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(long id, String title, String company, String location, String description, String salaryRange,
			List<String> requiredSkills, List<Application> applications) {
		super();
		this.id = id;
		this.title = title;
		this.company = company;
		this.location = location;
		this.description = description;
		this.salaryRange = salaryRange;
		this.requiredSkills = requiredSkills;
		this.applications = applications;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSalaryRange() {
		return salaryRange;
	}

	public void setSalaryRange(String salaryRange) {
		this.salaryRange = salaryRange;
	}

	public List<String> getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(List<String> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@Override
	public int hashCode() {
		return Objects.hash(applications, company, description, id, location, requiredSkills, salaryRange, title);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(company, description, id, location, requiredSkills, salaryRange, title);
//	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		return Objects.equals(applications, other.applications) && Objects.equals(company, other.company)
				&& Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(location, other.location) && Objects.equals(requiredSkills, other.requiredSkills)
				&& Objects.equals(salaryRange, other.salaryRange) && Objects.equals(title, other.title);
//		return Objects.equals(company, other.company)
//				&& Objects.equals(description, other.description) && id == other.id
//				&& Objects.equals(location, other.location) && Objects.equals(requiredSkills, other.requiredSkills)
//			&& Objects.equals(salaryRange, other.salaryRange) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", company=" + company + ", location=" + location
				+ ", description=" + description + ", salaryRange=" + salaryRange + ", requiredSkills=" + requiredSkills
			+ ", applications=" + applications + "]";
				//+"]";
	}
	public void addApplication(Application application) {
        applications.add(application);
        application.setJob(this);
    }

    public void removeApplication(Application application) {
        applications.remove(application);
        application.setJob(null);
    }
}
