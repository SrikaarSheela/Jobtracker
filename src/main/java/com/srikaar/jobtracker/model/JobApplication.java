package com.srikaar.jobtracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class JobApplication {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String position;
    private String status; // e.g., Applied, Interview, Offer, Rejected
    private LocalDate dateApplied;
    private String notes;

    @ManyToOne
    @JsonIgnoreProperties("jobApplications") 
    @JoinColumn(name = "user_id")
    private User user;

	public JobApplication(Long id, String company, String position, String status, LocalDate dateApplied, String notes,
			User user) {
		super();
		this.id = id;
		this.company = company;
		this.position = position;
		this.status = status;
		this.dateApplied = dateApplied;
		this.notes = notes;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(LocalDate dateApplied) {
		this.dateApplied = dateApplied;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public JobApplication() 
	{
		super();
		
	}
    
    
    

    // Getters and Setters
}
