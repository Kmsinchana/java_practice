package com.capstone.project.mapper;

import com.capstone.project.DTO.JobDTO;
import com.capstone.project.dvo.Job;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")    //there is one more componentModel with C capital from lambok library(don't use that)
//This tells MapStruct to generate a Spring-managed bean for the mapper, so you can @Autowired it in your controller or service.
public interface JobMapper {
    JobDTO toDTO(Job job);
    Job toEntity(JobDTO jobDTO);
}
