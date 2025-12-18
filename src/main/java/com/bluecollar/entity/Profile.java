package com.bluecollar.entity;

import java.util.Base64;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bluecollar.dto.AssignmentDTO;
import com.bluecollar.dto.ProfileDTO;
import com.bluecollar.dto.WorkHistoryStatistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "profiles")
public class Profile {

    @Id
    private Long id; // MongoDB uses String ObjectId, not Long

//    private String userId; // Link to User collection

    // ✅ Worker Personal Details
    private byte[] picture;
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

//    private String emergencyContactName;
//    private String emergencyContactPhone;

    private List<String> skills;
    private List<String> languages; // Hindi, English, Tamil etc.


    
//    private List<String> experience;

    // ===============================
    // 🔹 FUTURE SECTIONS (Commented)
    // ===============================


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
    private List<Long>  savedJobs ;
//    private String educationLevel;
//    private List<String> certifications;
//    private List<PreviousEmployer> previousEmployers;

    // Step 3 → Work Preferences
//    private Boolean wageNegotiable = true;
//    private List<String> preferredShifts;
//    private Integer maxTravelDistance;
//    private String availabilityStatus;
//    private List<String> preferredJobTypes;
//    private List<String> preferredWorkDays;
//    private Boolean nightShiftWillingness;
//    private Boolean weekendWorkWillingness;

    // Document Management
//    private String aadhaarNumber;
//    private String aadhaarDocumentUrl;
//    private String aadhaarVerificationStatus;
//    private String panNumber;
//    private String panDocumentUrl;
//    private String panVerificationStatus;
//    private String profilePhotoUrl;
//    private String bankAccountNumber;
//    private String bankIFSCCode;
//    private String bankName;
  

    // System Fields
//    private Integer profileCompletionPercentage = 0;
//    private String overallVerificationStatus = "PENDING"; // Enum later
//    private String kycStatus = "NOT_STARTED"; // Enum later
//
//    private LocalDateTime profileCreatedDate = LocalDateTime.now();
//    private LocalDateTime lastUpdatedDate = LocalDateTime.now();

//    private Boolean isActive = true;
    
    
    public ProfileDTO toDTO() {
        return new ProfileDTO(
            this.id,
            this.picture!=null?Base64.getEncoder().encodeToString(this.picture):null,
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
//            this.picture != null ? Base64.getEncoder().encodeToString(this.picture) : null
       
    }

    
}
