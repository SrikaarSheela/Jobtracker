package com.srikaar.jobtracker.controller;

import com.srikaar.jobtracker.model.JobApplication;
import com.srikaar.jobtracker.model.User;
import com.srikaar.jobtracker.service.JobApplicationService;
import com.srikaar.jobtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobService;

    @Autowired
    private UserService userService;

    @PostMapping("/create/{userId}")
    public ResponseEntity<?> createJob(@PathVariable Long userId, @RequestBody JobApplication jobApp) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            jobApp.setUser(user.get());
            JobApplication createdJob = jobService.createJob(jobApp);
            return ResponseEntity.ok(createdJob);
        } else {
            return ResponseEntity.badRequest().body("User not found with ID: " + userId);
        }
    }

    @GetMapping("/user/{userId}")
    public List<JobApplication> getJobsByUser(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(jobService::getJobsByUser).orElse(null);
    }

    @GetMapping("/{id}")
    public Optional<JobApplication> getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJob(@PathVariable Long id, @RequestBody JobApplication updatedJob) {
        Optional<JobApplication> existingJob = jobService.getJobById(id);
        if (existingJob.isPresent()) {
            JobApplication job = existingJob.get();
            job.setCompany(updatedJob.getCompany());
            job.setPosition(updatedJob.getPosition());
            job.setStatus(updatedJob.getStatus());
            job.setDateApplied(updatedJob.getDateApplied());
            job.setNotes(updatedJob.getNotes());
            JobApplication savedJob = jobService.updateJob(job);
            return ResponseEntity.ok(savedJob);
        } else {
            return ResponseEntity.badRequest().body("Job not found with ID: " + id);
        }
    }


    @DeleteMapping("/delete/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }
}
