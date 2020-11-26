package com.luckysix.luckysix_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DrawRateDTO {
    private int no;
    private int count;
    private float rate;
}
