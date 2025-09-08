package com.capstone.project.schedular;

import com.capstone.project.dvo.Job;
import com.capstone.project.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class Schedular {

    @Autowired
    public JobRepository jobs;

    //@Scheduled(fixedRate = 5000) // every 5seconds this function will run
    @Scheduled(cron = "0 45 19 ? * MON-FRI") //every weekday at &:45 it will be called
    public void schecualrDisplay(){
        System.out.println("schecdular is running");
    }
    //for cron see the SS

}
