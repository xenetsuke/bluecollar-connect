package com.bluecollar.dto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.bluecollar.entity.Job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="jobs")
public class JobDTO {
	 private Long id;

	    // ---------------------------------------------------------
	    // BASIC INFORMATION
	    // ---------------------------------------------------------
	    private String jobTitle;
	    private String jobRole;
	    private String jobDescription;
	    private IndustryCategory industryCategory;
	    private List<ApplicantDTO> applicants;

	    // ---------------------------------------------------------
	    // WORKER REQUIREMENTS
	    // ---------------------------------------------------------
	    private Integer numberOfWorkers;                
	    private ExperienceLevel experienceLevel;        
	    private String skillCategory;
	    private List<String> primarySkills;
	    private List<String> secondarySkills;
	    private PhysicalRequirements physicalRequirements;   // Embedded Object

	    // ---------------------------------------------------------
	    // LOCATION DETAILS
	    // ---------------------------------------------------------
	    private Long workLocationId; 
	    private String locationName;
	    private String fullWorkAddress;
	    private String city;
	    private String state;
	    private String pincode;
	    private GPSLocation gpsCoordinates;

	    // ---------------------------------------------------------
	    // COMPENSATION
	    // ---------------------------------------------------------
//	    private WageType wageType;
	    private BigDecimal baseWageAmount;
	    private WageRange wageRange;
	    private BigDecimal overtimeRate;
	    private boolean performanceIncentives;
	    private PaymentFrequency paymentFrequency;

	    // ---------------------------------------------------------
	    // WORK SCHEDULE
	    // ---------------------------------------------------------
	    private LocalTime shiftStartTime;
	    private LocalTime shiftEndTime;
	    private Integer totalHoursPerDay;
	    private List<String> workingDays;
	    private WeeklyOffPattern weeklyOffPattern;
	    private Integer breakDuration;
	    private BigDecimal nightShiftPremium;

	    // ---------------------------------------------------------
	    // JOB DURATION / TIMELINE
	    // ---------------------------------------------------------
	    private JobType jobType;
	    private ContractDuration contractDuration;
	    private LocalDate startDate;
	    private LocalDate endDate;
	    private boolean immediateJoining;
	    private Integer probationPeriod;

	    // ---------------------------------------------------------
	    // BENEFITS & FACILITIES
	    // ---------------------------------------------------------
	    private boolean transportProvided;
	    private String transportDetails;
	    private boolean foodProvided;
	    private String foodDetails;
	    private boolean accommodationProvided;
	    private String accommodationDetails;
	    private boolean uniformProvided;
	    private boolean medicalInsurance;
	    private boolean esiPfBenefits;
	    private boolean festivalBonuses;
	    private String leavePolicy;

	    // ---------------------------------------------------------
	    // APPLICATION & HIRING PROCESS
	    // ---------------------------------------------------------
	    private LocalDateTime applicationDeadline;
	    private boolean allowDirectApplications;
	    private boolean interviewRequired;
	    private List<String> documentRequirements;
	    private boolean backgroundCheckRequired;
	    private boolean medicalFitnessRequired;

	    // ---------------------------------------------------------
	    // PRIORITY & VISIBILITY
	    // ---------------------------------------------------------
	    private UrgencyLevel urgencyLevel;
	    private Visibility visibility;
	    private boolean featuredJob;
	    private boolean autoRenewal;

	    // ---------------------------------------------------------
	    // REQUIREMENTS & QUALIFICATIONS
	    // ---------------------------------------------------------
	    private Integer minimumAge;
	    private Integer maximumAge;
	    private GenderPreference genderPreference;
	    private EducationLevel educationLevel;
	    private List<String> languageRequirements;
	    private List<String> certificationRequirements;
	    private List<String> previousIndustryExperience;

	    // ---------------------------------------------------------
	    // STATUS WORKFLOW
	    // ---------------------------------------------------------
	    private JobStatus jobStatus;
	    private Long postedBy ; 
	    

	    
	    public Job toEntity() {
	    	return new Job(
	    			 this.id,
	    	            this.jobTitle,
	    	            this.jobRole,
	    	            this.jobDescription,
	    	            this.industryCategory,
	    	            this.applicants!=null?this.applicants.stream().map((x)->x.toEntity()).toList():null,	    	            this.numberOfWorkers,
	    	            this.experienceLevel,
	    	            this.skillCategory,
	    	            this.primarySkills,
	    	            this.secondarySkills,
	    	            this.physicalRequirements,
	    	            this.workLocationId,
	    	            this.locationName,
	    	            this.fullWorkAddress,
	    	            this.city,
	    	            this.state,
	    	            this.pincode,
	    	            this.gpsCoordinates,
//	    	            this.wageType,
	    	            this.baseWageAmount,
	    	            this.wageRange,
	    	            this.overtimeRate,
	    	            this.performanceIncentives,
	    	            this.paymentFrequency,
	    	            this.shiftStartTime,
	    	            this.shiftEndTime,
	    	            this.totalHoursPerDay,
	    	            this.workingDays,
	    	            this.weeklyOffPattern,
	    	            this.breakDuration,
	    	            this.nightShiftPremium,
	    	            this.jobType,
	    	            this.contractDuration,
	    	            this.startDate,
	    	            this.endDate,
	    	            this.immediateJoining,
	    	            this.probationPeriod,
	    	            this.transportProvided,
	    	            this.transportDetails,
	    	            this.foodProvided,
	    	            this.foodDetails,
	    	            this.accommodationProvided,
	    	            this.accommodationDetails,
	    	            this.uniformProvided,
	    	            this.medicalInsurance,
	    	            this.esiPfBenefits,
	    	            this.festivalBonuses,
	    	            this.leavePolicy,
	    	            this.applicationDeadline,
	    	            this.allowDirectApplications,
	    	            this.interviewRequired,
	    	            this.documentRequirements,
	    	            this.backgroundCheckRequired,
	    	            this.medicalFitnessRequired,
	    	            this.urgencyLevel,
	    	            this.visibility,
	    	            this.featuredJob,
	    	            this.autoRenewal,
	    	            this.minimumAge,
	    	            this.maximumAge,
	    	            this.genderPreference,
	    	            this.educationLevel,
	    	            this.languageRequirements,
	    	            this.certificationRequirements,
	    	            this.previousIndustryExperience,
	    	            this.jobStatus,
	    	            this.postedBy
	    	            
	    			);
	    			
	    }

}
