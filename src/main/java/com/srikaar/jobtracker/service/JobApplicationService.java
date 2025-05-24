package com.srikaar.jobtracker.service;

import com.srikaar.jobtracker.model.JobApplication;
import com.srikaar.jobtracker.model.User;
import com.srikaar.jobtracker.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository jobRepo;

    public JobApplication createJob(JobApplication jobApp) {
        return jobRepo.save(jobApp);
    }

    public List<JobApplication> getJobsByUser(User user) {
        return jobRepo.findByUser(user);
    }

    public Optional<JobApplication> getJobById(Long id) {
        return jobRepo.findById(id);
    }

    public JobApplication updateJob(JobApplication jobApp) {
        return jobRepo.save(jobApp);
    }

    public void deleteJob(Long id) {
        jobRepo.deleteById(id);
    }
}
