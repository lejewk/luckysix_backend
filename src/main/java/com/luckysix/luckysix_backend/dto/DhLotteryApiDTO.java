package com.luckysix.luckysix_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DhLotteryApiDTO {
    private long totSellamnt;
    private String returnValue;
    private String drwNoDate;
    private long firstWinamnt;
    private long firstAccumamnt;
    private int firstPrzwnerCo;
    private int drwNo;
    private int drwtNo1;
    private int drwtNo2;
    private int drwtNo3;
    private int drwtNo4;
    private int drwtNo5;
    private int drwtNo6;
    private int bnusNo;
}
