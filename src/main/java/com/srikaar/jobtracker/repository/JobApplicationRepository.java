package com.srikaar.jobtracker.repository;

import com.srikaar.jobtracker.model.JobApplication;
import com.srikaar.jobtracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByUser(User user);
}
