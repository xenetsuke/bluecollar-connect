package com.bluecollar.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class WageRange {
    private BigDecimal min;
    private BigDecimal max;
}
