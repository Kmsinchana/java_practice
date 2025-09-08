package com.capstone.project.DTO;

import org.mapstruct.Mapper;

import java.util.Objects;

public class ApplicationDTO {
    private long id;
    private String fullName;
    private String email;
    private long jobId;

    public ApplicationDTO(long id, String fullName, String email, long jobId) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.jobId = jobId;
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

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationDTO that = (ApplicationDTO) o;
        return id == that.id && jobId == that.jobId && Objects.equals(fullName, that.fullName) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, jobId);
    }

    @Override
    public String toString() {
        return "ApplicationDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", jobId=" + jobId +
                '}';
    }
}
