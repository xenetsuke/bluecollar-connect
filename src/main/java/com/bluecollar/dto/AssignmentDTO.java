package com.bluecollar.dto;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentDTO {
    private String id;
    private String jobTitle;
    private String company;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String wagetype;           // Fixed typo (wagetype)
    private Double wage;
    private Double rating;

}
