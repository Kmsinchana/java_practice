package com.capstone.project.schedular;

import com.capstone.project.dvo.Job;
import com.capstone.project.service.JobService;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ScheduledFuture;

@Service
public class DynamicJobScheduler {

    private final ThreadPoolTaskScheduler taskScheduler;
    private final JobService jobService;

    private final Map<String, ScheduledFuture<?>> scheduledTasks = new HashMap<>();

    public DynamicJobScheduler(JobService jobService) {
        this.jobService = jobService;
        this.taskScheduler = new ThreadPoolTaskScheduler();
        this.taskScheduler.setPoolSize(5);
        this.taskScheduler.initialize();
    }

    public void scheduleJob(Job job, String cronExpression) {
        String jobKey = UUID.randomUUID().toString(); // unique key

        ScheduledFuture<?> future = taskScheduler.schedule(() -> {
            System.out.println("Running scheduled job: " + job.getTitle());
            jobService.addJob(new Job(
                    0,
                    job.getTitle(),
                    job.getCompany(),
                    job.getLocation(),
                    job.getDescription(),
                    job.getSalaryRange(),
                    new ArrayList<>(job.getRequiredSkills()),
                    new ArrayList<>()
            ));
        }, new CronTrigger(cronExpression));

        scheduledTasks.put(jobKey, future);
        System.out.println("Job scheduled: " + job.getTitle() + " with cron: " + cronExpression);
    }
}
