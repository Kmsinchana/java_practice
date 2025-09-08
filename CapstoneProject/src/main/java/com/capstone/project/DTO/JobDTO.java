package com.capstone.project.DTO;


import java.util.List;
import java.util.Objects;

public class JobDTO {

    private long id;
    private String title;
    private String company;
    private String location;
    private String description;
    private String salaryRange;
    private List<String> requiredSkills;

    public JobDTO(long id, String title, String company, String location, String description, String salaryRange, List<String> requiredSkills) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.location = location;
        this.description = description;
        this.salaryRange = salaryRange;
        this.requiredSkills = requiredSkills;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        JobDTO jobDTO = (JobDTO) o;
        return id == jobDTO.id && Objects.equals(title, jobDTO.title) && Objects.equals(company, jobDTO.company) && Objects.equals(location, jobDTO.location) && Objects.equals(description, jobDTO.description) && Objects.equals(salaryRange, jobDTO.salaryRange) && Objects.equals(requiredSkills, jobDTO.requiredSkills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, company, location, description, salaryRange, requiredSkills);
    }

    @Override
    public String toString() {
        return "JobDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", salaryRange='" + salaryRange + '\'' +
                ", requiredSkills=" + requiredSkills +
                '}';
    }
}
