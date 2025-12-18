package com.bluecollar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluecollar.dto.ApplicantDTO;
import com.bluecollar.dto.Application;
import com.bluecollar.dto.ApplicationStatus;
import com.bluecollar.dto.JobDTO;
import com.bluecollar.entity.Applicant;
import com.bluecollar.entity.Job;
import com.bluecollar.exception.BlueCollarException;
import com.bluecollar.repository.JobRepository;
import com.bluecollar.utility.Utilities;

@Service("jobService")
public class JobServiceImpl implements JobService {
	
	@Autowired
    private JobRepository jobRepository ;

	@Override
	public JobDTO postJob(JobDTO jobDTO) throws BlueCollarException {
	
		jobDTO.setId(Utilities.getNextSequenceId("jobs"));
		return jobRepository.save(jobDTO.toEntity()).toDTO() ;
		
	}

	@Override
	public List<JobDTO> getAllJobs() {
		// TODO Auto-generated method stub
		return jobRepository.findAll().stream().map((x) -> x.toDTO()).toList();
	}

	@Override
	public JobDTO getJob(Long id) throws BlueCollarException {
		// TODO Auto-generated method stub
		return jobRepository.findById(id).orElseThrow(() -> new BlueCollarException("JOB_NOT_FOUND")).toDTO();
	}

	@Override
	public void applyJob(Long id, ApplicantDTO applicantDTO) throws BlueCollarException {
		Job job = jobRepository.findById(id).orElseThrow(() -> new BlueCollarException("JOB_NOT_FOUND"));
		List<Applicant> applicants = job.getApplicants();
		if (applicants == null)applicants = new ArrayList<>();
		if (applicants.stream().filter((x) -> x.getApplicantId() == applicantDTO.getApplicantId()).toList().size() > 0)throw new BlueCollarException("JOB_APPLIED_ALREADY");
		applicantDTO.setApplicationStatus(ApplicationStatus.APPLIED);
		applicants.add(applicantDTO.toEntity());
		job.setApplicants(applicants);
		jobRepository.save(job);
	}

	@Override
	public List<JobDTO> getJobsPostedBy(Long id) {
		// TODO Auto-generated method stub
		return jobRepository.findByPostedBy(id).stream().map((x) -> x.toDTO()).toList();

	}

	@Override
	public void changeAppStatus(Application application) throws BlueCollarException {
		Job job = jobRepository.findById(application.getId()).orElseThrow(() -> new BlueCollarException("JOB_NOT_FOUND"));
		List<Applicant> applicants = job.getApplicants().stream().map((x) -> {
			if (application.getApplicantId() == x.getApplicantId()) {
				x.setApplicationStatus(application.getApplicationStatus());
				if(application.getApplicationStatus().equals(ApplicationStatus.INTERVIEWING)) {
					x.setInterviewTime(application.getInterviewTime());
					
					}
				
			}
			return x;
		}).toList();
		job.setApplicants(applicants);
		jobRepository.save(job);
		
	}

	
}
