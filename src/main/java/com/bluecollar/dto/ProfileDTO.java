package com.bluecollar.dto;

import java.util.Base64;
import java.util.List;

import com.bluecollar.entity.Profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {
	 
	 private Long id; // MongoDB uses String ObjectId, not Long

//	    private String userId; // Link to User collection

	    // ✅ Worker Personal Details
	 private String picture ;
	    private String fullName;
	    private Integer age; // 18 - 65
	    private String gender; // MALE / FEMALE / OTHER

	    private String primaryPhone;
	    private String alternatePhone;
	    private String whatsappNumber;

	    private String email;
	    private String currentCity;
	    private String currentState;

	    private String currentAddress;
	    private String pincode;
	    private List<String> skills;
	    private List<String> languages; // Hindi, English, Tamil etc.
//	    private List<String> experience;
	
	    // 🔹 PROFESSIONAL INFORMATION
	    // ===============================
	    private String primaryJobRole;
	    private String skillLevel;

	    private Integer totalExperience;

	    private List<String> secondarySkills;
	    private String shiftPreference;

	    private String workType;           // Fixed typo
	    private List<String> availability;

	    private String wageType;           // Fixed typo (wagetype)
	    private Integer wageAmount;

	    private Boolean wageNegotiable;
	    // WORK HISTORY (NEW)
	    // -------------------------
	    private WorkHistoryStatistics statistics;       // totals
	    private List<AssignmentDTO> recentAssignments;     // cards list
	    private List<Long> savedJobs ;


	    
	    public Profile toEntity() {
	        return new Profile(
	            this.id,
	            this.picture!=null?Base64.getDecoder().decode(this.picture):null,
	            this.fullName,
	            this.age,
	            this.gender,
	            this.primaryPhone,
	            this.alternatePhone,
	            this.whatsappNumber,
	            this.email,
	            this.currentCity,
	            this.currentState,
	            this.currentAddress,
	            this.pincode,
	            this.skills,
	            this.languages,
	            this.primaryJobRole,
	            this.skillLevel,
	            this.totalExperience,
	            this.secondarySkills,
	            this.shiftPreference,
	            this.workType,
	            this.availability,
	            this.wageType,
	            this.wageAmount,
	            this.wageNegotiable,
	            this.statistics,
	            this.recentAssignments,
	            this.savedJobs
	            );
	       
	    }


}
