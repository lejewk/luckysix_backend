package com.luckysix.luckysix_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StatisticsDTO {
    private ArrayList<NoRateDTO> noRates;
}
