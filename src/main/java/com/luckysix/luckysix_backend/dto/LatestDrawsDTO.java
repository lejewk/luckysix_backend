package com.luckysix.luckysix_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LatestDrawsDTO {
    private int round;
    private int no1;
    private int no2;
    private int no3;
    private int no4;
    private int no5;
    private int no6;
}
