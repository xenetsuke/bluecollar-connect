package com.bluecollar.service;

import java.util.List;

import com.bluecollar.dto.ApplicantDTO;
import com.bluecollar.dto.Application;
import com.bluecollar.dto.JobDTO;
import com.bluecollar.exception.BlueCollarException;

public interface JobService {

	public JobDTO postJob(JobDTO jobDTO) throws BlueCollarException;

	public List<JobDTO> getAllJobs();
	
	public JobDTO getJob(Long id) throws BlueCollarException;


	public void applyJob(Long id, ApplicantDTO applicantDTO) throws BlueCollarException ;

	public List<JobDTO> getJobsPostedBy(Long id);

	public void changeAppStatus(Application application) throws BlueCollarException ;


}
