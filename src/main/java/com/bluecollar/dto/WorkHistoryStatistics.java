package com.bluecollar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkHistoryStatistics {
	  private Integer totalJobsCompleted;
	  
      private Double totalEarnings;
      private Double averageRating;

}
