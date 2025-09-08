package com.capstone.project.mapper;

import com.capstone.project.DTO.ApplicationDTO;
import com.capstone.project.dvo.Application;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    @Mapping(source = "job.id", target = "jobId")   //When mapping from Application to ApplicationDTO, extract the id from the job field and put it into jobId.
    ApplicationDTO toDto(Application application);
    @Mapping(target = "job.id", source = "jobId")
    Application toEntity(ApplicationDTO applicationDTO);
}
